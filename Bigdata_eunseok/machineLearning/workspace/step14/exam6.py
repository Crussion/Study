import numpy as np
import tensorflow.keras as keras
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.layers import LSTM
from tensorflow.keras import utils
import matplotlib.pyplot as plt

np.random.seed(5)

class LossHistory(keras.callbacks.Callback):
    def __init__(self):
        self.losses = []
        self.accuracies = []
    
    def on_epoch_end(self, batch, logs={}):
        self.losses.append(logs.get('loss'))
        self.accuracies.append(logs.get('accuracy'))
        
code2idx = {'c4':0, 'd4':1, 'e4':2, 'f4':3, 'g4':4, 'a4':5, 'b4':6,
           'c8':7, 'd8':8, 'e8':9, 'f8':10, 'g8':11, 'a8':12, 'b8':13}

idx2code = {0:'c4', 1:'d4', 2:'e4', 3:'f4', 4:'g4', 5:'a4', 6:'b4',
            7:'c8', 8:'d8', 9:'e8', 10:'f8', 11:'g8', 12:'a8', 13:'b8'}

code2scale = {'c':0, 'd':1, 'e':2, 'f':3, 'g':4, 'a':5, 'b':6}
code2length = {'4':0, '8':1}

# 데이터 셋 생성
def seq2dataset(seq, window_size):
    dataset_x = []
    dataset_y = []
    
    for i in range(len(seq) - window_size):
        subset = seq[i:(i+window_size + 1)]
        for si in range(len(subset) - 1):
            features = code2features(subset[si])
            dataset_x.append(features)
        
        dataset_y.append([code2idx[subset[window_size]]])
        
    return np.array(dataset_x), np.array(dataset_y)

def code2features(code):
    features = []
    features.append(code2scale[code[0]] / 13)
    features.append(code2length[code[1]])
    return features

seq = ['g8', 'e8', 'e4', 'f8', 'd8', 'd4', 'c8', 'd8', 'e8', 'f8', 'g8', 'g8', 'g4',
       'g8', 'e8', 'e8', 'e8', 'f8', 'd8', 'd4', 'c8', 'e8', 'g8', 'g8', 'e8', 'e8', 'e4',
       'd8', 'd8', 'd8', 'd8', 'd8', 'e8', 'f4', 'e8', 'e8', 'e8', 'e8', 'e8', 'f8', 'g4',
       'g8', 'e8', 'e4', 'f8', 'd8', 'd4', 'c8', 'e8', 'g8', 'g8', 'e8', 'e8', 'e4']

x_train, y_train = seq2dataset(seq, window_size=4)

print(x_train.shape)
print(y_train.shape)
print(x_train[:2])
print(y_train[:2])

x_train = x_train.reshape(50, 4, 2)

y_train = utils.to_categorical(y_train)

one_hot_size = y_train.shape[1]

model = Sequential()
model.add(LSTM(128, batch_input_shape=(1, 4, 2), stateful=True))
model.add(Dense(one_hot_size, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam',
              metrics=['accuracy'])

lossHistory = LossHistory()

for i in range(150):
    print('Epoch :', i + 1, '/', 150, end=' ')
    model.fit(x_train, y_train, batch_size=1, epochs=1, verbose=2,
              callbacks=[lossHistory], shuffle=False)
    model.reset_states() # 모델 상태 초기화
    print()

fig, loss = plt.subplots()
acc = loss.twinx()

loss.plot(lossHistory.losses, 'y', label='loss')
acc.plot(lossHistory.accuracies, 'b', label='accuracy')

loss.set_xlabel('epochs')
loss.set_ylabel('loss')
acc.set_ylabel('accuracy')

loss.legend(loc='upper left')
acc.legend(loc='lower left')

plt.show()

scores = model.evaluate(x_train, y_train, batch_size=1)
print(scores)

model.reset_states()

pred_count = 50

seq_out = ['g8', 'e8', 'e4', 'f8']
pred_out = model.predict(x_train, batch_size=1)

for i in range(pred_count):
    idx = np.argmax(pred_out[i])
    seq_out.append(idx2code[idx])
    
model.reset_states()
    
cnt = 0
for i, code in enumerate(seq_out):
    if seq[i] == code:
        cnt += 1
         
print('정확도 : %.2f%%' %(cnt/len(seq_out) * 100))

seq_in = ['g8', 'e8', 'e4', 'f8']
seq_out = seq_in
seq_in_features = []

for si in seq_in:
    features = code2features(si)
    seq_in_features.append(features)

for i in range(pred_count):
    sample_in = np.array(seq_in_features).reshape((1, 4, 2))
    pred_out = model.predict(sample_in)
    idx = np.argmax(pred_out)
    seq_out.append(idx2code[idx])
    
    features = code2features(idx2code[idx])
    seq_in_features.append(features)
    del seq_in_features[0]
    
cnt = 0
for i, code in enumerate(seq_out):
    if seq[i] == code:
        cnt += 1
        
print('정확도 : %.2f%%' %(cnt/len(seq_out) * 100))