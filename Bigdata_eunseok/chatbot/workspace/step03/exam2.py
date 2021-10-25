import cx_Oracle as orc

conn = None
cursor = None

try :
    conn = orc.connect('C##pythonexam', 'm1234', 'localhost:1521/xe')
    
    sql = "insert into goods values ('{}', '{}', {}, '{}')".format(
        'p0001', '파이썬무따기', '25000', '닷컴')
    
    cursor = conn.cursor()
    
    cursor.execute(sql)
    
    conn.commit()
    
    result = cursor.rowcount
    print(result)
    
    if result > 0: print('저장 성공')
    else: print('저장 실패')
    
except Exception as e:
    print('저장 실패', e)
finally:
    if cursor != None:
        cursor.close()
        cursor = None
        
    if conn != None:
        conn.close()
        conn = None