from tensorflow.keras import utils
from tensorflow.keras.datasets import mnist
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import matplotlib.pyplot as plt

(x_train, y_train), (x_test, y_test) = mnist.load_data()

print(len(x_train))
print(len(y_train))
print(len(x_test))
print(len(y_test))

plt.imshow(x_train[0])
plt.show()

x_train = x_train.reshape(60000, 784).astype('float32') / 255.0
x_test = x_test.reshape(10000, 784).astype('float32') / 255.0

y_train = utils.to_categorical(y_train)
y_test = utils.to_categorical(y_test)

print(y_train[0])


model = Sequential()
model.add(Dense(units=64, input_dim=28*28, activation='relu'))
model.add(Dense(units=10, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='sgd',
              metrics=['accuracy'])

# x_train, y_tran : 훈련셋, x_train : 입력, y_train : 정답
# validation_data : 검증셋
# epochs : 학습 반복 횟수
# batch_size : 몇 개의 샘플로 가중치를 갱신할 것인지 지정
# verbose : 훈련과정 출력, 0 = 생략, 1 = 프로그래스 바, 2 = 결과만 출력, 기본 1
hist = model.fit(x_train, y_train, epochs=5, batch_size=1, verbose=1,
                 validation_data=(x_test, y_test))

print('loss :', hist.history['loss'])
print('accuracy :', hist.history['accuracy'])
print('val_loss :', hist.history['val_loss'])
print('val_accuracy :', hist.history['val_accuracy'])
print('-' * 40)

loss_and_metrics = model.evaluate(x_test, y_test, batch_size=32)
print('손실 :', loss_and_metrics[0])
print('정확도 :', loss_and_metrics[1])
print('-' * 40)

xhat = x_test[:1]
yhat = model.predict(xhat)
print('-' * 40)
