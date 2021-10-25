import numpy as np

# (3, 3) 2차원 배열
arr = np.array([[1,2,3], [2,3,4], [3,4,5]])
print(arr)
print('-' * 40)

print(arr.shape)
print('-' * 40)

# (3, 3, 1) 3차원 배열
arr1 = arr.reshape(3, 3, 1)
print(arr1)
print('-' * 40)

print(arr1.shape)
print('-' * 40)

# shape값이 1인 값을 축소시킴
arr2 = arr1.squeeze()
print(arr2)
print('-' * 40)

print(arr2.shape)
print('-' * 40)

# (3, 1, 3) 3차원 배열
arr1 = arr.reshape(3, 1, 3)
print(arr1)
print('-' * 40)

print(arr1.shape)
print('-' * 40)

# shape값이 1인 값을 축소시킴
arr2 = arr1.squeeze()
print(arr2)
print('-' * 40)

print(arr2.shape)
print('-' * 40)