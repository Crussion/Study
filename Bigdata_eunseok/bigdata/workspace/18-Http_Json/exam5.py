import requests
import sys

url = 'http://localhost:8080/server_data/grade.csv'

r = requests.get(url)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()
    
r.encoding = 'euc-kr'

#print(r.text)
#print('-' * 20)

with open('grade.csv', 'w') as f:
    f.write(r.text)
    print('저장 완료')

print('-' * 20)

#######################################

# stream=True : 문자열이 아닌 바이너리 형식으로 요청
r = requests.get(url, stream=True)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

data = r.raw.read()
#print(data)
print('-' * 20)

with open('grade2.csv', 'wb') as f:
    f.write(data)
    print('저장 성공')