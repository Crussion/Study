from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from bs4 import BeautifulSoup
import time
import datetime as dt
import os
import requests

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
myid = 'eunseok1996'
mypw = '~Jang18291595'

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
'''

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