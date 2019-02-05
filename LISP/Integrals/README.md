# Integrals

## Introduction
This program allows the user to solve indefinite and definite integrals via their input.
LISP utilizes a form of mathematics where the operator (+,-) comes before the operands (4,7).

```
(+ 4 7) => 11
```
	
## Use
This integrals program is has several built in testing evaluation functions (t1-t20).

```
(t1)
(t2)
(integrate '(14 x y) 'x)
(integrate '(- (+ (- - x) x)) 'x 1 4))
```
<b>Test Functions</b>:
t1 integrates 1 dx
t2 integrates 1 dy definite range = 1 4
t3 integrates z dz
t4 integrates x+0 dx
t5 integrates -x dx definite range = 1 3
t6 integrates --x dx definite range = 1 4
t7 integrates -x dx
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
