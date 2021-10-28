import cx_Oracle

class Database:
    def __init__(self, user, password, host):
        self.host = host
        self.user = user
        self.password = password
        self.conn = None
        self.cursor = None
        
    def connect(self):
        if self.conn == None:
            self.conn = cx_Oracle.connect(self.user, self.password, self.host)
            self.cursor = self.conn.cursor()
            
    def close(self):
        if self.cursor != None:
            self.cursor.close()
            self.cursor = None
            
        if self.conn != None:
            self.conn.close()
            self.conn = None
            
    def execute(self, sql):
        result = 0
        try:
            self.connect()
            self.cursor.execute(sql)
            self.conn.commit()
            result = self.cursor.rowcount       # 처리 결과
        except Exception as e:
            print('[Error]', e)
        finally:
            self.close()
        return result
    
    def select_one(self, sql):
        result = None
        try:
            self.connect()
            self.cursor.execute(sql)
            result = self.cursor.fetchone()     # 튜플로 한줄 가져오기
            # 컬럼명만 얻어오기
            columnNames = [d[0].lower() for d in self.cursor.description]
            # 검색 결과를 컬럼명 : 데이터 딕셔너리로 구성
            dic_result = {}
            for key, value in zip(columnNames, result):
                dic_result[key] = value
        except Exception as e:
            print('[Error]', e)
        finally:
            self.close()
        return dic_result
    
    def select(self, sql):
        result = None
        try:
            self.connect()
            self.cursor.execute(sql)
            result = self.cursor.fetchall()     # 튜플로된 리스트 가져오기
            
            # 검색결과를 컬럼명 : 데이터 딕셔너리로 구성된 리스트 만들기
            list_result = []
            # 컬럼명만 얻어오기
            columnNames = [d[0].lower() for d in self.cursor.description]
            for temp in result:
                dic = {}
                for key, value in zip(columnNames, temp):
                    dic[key] = value
                list_result.append(dic)
        except Exception as e:
            print('[Error]', e)
        finally:
            self.close()
        return list_result