from tensorflow.keras import utils
from tensorflow.keras.datasets import mnist
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import matplotlib.pyplot as plt
import numpy as np
from tensorflow.keras.callbacks import Callback

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

class CustomHistory(Callback):
    def __init__(self):
        self.train_loss = []
        self.val_loss = []
        self.train_acc = []
        self.val_acc = []
        
    def on_epoch_end(self, batch, logs={}):
        self.train_loss.append(logs.get('loss'))
        self.val_loss.append(logs.get('val_loss'))
        self.train_acc.append(logs.get('accuracy'))
        self.val_acc.append(logs.get('val_accuracy'))

custom_hist = CustomHistory()

for i in range(5):
    model.fit(x_train, y_train, epochs=1, batch_size=32,
                 validation_data=(x_val, y_val), callbacks=[custom_hist])
    
plt.rcParams['figure.figsize'] = (12, 8)
fig, loss_ax = plt.subplots()
acc_ax = loss_ax.twinx()

loss_ax.plot(custom_hist.train_loss, 'y', label='train loss')
loss_ax.plot(custom_hist.val_loss, 'r', label='val loss')

acc_ax.plot(custom_hist.train_acc, 'b', label='train acc')
acc_ax.plot(custom_hist.val_acc, 'g', label='val acc')

loss_ax.set_xlabel('epoch')
loss_ax.set_ylabel('loss')
acc_ax.set_ylabel('accuracy')

loss_ax.legend(loc='upper left')
acc_ax.legend(loc='upper right')

plt.show()