import numpy as np

arr1 = np.random.randint(10, size=(3, 4))
print(arr1)
print('-' * 40)

print(np.argmax(arr1))
print('-' * 40)

print(np.argmax([1, 0, 0, 0, 0, 0, 0, 0, 0, 0]))
print('-' * 40)

print(np.argmax([0, 1, 0, 0, 0, 0, 0, 0, 0, 0]))
print('-' * 40)


print(np.argmax([0, 0, 0, 0, 0, 0, 0, 0, 0, 1]))
print('-' * 40)
