;;;========================================================
;;; INTEGRATE FUNCTIONS
;Call/type this function in the buffer to use the program and make it run.
(defun integrate (F V &optional lo hi)
 (def-integral  (indef-integral F V)  V lo hi)))

;Sub-function used to do actual integrals.
(defun indef-integral (F V)
 (labels ((indef-integral-subfun (F V)
  	    (cond ((number-p F)   (make-product F V))													; is it a number?
         	    ((variable-p F) (make-product 1/2 (make-power F 2)))										; is it a variable?
	 	    ((negative-p F) (make-negative (integrate (make-negative F) V)))								; is it a negative symbol?
		    ((sum-p F)      (make-sum (integrate (sum-operand-1 F) V)									; is it an addition?
				       	      (integrate (sum-operand-2 F) V)))									
		    ((difference-p F) (make-difference (integrate (difference-operand-1 F) V)							; is it a subtraction?
						       	   (integrate (difference-operand-2 F) V)))
		    ((and (power-p F)																	; is it a positive power?
			    (not (= (power-operand-2 F) -1))) (make-quotient (make-power V (make-sum (power-operand-2 F) 1))
									  					 (make-sum (power-operand-2 F) 1)))
		    ((and (power-p F)																	; is it a negative power?
			    (equal (power-operand-2 F) -1)) (make-log (power-operand-1 F))))))
   
 (cond ((not (variable-p V)) nil)																	; IF V not on list THEN nil
	 ((multi-negative-p F) (indef-integral-subfun (make-negative-compress F) V))								; IF multi-negatives, compress
	 (t(indef-integral-subfun F V)))))															; ELSE evaluate

;Sub-function used to evaluate lower & upper limits for definite integrals.
(defun def-integral (F V lo hi)
 (cond ((not (and (number-p lo)						; Exception handling if limits of integration are not numbers
		      (number-p hi)))F)
	 (t(eval(make-difference (variable-sub V hi F)		; After evaluating each limit, subtract them
				 (variable-sub V lo F))))))

;Sub-function of def-integral that substitues variables with limits of integration.
(defun variable-sub (e1 e2 L)										; var-of-integration | limit | list		
 (labels ((variable-sub-subfun (e1 e2 L)								; recursively iterrate through F until you find var-of-integration
	    (cond ((endp L) nil)										; IF list is empty THEN finished
		    ((equal (first L) e1) (cons e2 (variable-sub e1 e2 (rest L))))		; IF var-of-integration == first of list THEN limit.append var-sub
		    ((listp (first L)) (cons (variable-sub e1 e2 (first L))			; IF the list element is a list
					           (variable-sub e1 e2 (rest L))))
		    (t(cons (first L) (variable-sub e1 e2 (rest L)))))))
	
 (cond ((variable-p L) (first (variable-sub-subfun e1 e2 (list L))))		
	 (t (variable-sub-subfun e1 e2 L)))))								
;;;========================================================
;;; SYMBOLS
;Used to output symbols that are evaluated by lists.
(defconstant variable-symbols '(U V W X Y Z))
(defconstant negative-symbol '-)
(defconstant sum-symbol '+)
(defconstant difference-symbol '-)
(defconstant product-symbol '*)
(defconstant quotient-symbol '/)
(defconstant log-symbol 'log)
(defconstant power-symbol 'expt)
;;;========================================================
;;; SELECTORS -- OPERATORS
;Used to locate positions in a list, repetitively defined for clarity of the type (unnecessary).
(defun negative-operator (F) (first F))
(defun sum-operator (F) (first F))
(defun difference-operator (F) (first F))
(defun product-operator (F) (first F))
(defun quotient-operator (F) (first F))
(defun power-operator (F) (first F))

;;; SELECTORS -- OPERANDS
;See operators comment above.
(defun negative-operand (F) (second F))
(defun sum-operand-1 (F) (second F))
(defun sum-operand-2 (F) (third F))
(defun difference-operand-1 (F) (second F))
(defun difference-operand-2 (F) (third F))
(defun product-operand-1 (F) (second F))
(defun product-operand-2 (F) (third F))
(defun quotient-operand-1 (F) (second F))
(defun quotient-operand-2 (F) (third F))
(defun power-operand-1 (F) (second F))
(defun power-operand-2 (F) (third F))

;;;========================================================
;;; PREDICATES
;Boolean T/F statements used to validate a character in a position of a list.
(defun variable-p (F)
 (member F variable-symbols))	;IF does not return THEN "nil"
  
(defun number-p (F)
 (numberp F)) 		; IF "number" THEN "true"

(defun negative-p (F)
 (cond ((and (numberp F) 									; IF list position is "number" &
             (< F 0)) t)
	 ((numberp F) nil)
	 ((variable-p F) nil)									; list position is less than 0 THEN "true"
       ((difference-p F) nil)
	 ((and (equal (negative-operator F) negative-symbol) 			; IF list position is "negative-symbol" &
	       (not (equal (negative-operand F) negative-symbol)))t))) 	; next character is not a "negative-symbol" THEN "true"

(defun multi-negative-p (F)
 (labels ((multi-negative-p-subfun (F)
	    (cond ((endp F) t)												; IF end-of-list THEN "true"
		    ((equal (first F) negative-symbol) (multi-negative-p-subfun (rest F)))	; IF list position is "negative-symbol" THEN look at the next position
		    (t(multi-negative-p-subfun (rest F))))))							; Look at the next position in the list, but take the current position and append it to the negative symbols
 
 (cond ((not (listp F)) nil)
       ((difference-p F) nil)
	 ((negative-p F) nil)
	 ((sum-p F) nil)
	 ((product-p F) nil)
	 ((power-p F) nil)
	 ((number-p F) nil)
	 ((variable-p F) nil)											; IF "negative-p" returns true THEN escape this truth check.
       (t(multi-negative-p-subfun F)))))								; Look at the subfunction in labels.

(defun sum-p (F)
 (cond ((and (equal (sum-operator F) sum-symbol)	; IF list position is "sum-symbol" &
             (sum-operand-1 F) 				; "sum-operand-1" exists &
             (sum-operand-2 F)) t))) 			; "sum-operand-2" exists THEN "true"

(defun product-p (F)
 (cond ((equal (product-operator F) product-symbol)t)))

(defun difference-p (F)
 (cond ((and (equal (difference-operator F) difference-symbol)		; IF list position is "difference-symbol" &
	       (not (equal (difference-operand-1 F) difference-symbol))	; "difference-operand-1" is NOT "difference-symbol" &
             (difference-operand-2 F)) t)))						; "difference-operand-2" exists THEN "true"

(defun power-p (F)
 (cond ((and (equal (power-operator F) power-symbol) 	; IF list position is "power-symbol" &
	       (variable-p (power-operand-1 F))         	; "power-operand-1" is a variable &
	       (number-p (power-operand-2 F))) t)))     	; "power-operand-2" is a number THEN "true"


;;;========================================================
;;; CONSTRUCTORS
;Used to actually do the math required to execute an integral.
(defun make-variable (V) V)
	      ;;; NOTE that this function, which seems ''trivial'', included
	      ;;; for the completeness of the abtraction from the way the math
	      ;;; functions are represented in LISP.

(defun make-sum (F G)
 (cond ((eq F 0) G)						; 0+G = G
       ((eq G 0) F)                 			; F+0 = F
       ((equal F (make-negative G))0)        	; IF "function" equals "function" (that has been labeled a negative) THEN return "0"
       ((equal G (make-negative F))0)  		; ^opposite
       ((and(numberp F)(numberp G))(+ F G))  	; IF both are "number" THEN add
       (t(list sum-symbol F G))))          		; return: (+ F G)
	      
(defun make-negative (F)
 (labels ((make-negative-subfun (F)
          (cond ((number-p F) (* -1 F)) 							; IF "number" THEN return "-1*number"
	   	    ((negative-p F) (negative-operand F)) 					; IF "(-x)" THEN select "x"
         	    (t(list negative-symbol F))))) 						; IF "x" THEN return "(-x)" (this is for completing a variable statement for illustration mathematically)
 
 (cond ((multi-negative-p F) (make-negative-subfun (make-negative-compress F)))	; IF multiple negative symbols THEN initiate compression of negative symbols
	 (t(make-negative-subfun F))))) 							; ELSE use make-negative-subfun

(defun make-negative-compress (F)
 (labels ((make-negative-compress-subfun (F)
	    (cond ((equal (mod (length F) 2) 0) (list negative-symbol (first (last F)))) 	; IF length of multi-negatives is 'even' THEN return function with negative symbol (---x) = (-x)
		    (t(first (last F)))))) 										; ELSE return "x" without a negative
  
 (cond ((multi-negative-p F) (make-negative-compress-subfun F)) 				; IF there are multiple negative symbols THEN compress down to 1 or 0 negative symbols
	 ((negative-p F) F)))) 										; IF there is only one negative symbol THEN return function 'as is'
	 
(defun make-difference (F G)
 (cond ((equal F 0) G)										; 0+G = G
	 ((equal G 0) F)										; F+0 = F
	 ((equal F G) 0)										; F-F = 0
	 ((and (number-p F) (number-p G)) (- F G))					; IF both are "number" THEN "subtract"
	 ((equal F (make-negative G)) (make-sum F (make-negative G))) 	; IF both are "same variable" but 2nd is negative variant THEN switch equation to "sum"
	 (t(list difference-symbol F G))))						; ELSE return a list displaying the math that needs to occur

(defun make-product (F G)
 (cond ((or (equal F 0)        									; IF either operand is "0" THEN return "0"
	      (equal G 0)) 0)										; ^above
	 ((equal F 1) G)											; G*1 = G
	 ((equal G 1) F)											; F*1 = F
	 ((equal F -1) (make-negative G)) 								; G*-1=-G
	 ((equal G -1) (make-negative F))								; F*-1=-F
	 ((and (negative-p F) 										
             (negative-p G)) (make-product (make-negative F) (make-negative G))) 	; IF both operands are "negative" THEN return "positive" answer
	 ((and (number-p F) 										
             (number-p G)) (* F G))  								; IF both operands are "number" THEN return "product" answer
	 (t(list product-symbol F G))))								; ELSE return a list displaying the math that needs to occur

(defun make-quotient (F G)
 (cond ((equal G 0) nil)			; F/0=nil
	 ((equal F 0) 0)				; 0/G=0
	 ((equal F G) 1)				; F/F=1
	 ((and (number-p F) 			
             (number-p G)) (/ F G))  	; IF both are "number" THEN "divide"
	 (t(list quotient-symbol F G))))	; ELSE return a list displaying the math that needs to occur

(defun make-log (V)
 (cond ((variable-p V) (list log-symbol V))))	; IF variable of integration is "true" THEN return a list displaying the log of it

(defun make-power (V N)
 (cond ((and (variable-p V)						; IF variable of integration is "true" & 
	       (number-p N)) (list power-symbol V N))))	; the power is a "number" THEN list the math that needs to occur


;;;========================================================
;;; TESTS

(defun t1 () (integrate '1 'x))
(defun t2 () (integrate '1 'y 1 4))
(defun t3 () (integrate 'z 'z))
(defun t4 () (integrate '(+ x 0) 'x))
(defun t5 () (integrate '(- x) 'x 1 3))
(defun t6 () (integrate '(- - x) 'x) 1 4)
(defun t7 () (integrate '(-  x) 'x))
(defun t8 () (integrate '(- - x) 'x))
(defun t9 () (integrate '(- - - x) 'x))
(defun t10 () (integrate '(+ x (- x)) 'x))
(defun t11 () (integrate '(- (+ (- - x) x)) 'x 1 4))
(defun t12 () (integrate '(+ (+ (- - x) (+ x 3)) 2) 'x 2 6))
(defun t13 () (integrate '(- x (expt x 3)) 'x))
(defun t14 () (integrate '(- x (expt x 3)) 'x 2 5))
(defun t15 () (integrate '(+ (+ x (- - - x)) (expt x 3)) 'x))
(defun t16 () (integrate '(+ (- x (-x)) (expt x 3)) 'x 2 3))
(defun t17 () (integrate '(expt x -1) 'x))
(defun t18 () (integrate '(expt x -1) 'x 3 45))
(defun t19 () (integrate '(+ (+ x (- 5 x)) (expt x -1)) 'x))
(defun t20 () (integrate '(+ (+ x (- 5 x)) (expt x -1)) 'x 5 217))

