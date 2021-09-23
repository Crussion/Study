# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 18:11:17 2021

@author: eunse
"""

import numpy as np

data1 = [70, 85, 65, 55, 90]

result = []

for v in data1:
    if v >= 70 : result.append('합격')
    else : result.append('불합격')

print(result)    
print('-' * 20)

arr1 = np.array(data1)

result = np.where(arr1>=70, '합격', '불합격')
print(result)    
print('-' * 20)

result = np.where((arr1>=60) & (arr1<=80), '합격', '불합격')
print(result)    
print('-' * 20)

result = np.where((arr1<60) | (arr1>80), '합격', '불합격')
print(result)    
print('-' * 20)