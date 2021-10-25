import cx_Oracle as orc
import pandas as pd

conn = None
cursor = None

try :
    conn = orc.connect('C##pythonexam', 'm1234', 'localhost:1521/xe')
    cursor = conn.cursor()
    
    sql = "select * from goods"
    
    cursor.execute(sql)
    
    # 검색 결과를 모든 행이 Tuple로 된 list 얻기
    result = cursor.fetchall()
    print(result)
    print('-' * 40)
    
    # table 구조 확인
    desc = cursor.description
    print(desc)
    print('-' * 40)
    
    # column 명만 얻기
    col_names = [d[0].lower() for d in cursor.description]
    print(col_names)
    print('-' * 40)
    
    # 검색 결과를 컬럼명, 데이터의 딕셔너리로 구성된 리스트 만들기
    dic_result = []
    for temp in result:
        dic = {}
        for key, value in zip(col_names, temp):
            dic[key] = value
        dic_result.append(dic)
    print(dic_result)
    print('-' * 40)
    
    df = pd.DataFrame(dic_result)
    print(df)
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
    
    sql = "select * from goods"
    
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