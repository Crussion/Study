import numpy as np
from tensorflow.keras.preprocessing.image import ImageDataGenerator
import matplotlib.pyplot as plt
import prac3_1

from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D
from tensorflow.keras.layers import MaxPooling2D
from tensorflow.keras.layers import Flatten
from tensorflow.keras.layers import Dense
from tensorflow.keras.layers import Dropout

#prac3_1.save_image()

train_datagen = ImageDataGenerator(rescale=1/255)

train_generator = train_datagen.flow_from_directory('search',
    target_size=(256, 256), batch_size=5,
    class_mode='categorical')

x_train_list = []
y_train_list = []

for i in range(12):
    img, label = train_generator.next()
    x_train_list.extend(img)
    y_train_list.extend(label)
    
x_train = np.array(x_train_list)
y_train = np.array(y_train_list)

x_test = x_train[50:]
y_test = y_train[50:]

model = Sequential()
model.add(Conv2D(32, (3, 3), activation='relu', input_shape=(256, 256, 3)))
model.add(MaxPooling2D((2, 2)))
model.add(Dropout(0.25))
model.add(Conv2D(32, (3, 3), activation='relu'))
model.add(MaxPooling2D((2, 2)))
model.add(Dropout(0.25))
model.add(Flatten())
model.add(Dense(256, activation='relu'))
model.add(Dense(64, activation='relu'))
model.add(Dropout(0.25))
model.add(Dense(32, activation='relu'))
model.add(Dense(2, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, 5, 15)

loss = plt.subplot()
acc = loss.twinx()

loss.plot(hist.history['loss'], 'y', label='train loss')
#loss.plot(hist.history['val_loss'], 'g', label='val loss')
acc.plot(hist.history['accuracy'], 'r', label='accuracy')
#acc.plot(hist.history['val_accuracy'], 'b', label='val accuracy')

loss.set_xlabel('epochs')
loss.set_ylabel('loss')
acc.set_ylabel('accuracy')

loss.legend(loc='lower right')
acc.legend(loc='upper right')

plt.show()

scores = model.evaluate(x_test, y_test, batch_size=32)
print(scores)

y_hat_test = model.predict(x_test, batch_size=32)

plt.rcParams['figure.figsize'] = (10, 4)
fig, axarr = plt.subplots(2, 5)

for i in range(10) :
    sub_plt = axarr[i//5, i%5]
    sub_plt.axis('off')
    sub_plt.imshow(x_test[i])
    
    sub_plt_title = 'R: ' + str(np.argmax(y_test[i])) + ', P: ' + str(np.argmax(y_hat_test[i]))
    sub_plt.set_title(sub_plt_title)
    
plt.show()