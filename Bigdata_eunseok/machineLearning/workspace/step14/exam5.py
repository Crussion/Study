import numpy as np

np.random.seed(5)
        
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

seq = ['g8', 'e8', 'e4', 'f8', 'd8', 'd4', 'c8', 'd8', 'e8', 'f8', 'g8', 'g8', 'g4',
       'g8', 'e8', 'e8', 'e8', 'f8', 'd8', 'd4', 'c8', 'e8', 'g8', 'g8', 'e8', 'e8', 'e4',
       'd8', 'd8', 'd8', 'd8', 'd8', 'e8', 'f4', 'e8', 'e8', 'e8', 'e8', 'e8', 'f8', 'g4',
       'g8', 'e8', 'e4', 'f8', 'd8', 'd4', 'c8', 'e8', 'g8', 'g8', 'e8', 'e8', 'e4']

x_train, y_train = seq2dataset(seq, window_size=4)

print(x_train.shape)
print(y_train.shape)