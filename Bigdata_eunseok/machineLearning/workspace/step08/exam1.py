import numpy as np
import matplotlib.pyplot as plt

x_train = np.random.random((1000, 12))
y_train = np.random.randint(2, size=(1000, 1))
x_test = np.random.random((100, 12))
y_test = np.random.randint(2, size=(100, 1))

print(x_train[:5])
print(y_train[:5])
print('-' * 40)

print(x_train.shape)
print(y_train.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

plt.scatter([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
            c=range(10))

plt.show()

plot_x = x_train[:, 0]
plot_y = x_train[:, 1]
colors = y_train.reshape(1000)
plt.scatter(plot_x, plot_y, c=colors)
plt.show()

plot_x = x_train[:, 0]
plot_y = x_train[:, 1]
plot_z = x_train[:, 2]
colors = y_train.reshape(1000)

fig = plt.figure()
ax = fig.add_subplot(1, 1, 1, projection='3d')

ax.scatter(plot_x, plot_y, plot_z, c=colors)
plt.show()