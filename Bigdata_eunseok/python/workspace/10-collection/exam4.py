a = [1, 2, 3]
print(a)
print('-' * 20)


# 인덱싱 : 데이터 1개
print(a[1])
print('-' * 20)

a[1] = 100
print(a)
print('-' * 20)

a[2] = ['a', 'b', 'c']
print(a)
print('-' * 20)

print(a[2][1])
print('-' * 20)

# 슬라이싱 : 데이터 여러개
b = [1, 2, 3, 4, 5]
print(b)
print('-' * 20)

print(b[1:3])
print('-' * 20)

# 리스트에 슬라이싱으로 값을 저장할 경우, 해당부분이 대체됨
b[1:3] = [10, 20, 30]
print(b)
print('-' * 20)

b[1:3] = [100, 200]
print(b)
print('-' * 20)

b[1:3] = [1000]
print(b)
print('-' * 20)





