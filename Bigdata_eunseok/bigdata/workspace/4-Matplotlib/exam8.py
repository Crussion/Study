# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 14:39:19 2021

@author: eunse
"""


import matplotlib.pyplot as plt

fruit = ['사과','바나나','딸기','오렌지','포도']
result = [7,6,3,2,2]

plt.figure(figsize=(7,7))
plt.pie(result)
plt.show()

plt.figure(figsize=(7,7))
plt.pie(result, labels=fruit, autopct='%.1f%%')
plt.show()

plt.figure(figsize=(7,7))
plt.pie(result, labels=fruit, autopct='%.1f%%', startangle=90,
        counterclock=False)
plt.show()

plt.figure(figsize=(7,7))
plt.pie(result, labels=fruit, autopct='%.1f%%', startangle=90,
        counterclock=False, explode=[0,0,0.1,0,0])

plt.savefig('pi.png')

plt.show()
