def calculate(name1,name2):
    nam1=name1
    nam2=name2
    length1=len(name1)
    length2=len(name2)
    sumOfLen=length1+length2
    if(length1>length2):
        sumOfLen=sumOfLen-3
    else:
        sumOfLen=sumOfLen+5
        
    sumOfLen=sumOfLen*42
    sumOfLen=sumOfLen/(100+length2)
    if(sumOfLen>10):
        sumOfLen-10
    else:
        sumOfLen=round(sumOfLen,0)
        
    return sumOfLen