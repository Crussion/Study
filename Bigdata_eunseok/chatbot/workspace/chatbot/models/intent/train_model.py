import pandas as pd
import tensorflow as tf
from tensorflow.keras import preprocessing
from tensorflow.keras.models import Model
from tensorflow.keras.layers import Input, Embedding, Dense
from tensorflow.keras.layers import Dropout, Conv1D, GlobalMaxPooling1D
from tensorflow.keras.layers import concatenate
from utils.Preprocess import Preprocess
from sklearn.model_selection import train_test_split
import numpy as np

df = pd.read_csv('total_train_data.csv')

queries = df['query'].tolist()
intents = df['intent'].tolist()

p = Preprocess(word2index_dic='../../train_tools/dict/chatbot_dict.bin',
               userdic='../../utils/user_dic.tsv')

sequences = []
for sentence in queries:
    pos = p.pos(sentence)
    keywords = p.get_keywords(pos, True)
    seq = p.get_wordidx_sequence(keywords)
    sequences.append(seq)

MAX_SEQ_LEN = 15

# 문장 길이 통일
padded_seqs = preprocessing.sequence.pad_sequences(sequences, MAX_SEQ_LEN,
                                                   padding='post')

intents = np.array(intents)

# train_test_split : 훈련셋과 테스트셋을 나눌때, 랜덤하게 테이터를 비슷한 비율로 분리
# stratify : 분리 기준 데이터 설정
# test_size : 분리 비율 설정 10 - x : x
# random_state : 랜덤 시드
x_train_all, x_test, y_train_all, y_test = train_test_split(padded_seqs, intents,
                                                            stratify=intents,
                                                            test_size=0.1,
                                                            random_state=42)

# print(x_train_all.shape)
# print(x_test.shape)
# print(y_train_all.shape)
# print(y_test.shape)
# print('-' * 40)

# 훈련셋 : 검증셋 = 9 : 1
x_train, x_val, y_train, y_val = train_test_split(x_train_all, y_train_all,
                                                  stratify=y_train_all,
                                                  test_size=0.1,
                                                  random_state=42)

# print(x_train.shape)
# print(x_val.shape)
# print(x_test.shape)
# print(y_train.shape)
# print(y_val.shape)
# print(y_test.shape)
# print('-' * 40)

dropout_prob = 0.5
EMB_SIZE = 128
EPOCH = 5
VOCAB_SIZE = len(p.word_index) + 1

# CNN 모델 정의 : Conv1D
input_layer = Input(shape=(MAX_SEQ_LEN, ))
embedding_layer = Embedding(VOCAB_SIZE, EMB_SIZE,
                            input_length=MAX_SEQ_LEN)(input_layer)
dropout_emb = Dropout(rate=dropout_prob)(embedding_layer)

conv1 = Conv1D(filters=128, kernel_size=3, padding='valid',
               activation='relu')(dropout_emb)
pool1 = GlobalMaxPooling1D()(conv1)

conv2 = Conv1D(filters=128, kernel_size=4, padding='valid',
               activation='relu')(dropout_emb)
pool2 = GlobalMaxPooling1D()(conv2)

conv3 = Conv1D(filters=128, kernel_size=5, padding='valid',
               activation='relu')(dropout_emb)
pool3 = GlobalMaxPooling1D()(conv3)

# concatenate : 모델 합치기 함수
concat = concatenate([pool1, pool2, pool3])
hidden = Dense(128, activation='relu')(concat)
dropout_hidden = Dropout(rate=dropout_prob)(hidden)
# name: 레이어에 대한 선택적 이름 문자열. 모델 내에서 고유해야 합니다
logits = Dense(5, name='logits')(dropout_hidden)
predictions = Dense(5, activation='softmax')(logits)

model = Model(inputs=input_layer, outputs=predictions)

model.compile(loss='sparse_categorical_crossentropy', optimizer='adam',
              metrics=['accuracy'])

hist = model.fit(x_train, y_train, epochs=EPOCH, batch_size=16,
                 validation_data=(x_val, y_val))

loss, accuracy = model.evaluate(x_test, y_test, batch_size=16)

print('로스 :', loss)
print('정확도 :', accuracy)

import matplotlib.pyplot as plt

loss_ax = plt.subplot()
acc_ax = loss_ax.twinx()

loss_ax.plot(hist.history['loss'], 'y', label='train loss')
loss_ax.plot(hist.history['val_loss'], 'g', label='val loss')
acc_ax.plot(hist.history['accuracy'], 'r', label='train accuracy')
acc_ax.plot(hist.history['val_accuracy'], 'b', label='val accuracy')

loss_ax.set_xlabel('epoch')
loss_ax.set_ylabel('loss')
acc_ax.set_ylabel('accuracy')

loss_ax.legend(loc='lower left')
acc_ax.legend(loc='upper left')

plt.show()

from tensorflow.keras.utils import plot_model
plot_model(model, to_file='intent_model.png', show_shapes=True)

model.save('intent_model.h5')
