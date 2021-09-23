# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 15:52:14 2021

@author: eunse
"""

import numpy as np

data1 = [[1,2,3], 5,
         [4,5,6],
         [7,8,9]]

arr1 = np.array(data1)
print(data1)
print('-' * 20)

print(arr1)
print('-' * 20)

print(arr1.dtype)
print(arr1.shape)
print('-' * 20)