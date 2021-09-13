# 아이덴티티 연산자
# is : 레퍼런스 변수값이 같은 지 검사
#      True : 레퍼런스 값이 같음, False : 레퍼런스 값이 다름
# is not : 레퍼런스 변수값이 같지 않은 지 검사
#      True : 레퍼런스 값이 다름, False : 레퍼런스 값이 같음

a = 10
b = 2
c = 10
d = a

print('a =', a, ',', id(a))
print('b =', b, ',', id(b))
print('c =', c, ',', id(c))
print('d =', d, ',', id(d))
print('-' * 20)

print('a is b --> ', a is b)
print('a is c --> ', a is c)
print('a is d --> ', a is d)
print('-' * 20)

print('a is not b --> ', a is not b)
print('a is not c --> ', a is not c)
print('a is not d --> ', a is not d)
print('-' * 20)








