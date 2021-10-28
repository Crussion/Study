import pickle
from utils.Preprocess import Preprocess

f = open('../train_tools/dict/chatbot_dict.bin', 'rb')
word_index = pickle.load(f)
f.close()

p = Preprocess(userdic='../utils/user_dic.tsv')

sentence = '내일 오전 10시에 탕수육 주문하고 싶어 ㅋㅋ'
print(sentence)

pos = p.pos(sentence)
print(pos)

keywords = p.get_keywords(pos, without_tag=False)
print(keywords)

for word in keywords:
    try:
        print(word, word_index[word[0]])
    except KeyError:
        print(word, word_index['OOV'])
        
