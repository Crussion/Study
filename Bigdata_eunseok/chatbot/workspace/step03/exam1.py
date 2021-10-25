import cx_Oracle as orc
    

try :
    conn = None
    conn = orc.connect('C##pythonexam', 'm1234', 'localhost:1521/xe')
    print(conn.version)
    
    print('DB 연결 성공')
except Exception as e:
    print('DB 연결 실패', e)
finally:
    if conn != None:
        conn.close()
        conn = None