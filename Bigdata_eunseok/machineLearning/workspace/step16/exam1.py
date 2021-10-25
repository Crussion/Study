from tensorflow.keras.datasets import imdb
from tensorflow.keras.preprocessing import sequence

(x_train, y_train), (x_test, y_test) = imdb.load_data(num_words=20000)

for i in range(len(x_train)):
    x_train[i] = [w for w in x_train[i] if w > 2]
    
for i in range(len(x_test)):
    x_test[i] = [w for w in x_train[i] if w > 2]

x_val = x_train[20000:]
y_val = y_train[20000:]
x_train = x_train[:20000]
y_train = y_train[:20000]

x_train = sequence.pad_sequences(x_train, maxlen=200, truncating='post')
x_val = sequence.pad_sequences(x_train, maxlen=200, truncating='post')
x_test = sequence.pad_sequences(x_train, maxlen=200, truncating='post')


word_to_index = imdb.get_word_index()

index_to_word = {word_to_index[k] : k for k in word_to_index}

for w in x_test[6]:
    if w != 0:
        print(index_to_word[w-3], end=' ')
        
print()
print(y_test[6])
