# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 10:52:02 2021

@author: eunse
"""

from pandas import DataFrame, merge

score_math = DataFrame({'수학':[90, 82]},
                        index=['민철', '봉구'])

score_sci = DataFrame({'과학':[88, 92]},
                        index=['민철', '철수'])

print(score_math)
print(score_sci)
print('-' * 20)

df = merge(score_math, score_sci, left_index=True, right_index=True)
print(df)
print('-' * 20)

df = merge(score_math, score_sci, left_index=True, right_index=True,
           how='outer')
print(df)
print('-' * 20)