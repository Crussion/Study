# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 16:13:49 2021

@author: eunse
"""

import pandas as pd
from pandas import Series

date = pd.date_range(start="2021-12-02", periods=5)
value = range(10, 60, 10)

s1 = Series(value, index=date)
print('s1: \n', s1)
print('-'*20)