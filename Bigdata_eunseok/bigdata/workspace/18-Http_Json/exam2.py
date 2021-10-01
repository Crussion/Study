import requests
import sys
import json
from pandas import DataFrame
import matplotlib.pyplot as plt
from matplotlib.image import imread

url = 'http://localhost:8080/server_data/simple.json'

r = requests.get(url)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

print(r.text)
print('-' * 20)

result = json.loads(r.text)
print(result)
print('-' * 20)

df = DataFrame([result])
print(df)
print('-' * 20)

img = imread(df.loc[0, 'img'])
print(img.shape)
print('-' * 20)

# imshow(이미지 데이터로 구성된 넘파이배열) : 이미지 출력
plt.imshow(img)
plt.axis('off')
plt.show()