from tensorflow.keras import utils
from tensorflow.keras.datasets import mnist
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import matplotlib.pyplot as plt
import numpy as np

np.random.seed(3)

(x_train, y_train), (x_test, y_test) = mnist.load_data()

x_val = x_train[50000:] # 검증셋 설정하기, 1만개
y_val = y_train[50000:]
x_train = x_train[:50000]
y_train = y_train[:50000]

# 모든 값을 0~1로 변경
x_val = x_val.reshape(10000, 28*28).astype('float32') / 255.0
x_train = x_train.reshape(50000, 28*28).astype('float32') / 255.0
x_test = x_test.reshape(10000, 28*28).astype('float32') / 255.0

# 라벨링 전환 : on hot encoding
y_train = utils.to_categorical(y_train)
y_val = utils.to_categorical(y_val)
y_test = utils.to_categorical(y_test)

# 모델 구성
model = Sequential()
model.add(Dense(units=64, input_dim=28*28, activation='relu'))
model.add(Dense(units=10, activation='softmax'))

# 모델 학습과정 설정
model.compile(loss='categorical_crossentropy', optimizer='sgd',
              metrics=['accuracy'])

# 모델 학습
hist = model.fit(x_train, y_train, epochs=5, batch_size=32,
                 validation_data=(x_val, y_val))

print('loss :', hist.history['loss'])
print('accuracy :', hist.history['accuracy'])
print('val_loss :', hist.history['val_loss'])
print('val_accuracy :', hist.history['val_accuracy'])
print('-' * 40)

plt.rcParams['figure.figsize'] = (12, 8)

# fig: 그래프창, loss_ax: 단일축에 변수 ax 사용
fig, loss_ax = plt.subplot()