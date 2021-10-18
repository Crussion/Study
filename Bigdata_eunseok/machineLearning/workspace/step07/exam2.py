import numpy as np
from sklearn.metrics import mean_squared_error

# 훈련셋
x_train = np.random.random((1000, 1))
y_train = x_train * 2 + np.random.random((1000, 1)) / 0.3

# 테스트셋
x_test = np.random.random((100, 1))
y_test = x_test * 2 + np.random.random((100, 1)) / 0.3

# 2차원 배열을 1차원 배열로 변환
x_train = x_train.reshape(1000)
y_train = y_train.reshape(1000)
x_test = x_test.reshape(100)
y_test = y_test.reshape(100)

print(x_train.shape)
print(y_train.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

# 모델 구성
w = np.cov(x_train, y_train, bias=True)[0, 1] / np.var(x_train)
b = np.average(y_train) - w * np.average(x_train)

print('w =', w)
print('b =', b)
print('-' * 40)

# 모델 평가
y_predict = w * x_test + b

# 손실함수로 평균제곱 오차 사용
mse = mean_squared_error(y_test, y_predict)
print('평균제곱오차 :', mse)