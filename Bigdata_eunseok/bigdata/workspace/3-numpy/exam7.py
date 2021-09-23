# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 17:52:52 2021

@author: eunse
"""

import numpy as np

data1 = [10,20,30,40]
data2 = [100,200,300,400]

result = data1 + data2
print(result)
print('-' * 20)

result = data1 * 3
print(result)
print('-' * 20)

arr1 = np.array(data1)
arr2 = np.array(data2)

print(arr1, arr2)
print('-' * 20)

result = arr1 + arr2
print(result)
print('-' * 20)

result = arr1 - arr2
print(result)
print('-' * 20)

result = arr1 * arr2
print(result)
print('-' * 20)

result = arr1 / arr2
print(result)
print('-' * 20)

arr3 = arr1.reshape(2, 2)
arr4 = arr2.reshape(2, 2)
print('-' * 20)

result = arr3 + arr4
print(result)
print('-' * 20)

result = arr3 - arr4
print(result)
print('-' * 20)

result = arr3 * arr4
print(result)
print('-' * 20)

result = arr3 / arr4
print(result)
print('-' * 20)
