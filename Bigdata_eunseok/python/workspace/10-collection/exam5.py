str_list = ['국어', '영어', '수학', '사회', '한국사']
print(str_list)
print('-' * 20)

# 항목 변경 : 인덱싱
str_list[3] = '과학'
print(str_list)
print('-' * 20)

# 항목 추가 : 제일 뒤에 추가
str_list.append('세계사')
print(str_list)
print('-' * 20)

# 함목 추가 : 중간에 추가
str_list.insert(2, '일본어')
print(str_list)
print('-' * 20)

# 데이터 정렬 1 : 파이썬 내장함수 이용
# => 원본을 건드리지 않고, 정렬 결과값 리턴
print(sorted(str_list)) # 오름차순
print('-' * 20)

print(sorted(str_list, reverse=True)) # 내림차순
print('-' * 20)

print(str_list)
print('=' * 20)

# 데이터 정렬2 : list 내장함수 이용
# => 원본을 수정함
str_list.sort()   # 오름차순

print(str_list)
print('-' * 20)

str_list.sort(reverse=True)   # 내림차순

print(str_list)
print('=' * 20)

# 데이터 삭제1 : 인덱싱과 슬라이싱으로 삭제
del(str_list[4])
print(str_list)
print('-' * 20)

del(str_list[1:3])
print(str_list)
print('-' * 20)

# 데이터 삭제2 : 데이터로 삭제
if '영어' in str_list :
    str_list.remove('영어')

print(str_list)
print('-' * 20)

if '수학' in str_list :
    str_list.remove('수학')

print(str_list)
print('-' * 20)

# 모든 데이터 삭제
str_list.clear()
print(str_list)
print('-' * 20)



