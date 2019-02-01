(* Homework #3 in SML for creating three functions *)
fun flip (x::y::xys) = y::x::flip(xys) 
  | flip (nil) = nil 
  | flip ([x]) = [x];

fun deleteIth (nil, _) = nil
  | deleteIth (_::xs, 1) = xs 
  | deleteIth (x::xs, i) = x::deleteIth(xs, i-1);

(*IF - begin with vowel THEN - append "yay" *)
(*ELSE - Move non-vowels to end of word UNTIL vowel is front THEN append "ay" *)
fun piglatinize (str: string) = let val c = explode(str)
                                    val isVowel = Char.contains "AEIOUaeiou"
				in
				    if List.exists isVowel c then 
				      if vowel(List.nth(c,0)) then implode c ^ "yay"
				      else (implode (piglatinizesub(c)) ^ "ay")
				    else implode c
				end

and


piglatinizesub (nil) = nil 
  | piglatinizesub (x::xs : char list) = if vowel(x) then x::xs
					 else piglatinizesub(xs@[x])

and


vowel (i) = if (i = #"A") orelse
		   (i = #"a") orelse
		   (i = #"E") orelse
                   (i = #"e") orelse
		   (i = #"I") orelse
                   (i = #"i") orelse
		   (i = #"O") orelse
                   (i = #"o") orelse
		   (i = #"U") orelse
                   (i = #"u") then true else false;
