num = int(input("원하는 숫자를 입력하세요 : "))
num2 = 0

for x in range (1,101) :  #(1~100)
    if x % num == 0 :
        print(x, end=" ")
        num2 += 1    #num2 = num2 + 1
        
print("")  # 줄넘김        
print('1~100 사이의 %d의 배수 갯수 = %d' %(num, num2))  

