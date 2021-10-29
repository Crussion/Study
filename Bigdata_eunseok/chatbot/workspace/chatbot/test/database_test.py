from utils.Database import Database

db = Database('C##pythonexam', 'm1234', 'localhost:1521/xe')

# sql = "insert into goods values ('{}', '{}', {}, '{}')".format(
#     'p0001', '파이썬', 25000, '닷컴')

# result = db.execute(sql)
# if result > 0 : print('저장 성공')
# else : print('저장 실패')
# print('-' * 40)

# sql = "select * from goods"
# result = db.select(sql)
# print(result)
# print('-' * 40)

# sql = "select * from goods"
# result = db.select_one(sql)
# print(result)
# print('-' * 40)

# sql = "update goods set price=50000 where code='{}'".format('p0001')

# result = db.execute(sql)
# if result > 0 : print('수정 성공')
# else : print('수정 실패')
# print('-' * 40)

sql = "select * from chatbot_train_data where intent='{}' and ner like '%{}%'".format(
        '주문', 'B_FOOD')
result = db.select_one(sql)
print(result)
print('-' * 40)