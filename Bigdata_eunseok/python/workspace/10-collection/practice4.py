# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 14:35:03 2021

@author: eunse
"""

position = [False for i in range(5)]
while True:
    n = input('''          *************
              1. 입차
              2. 출차
              3. 리스트
              4. 종료
          *************
             메뉴 : ''')
    if n == '1':
        p = int(input("위치 입력 : "))
        if not position[p - 1]:
            position[p - 1] = True
            print("%d위치에 주차." %(p))
        else:
            print("%d위치에는 이미 주차 되었습니다." %(p))
    elif n == '2':
        p = int(input("위치 입력 : "))
        if position[p - 1]:
            position[p - 1] = False
            print("%d위치에 출차." %(p))
        else:
            print("%d위치에는 이미 비어 있습니다." %(p))
    elif n == '3':
        for i in range(len(position)):
            print("%d위치 : %s" %(i + 1, position[i]))
    elif n == '4':
        break