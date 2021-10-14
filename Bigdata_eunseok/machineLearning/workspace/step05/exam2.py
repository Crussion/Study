from tensorflow.keras import utils
from tensorflow.keras.datasets import mnist
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import numpy as np
import matplotlib.pyplot as plt

# 데이터셋
(x_train, y_train), (x_test, y_test) = mnist.load_data()

# 정규값 변환
x_train = x_train.reshape(60000, 784).astype('float32') / 255.0
x_test = x_test.reshape(10000, 784).astype('float32') / 255.0

# on hot encoding
y_train = utils.to_categorical(y_train)
y_test = utils.to_categorical(y_test)

# 훈련셋과 검증셋으로 분리
x_val = x_train[42000:]
x_train = x_train[:42000]

y_val = y_train[42000:]
y_train = y_train[:42000]

# 모델 구성
model = Sequential()
model.add(Dense(units=64, input_dim=28*28, activation='relu'))
model.add(Dense(units=10, activation='softmax'))

# 모델 학습과정 설정
model.compile(loss='categorical_crossentropy', optimizer='sgd',
              metrics=['accuracy'])

# 모델 학습
model.fit(x_train, y_train, epochs=5, batch_size=32,
          validation_data=(x_val, y_val))

# 모델 평가
loss_and_metrics = model.evaluate(x_test, y_test, batch_size=32)

print('손실 :', loss_and_metrics[0])
print('정확도 :', loss_and_metrics[1])
print('-' * 40)

# 모델 사용
xhat_idx = np.random.choice(x_test.shape[0], 5)
xhat = x_test[xhat_idx]
yhat = np.argmax(model.predict(xhat), axis=1)
    
# 모델 저장
model.save('mnist_mlp_model.h5')
print('저장 완료')