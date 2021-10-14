from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.utils import plot_model

# 이진 분류 모델 : 출력층은 unit이 1개, 활성화 함수 'sigmoid'
model = Sequential()
model.add(Dense(12, activation='relu'))
model.add(Dense(8, activation='relu'))
model.add(Dense(1, activation='sigmoid'))

# 요약 정보 확인
model.summary()

# 그래프로 확인

plot_model(model, to_file='model_shape.png', show_shapes=True)

print('-' * 40)
