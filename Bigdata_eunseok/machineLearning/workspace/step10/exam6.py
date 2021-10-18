import numpy as np
from tensorflow.keras.preprocessing.image import ImageDataGenerator
import matplotlib.pyplot as plt

origin_datagen = ImageDataGenerator(rescale=1/255)

origin_generator = origin_datagen.flow_from_directory(
    'hard_handwriting_shape/train', target_size=(24, 24), batch_size=3)

num = 1
plt.figure(figsize=(12, 8))
'''
for i in range(15):
    img, label = origin_generator.next()
    
    plt.subplot(5, 9, num)
    plt.imshow(img[0])
    plt.subplot(5, 9, num + 1)
    plt.imshow(img[1])
    plt.subplot(5, 9, num + 2)
    plt.imshow(img[2])
    num += 3
    
plt.show()
'''
train_datagen = ImageDataGenerator(rescale=1/255, rotation_range=10,
                                   width_shift_range=0.2, height_shift_range=0.2,
                                   shear_range=0.7, zoom_range=[0.9, 2.2],
                                   horizontal_flip=True, vertical_flip=True,
                                   fill_mode='nearest')

train_generator = train_datagen.flow_from_directory(
    'hard_handwriting_shape/train', target_size=(24, 24), batch_size=3)

num = 1
plt.figure(figsize=(12, 8))

for i in range(15):
    img, label = train_generator.next()
    
    plt.subplot(5, 9, num)
    plt.imshow(img[0])
    plt.subplot(5, 9, num + 1)
    plt.imshow(img[1])
    plt.subplot(5, 9, num + 2)
    plt.imshow(img[2])
    num += 3
    
plt.show()