# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 12:08:23 2021

@author: eunse
"""

f = open('test.txt', 'w')

for i in range(1, 11):
    data = str(i) + '번째 줄입니다.\n'
    f.write(data)
    
f.close()
print("파일 저장")