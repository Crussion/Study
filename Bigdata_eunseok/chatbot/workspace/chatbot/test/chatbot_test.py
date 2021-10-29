from utils.Database import Database
from utils.Preprocess import Preprocess
from models.intent.intentModel import IntentModel
from models.ner.NerModel import NerModel
from utils.FindAnswer import FindAnswer

# 전처리 객체
p = Preprocess(word2index_dic='../train_tools/dict/chatbot_dict.bin',
               userdic='../utils/user_dic.tsv')

# DB 객체
db = Database('C##pythonexam', 'm1234', 'localhost:1521/xe')

# 원문
query = '자장면 주문할게요'

# 의도파악
intent = IntentModel(model_name='../models/intent/intent_model.h5', preprocess=p)
predict = intent.predict_class(query)
intent_name = intent.labels[predict]

print(predict)
print(intent_name)
print('-' * 40)

# 개체명 인식
ner = NerModel(model_name='../models/ner/ner_model.h5', preprocess=p)
ner_predicts = ner.predict(query)
ner_tags = ner.predict_tags(query)

print(ner_predicts)
print(ner_tags)
print('-' * 40)

try:
    f = FindAnswer(db)
    answer_text, answer_image = f.search(intent_name, ner_tags)
    answer = f.tag_to_word(ner_predicts, answer_text)
except Exception as e:
    print('[Error]', e)
    answer = '죄송해요 무슨 말인지 모르겠어요'
    
print('답변 :', answer)