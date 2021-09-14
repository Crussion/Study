# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 16:14:18 2021

@author: eunse
"""

tup1 = (1,2,3,4,5)
print(tup1)
print('-' * 20)

st1 = '%s %s %s' %(tup1[1], tup1[3], tup1[4])
print(st1)
print('-' * 20)


st2 = '{} {} {}'.format(tup1[1], tup1[3], tup1[4])
print(st2)
print('-' * 20)

st2 = '{0} {1} {2}'.format(tup1[1], tup1[3], tup1[4])
print(st2)
print('-' * 20)

st2 = '{1} {2} {0}'.format(tup1[1], tup1[3], tup1[4])
print(st2)
print('-' * 20)

st2 = '{} {} {}'.format(*tup1)
print(st2)
print('-' * 20)

st2 = '{3} {4} {2}'.format(*tup1)
print(st2)
print('-' * 20)

st2 = '{:.2f}'.format(3.141592)
print(st2)
print('-' * 20)


a, b, c, d, e = tup1
print(a, b, c, d, e)