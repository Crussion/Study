# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 12:32:59 2021

@author: eunse
"""

import numpy as np
import matplotlib.pyplot as plt

member_IDs = ['m01', 'm02', 'm03', 'm04']
ex_before = [27, 35, 40, 33]
ex_after = [30, 38, 42, 37]

plt.rcParams['axes.unicode_minus'] = False

mem_num = len(member_IDs)
index = np.arange(mem_num)
plt.bar(index, ex_before)
plt.show()

plt.bar(index, ex_before, width=0.6)
plt.xticks(index, member_IDs)
plt.show()

plt.barh(index, ex_before, height=0.6)
plt.yticks(index, member_IDs)
plt.show()


plt.bar(index - 0.2, ex_before, width=0.4, color='c')
plt.bar(index + 0.2, ex_after, width=0.4, color='m')
plt.xticks(index, member_IDs)
plt.title('운동 시작전과 후의 근지구력(복근) 변화 비교')
plt.legend(['before','after'], loc='upper left')
plt.show()