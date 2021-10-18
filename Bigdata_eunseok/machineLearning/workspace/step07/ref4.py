import numpy as np

a = np.array([5, 6, 7, 8])
b = np.array([1, 3, 4, 5])
print(a, b)
print('-' * 40)

# 공분산
print(np.cov(a, b))
print('-' * 40)

# 상관계수
print(np.corrcoef(a, b))
print('-' * 40)