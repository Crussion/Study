from utils.Preprocess import Preprocess

p = Preprocess(userdic='../utils/user_dic.tsv')

sentence = '내일 오전 10시에 탕수육 주문하고 싶어'
print(sentence)

pos = p.pos(sentence)
print(pos)

keywords = p.get_keywords(pos)
print(keywords)