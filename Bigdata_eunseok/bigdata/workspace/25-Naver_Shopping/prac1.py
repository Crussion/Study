import urllib        # URLEncoding을 위한 모듈
from bs4 import BeautifulSoup
from pandas import DataFrame
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
import sys
'''
driver = webdriver.Chrome('data/chromedriver.exe')
driver.implicitly_wait(10)

keyword = '닌텐도 스위치'
max_page = 5
base_url = 'https://search.shopping.naver.com/search/all'

base_param = {'frm':'NVSHATC', 'origQuery':keyword,
              'pagingIndex':1,
              'pagingSize':40,
              'productSet':'total',
              'query':keyword,
              'sort':'rel',
              'timestamp':'',
              'viewType':'list'}
'''
data_list = []

for i in range(1, max_page + 1):
    base_param['pagingIndex'] = i
    query = urllib.parse.urlencode(base_param)
    url = base_url + '?' + query
    
    driver.get(url)
    time.sleep(1)
    
    try:
        WebDriverWait(driver, 5).until(
            lambda drv : drv.find_element_by_css_selector('.style_content__2T20F'))
    except Exception as e:
        print(e)
        driver.quit()
        sys.exit()
        
    driver.execute_script('window.scrollTo(0, document.body.scrollHeight)')
    time.sleep(1)
    
    soup = BeautifulSoup(driver.page_source, 'html.parser')
    
    info_list = soup.select('.basicList_info_area__17Xyo')
    
    for info in info_list:
        item_dict = {}
        
        title = info.select('.basicList_title__3P9Q7 > a')
        item_dict['제품명'] = title[0].text.strip()
        
        price = info.select('.price_num__2WUXn')
        price = price[0].text.strip()
        price = price.replace(',', '')
        price = price.replace('원', '')
        price = int(price)
        
        item_dict['가격'] = price
        
        spec_list = info.select('.basicList_detail_box__3ta3h > a')
        
        for t in spec_list:
            t = t.text.strip().split(':')
            
            if len(t) == 2:
                key = t[0].strip()
                value = t[1].strip()
                item_dict[key] = value
        
        data_list.append(item_dict)
        
print(data_list)
print('-' * 40)

df = DataFrame(data_list)
print(df)
print('-' * 40)

df.to_excel(keyword + '.xlsx')