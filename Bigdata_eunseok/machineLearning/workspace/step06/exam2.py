import numpy as np
from pandas import read_csv
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import matplotlib.pyplot as plt

np.random.seed(5)

df = read_csv('data/diabetes.csv', header=None)

print(df)
print('-' * 40)

dataset = df.values
print(dataset)
print('-' * 40)

print(dataset.shape)
print('-' * 40)

df.boxplot()
plt.show()

x_train = dataset[:700, 0:8]
y_train = dataset[:700, 8]

x_test = dataset[700:, 0:8]
y_test = dataset[700:, 8]

model = Sequential()
model.add(Dense(12, 'relu', input_shape=(8,)))
model.add(Dense(8, 'relu'))
model.add(Dense(1, 'sigmoid'))

model.compile(loss='binary_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, epochs=200, batch_size=40)

fig, loss_ax = plt.subplots()
acc_ax = loss_ax.twinx()

loss_ax.plot(hist.history['loss'], 'y', label='train loss')
acc_ax.plot(hist.history['accuracy'], 'b', label='train acc')

loss_ax.set_xlabel('epoch')
loss_ax.set_ylabel('loss')
acc_ax.set_ylabel('accuracy')

loss_ax.legend(loc='upper left')
acc_ax.legend(loc='lower left')
plt.show()

scores = model.evaluate(x_test, y_test)
print('정확도 : %.2f%%' %(scores[1] * 100))