import numpy as np
import matplotlib.pyplot as plt
from tensorflow.keras.datasets import mnist

from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.layers import Conv2D
from tensorflow.keras.layers import MaxPooling2D
from tensorflow.keras.layers import Flatten

width = 28
height = 28

(x_train, y_train), (x_test, y_test) = mnist.load_data()

x_train = x_train.reshape(60000, width, height, 1).astype('float32') / 255
x_test = x_test.reshape(10000, width, height, 1).astype('float32') / 255

x_val = x_train[50000:]
y_val = y_train[50000:]
x_train = x_train[:50000]
y_train = y_train[:50000]

y_train = y_train % 2
y_val = y_val % 2
y_test = y_test % 2

model = Sequential()
model.add(Conv2D(32, (3, 3), activation='relu', input_shape=(width, height, 1)))
model.add(MaxPooling2D(2, 2))
model.add(Conv2D(32, (3, 3), activation='relu'))
model.add(MaxPooling2D(2, 2))
model.add(Flatten())
model.add(Dense(256, activation='relu'))
model.add(Dense(1, activation='sigmoid'))

model.summary()

model.compile(loss='binary_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, 32, 10,
                 validation_data=(x_val, y_val))

loss = plt.subplot()
acc = loss.twinx()

loss.plot(hist.history['loss'], 'y', label='train loss')
loss.plot(hist.history['val_loss'], 'r', label='val loss')
acc.plot(hist.history['accuracy'], 'b', label='train acc')
acc.plot(hist.history['val_accuracy'], 'g', label='val acc')

loss.set_xlabel('epochs')
loss.set_ylabel('loss')
acc.set_ylabel('accuracy')

loss.legend()
acc.legend()

plt.show()

score = model.evaluate(x_test, y_test)
print(score)

y_hat_test = model.predict(x_test, 32)

plt.rcParams['figure.figsize'] = (12, 12)
fig, axarr = plt.subplots(5, 5)

for i in range(25) :
    sub_plt = axarr[i//5, i%5]
    sub_plt.axis('off')
    sub_plt.imshow(x_test[i].reshape(width, height))
    
    sub_plt_title = 'R: '
    
    if y_test[i]:
        sub_plt_title += 'odd'
    else:
        sub_plt_title += 'even'
        
    sub_plt_title += ', P: '
    
    if y_hat_test[i] >= 0.5:
        sub_plt_title += 'odd'
    else:
        sub_plt_title += 'even'
        
    sub_plt.set_title(sub_plt_title)
    
plt.show()