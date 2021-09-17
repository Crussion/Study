# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 17:08:51 2021

@author: eunse
"""

class Article:
    def __init__(self):
        self.num = 0
        self.title = 0
        
class FileArticle(Article):
    def __init__(self):
        super().__init__()
        self.filename = 0
        
    def __str__(self):
        return '자료실 [번호=%d, 제목=%s, 첨부파일=%s]'\
            %(self.num, self.title, self.filename)
            
class QnaArticle(Article):
    def __init__(self):
        super().__init__()
        self.answer = 0
        
    def __str__(self):
        return '질문/답변 [번호=%d, 제목=%s, 답변=%s]'\
            %(self.num, self.title, self.answer)
            
fileArticle = FileArticle()
fileArticle.num = 1
fileArticle.title = '첫번째 자료입니다.'
fileArticle.filename = 'python'
print(fileArticle.__str__())
print(fileArticle)
