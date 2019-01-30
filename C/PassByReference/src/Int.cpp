/*
 Name: John A Chrin
 Course: CSC345
 Date: 2018/09/02
 Assignment: 0
 Purpose: This program does pass by reference
 math.
 */
#include<iostream>

using namespace std;

// initialize functions to do math (& = pass by reference modifier).
int square(int& i);
int twice(int& i);
int once(int& i);

// where the code is called/executed.
int main()
	{
		int x = 3;
		int y = square(x) + twice(x) + once(x);
		cout << y << endl;
		return 0;
	}

// 3 functions doing math for the main body.
int square(int& i)
	{
		i = i * i;
		return i;
	}
int twice(int& i)
	{
		i = 2 * i;
		return i;
	}
int once(int& i)
	{
		return i;
	}
