# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 11:43:58 2021

@author: eunse
"""

import numpy as np
import matplotlib.pyplot as plt

x = np.arange(5)
y1 = x
y2 = x + 1
y3 = x + 2
y4 = x + 3

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 16
plt.rcParams['figure.figsize'] = (8,6)

plt.plot(x, y1, 'm-o')
plt.plot(x, y2, 'y--^')
plt.plot(x, y3, 'k:s')
plt.plot(x, y4, 'c-.d')

plt.xlabel('X-axis')
plt.ylabel('Y-axis')
plt.title('Plot Graph')
plt.grid()
plt.legend(['data1', 'data2', 'data3', 'data4'], loc=4)

plt.show()