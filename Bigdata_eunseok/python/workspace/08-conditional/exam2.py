a = int(input('첫 번째 정수 입력 : '))
b = int(input('두 번째 정수 입력 : '))

'''
if(a<b):  
    # 변수값 교환
    tmp = a
    a = b
    b = tmp
'''

if a<b :
    a, b = b, a  # 변수값 교환
    
print("큰값 : %d, 작은값 : %d" %(a, b))


