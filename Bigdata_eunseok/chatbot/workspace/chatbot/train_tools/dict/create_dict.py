from utils.Preprocess import Preprocess
from tensorflow.keras import preprocessing
import pickle

def read_corpus_data(filename):
    with open(filename, 'r', encoding='utf-8') as f:
        data = [line.split('\t') for line in f.read().splitlines()]
    return data
        
corpus_data = read_corpus_data('corpus.txt')

p = Preprocess()
dic = []

for c in corpus_data:
    pos = p.pos(c[1])
    
    #print(pos)
    #print('-' * 40)
    
    #pos = p.get_keywords(pos)
    
    for k in pos:
        dic.append(k[0])
        
print(dic[:3])
print('-' * 40)

# 사전에 사용될 word_index 생성
# 사전의 첫번째 인덱스에는 OOV 사용
# OOV : 단어 사전에 존재하지 않는 단어
# 단어 리스트 dic을 단어 인덱스 딕셔너리로 만든다
tokenizer = preprocessing.text.Tokenizer(oov_token='OOV')
tokenizer.fit_on_texts(dic)
word_index = tokenizer.word_index

print(word_index)
print('-' * 40)

f = open('chatbot_dict.bin', 'wb')
try:
    pickle.dump(word_index, f)
    print('파일 저장')
except Exception as e:
    print('저장 실패')
    print('[Error]', e)
finally:
    f.close()

'''
sort_word_index = sorted(word_index.keys())
str_word_index = "{"

for i, key in enumerate(sort_word_index):
    if i%9 == 0 and i != 0 : str_word_index += '\n'
    str_word_index += "'%s': %s, " %(key, word_index[key])
    
str_word_index += "}"
print(str_word_index)
print('-' * 40)
'''