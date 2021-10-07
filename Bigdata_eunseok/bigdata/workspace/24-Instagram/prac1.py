from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from bs4 import BeautifulSoup
import time
import datetime as dt
import os
import requests

driver = webdriver.Chrome('data/chromedriver.exe')
driver.implicitly_wait(10)

search = '아이유'
url = 'https://search.naver.com/search.naver?where=image&sm=tab_jum&query=%s' %search
driver.get(url)
time.sleep(3)

img_list = []

for i in range(5):
    soup = BeautifulSoup(driver.page_source, 'html.parser')
    
    img = soup.select('._image')
    
    img_list += img
    
    driver.execute_script('window.scrollTo(0, document.body.scrollHeight);')
    
    time.sleep(3)
    
print(len(img_list))

src_list = []

for t in img_list:
    src = t.attrs['src']
    src_list.append(src)
    
src_list = list(set(src_list))

print(len(src_list))

datetime = dt.datetime.now().strftime('%y%m%d_%H%M%S')
dirname = 'naver_' + datetime

if not os.path.exists(dirname):
    os.mkdir(dirname)
    
user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Edg/94.0.992.38"
headers = {'User-Agent':user_agent, 'Referer':None}

print('이미지 수집 시작', end=' ')
for i, img_url in enumerate(src_list):
    print('>', end='')
    path = '%s/%04d.jpg' %(dirname, i+1)
    
    try:
        r = requests.get(img_url, headers=headers, stream=True)
        
        if r.status_code != 200:
            raise Exception
            
        with open(path, 'wb') as f:
            f.write(r.raw.read())
        
    except Exception as e:
        print('저장실패', i+1)