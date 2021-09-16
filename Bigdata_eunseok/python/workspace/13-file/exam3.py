# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 12:37:23 2021

@author: eunse
"""

f = open('test.txt', 'a')

for i in range(11, 21):
    data = str(i) + '번째 줄입니다.\n'
    f.write(data)
    
f.close()
print("파일 저장")