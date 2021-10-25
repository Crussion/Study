from tensorflow.keras.datasets import imdb
from tensorflow.keras.preprocessing import sequence
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Embedding
from tensorflow.keras.layers import Dense
from tensorflow.keras.layers import LSTM
import matplotlib.pyplot as plt
import numpy as np

(x_train, y_train), (x_test, y_test) = imdb.load_data(num_words=20000)

for i in range(len(x_train)):
    x_train[i] = [w for w in x_train[i] if w > 2]
    
for i in range(len(x_test)):
    x_test[i] = [w for w in x_train[i] if w > 2]

x_val = x_train[20000:]
y_val = y_train[20000:]
x_train = x_train[:20000]
y_train = y_train[:20000]

x_train = sequence.pad_sequences(x_train, maxlen=200, truncating='post')
x_val = sequence.pad_sequences(x_val, maxlen=200, truncating='post')
x_test = sequence.pad_sequences(x_test, maxlen=200, truncating='post')

print(x_train.shape)
print(y_train.shape)
print(x_val.shape)
print(y_val.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

model = Sequential()
model.add(Embedding(20000, 128, input_length=200))
model.add(LSTM(128))
model.add(Dense(1, activation='sigmoid'))

model.summary()

model.compile(loss='binary_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, 32, 10,
                 validation_data=(x_val, y_val))

loss = plt.subplot()
acc = loss.twinx()

loss.plot(hist.history['loss'], 'y', label='train loss')
loss.plot(hist.history['val_loss'], 'g', label='val loss')

acc.plot(hist.history['accuracy'], 'r', label='train accuray')
acc.plot(hist.history['val_accuracy'], 'b', label='val accuray')

loss.set_xlabel('epoch')
loss.set_ylabel('loss')
acc.set_ylabel('accuray')
loss.legend(loc='lower left')
acc.legend(loc='upper left')
plt.show()

scores = model.evaluate(x_test, y_test)
print(scores)

yhat = model.predict(x_test)

pred_result = np.array([1 if i > 0.5 else 0 for i in yhat])

print('실제값 :',y_test[:10])
print('예측값 :',pred_result[:10])
