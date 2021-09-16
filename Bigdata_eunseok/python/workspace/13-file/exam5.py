# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 12:46:29 2021

@author: eunse
"""

# open() 함수는 기본적으로 encoding='euc-kr'(ANSI)로 설정되어 있다.
with open('test.csv', 'r', encoding='utf-8') as f:
    lines = f.readlines()
    print(lines)
    
    for i, line in enumerate(lines):
        line = line.replace('\n', '')
        lines[i] = line
        
        print(lines)
        
print('-' * 20)

students = []

with open('test.csv', 'r', encoding='utf-8') as f:
    lines = f.readlines()
    
    for i, line in enumerate(lines):
        line = line.replace('\n', '')
        lst = line.split(',')
        students.append(lst)
        
        
print(students)
print('-' * 20)
for lst in students:
    tot = int(lst[1]) + int(lst[2]) + int(lst[3])
    avg = tot / 3
    print("이름 : %s, 국어 : %s, 영어 : %s, 수학 : %s, 총점 : %d, 평균 : %d" %(lst[0], lst[1], lst[2], lst[3], tot, avg))