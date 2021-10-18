import numpy as np
import matplotlib.pyplot as plt

x_train = np.random.random((1000, 1))
print(x_train[:5])
print('-' * 40)
print(x_train.shape)
print('-' * 40)

y_train = x_train * 2 + np.random.random((1000, 1)) / 0.3

print(y_train[:5])
print('-' * 40)
print(y_train.shape)
print('-' * 40)

x_test = np.random.random((100, 1))
y_test = x_test * 2 + np.random.random((100, 1)) / 0.3

print(x_test[:5])
print('-' * 40)
print(x_test.shape)
print('-' * 40)

print(y_test[:5])
print('-' * 40)
print(y_test.shape)
print('-' * 40)

plt.plot(x_train, y_train, 'ro')
plt.show()

plt.plot(x_test, y_test, 'bo')
plt.show()