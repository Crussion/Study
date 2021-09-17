# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 15:42:36 2021

@author: eunse
"""

from random import *

class Lotto :
    def __init__(self):
        self.m = 0
        self.buyNum = 0
    
    def inputBuyNum(self):
        self.buyNum = int(input('구매 횟수를 입력하세요 : '))
        print()
        
    def outputResult(self):
        for v in self.m:
            print('%2d' %v, end=' ')
        print()
    
    def selectLotto(self):
        for i in range(self.buyNum):
            self.m = sample([a for a in range(1, 46)], 6)
            self.m.sort()
            self.outputResult()
            
lotto = Lotto()
lotto.inputBuyNum()
lotto.selectLotto()