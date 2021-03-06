import numpy as np
from tensorflow.keras.preprocessing.image import ImageDataGenerator
import matplotlib.pyplot as plt
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.layers import Conv2D
from tensorflow.keras.layers import Flatten
from tensorflow.keras.layers import MaxPooling2D

np.random.seed(5)

train_datagen = ImageDataGenerator(rescale=1/255, rotation_range=10,
                                   width_shift_range=0.2, height_shift_range=0.2,
                                   shear_range=0.7, zoom_range=[0.9, 2.2],
                                   horizontal_flip=True, vertical_flip=True,
                                   fill_mode='nearest')

test_datagen = ImageDataGenerator(rescale=1/255)

train_generator = train_datagen.flow_from_directory(
    'hard_handwriting_shape/train', target_size=(24, 24), batch_size=3)

test_generator = test_datagen.flow_from_directory(
    'hard_handwriting_shape/test', target_size=(24, 24), batch_size=3)

x_train_list = []
y_train_list = []

x_test_list = []
y_test_list = []

for i in range(3000):
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

model = Sequential()
model.add(Conv2D(32, kernel_size=(3,3), activation='relu', input_shape=(24,24,3)))
model.add(Conv2D(64, (3,3), activation='relu'))
model.add(MaxPooling2D((2, 2)))
model.add(Flatten())
model.add(Dense(128, activation='relu'))
model.add(Dense(3, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, epochs=10, batch_size=50)

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
print('?????? :', np.argmax(output, axis=1))
print('?????? :', np.argmax(y_test, axis=1))