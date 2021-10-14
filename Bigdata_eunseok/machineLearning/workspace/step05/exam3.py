from tensorflow.keras import utils
from tensorflow.keras.datasets import mnist
from tensorflow.keras.models import load_model
import numpy as np
import matplotlib.pyplot as plt

(x_train, y_train), (x_test, y_test) = mnist.load_data()
x_test = x_test.reshape(10000, 28*28).astype('float32') / 255.0
y_test = utils.to_categorical(y_test)

xhat_idx = np.random.choice(x_test.shape[0], 5)
xhat = x_test[xhat_idx]

# 모델 불러오기
model = load_model('mnist_mlp_model.h5')

yhat = np.argmax(model.predict(xhat), axis=1)

for i in range(5):
    plt.imshow(xhat[i].reshape(28, 28))
    plt.show()
    print('정답 :', np.argmax(y_test[xhat_idx[i]]), ', 예측 :', yhat[i])