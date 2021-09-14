# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 18:01:24 2021

@author: eunse
"""

student_list = []
while True:
    n = input('''          성적 관리 프로그램
          -------------------
           1. 입력
           2. 출력
           3. 종료
          -------------------
           번호 : ''')
    
    if n == '1':
        student_data = {}
        student_data['이름'] = input('이름 입력 : ')
        student_data['국어'] = int(input('국어 점수 : '))
        student_data['영어'] = int(input('영어 점수 : '))
        student_data['수학'] = int(input('수학 점수 : '))
        student_data['총점'] = student_data['국어'] + student_data['영어'] + student_data['수학']
        student_data['평균'] = student_data['총점'] / 3
        student_list.append(student_data)
    elif n == '2':
        for i in student_list:
            print(i)
    elif n == '3':
        break