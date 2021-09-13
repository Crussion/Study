st1 = 'abcdcba1'

print(st1)
print(st1[::-1])
print('-' * 20)

print(st1, ": 회문" if st1==st1[::-1] else ": 회문 아님")

