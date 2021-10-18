import numpy as np
import matplotlib.pyplot as plt
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

# 데이터 
x_train = np.random.random((1000, 12))
y_train = np.random.randint(2, size=(1000, 1))
x_test = np.random.random((100, 12))
y_test = np.random.randint(2, size=(100, 1))

# 모델 구성
model = Sequential()
model.add(Dense(64, activation='relu', input_shape=(12,)))
model.add(Dense(1, activation='sigmoid'))

print(x_train.shape)
print(y_train[:5])
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

# 모델 학습과정
model.compile(loss='binary_crossentropy', optimizer='rmsprop',
              metrics=['accuracy'])

# 모델 학습
hist = model.fit(x_train, y_train, 20, 200)

# 학습 과정
fig, loss = plt.subplots()
acc = loss.twinx()

loss.plot(hist.history['loss'], 'y', label='train loss')
acc.plot(hist.history['accuracy'], 'b', label='train accuracy')

loss.set_xlabel('epoch')
loss.set_ylabel('loss')
acc.set_ylabel('accuracy')

loss.legend(loc='upper left')
acc.legend(loc='lower left')
plt.show()

scores = model.evaluate(x_test, y_test)
print('로스 : %.2f%%' %(scores[0] * 100))
print('정확도 : %.2f%%' %(scores[1] * 100))