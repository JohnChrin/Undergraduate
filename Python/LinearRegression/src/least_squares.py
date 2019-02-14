# List Squares Linear Regression Program
# Author: John A Chrin
# Section: CS-171-A - FA 17-18
# Lab Sec: 062

import sys
import csv

# Denominator's first three letters are 'den' not 'dem' 

# Begin program
print('Welcome to Linear Regression Generator')
csv_file = open(input("Enter File Name Containing Data :"), 'r')
text = csv.reader(csv_file)

# Read CSV into a list
num = []
den = []
for row in text:
    x = row[0]
    den.append(x)
    y = row[1]
    num.append(y)

# Remove titles
num.pop(0)
den.pop(0)

# Convert values of list into new floats list for decimal accuracy
n = [float(y) for y in num]
d = [float(x) for x in den]

# Create regression formula
avgnum = sum(n) / len(n)
avgden = sum(d) / len(d)

mnum = []
mden = []
i = 0
while i < len(n):
    xnum = (n[i] - avgnum ) * (d[i] - avgden)
    xden = (d[i] - avgden) ** 2
    mnum.append(xnum)
    mden.append(xden)
    i += 1

    # Calculate the slope "m" and intercept "b"
mnumsum = sum(mnum)
mdensum = sum(mden)
m = (mnumsum / mdensum)
b = (avgnum  - (m * avgden))

    # Ensure the print statement is positive
if b < 0:
    print("The Linear Regression Line is y=" + str(round(m, 5)) + "*x-" + str(b * (-1)) + ".")
else:
    print("The Linear Regression Line is y=" + str(round(m, 5)) + "*x+" + str(b) + ".")

# Average error
avgerr_list = []
k = 0
while k < len(n):
    avgerrval = m * d[k] + bItrpt
    error = n[k] - avgerrval
    if error < 0:
        error = error * (-1)
    avgerr_list.append(error)
    k+=1
avgerror = round((sum(avgerr_list) / len(avgerr_list)), 5)

print('Average Error for Known Values was +/-' + str(avgerror) + "." )

# Standard error
stderr_list = []
p = 0
while p < len(n):
    stderr = (avgerr_list[p]) ** 2
    stderr_list.append(stderr)
    p+=1

realstderr = sum(stderr_list)
mrealstderr = ((1 / (len(n) - 2)) * stderr_list)
rootstderr = round((mrealstderr ** (1 / 2)), 5)

print("Regression Standard Error for Known Values was " + str(rootstderr) + ".")

print('System ready to make predictions')
print('To quit, type "exit " as the year')
value = input('Enter Year:')