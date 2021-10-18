from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.layers import Flatten
from tensorflow.keras.layers import Conv2D
from tensorflow.keras.layers import MaxPool2D

model = Sequential()

# 입력 이미지 크기 8 * 8, 입력 이미지 채널 1개
# 2, (3, 3) : 필터의 크기 3x3, 필터의 수 2개
model.add(Conv2D(2, (3, 3), padding='same', activation='relu',
                 input_shape=(8, 8, 1)))
# 필터에서의 최대값 필터, 특징 탐색
model.add(MaxPool2D(pool_size=(2,2)))
model.add(Conv2D(3, (2, 2), padding='same', activation='relu'))
model.add(MaxPool2D(pool_size=(2,2)))
# 직선화
model.add(Flatten())
model.add(Dense(8, activation='relu'))
model.add(Dense(3, activation='softmax'))

model.summary()