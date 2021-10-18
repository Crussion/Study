import numpy as np
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.preprocessing.image import load_img
import matplotlib.pyplot as plt

train_datagen = ImageDataGenerator(rescale=1/255, rotation_range=15,
                                   width_shift_range=0.1,
                                   height_shift_range=0-.1,
                                   shear_range=0.5,
                                   zoom_range=[0.8, 2.0],
                                   horizontal_flip=True,
                                   vertical_flip=True,
                                   fill_mode='nearest')

img = load_img('hard_handwriting_shape/train/triangle/triangle001.png')

x = np.array(img)

x = x.reshape((1,) + x.shape)

tx = train_datagen.flow(x, batch_size=1, save_to_dir='preview',
                        save_prefix='tri', save_format='png').next()

for i in range(30):
    train_datagen.flow(x, batch_size=1, save_to_dir='preview',
                        save_prefix='tri', save_format='png').next()