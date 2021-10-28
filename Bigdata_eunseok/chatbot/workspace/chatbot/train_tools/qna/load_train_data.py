import cx_Oracle
import openpyxl

def all_clear_train_data(conn):
    # 기존 학습 데이터 삭제
    sql = 'delete chatbot_train_data'
    with conn.cursor() as cursor:
        cursor.execute(sql)
        conn.commit()
        
    sql = 'drop sequence seq_id'
    with conn.cursor() as cursor:
        cursor.execute(sql)
        
    sql = 'create sequence seq_id nocache nocycle'
    with conn.cursor() as cursor:
        cursor.execute(sql)
        
def insert_data(conn, xls_row):
    intent, ner, query, answer, answer_img = xls_row

    sql = '''insert into chatbot_train_data 
            values(seq_id.nextval, '{}', '{}', '{}', '{}', '{}')
            '''.format(intent.value, ner.value, query.value,
                        answer.value, answer_img.value)
    
    sql = sql.replace('None', 'null')
    with conn.cursor() as cursor:
        cursor.execute(sql)
        conn.commit()
        print(query.value, '저장')
        
train_file = 'train_data.xlsx'
conn = None

try:
    conn = cx_Oracle.connect('C##pythonexam', 'm1234', 'localhost:1521/xe')

    all_clear_train_data(conn)

    wb = openpyxl.load_workbook(train_file)
    sheet = wb['Sheet1']
    for row in sheet.iter_rows(min_row=2):
        insert_data(conn, row)
    
except Exception as e:
    print('[Error]', e)
finally:
    wb.close()
    if conn is not None:
        conn.close()