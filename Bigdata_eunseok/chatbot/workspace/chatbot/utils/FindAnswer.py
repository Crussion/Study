class FindAnswer:
    def __init__(self, db):
        self.db = db
        
    def _make_query(self, intent_name, ner_tags=None):
        sql = "select * from chatbot_train_data"
        if intent_name != None and ner_tags == None:
            sql = sql + " where intent='{}'".format(intent_name)
        elif intent_name != None and ner_tags != None:
            where = " where intent='{}'".format(intent_name)
            
            if len(ner_tags) > 0:
                where += " and ("
                for ne in ner_tags:
                    where += "ner like '%{}%' or ".format(ne)
                # 마지막 구분에 or 를 없애는 작업
                where = where[:-4] + ')'
            sql = sql + where
        
        return sql
    
    def search(self, intent_name, ner_tags=None):
        sql = self._make_query(intent_name, ner_tags)
        answer = self.db.select_one(sql)
        if answer == None:
            sql = self._make_query(intent_name)
            answer = self.db.select_one(sql)
        
        print(answer)
        return (answer['answer'], answer['answer_image'])
    
    # NER 태그를 실제 입력된 단어로 변환
    def tag_to_word(self, ner_predicts, answer):
        for word, tag in ner_predicts:
            if tag=='B_FOOD' or tag=='B_DT' or tag=='B_TI':
                answer = answer.replace(tag, word)
                answer = answer.replace('{', '')
                answer = answer.replace('}', '')
        return answer
        
     
# sql 문 확인용
# from utils.Database import Database

# db = Database('C##pythonexam', 'm1234', 'localhost:1521/xe')

# f = FindAnswer(db)
# f._make_query('주문', ['B_FOOD', ['B_DT']])

