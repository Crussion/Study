import numpy as np
from sklearn.preprocessing import MinMaxScaler
import matplotlib.pyplot as plt

def create_dataset(signal_data, look_back=1):
    data_x, data_y = [], []
    for i in range(len(signal_data) - look_back):
        data_x.append(signal_data[i:(i+look_back), 0])
        data_y.append(signal_data[i + look_back, 0])
    return np.array(data_x), np.array(data_y)

# reshape(-1, 1): -1은 갯수에 상관없다는 뜻
signal_data = np.cos(np.arange(1600) * 2 * np.pi / 100).reshape(-1, 1)

print(signal_data.shape)

plt.plot(signal_data)
plt.show()

scaler = MinMaxScaler(feature_range=(0, 1))
signal_data = scaler.fit_transform(signal_data)

plt.plot(signal_data)
plt.show()

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