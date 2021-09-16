# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 17:34:05 2021

@author: eunse
"""

def menu():
    return int(input('상품 관리 프로그램\
                 \n**********************\
                 \n    1. 입고\
                 \n    2. 출고\
                 \n    3. 목록\
                 \n    4. 종료\
                 \n**********************\
                 \n   메뉴 : '))

def in_goods(list):
    goods_data = {}
    goods_data['품명'] = input("품명 : ")
    goods_data['수량'] = int(input("수량 : "))
    goods_data['단가'] = int(input("단가 : "))
    goods_data['총액'] = goods_data['수량'] * goods_data['단가']
    list.append(goods_data)
    
def out_goods(list):
    goods = input("품명 : ")
    empty = True
    for i in list:
        if goods == i['품명']:
            qty = int(input("수량 : "))
            compute(goods, qty, i)
            empty = False
            return
    if empty:
        print('품목이 존재하지 않습니다.')
    
def compute(goods, qty, list):
    list['수량'] -= qty
    list['총액'] = list['수량'] * list['단가']
    
def output_list(list):
    print('품명    수량    단가(원)    총액(원)')
    for i in range(len(list)):
        print('%s    %d      %d      %d' %(list[i]['품명'], list[i]['수량'], list[i]['단가'], list[i]['총액']))

goods_list = []
    
while True:
    c = menu()
    if c == 1:
        in_goods(goods_list)
    elif c == 2:
        out_goods(goods_list)
    elif c == 3:
        output_list(goods_list)
    elif c == 4:
        break