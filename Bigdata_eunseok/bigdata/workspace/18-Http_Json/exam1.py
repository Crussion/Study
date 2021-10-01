import requests
import sys

url = 'http://localhost:8080/server_data/simple_text.txt'

r = requests.get(url)
print(type(r))
print('-' * 20)

print(r.status_code)
print('-' * 20)

# utf-8, euc-kr
r.encoding = 'utf-8'

print(r.text)
print('-' * 20)