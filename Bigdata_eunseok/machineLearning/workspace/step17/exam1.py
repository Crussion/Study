from tensorflow.keras.datasets import reuters
from tensorflow.keras.preprocessing import sequence

(x_train, y_train), (x_test, y_test) = reuters.load_data(num_words=20000)

print(x_train.shape)
print(y_train.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

x_val = x_train[7000:]
y_val = y_train[7000:]
x_train = x_train[:7000]
y_train = y_train[:7000]

print(x_train.shape)
print(y_train.shape)
print(x_val.shape)
print(y_val.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

x_train = sequence.pad_sequences(x_train, maxlen=120, truncating='post')
x_val = sequence.pad_sequences(x_val, maxlen=120, truncating='post')
x_test = sequence.pad_sequences(x_test, maxlen=120, truncating='post')

print(x_train.shape)
print(y_train.shape)
print(x_val.shape)
print(y_val.shape)
print(x_test.shape)
print(y_test.shape)
print('-' * 40)

word_to_index = reuters.get_word_index()

index_to_word = {word_to_index[k] : k for k in word_to_index}
    
for w in x_train[1000]:
    if w > 2:
        print(index_to_word[w-3], end=' ')
        
print()
print(y_train[1000])
