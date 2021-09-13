for a in 'abcd' :
    print(a, end=' ')

print()  # 줄넘김
print('-' * 20)

# 참조 : 문자열의 슬라이싱 [start=0: end: step=1]
# range([start=0,] end[, step=1]) : 정수 만들기 함수
for i in range(1, 5, 2) :   # (1, 3)
    print(i, end=' ')

print()  # 줄넘김
print('-' * 20)

for i in range(1, 5, 1) :   # (1, 2, 3, 4)
    print(i, end=' ')

print()  # 줄넘김    
print('-' * 20)

for i in range(1, 5) :   # (1, 2, 3, 4)
    print(i, end=' ')

print()  # 줄넘김
print('-' * 20)

for i in range(5) :   # (0, 1, 2, 3, 4)
    print(i, end=' ')

print()  # 줄넘김
print('-' * 20)

for i in range(-5, 5) :   # (-5, -4, -3, -2, -1, 0, 1, 2, 3, 4)
    print(i, end=' ')

print()  # 줄넘김
print('-' * 20)