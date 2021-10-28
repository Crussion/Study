import numpy as np
import matplotlib.pyplot as plt
import tensorflow as tf
from tensorflow.keras import preprocessing
from sklearn.model_selection import train_test_split
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import LSTM, Embedding, Dense
from tensorflow.keras.layers import TimeDistributed, Dropout, Bidirectional
from tensorflow.keras.optimizers import Adam
from seqeval.metrics import f1_score, classification_report
from utils.Preprocess import Preprocess

def read_file(file_name):
    sentences = []
    with open(file_name, 'r', encoding='utf-8') as f:
        lines = f.readlines()
        this_sent = []
        
        for i, line in enumerate(lines):
            if line[0] == '\n':
                sentences.append(this_sent)
                this_sent = []
            elif line[0] != ';' and line[0] != '$':
                this_sent.append(tuple(line.split()))            
        return sentences

corpus = read_file('ner_train.txt')
print(corpus[:3])
print('-' * 40)

sentences, tags = [], []
for t in corpus:
    sentence, bio_tag = [], []
    for w in t:
        sentence.append(w[1])
        bio_tag.append(w[3])
    sentences.append(sentence)
    tags.append(bio_tag)
    
print(sentences[:3])
print(tags[:3])
print('-' * 40)

plt.hist([len(s) for s in sentences], bins=50)
plt.show()

# 사전에 사용될 word_index 생성
tag_tokenizer = preprocessing.text.Tokenizer(lower=False)
tag_tokenizer.fit_on_texts(tags)

p = Preprocess(word2index_dic='../../train_tools/dict/chatbot_dict.bin',
               userdic='../../utils/user_dic.tsv')

x_train = [p.get_wordidx_sequence(sent) for sent in sentences]
y_train = tag_tokenizer.texts_to_sequences(tags)

print(x_train[:2])
print(y_train[:2])
print('-' * 40)

max_len = 25
x_train = preprocessing.sequence.pad_sequences(x_train, padding='post',
                                               maxlen=max_len)
y_train = preprocessing.sequence.pad_sequences(y_train, padding='post',
                                               maxlen=max_len)

print(x_train[:2])
print(y_train[:2])
print('-' * 40)

vocab_size = len(p.word_index) + 1
tag_size = len(tag_tokenizer.word_index) + 1

index_to_ner = tag_tokenizer.index_word
index_to_ner[0] = 'PAD'
print(index_to_ner)
print('-' * 40)

x_train, x_test, y_train, y_test = train_test_split(x_train, y_train,
                                                    test_size=0.2,
                                                    random_state=42)

# 출력 데이터를 one-hot encoding 처리
y_train = tf.keras.utils.to_categorical(y_train, num_classes=tag_size)
y_test = tf.keras.utils.to_categorical(y_test, num_classes=tag_size)

model = Sequential()
model.add(Embedding(input_dim=vocab_size, output_dim=30, input_length=max_len,
                    mask_zero=True))
model.add(Bidirectional(LSTM(200, return_sequences=True, dropout=0.5,
                             recurrent_dropout=0.25)))
model.add(TimeDistributed(Dense(tag_size, activation='softmax')))

model.compile(loss='categorical_crossentropy', optimizer=Adam(0.01),
              metrics=['accuracy'])

model.fit(x_train, y_train, batch_size=128, epochs=10)

scores = model.evaluate(x_test, y_test)
print(scores)

model.save('ner_model.h5')

# 시퀀스를 NER 태그로 변환 하는 함수
def sequences_to_tag(sequences):
    result = []
    for sequence in sequences:
        temp = []
        for pred in sequence:
            pred_index = np.argmax(pred)
            temp.append(index_to_ner[pred_index])
        result.append(temp)
    return result

# 테스트 데이터셋의 NER 예측
y_predicted = model.predict(x_test)
pred_tags = sequences_to_tag(y_predicted)
test_tags = sequences_to_tag(y_test)
print('실제값 :', test_tags[0])
print('예측값 :', pred_tags[0])


