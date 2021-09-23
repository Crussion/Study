# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 16:06:30 2021

@author: eunse
"""

import numpy as np

data = [10,20,30,40,50,60]

arr1 = np.array(data)

print(arr1[2])
print(arr1[-3])
print('-' * 20)

print(arr1[[2,4,5]])
print('-' * 20)

print(arr1[arr1 > 30])
print('-' * 20)

print(arr1 > 30)
print('-' * 20)

print(arr1[[False, False, False, True, True, True]])
print('-' * 20)

arr1[2] = 555
print(arr1)
print('-' * 20)

arr1[[2,4,5]] = [100, 200, 300]
print(arr1)
print('-' * 20)

arr1[[2,4,5]] = 1000
print(arr1)
print('-' * 20)

arr1[arr1 > 30] = [1, 2, 3, 4]
print(arr1)
print('-' * 20)

arr1[arr1 > 5] = 5
print(arr1)
print('-' * 20)


data1 = [[1,2,3],
         [4,5,6],
         [7,8,9]]

arr2 = np.array(data1)
print(arr2)
print('-' * 20)

print(arr2[1][2])
print('-' * 20)

print(arr2[1, 2])
print('-' * 20)

print(arr2[[0,1], [1,2]])
print('-' * 20)