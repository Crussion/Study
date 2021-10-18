import numpy as np

arr1 = np.array([[3, 7, 5], [8, 4, 3], [2, 4, 9]])
print(arr1)
print('-' * 40)

# 분산
print(np.var(arr1))
print('-' * 40)

# 표준편차
print(np.std(arr1))
print('-' * 40)

# 표본 분산
print(np.var(arr1, ddof=1))
print('-' * 40)

# 표본 표준편차
print(np.std(arr1, ddof=1))
print('-' * 40)