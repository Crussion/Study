# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 17:41:20 2021

@author: eunse
"""

class Gugudan:
    def setGugudan(self, start, end):
        self.start = start
        self.end = end
    def dispGugudan(self):
        for i in range(self.start, self.end + 1):
            for j in range(1, 10):
                print("%d * %d = %2d" %(i, j, i * j), end="   ")
            print()
            
gugudan = Gugudan()
s = int(input("시작단 : "))
e = int(input("끝단 : "))

gugudan.setGugudan(s, e)
gugudan.dispGugudan()