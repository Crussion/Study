import numpy as np
from tensorflow.keras.preprocessing.image import ImageDataGenerator
import matplotlib.pyplot as plt
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.layers import Conv2D
from tensorflow.keras.layers import Flatten
from tensorflow.keras.layers import MaxPooling2D

np.random.seed(5)

# 정규화 설정 (0~255) -> (0~1)
train_datagen = ImageDataGenerator(rescale=1/255)

train_generator = train_datagen.flow_from_directory(
    'handwriting_shape/train',
    target_size=(24, 24), batch_size=3,
    class_mode='categorical')

test_generator = train_datagen.flow_from_directory(
    'handwriting_shape/test',
    target_size=(24, 24), batch_size=3,
    class_mode='categorical')

x_train_list = []
y_train_list = []

x_test_list = []
y_test_list = []

for i in range(15):
    img, label = train_generator.next()
    x_train_list.extend(img)
    y_train_list.extend(label)

for i in range(5):
    img, label = test_generator.next()
    x_test_list.extend(img)
    y_test_list.extend(label)
        
x_train = np.array(x_train_list)
y_train = np.array(y_train_list)

x_test = np.array(x_test_list)
y_test = np.array(y_test_list)

print(x_train.shape)
print('-' * 40)

print(y_train.shape)
print('-' * 40)

print(x_test.shape)
print('-' * 40)

print(y_test.shape)
print('-' * 40)
'''
model = Sequential()
model.add(Conv2D(32, kernel_size=(3,3), activation='relu', input_shape=(24,24,3)))
model.add(Conv2D(64, (3,3), activation='relu'))
model.add(MaxPooling2D((2, 2)))
model.add(Flatten())
model.add(Dense(128, activation='relu'))
model.add(Dense(3, activation='softmax'))
'''

x_train = x_train.reshape(45, 24*24*3)
x_test = x_test.reshape(15, 24*24*3)

model = Sequential()
model.add(Dense(64, activation='relu', input_shape=(24*24*3,)))
model.add(Dense(3, activation='softmax'))

model.summary()

model.compile(loss='categorical_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, epochs=50)

loss = plt.subplot()
acc = loss.twinx()

loss.plot(hist.history['loss'], 'y', label='loss')
acc.plot(hist.history['accuracy'], 'b', label='accuracy')

loss.set_xlabel('epoch')
loss.set_ylabel('loss')
acc.set_ylabel('accuracy')

loss.legend(loc='upper left')
acc.legend(loc='lower left')

plt.show()

scores = model.evaluate(x_test, y_test)
print('loss :', scores[0])
print('acc : %.2f%%' %(scores[1] * 100))

output = model.predict(x_test)
print('예측 :', np.argmax(output, axis=1))
print('정답 :', np.argmax(y_test, axis=1))