import cx_Oracle as orc

conn = None
cursor = None

try :
    conn = orc.connect('C##pythonexam', 'm1234', 'localhost:1521/xe')
    cursor = conn.cursor()
    
    sql = "update goods set price=30000 where code='{}'".format('p0001')
    
    cursor.execute(sql)
    conn.commit()
    
    result = cursor.rowcount
    
    if result > 0:print('수정 성공')
    else: print('수정 실패')
    
except Exception as e:
    print('[Error]', e)
finally:
    if cursor != None:
        cursor.close()
        cursor = None
        
    if conn != None:
        conn.close()
        conn = None