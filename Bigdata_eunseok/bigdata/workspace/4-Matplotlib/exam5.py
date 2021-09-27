# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 12:05:33 2021

@author: eunse
"""


import numpy as np
import matplotlib.pyplot as plt

height = [165, 174, 160, 180, 185, 155, 172]
weight = [62, 67, 55, 74, 90 ,43, 64]

plt.scatter(height, weight)
plt.xlabel('Height(cm)')
plt.ylabel('Weight(kg')
plt.title('Height & Weight')
plt.grid()
plt.show()

size = 100 * np.arange(1, 8)
colors = ['r', 'g', 'b', 'c', 'm', 'k', 'y']

plt.scatter(height, weight, s=size, c=colors, alpha=0.5)
plt.xlabel('Height(cm)')
plt.ylabel('Weight(kg')
plt.title('Height & Weight')
plt.grid()
plt.show()