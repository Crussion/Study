from tensorflow.keras.datasets import cifar10
import ssl

import numpy as np
import matplotlib.pyplot as plt

import tensorflow
from tensorflow.keras import utils
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D
from tensorflow.keras.layers import MaxPooling2D
from tensorflow.keras.layers import Flatten
from tensorflow.keras.layers import Dense
from tensorflow.keras.layers import Dropout

tensorflow.device("/cpu:0")

ssl._create_default_https_context = ssl._create_unverified_context

(x_train, y_train), (x_test, y_test) = cifar10.load_data()

print(x_train.shape)
print(y_train.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

y_train = utils.to_categorical(y_train)
y_test = utils.to_categorical(y_test)

x_val = x_train[40000:]
y_val = y_train[40000:]
x_train = x_train[:40000]
y_train = y_train[:40000]

print(x_train.shape)
print(y_train.shape)
print(x_test.shape)
print(y_test.shape)

model = Sequential()
model.add(Conv2D(3, (3, 3), activation='relu', input_shape=(32, 32, 3)))
model.add(MaxPooling2D((2, 2)))
model.add(Dropout(0.25))
model.add(Conv2D(3, (3, 3), activation='relu'))
model.add(MaxPooling2D((2, 2)))
model.add(Dropout(0.25))
model.add(Flatten())
model.add(Dense(256, activation='relu'))
model.add(Dense(64, activation='relu'))
model.add(Dropout(0.25))
model.add(Dense(32, activation='relu'))
model.add(Dense(10, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, 32, 30,
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

class_names = ['airplane', 'automobile', 'bird', 'cat', 'deer',
               'dog', 'frog', 'horse', 'ship', 'truck']

for i in range(25) :
    while np.argmax(y_test[n]) != np.argmax(y_hat_test[n]):
        n += 1
    sub_plt = axarr[i//5, i%5]
    sub_plt.axis('off')
    sub_plt.imshow(x_test[n])
    
    sub_plt_title = 'R: ' + str(np.argmax(y_test[n])) + ', P: ' + str(np.argmax(y_hat_test[n]))
    sub_plt_title += ', ' + class_names[np.argmax(y_test[n])]
    sub_plt.set_title(sub_plt_title)
    n += 1
    
plt.show()