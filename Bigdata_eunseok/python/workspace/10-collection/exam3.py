# index : 위치값
# 양수          0       1       2       3        4
# 음수         -5      -4      -3      -2       -1     
str_list = ['국어', '영어', '수학', '사회', '한국사']
print(str_list)
print('-' * 20)

# 인덱싱 (indexing) : 데이터 1개
print(str_list[0])
print(str_list[2])
print(str_list[4])
print('-' * 20)

print(str_list[-1])
print(str_list[-2])
print(str_list[-4])
print('-' * 20)

# 슬라이싱 (slicing) : 데이터 여러개
# [start=0: end: step=1]
print(str_list[1:5:2])
print('-' * 20)

print(str_list[1:5:1])
print('-' * 20)

print(str_list[1:5])
print('-' * 20)

print(str_list[:5])
print('-' * 20)

print(str_list[1:])
print('-' * 20)

print(str_list[:])
print('-' * 20)

print(str_list[::-1])
print('-' * 20)

print(str_list[::-2])
print('-' * 20)

# 데이터 유무 검사
if '사회' in str_list :
    print('데이터가 있음')
    print('위치 :', str_list.index('사회'))
else :
    print('데이터가 없음')

print('-' * 20)

# for문 사용
for v in str_list :
    print(v, end=' ')

