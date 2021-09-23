# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 11:16:29 2021

@author: eunse
"""

st1 = '1234'
st2 = 'HelloPython'
st3 = 'Hello Python'
st4 = '홍길동'
st5 = '1234abcd'

print(st1, st1.isdigit())
print(st2, st2.isdigit())
print('-' * 20)

print(st1, st1.isalpha())
print(st2, st2.isalpha())
print(st3, st3.isalpha())
print('-' * 20)

print(st1, st1.isalnum())
print(st2, st2.isalnum())
print(st3, st3.isalnum())
print(st4, st4.isalnum())
print(st5, st5.isalnum())
print('-' * 20)

st6 = st2.lower()
print(st1, st1.islower())
print(st2, st2.islower())
print(st6, st6.islower())
print('-' * 20)

st7 = st2.upper()
print(st1, st1.isupper())
print(st2, st2.isupper())
print(st7, st7.isupper())
print('-' * 20)

st8 = '           '
print(st8, st8.isspace())
print('-' * 20)

print(st3, st3.istitle())
print('-' * 20)