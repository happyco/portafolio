objective of the script

read the regular expresion and compare the registers between two files, it takes the final value of the register before comparation

e.g. 
REG:0, 0, 0x780, 1, 1, 0xFF

register 0x780 has value 0xFF on positition 0,0

the script at this point only compare the register of the array 0,0, it was left open for future request


how to use it:

run the script python selftest-registers.py <golden log>.log <test log>.log

it will genearte a result file with the comparation if the files have the same value for the register, the csv result will be blank
if the is register with different value it will be displayed on the result csv file

Note:
run createreg.py to simulate the inputs