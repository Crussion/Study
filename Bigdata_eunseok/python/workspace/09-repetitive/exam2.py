a = 0
b = 0

for x in range(1, 101) :  # (1~100)
    if x%5 == 0 : a += x    # 5의 배수의 합 구하기
    if x%7 == 0 : b += x    # 7의 배수의 합 구하기
    
print('%d - %d = %d' %(a, b, a-b))
    


