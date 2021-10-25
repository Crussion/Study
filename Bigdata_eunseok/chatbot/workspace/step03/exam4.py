import cx_Oracle as orc
import pandas as pd

conn = None
cursor = None

try :
    conn = orc.connect('C##pythonexam', 'm1234', 'localhost:1521/xe')
    cursor = conn.cursor()
    
    sql = "select * from goods where code='{}'".format('p0001')
    cursor.execute(sql)
    
    result = cursor.fetchone()
    print(result)
    print('-' * 40)
    
    
    col_names = [d[0].lower() for d in cursor.description]
    
    dic_result = {}
    for key, value in zip(col_names, result):
        dic_result[key] = value
    print(dic_result)
    print('-' * 40)
    

except Exception as e:
    print('[Error]', e)
finally:
    if cursor != None:
        cursor.close()
        cursor = None
        
    if conn != None:
        conn.close()
        conn = None
        
try :
    conn = orc.connect('C##pythonexam', 'm1234', 'localhost:1521/xe')
    cursor = conn.cursor()
    
    sql = "select * from goods where code='{}'".format('p0001')
    
    df = pd.read_sql(sql, conn)
    
    print(df)
    
except Exception as e:
    print('[Error]', e)
finally:
    if cursor != None:
        cursor.close()
        cursor = None
        
    if conn != None:
        conn.close()
        conn = None