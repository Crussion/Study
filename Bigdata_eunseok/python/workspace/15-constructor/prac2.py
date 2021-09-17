# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 16:11:25 2021

@author: eunse
"""

class Address:
    def __init__(self, name='', tel='', addr=''):
        self.name = name
        self.tel = tel
        self.addr = addr
    
    def showAddress(self):
        print('이름 :', self.name)
        print('전화 :', self.tel)
        print('주소 :', self.addr)
        
a1 = Address('홍길동', '010-1234-5678', '서울시 강남구 역삼동')
a1.showAddress()