# -*- coding: utf-8 -*-
"""
Created on Fri Sep 10 17:45:53 2021

@author: eunse
"""

location = input("경기장은 어디입니까? ")
win = input("이긴 팀은 어디입니까? ")
lose = input("진 팀은 어디입니까? ")
score = input("스코어는 몇대몇 입니까? ")

print("오늘 %s에서 야구경기가 열렸습니다." %location)
print("%s과 %s의 치열한 공방전이 펼쳤습니다." %(win, lose))
print("결국 %s은 %s를 %s로 이겼습니다." %(win, lose, score))