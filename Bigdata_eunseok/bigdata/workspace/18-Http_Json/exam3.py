import requests
import sys
import json
from pandas import DataFrame
import matplotlib.pyplot as plt
from matplotlib.image import imread

url = 'http://localhost:8080/server_data/student.json'

r = requests.get(url)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

print(r.text)
print('-' * 20)

result = json.loads(r.text)
print(result)
print('-' * 20)

student_df = DataFrame(result['student'])
print(student_df)
print('-' * 20)

score_df = student_df.set_index('name')
score_df = score_df.rename(columns={'math':'수학',
                                    'kor':'국어',
                                    'eng':'영어'})
print(score_df)
print('-' * 20)

score_df = score_df.filter(['국어', '영어', '수학'])
print(score_df)
print('-' * 20)

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 16
plt.rcParams['figure.figsize'] = (10, 8)
plt.rcParams['axes.unicode_minus'] = False

score_df.plot.bar(rot=0)
plt.title('학생별 시험 점수')
plt.xlabel('학생')
plt.ylabel('점수')
plt.grid()
plt.show()