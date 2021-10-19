import numpy as np
import matplotlib.pyplot as plt

from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.layers import Conv2D
from tensorflow.keras.layers import MaxPooling2D
from tensorflow.keras.layers import Flatten

width = 16
height = 16

def generate_dataset(samples):
    ds_x = []
    ds_y = []
    
    for i in range(samples):
        point_num = np.random.randint(0, width * height)
        img = generate_image(point_num)
        ds_x.append(img)
        ds_y.append(point_num)
    
    x_train = np.array(ds_x)
    y_train = np.array(ds_y).reshape(samples, 1)
    return x_train, y_train
        
def generate_image(point_num):
    img = np.zeros((width, height))
    points = np.random.random((point_num, 2))
    
    for point in points:
        img[int(point[0] * width), int(point[1] * height)] = 1
        
    return img.reshape(width, height, 1)

np.random.seed(5)

x_train, y_train = generate_dataset(1500)
x_val, y_val = generate_dataset(300)
x_test, y_test = generate_dataset(100)

print(x_train.shape)
print(y_train.shape)
print(x_val.shape)
print(y_val.shape)
print(x_test.shape)
print(y_test.shape)

model = Sequential()
model.add(Conv2D(32, (3,3), activation='relu', input_shape=(width, height, 1)))
model.add(MaxPooling2D((2, 2)))
model.add(Conv2D(32, (3,3), activation='relu'))
model.add(MaxPooling2D((2, 2)))
model.add(Flatten())

model.add(Dense(256))
model.add(Dense(1))

model.summary()

model.compile(loss='mse', optimizer='adam')

hist = model.fit(x_train, y_train, 32, 1000,
          validation_data=(x_val, y_val))

plt.plot(hist.history['loss'])
plt.plot(hist.history['val_loss'])
plt.legend(['train', 'val'], loc='upper left')
plt.xlabel('epoch')
plt.ylabel('loss')
plt.show()

score = model.evaluate(x_test, y_test)
print(score)

yhat_test = model.predict(x_test)


plt.rcParams['figure.figsize'] = (12, 8)
fig, axarr = plt.subplots(5, 5)

for i in range(5 * 5):
    sub_plt = axarr[i//5, i%5]
    sub_plt.axis('off')
    sub_plt.imshow(x_test[i].reshape(width, height))
    sub_plt.set_title('R %d, p %d' %(y_test[i][0], yhat_test[i][0]))
    
plt.show()
