# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 11:02:13 2021

@author: eunse
"""

import numpy as np
import matplotlib.pyplot as plt

x = np.arange(5)
y1 = x
y2 = x + 1
y3 = x + 2
y4 = x + 3

plt.plot(x, y1)
plt.plot(x, y2)
plt.plot(x, y3)
plt.plot(x, y4)
plt.show()

plt.plot(x, y1, x, y2, x, y3, x, y4)
plt.show()

plt.plot(x, y1, 'm')
plt.plot(x, y2, 'y')
plt.plot(x, y3, 'k')
plt.plot(x, y4, 'c')
plt.show()

plt.plot(x, y1, '-')
plt.plot(x, y2, '--')
plt.plot(x, y3, ':')
plt.plot(x, y4, '-.')
plt.show()

plt.plot(x, y1, 'o')
plt.plot(x, y2, '^')
plt.plot(x, y3, 's')
plt.plot(x, y4, 'd')
plt.show()

plt.plot(x, y1, 'm-o')
plt.plot(x, y2, 'y--^')
plt.plot(x, y3, 'k:s')
plt.plot(x, y4, 'c-.d')
plt.show()