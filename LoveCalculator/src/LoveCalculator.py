'''
Created on 17-Sep-2016

@author: user
'''
from cmd import PROMPT
from time import sleep
from src.PercentageCalculator import calculate



name1=raw_input("Enter your name\n ")
print 
sleep(1)
name2=raw_input("Enter your Lover Name\n")
sleep(1)
print
print("Thanks for entering yours and your lovers name")
print 
print("Please wait for some time as we are calculating the match. Hope you both will be made for each other")
sleep(2)
# def PercentageCalculator(name1,name2):
#         nam1=name1
#         nam2=name2
#         return 90
result=calculate(name1,name2)
print(result)
if(result<35 and result!=0):
    print("The love percentage is too low and you should create an intimacy")
elif(result>=35 and result<=70):
    print("Your love percentage is some what ok and you should improve it")
elif(result>=70 and result<=90):
    print("your love percentage is above 70. You might be the best")
elif(result>90):
    print("You are the best match in this world and your score is")
    
    



