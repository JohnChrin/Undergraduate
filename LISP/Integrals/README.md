# Integrals

## Introduction
This program allows the user to solve indefinite and definite integrals via their input. The primary difficulty was differentiating the use of a negative sign and the compression of multiple negative symbols into either 1 negative or 0 negatives depending upon whether the amount was odd or even. Just about everything uses recursion to solve. \
LISP utilizes a form of mathematics where the operator (+,-) comes before the operands (4,7).

```
(+ 4 7) => 11
```
	
## Use
This integrals program has several built in testing evaluation functions (t1-t20), but you may also make use of the integrate function to draft your own equations.

```
(t1)
(t2)
(integrate '(14 x y) 'x)
(integrate '(- (+ (- - x) x)) 'x 1 4))
```
<b>Test Functions</b>: \
t1 integrates 1 dx \
t2 integrates 1 dy | lo 1 / hi 4 \
t3 integrates z dz \
t4 integrates x+0 dx \
t5 integrates -x dx | lo 1 hi 3 \
t6 integrates --x dx | lo 1 hi 4 \
t7 integrates -x dx \
t8 integrates --x dx \
t9 integrates ---x dx \
t10 integrates x+(-x) dx \
t11 integrates -((--x)+x) dx | lo 1 hi 4 \
t12 integrates ((--x)+(x+3))+2) dx | lo 2 hi 6 \
t13 integrates x-(x^3) dx \
t14 integrates x-(x^3) dx | lo 2 hi 5 \
t15 integrates (x+(---x))+(x^3) dx \
t16 integrates (x-(-x))+(x^3) dx | lo 2 hi 3 \
t17 integrates (x^(-1)) dx \
t18 integrates (x^(-1)) dx | lo 3 hi 45 \
t19 integrates (x+(5-x))+(x^(-1)) dx \
t20 integrates (x+(5-x))+(x^(-1)) dx | lo 5 hi 217
