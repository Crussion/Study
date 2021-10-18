import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import matplotlib.pyplot as plt

# 훈련셋
x_train = np.random.random((1000, 1))
y_train = x_train * 2 + np.random.random((1000, 1)) / 0.3

# 테스트셋
x_test = np.random.random((100, 1))
y_test = x_test * 2 + np.random.random((100, 1)) / 0.3

# 모델 구성
model = Sequential()
model.add(Dense(64, input_dim=1, activation='relu'))

# 모델 학습과정 설정
model.compile(loss='mse', optimizer='rmsprop')

# 모델 학습
hist = model.fit(x_train, y_train, 32, 50)

model.summary()

w = model.get_weights()
print('w=', w)
print('-' * 40)

plt.plot(hist.history['loss'], 'y', label='loss')
plt.xlabel('epoch')
plt.ylabel('loss')
plt.legend()
plt.show()

loss = model.evaluate(x_test, y_test, 10)
print('loss = ', loss)