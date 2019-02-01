
(* NAME: John A Chrin *)
(* DATE: 18/11/29 *)

(*================================================================================*)
(* Data Types & Tests *)

datatype X = A|B|C|D|E|F|G|H;
datatype 'a BT = empty | bTree of 'a * 'a BT * 'a BT;

val t1 = bTree(1,
       bTree(2,bTree(3,empty,empty),bTree(4,empty,empty)),
       bTree(5,bTree(6,empty,empty),bTree(7,empty,empty)));

val t2 = bTree(A,
       bTree(B,bTree(D,empty,empty),bTree(E,empty,empty)),
       bTree(C,bTree(F,empty,empty),bTree(G,empty,empty)));

val t3 = bTree(1.22,bTree(2.33,empty,empty),bTree(3.44,empty,empty));

val t4 = bTree("A",
             bTree("B",bTree("C",bTree
	       ("E",empty,empty),empty),bTree
	       ("D",bTree("F",empty,empty),bTree
	       ("G",bTree("H",empty,empty),empty))),
             bTree("I",bTree("J",empty,bTree
	       ("K",bTree("L",empty,empty),bTree
	       ("M",empty,empty))),empty));

(*================================================================================*)
(* Binary Tree Ordering Functions *)

fun preOrder empty = nil
  | preOrder (bTree(s,left,right)) = [s]@(preOrder left)@(preOrder right);
				    
fun inOrder empty = nil 
  | inOrder (bTree(s,left,right)) = (inOrder left)@[s]@(inOrder right);

fun postOrder empty = nil
  | postOrder (bTree(s,left,right)) = (postOrder left)@(postOrder right)@[s];

(*================================================================================*)
(* Print Type Functions *)
fun printInt n = print(Int.toString n);
fun printReal n = print(Real.toString n);
fun printX A = print "A"
  | printX B = print "B"
  | printX C = print "C"
  | printX D = print "D"
  | printX E = print "E"
  | printX F = print "F"
  | printX G = print "G"
  | printX H = print "H";

(*================================================================================*)
(* Display Binary Trees Functions *)

val indentLevel = 2;

fun tab n = if n = 0 then print "" else (print "  "; tab(n-1));

fun displayNode (x,n,printy : 'a -> unit) = (print "\n"; tab n; printy x);

fun dash (m,n) = (print "\n"; tab m; print "-");

fun displayTreeIndent (bTree(x,empty,empty),n,printy) = (displayNode(x,n+1,printy))
  | displayTreeIndent (bTree(x,empty,right),n,printy) = (displayNode(x,n+1,printy);
							   dash(n+2,1);
							   displayTreeIndent(right,n+1,printy))
  | displayTreeIndent (bTree(x,left,empty),n,printy) =  (displayNode(x,n+1,printy);
							   displayTreeIndent(left,n+1,printy);
							   dash(n+2,1))
  | displayTreeIndent (bTree(x,left,right),n,printy) =  (displayNode(x,n+1,printy);
							   displayTreeIndent(left,n+1,printy);
							   displayTreeIndent(right,n+1,printy))
  | displayTreeIndent (_,n,printy) = (print ""); 

fun displayTree (bTree(x,left,right),printy : 'a -> unit) =
    let
	val n = 0
    in
	(printy x; displayTreeIndent(left,n,printy);
	 displayTreeIndent(right,n,printy);
	 print "\n")
    end;
 
				    
