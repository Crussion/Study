import time
from selenium import webdriver # 크롬 브라우저 제어를 위한 모듈
from bs4 import BeautifulSoup
import account

driver = webdriver.Chrome('data/chromedriver.exe')

# 브라우저 안정화 기다리기
driver.implicitly_wait(10)

url = 'https://nid.naver.com/nidlogin.login'
driver.get(url)

time.sleep(3)

# 아이디 비밀번호 입력
myid=account.getId()
mypwd=account.getPassword()

script = 'frmNIDLogin.id.value = "%s"' %myid
#script = 'document.getElementById("id").value = "%s"' %myid
driver.execute_script(script)

script = 'frmNIDLogin.pw.value = "%s"' %mypwd
#script = 'document.getElementById("pw").value = "%s"' %mypwd
driver.execute_script(script)

btn = driver.find_element_by_css_selector(".btn_login")
btn.click()
time.sleep(8)

url = 'https://mail.naver.com/'
driver.get(url)
time.sleep(3)

soup = BeautifulSoup(driver.page_source, 'html.parser')

#print(soup)
print('-' * 40)

selector = soup.select('.mail_title')

print(selector)
print(len(selector))
print('-' * 40)

mail_title_list = []

for i in selector:
    mail_title_list.append(i.text.strip())
    
print(mail_title_list)
print('-' * 40)