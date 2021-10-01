import requests
import sys
import json
from pandas import DataFrame

url = 'http://localhost:8080/server_data/students.json'

r = requests.get(url)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

print(r.text)
print('-' * 20)

result = json.loads(r.text)
print(result)
print('-' * 20)

student_df = DataFrame(result['students']['student'])
print(student_df)
print('-' * 20)

student_df.to_excel('student.xlsx')