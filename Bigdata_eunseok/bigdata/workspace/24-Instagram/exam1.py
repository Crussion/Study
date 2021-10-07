from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from bs4 import BeautifulSoup
import time
import datetime as dt
import os
import requests
import account

# 크롬이 모바일 장치로 인식되도록 속성을 설정
options = webdriver.ChromeOptions()
mobile_emulation = {'deviceName': 'Nexus 5'}
options.add_experimental_option('mobileEmulation', mobile_emulation)

'''
# 준비된 옵션을 적용한 상태로 크롬브라우저 열기
driver = webdriver.Chrome('data/chromedriver.exe', options=options)
driver.implicitly_wait(10)

# 인스타그램 로그인 페이지 접속
url = 'https://www.instagram.com/accounts/login/'
driver.get(url)
time.sleep(3)


# 아이디, 비밀번호
myid = account.getId()
mypw = account.getPassword()

try:
    username = WebDriverWait(driver, 10).until(
        lambda drv: drv.find_element_by_css_selector(
            'input[name="username"]'))
    username.send_keys(myid)
except Exception as e:
    print('아이디 입력 실패', e)

try:
    password = WebDriverWait(driver, 10).until(
        lambda drv: drv.find_element_by_css_selector(
            'input[name="password"]'))
    password.send_keys(mypw)
except Exception as e:
    print('비밀번호 입력 실패', e)
    
try:
    submit = WebDriverWait(driver, 10).until(
        lambda drv: drv.find_element_by_css_selector(
            'button[type="submit"]'))
    submit.click()
except Exception as e:
    print('버튼 입력 실패', e)
    
time.sleep(3)


url = 'https://www.instagram.com/explore/'
driver.get(url)
time.sleep(3)

try:
    serch = WebDriverWait(driver, 10).until(
        lambda drv: drv.find_element_by_css_selector(
            'input[type="search"]'))
    serch.send_keys('파이썬')
except Exception as e:
    print('검색 입력 실패', e)
    
time.sleep(3)

try:
    btn = WebDriverWait(driver, 10).until(
        lambda drv: drv.find_element_by_css_selector(
            '.-qQT3'))
    btn.click()
except Exception as e:
    print('버튼 입력 실패', e)
'''

url = 'https://www.instagram.com/explore/tags/파이썬'
driver.get(url)
time.sleep(8)

img_list = []

for i in range(5):
    soup = BeautifulSoup(driver.page_source, 'html.parser')
    
    img = soup.select('img')
    
    img_list += img
    
    driver.execute_script('window.scrollTo(0, document.body.scrollHeight);')
    
    time.sleep(3)
    
print(len(img_list))
print('-' * 40)

src_list = []

for t in img_list:
    src = t.attrs['src']
    src_list.append(src)
    
print(len(src_list))
print('-' * 40)

#중복제거
src_list = list(set(src_list))
print(len(src_list))
print('-' * 40)

datetime = dt.datetime.now().strftime('%y%m%d_%H%M%S')
dirname = 'insta_' + datetime

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