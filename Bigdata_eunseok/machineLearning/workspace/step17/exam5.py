from tensorflow.keras.datasets import reuters
from tensorflow.keras.preprocessing import sequence
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Embedding
from tensorflow.keras.layers import Conv1D, MaxPool1D
from tensorflow.keras.layers import LSTM
from tensorflow.keras.layers import Dense
import matplotlib.pyplot as plt
from tensorflow.keras import utils
import numpy as np

(x_train, y_train), (x_test, y_test) = reuters.load_data(num_words=20000)

for i in range(len(x_train)):
    x_train[i] = [w for w in x_train[i] if w > 2]

for i in range(len(x_test)):
    x_test[i] = [w for w in x_train[i] if w > 2]
    
y_train = utils.to_categorical(y_train)
y_test = utils.to_categorical(y_test)

print(x_train.shape)
print(y_train.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

x_val = x_train[7000:]
y_val = y_train[7000:]
x_train = x_train[:7000]
y_train = y_train[:7000]

print(x_train.shape)
print(y_train.shape)
print(x_val.shape)
print(y_val.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

x_train = sequence.pad_sequences(x_train, maxlen=120, truncating='post')
x_val = sequence.pad_sequences(x_val, maxlen=120, truncating='post')
x_test = sequence.pad_sequences(x_test, maxlen=120, truncating='post')

print(x_train.shape)
print(y_train.shape)
print(x_val.shape)
print(y_val.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

model = Sequential()
model.add(Embedding(15000, 128, input_length=120))
model.add(Conv1D(256, 3, padding='same', activation='relu'))
model.add(MaxPool1D((4,)))
model.add(LSTM(128))
model.add(Dense(46, activation='softmax'))

model.summary()

model.compile(loss='categorical_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, 32, 10, 
                 validation_data=(x_val, y_val))

loss = plt.subplot()
acc = loss.twinx()

loss.plot(hist.history['loss'], 'y', label='train loss')
loss.plot(hist.history['val_loss'], 'g', label='val loss')
acc.plot(hist.history['accuracy'], 'r', label='train accuracy')
acc.plot(hist.history['val_accuracy'], 'b', label='val accuracy')

loss.set_xlabel('epoch')
loss.set_ylabel('loss')
acc.set_ylabel('accuracy')

loss.legend(loc='lower left')
acc.legend(loc='upper left')

plt.show()

scores = model.evaluate(x_test, y_test)
print(scores)

yhat = model.predict(x_test)

print(np.argmax(y_test, axis=1)[:10])
print(np.argmax(yhat, axis=1)[:10])
