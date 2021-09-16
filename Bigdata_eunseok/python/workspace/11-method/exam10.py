# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 16:45:47 2021

@author: eunse
"""

def greet(name, msg='별일 없죠?'):
    print(name + ", " + msg)
    
greet('홍길동')

greet('철수', '좋은 아침')

greet(name='길동', msg="즐거운 오후")

greet(msg="즐거운 오후", name='길동')