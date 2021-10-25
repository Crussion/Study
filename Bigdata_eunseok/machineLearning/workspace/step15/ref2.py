import numpy as np

a = np.array([1, 2, 3])
b = np.array([11, 12, 13])
r = np.hstack((a, b))

print(a)
print(b)
print(r)
print('-' * 40)

a = np.array([[1], [2], [3]])
b = np.array([[11], [12], [13]])
r = np.hstack((a, b))

print(a)
print(b)
print(r)
print('-' * 40)