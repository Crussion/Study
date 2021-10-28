from utils.Preprocess import Preprocess
from tensorflow.keras import preprocessing

p = Preprocess(word2index_dic='../train_tools/dict/chatbot_dict.bin',
               userdic='../utils/user_dic.tsv')

sentence = '내일 오전 10시에 탕수육 주문하고 싶어 ㅋㅋ'
print(sentence)

pos = p.pos(sentence)
print(pos)

keywords = p.get_keywords(pos)
print(keywords)

w2i = p.get_wordidx_sequence(keywords)
print(w2i)