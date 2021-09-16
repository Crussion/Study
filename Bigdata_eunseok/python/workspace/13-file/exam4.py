# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 12:40:55 2021

@author: eunse
"""

with open('test4.txt', 'w') as f:
    f.write('내일은 웃으리...')
    
with open('test4.txt', 'r') as f:
    print(f.read())