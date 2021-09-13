# bool(데이터) : 데이터가 있는 지 없는 지 검사
#                True : 데이터 있음, False : 데이터 없음
# 주의 : 숫자는 '0'은 False, '0'이 아니면 True
a = 1
b = 0
print(bool(a), bool(b))
print('-' * 20)

a = 'ab'
b = ''
print(bool(a), bool(b))
print('-' * 20)

# None : 데이터가 없음을 나타내는 데이터
a = None
print(bool(a))
print('-' * 20)