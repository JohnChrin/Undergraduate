# Unit Conversion Dictionary Program
# Author: John A Chrin
# Section: CS-171-A - FA 17-18
# Lab Sec: 062

# Ask the user for three inputs: 
#ASK 'value to be converted to float', 
#ASK 'type of units the value is currently in', 
#ASK 'target units to convert to'

# OUTPUT: Opening statement.
print("""Welcome to the length conversion wizard.
This program can convert between any of the following lengths.
inches
feet 
yards 
miles
leagues
centimeters
decimeters 
meters
decameters 
hectometers 
kilometers
Note: You must use the units exactly as spelled above.\n""")

# INPUT: Request information stuff and things.
number = float(input('Enter value:'))
funits = input('Enter from units:')
tunits = input('Enter to units:')

# DICTIONARY: Conversion of units compendium.
# BASE = inches
dic1 = {
	'inches': 1,
	'feet': 12, 
	'yards': 36,
	'miles': 63360,
	'leagues': 190080,
	'centimeters': 0.393701, 
	'decimeters': 3.93701,
	'meters': 39.3701,
	'decameters': 393.701,
	'hectometers': 3937.01,
	'kilometers': 39370.1}

# converts everything to inches
conv1 = (number * dic1[funits])
conv1 = (conv1 / dic1[tunits])


# OUTPUT: Conclude the user's query with requested conversions.
print(number, funits, 'is', conv1, tunits)



