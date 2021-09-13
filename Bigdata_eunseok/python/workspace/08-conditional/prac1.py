num1=float(input('첫번째 수 :'))
num2=float(input('두번째 수 :'))
op= input('연산자 :')

result1=num1+num2
result2=num1-num2
result3=num1*num2
result4=num1/num2

if(op=='+'):
    print(num1,'+',num2,'=',result1)
elif(op=='-'):
    print(num1,'-',num2,'=',result2)
elif(op=='*'):
    print(num1,'*',num2,'=',result3)
elif(op=='/'):
    print(num1,'/',num2,'=',result4)  
else :
    print('입력값이 잘못되었습니다. 처음부터 다시 시작해주세요')    
print('-' * 20)


result = 0
    
if(op=='+'):
    result=num1+num2
elif(op=='-'):
    result=num1-num2
elif(op=='*'):
    result=num1*num2
elif(op=='/'):
    result=num1/num2  
else :
    print('입력값이 잘못되었습니다. 처음부터 다시 시작해주세요')  
    
print(num1, op, num2, '=', result) 





