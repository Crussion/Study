from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.utils import plot_model

model = Sequential()
model.add(Dense(units=64, input_dim=28*28, activation='relu'))
model.add(Dense(units=10, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='sgd',
              metrics=['accuracy'])

model.summary()
print('-' * 40)

# 모델 아키텍처 저장
# pip install pydot
# pip install graphviz
plot_model(model, to_file='mode1.png')
plot_model(model, to_file='model_shape.png', show_shapes=True)