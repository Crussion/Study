from tensorflow.keras.datasets import fashion_mnist
from tensorflow.keras import utils
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D, MaxPooling2D, Flatten, Dense
import matplotlib.pyplot as plt
import numpy as np

(x_train, y_train), (x_test, y_test) = fashion_mnist.load_data()

y_train = utils.to_categorical(y_train)
y_test = utils.to_categorical(y_test)

x_train = x_train.reshape(60000, 28, 28, 1).astype('float32') / 255
x_test = x_test.reshape(10000, 28, 28, 1).astype('float32') / 255

x_val = x_train[50000:]
y_val = y_train[50000:]
x_train = x_train[:50000]
y_train = y_train[:50000]

model = Sequential()
model.add(Conv2D(256, (3,3), padding='same', input_shape=(28, 28, 1)))
model.add(MaxPooling2D())
model.add(Conv2D(128, (3,3), padding='same'))
model.add(MaxPooling2D())
model.add(Flatten())
model.add(Dense(64, activation='relu'))
model.add(Dense(10, activation='softmax'))
model.summary()

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

loss.set_xlabel('epoch')
loss.set_ylabel('loss')
acc.set_ylabel('accuracy')

loss.legend(loc='lower left')
acc.legend(loc='upper left')

plt.show()

scores = model.evaluate(x_test, y_test)
print('로스 : %f, 정확도: %.2f%%' %(scores[0], scores[1] * 100))

yhat = model.predict(x_test)

plt.rcParams['figure.figsize'] = (12, 12)
fig, sub = plt.subplots(5, 5)

for i in range(25):
    ax = sub[i//5, i%5]
    ax.imshow(x_test[i].reshape(28, 28))
    title = 'R: %d, P: %d' %(np.argmax(y_test[i]), np.argmax(yhat[i]))
    ax.set_title(title)
    ax.axis('off')
    
plt.show()
