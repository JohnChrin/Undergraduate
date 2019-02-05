So at first, I thought I could solve it from using a simple array
and emplacing numbers that fit in a chronological order, such as:

123456789 \
2 . . . . . . . . \
3 . . . . . . . . \
4 . . . . . . . . \
5 . . . . . . . . \
6 . . . . . . . . \
7 . . . . . . . . \
8 . . . . . . . . \
9 . . . . . . . . 

This clearly did not work, and I did not take into account the 3x3 check.
So obviously I decided to try something else stupid, I thought using a random
number generator and trying to brute-force guess my way to the end was
a feasible approach... Wrong...

The real solution came into view when I finally incorporated the 3x3 box-check.
After that, I had to figure out how to make a mutable i & j (row & column)
variable. This was accomplished from arrays.

1.) Draft up an empty array.
2.) Recursive boolean solvePuzzle that does this:
	A.) Checks for empty space, starting at beginning [0][0].
	B.) Attempts to populate empty space with 1.
	C.) If it passes row check, column check, and box check, place 1.
		i.) If it fails any one of these, increment 1 and try again.
		ii.) If it fails 1-9, go back one block and try the next #.
		iii.) If that new # fails, go back another block, ect...
	D.) When the boolean solvePuzzle has no empty spaces, it achieves
	    solved status and moves to the main's boolean of print the array.
3.) Print array.

The magic involved here is, endlessly openning up a stack up to instance 81,
but going backwards as far as necessary in the stack as it takes to input
a valid number that progresses the sequence forward. Brain hurts.
