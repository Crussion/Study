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

# 데이터 셋 생성
def seq2dataset(seq, window_size):
    dataset=[]
    
    for i in range(len(seq) - window_size):
        subset = seq[i:(i+window_size + 1)]
        dataset.append([code2idx[item] for item in subset])
        
    return np.array(dataset)

seq = ['g8', 'e8', 'e4', 'f8', 'd8', 'd4', 'c8', 'd8', 'e8', 'f8', 'g8', 'g8', 'g4',
       'g8', 'e8', 'e8', 'e8', 'f8', 'd8', 'd4', 'c8', 'e8', 'g8', 'g8', 'e8', 'e8', 'e4',
       'd8', 'd8', 'd8', 'd8', 'd8', 'e8', 'f4', 'e8', 'e8', 'e8', 'e8', 'e8', 'f8', 'g4',
       'g8', 'e8', 'e4', 'f8', 'd8', 'd4', 'c8', 'e8', 'g8', 'g8', 'e8', 'e8', 'e4']

dataset = seq2dataset(seq, window_size=4)

print(dataset)

x_train = dataset[:, 0:4]
y_train = dataset[:, 4]

y_train = utils.to_categorical(y_train)

one_hot_size = y_train.shape[1]

x_train = x_train.reshape(50, 4, 1)

model = Sequential()
model.add(LSTM(128, input_shape=(4, 1)))
model.add(Dense(one_hot_size, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam',
              metrics=['accuracy'])

lossHistory = LossHistory()
model.fit(x_train, y_train, batch_size=10, epochs=2000, verbose=2,
          callbacks=[lossHistory])

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

scores = model.evaluate(x_train, y_train)
print(scores)

pred_count = 50

seq_out = ['g8', 'e8', 'e4', 'f8']
pred_out = model.predict(x_train)

for i in range(pred_count):
    idx = np.argmax(pred_out[i])
    seq_out.append(idx2code[idx])
    
cnt = 0
for i, code in enumerate(seq_out):
    if seq[i] == code:
        cnt += 1
         
print('정확도 : %.2f%%' %(cnt/len(seq_out) * 100))

seq_in = ['g8', 'e8', 'e4', 'f8']
seq_out = seq_in

seq_in = [code2idx[i] / 13 for i in seq_in]

for i in range(pred_count):
    sample_in = np.array(seq_in).reshape((1, 4, 1))
    pred_out = model.predict(sample_in)
    idx = np.argmax(pred_out)
    seq_out.append(idx2code[idx])
    seq_in.append(idx/13)
    del seq_in[0]
    
cnt = 0
for i, code in enumerate(seq_out):
    if seq[i] == code:
        cnt += 1
        
print('정확도 : %.2f%%' %(cnt/len(seq_out) * 100))