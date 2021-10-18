import numpy as np
from tensorflow.keras.utils import to_categorical

x_train = np.random.random((1000, 12))
y_train = np.random.randint(10, size=(1000, 1))
x_test = np.random.random((100, 12))
y_test = np.random.randint(10, size=(100, 1))

y_train = to_categorical(y_train, num_classes=10)
y_test = to_categorical(y_test, num_classes=10)