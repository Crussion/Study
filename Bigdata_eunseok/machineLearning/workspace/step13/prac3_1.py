from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from bs4 import BeautifulSoup
import time
import datetime as dt
import os
import requests

def save_image():
    driver = webdriver.Chrome('data/chromedriver.exe')
    driver.implicitly_wait(10)
    
    search = '남자'
    url = 'https://search.naver.com/search.naver?where=image&sm=tab_jum&query=%s' %search
    driver.get(url)
    time.sleep(3)
    
    man_img_list = []
    
    for i in range(3):
        soup = BeautifulSoup(driver.page_source, 'html.parser')
        
        img = soup.select('._image')
        
        man_img_list += img
        
        driver.execute_script('window.scrollTo(0, document.body.scrollHeight);')
        
        time.sleep(3)
        
    search = '여자'
    url = 'https://search.naver.com/search.naver?where=image&sm=tab_jum&query=%s' %search
    driver.get(url)
    time.sleep(3)
        
    woman_img_list = []
    
    for i in range(3):
        soup = BeautifulSoup(driver.page_source, 'html.parser')
        
        img = soup.select('._image')
        
        woman_img_list += img
        
        driver.execute_script('window.scrollTo(0, document.body.scrollHeight);')
        
        time.sleep(3)
        
    print(len(man_img_list))
    print(len(woman_img_list))
    
    man_src_list = []
    woman_src_list = []
    
    for t in man_img_list:
        src = t.attrs['src']
        man_src_list.append(src)
        
    for t in woman_img_list:
        src = t.attrs['src']
        woman_src_list.append(src)
        
    man_src_list = list(set(man_src_list))
    woman_src_list = list(set(woman_src_list))
    
    print(len(man_src_list))
    print(len(woman_src_list))
    
    dirname = './search/'
    
    if not os.path.exists(dirname):
        os.makedirs(dirname + 'man')
        os.makedirs(dirname + 'woman')
        
    user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Edg/94.0.992.38"
    headers = {'User-Agent':user_agent, 'Referer':None}
    
    print('이미지 수집 시작', end=' ')
    dirname = 'search/man'
    cnt = 0
    for i, img_url in enumerate(man_src_list):
        print('>', end='')
        path = '%s/%04d.jpg' %(dirname, i+1)
        
        try:
            r = requests.get(img_url, headers=headers, stream=True)
            
            if r.status_code != 200:
                raise Exception
                
            with open(path, 'wb') as f:
                f.write(r.raw.read())
            
            cnt += 1
        except Exception as e:
            cnt -= 1
            print('저장실패', i+1)
        
        if cnt >= 60: break
            
    print()
    print('이미지 수집 시작', end=' ')
    dirname = 'search/woman'
    cnt = 0
    for i, img_url in enumerate(woman_src_list):
        print('>', end='')
        path = '%s/%04d.jpg' %(dirname, i+1)
        
        try:
            r = requests.get(img_url, headers=headers, stream=True)
            
            if r.status_code != 200:
                raise Exception
                
            with open(path, 'wb') as f:
                f.write(r.raw.read())
            
            cnt += 1
        except Exception as e:
            cnt -= 1
            print('저장실패', i+1)
        
        if cnt >= 60: break
    
    driver.close()