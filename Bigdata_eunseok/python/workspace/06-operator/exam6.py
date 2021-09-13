# 논리연산자 : 양쪽값이 반드시 boolean 값이어야함
# and : 어느 한쪽이라도 False 이면, False, 교집합
# or :  어느 한쪽이라도 True 이면, True, 합집합
# not : boolean 상태를 바꿈, 여집합

a = 100
b = 200
x = 5
y = 3

print((a>=b) and (x>=y))
print('-' * 20)

print((a>=b) or (x>=y))
print('-' * 20)

print(not((a>=b) or (x>=y)))
print('-' * 20)







