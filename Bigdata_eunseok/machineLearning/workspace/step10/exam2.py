import numpy as np
from tensorflow.keras.preprocessing.image import ImageDataGenerator
import matplotlib.pyplot as plt

np.random.seed(5)

# 정규화 설정 (0~255) -> (0~1)
train_datagen = ImageDataGenerator(rescale=1/255)

train_generator = train_datagen.flow_from_directory(
    'handwriting_shape/train',
    target_size=(24, 24), batch_size=3,
    class_mode='categorical')

x_train_list = []
y_train_list = []

for i in range(5):
    img, label = train_generator.next()
    x_train_list.extend(img)
    y_train_list.extend(label)
    
    plt.subplot(1, 3, 1)
    plt.imshow(img[0])
    plt.subplot(1, 3, 2)
    plt.imshow(img[1])
    plt.subplot(1, 3, 3)
    plt.imshow(img[2])
    plt.show()
    
    print(label[0], label[1], label[2])
    print('-' * 40)
    
print(x_train_list[:1])
print('-' * 40)

print(y_train_list)
print('-' * 40)

x_train = np.array(x_train_list)
y_train = np.array(y_train_list)

print(x_train.shape)
print('-' * 40)

print(y_train.shape)
print('-' * 40)