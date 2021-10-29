import threading
import json
from utils.Database import Database
from utils.BotServer import BotServer
from utils.Preprocess import Preprocess
from models.intent.intentModel import IntentModel
from models.ner.NerModel import NerModel
from utils.FindAnswer import FindAnswer
import sys

# 전처리 객체
p = Preprocess(word2index_dic='train_tools/dict/chatbot_dict.bin',
               userdic='utils/user_dic.tsv')

# 의도 파악 모델
intent = IntentModel(model_name='models/intent/intent_model.h5', preprocess=p)

# 개체명 인식 모델
ner = NerModel(model_name='models/ner/ner_model.h5', preprocess=p)

def to_client(client, addr, params):
    db = params['db']
    try:
        db.connect()
        
        read = client.recv(2048)
        print('=' * 40)
        print('Connection from :', addr)
        
        if read == None or not read:
            print('클라이언트 연결 끊어짐')
            sys.exit()
            
        recv_json_data = json.loads(read.decode())
        print('recv_json_data :', recv_json_data)
        print('=' * 40)
        
        query = recv_json_data['Query']
        
        # 의도 파악
        intent_predict = intent.predict_class(query)
        intent_name = intent.labels[intent_predict]
        print('intent_predict :', intent_predict)
        print('intent_name :', intent_name)
        print('=' * 40)
        
        ner_predicts = ner.predict(query)
        ner_tags = ner.predict_tags(query)
        print('ner_predicts :', ner_predicts)
        print('ner_tags :', ner_tags)
        print('=' * 40)\
            
        try:
            f = FindAnswer(db)
            answer_text, answer_image = f.search(intent_name, ner_tags)
            answer = f.tag_to_word(ner_predicts, answer_text)
        except Exception as e:
            answer = "죄송합니다. 무슨 말인지 모르겠어요. 조금 더 공부할게요."
            answer_image = None
            
        send_json_data_str={
                'Query': query,
                'Answer': answer,
                'AnswerImageUrl': answer_image,
                'Intent': intent_name,
                'NER': str(ner_predicts)
            }
        
        # 딕셔너리를 json 데이터로 변형
        message = json.dumps(send_json_data_str, indent=2)
        
        client.send(message.encode())
    except Exception as e:
        print('[Error]', e)
    finally:
        if db != None: db.close()
        client.close()
        
if '__name__' != '__main__':
    db = Database('C##pythonexam', 'm1234', 'localhost:1521/xe')
    
    port = 5050
    listen_num = 100
    
    bot = BotServer(port, listen_num)
    bot.create_sock()
    print('bot start')
    
    while True:
        client, addr = bot.ready_for_client()
        params = {'db': db}
        client_thread = threading.Thread(target=to_client, args=(client, addr, params))
        client_thread.start()