import csv

csv_file = open(input("Enter File Name Containing Data :"), 'r')
file = csv.reader(csv_file)

num = []
dem = []
for row in file:
    X = row[0]
    dem.append(X)
    Y = row[1]
    num.append(Y)

nameX= dem[0]
nameY= num[0]
dem.pop(0)
num .pop(0)

d = [float(x) for x in dem]
n = [float(y) for y in num]

###########################  Calculation for Linear Regression Line  ############################
averageN = sum(n) / len(n)
averageD = sum(d) / len(d)

mnum = []
mdem = []
i = 0
while i < len(n):
    xnum = (n[i] - averageN ) * (d[i] - averageD)
    xdem = (d[i] - averageD) ** 2
    mnum.append(xnum)
    mdem.append(xdem)
    i += 1

mSumN = sum(mnum)
mSumD = sum(mdem)
m = (mSumN / mSumD)
b = (averageN  - (m * averageD))

if bItrpt < 0:
    print("The Linear Regression Line is y=" + str(round(m, 5)) + "*x-" + str(bItrpt * (-1)) + ".")
else:
    print("The Linear Regression Line is y=" + str(round(m, 5)) + "*x+" + str(bItrpt) + ".")

################################Calculation for average Error##############################
avEn = []
j = 0
while j < len(n):
    avgEnum = m * d[j] + bItrpt
    error = n[j] - avgEnum
    if error < 0:
        error = error * (-1)
    avEn.append(error)
    j += 1
avgError = round((sum(avEn) / len(avEn)), 5)

print("Average Error for Known Values was +/-" + str(avgError) + ".")

#######################Calculating Regression Standard Error and print it######################
reStEr = []
k = 0
while k < len(n):
    stdEr = (avEn[k]) ** 2
    reStEr.append(stdEr)
    k += 1

ReStEr = sum(reStEr)
mse = ((1 / (len(n) - 2)) * ReStEr)
root = round((mse ** (1 / 2)), 5)

print("Regression Standard Error for Known Values was " + str(root) + ".")