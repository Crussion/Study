import numpy as np
from sklearn.preprocessing import MinMaxScaler
import matplotlib.pyplot as plt
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import *
import tensorflow.keras as keras

class CustomHistory(keras.callbacks.Callback):
    def __init__(self):
        self.train_loss=[]
        self.val_loss=[]
        self.train_acc=[]
        self.val_acc=[]
        
    def on_epoch_end(self, batch, logs={}):
        self.train_loss.append(logs.get('loss'))
        self.val_loss.append(logs.get('val_loss'))
        self.train_acc.append(logs.get('accuracy'))
        self.val_acc.append(logs.get('val_accuracy'))

def create_dataset(signal_data, look_back=1):
    data_x, data_y = [], []
    for i in range(len(signal_data) - look_back):
        data_x.append(signal_data[i:(i+look_back), 0])
        data_y.append(signal_data[i + look_back, 0])
    return np.array(data_x), np.array(data_y)

signal_data = np.cos(np.arange(1600) * 2 * np.pi / 100).reshape(-1, 1)

scaler = MinMaxScaler(feature_range=(0, 1))
signal_data = scaler.fit_transform(signal_data)

train = signal_data[:800]
val = signal_data[800:1200]
test = signal_data[1200:]

look_back = 40

x_train, y_train = create_dataset(train, look_back)
x_val, y_val = create_dataset(val, look_back)
x_test, y_test = create_dataset(test, look_back)

print(x_train.shape)
print(y_train.shape)
print(x_val.shape)
print(y_val.shape)
print(x_test.shape)
print(y_test.shape)

x_train = x_train.reshape(x_train.shape[0], x_train.shape[1], 1)
x_val = x_val.reshape(x_val.shape[0], x_val.shape[1], 1)
x_test = x_test.reshape(x_test.shape[0], x_test.shape[1], 1)

model = Sequential()
model.add(LSTM(32, batch_input_shape=(1, 40 , 1), stateful=True))
model.add(Dropout(0.3))
model.add(Dense(1))

model.compile(loss='mse', optimizer='adam')

custom_hist = CustomHistory()

for i in range(200):
    print('Epoch :', i+1, '/ 200')
    model.fit(x_train, y_train, 1, 1,
                     validation_data=(x_val, y_val),
                     shuffle=False, callbacks=[custom_hist])

plt.plot(custom_hist.train_loss)
plt.plot(custom_hist.val_loss)
plt.ylabel('loss')
plt.xlabel('epoch')
plt.legend(['train', 'val'])
plt.show()

scores = model.evaluate(x_test, y_test, batch_size=1)
print(scores)

yhat = model.predict(x_test, 1)

plot_x = np.arange(360)
plot_y = yhat.reshape(360)

plt.plot(plot_x, plot_y, 'r', label='prediction')
plt.plot(plot_x, y_test, 'b', label='y_test')
plt.show()