import numpy as np
import matplotlib.pyplot as plt

val = 2*np.pi / 100

# cos 1주기
print(np.cos(val * 0))
print(np.cos(val * 25))
print(np.cos(val * 50))
print(np.cos(val * 75))
print(np.cos(val * 100))
print('-' * 40)

# cos 16 주기

arr = np.arange(1600) * val

print(np.cos(arr))
print('-' * 40)

arr2 = np.cos(arr)

plt.plot(arr2)
plt.show()