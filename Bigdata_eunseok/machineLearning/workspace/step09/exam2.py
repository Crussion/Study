import numpy as np
from tensorflow.keras.utils import to_categorical
from tensorflow.keras.layers import Dense
from tensorflow.keras.models import Sequential
import matplotlib.pyplot as plt

x_train = np.random.random((1000, 12))
y_train = np.random.randint(10, size=(1000, 1))
x_test = np.random.random((100, 12))
y_test = np.random.randint(10, size=(100, 1))

y_train = to_categorical(y_train, num_classes=10)
y_test = to_categorical(y_test, num_classes=10)

# 모델 구성
model = Sequential()
model.add(Dense(10, activation='softmax', input_shape=(12,)))

# 모델 학습과정
model.compile(loss='binary_crossentropy', metrics=['accuracy'])

# 모델 학습
hist = model.fit(x_train, y_train, 10, 200)

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

# 모델 평가
scores = model.evaluate(x_test, y_test)
print('로스 :', scores[0])
print('정확도 : %.2f%%' %(scores[1] * 100))