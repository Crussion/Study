# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 13:14:24 2021

@author: eunse
"""

import matplotlib.pyplot as plt

math = [76, 82, 84, 83, 90,
        86, 85, 92, 72, 71,
        100, 87, 81, 76, 94,
        78, 81, 60, 79, 69,
        74, 87, 82, 68, 79]

plt.hist(math)
plt.show()

plt.hist(math, bins=8)
plt.show()