from tensorflow.keras.datasets import mnist
from tensorflow.keras import utils

from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

import numpy as np
import matplotlib.pyplot as plt

width = 28
height = 28

(x_train, y_train), (x_test, y_test) = mnist.load_data()

x_train = x_train.reshape(60000, width * height).astype('float32') / 255
x_test = x_test.reshape(10000, width * height).astype('float32') / 255

x_val = x_train[50000:]
y_val = y_train[50000:]
x_train = x_train[:50000]
y_train = y_train[:50000]

y_train = utils.to_categorical(y_train)
y_val = utils.to_categorical(y_val)
y_test = utils.to_categorical(y_test)

model = Sequential()
model.add(Dense(256, input_dim=width * height, activation='relu'))
model.add(Dense(256, activation='relu'))
model.add(Dense(256, activation='relu'))
model.add(Dense(10, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, batch_size=32, epochs=30,
                 validation_data=(x_val, y_val))

loss = plt.subplot()
acc = loss.twinx()

loss.plot(hist.history['loss'], 'y', label='train loss')
loss.plot(hist.history['val_loss'], 'g', label='val loss')
acc.plot(hist.history['accuracy'], 'r', label='accuracy')
acc.plot(hist.history['val_accuracy'], 'b', label='val accuracy')

loss.set_xlabel('epochs')
loss.set_ylabel('loss')
acc.set_ylabel('accuracy')

loss.legend(loc='lower right')
acc.legend(loc='upper right')

scores = model.evaluate(x_test, y_test, batch_size=32)
print(scores)

y_hat_test = model.predict(x_test, batch_size=32)

plt.rcParams['figure.figsize'] = (12, 12)
fig, axarr = plt.subplots(5, 5)

n = 0

for i in range(25) :
    while np.argmax(y_test[n]) == np.argmax(y_hat_test[n]):
        n += 1
    sub_plt = axarr[i//5, i%5]
    sub_plt.axis('off')
    sub_plt.imshow(x_test[n].reshape(width, height))
    
    sub_plt_title = 'R: ' + str(np.argmax(y_test[n])) + ', P: ' + str(np.argmax(y_hat_test[n]))
    sub_plt.set_title(sub_plt_title)
    n += 1
    
plt.show()