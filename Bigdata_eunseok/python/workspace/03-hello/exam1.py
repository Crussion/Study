# -*- coding: utf-8 -*-
"""
Created on Fri Sep 10 13:01:15 2021

@author: eunse
"""

print("hello python!")

#print("hello" + 5) <- error

print("hello" + str(5))

print(5,7,9)
print(5,7,9,sep=" ")
print(5,7,9,sep="")
print(5,7,9,sep="/")
print(5,7,9,sep=" / ")

print("---------------")
print(5,7,9,end="\n")
print(5,7,9,end="끝")
print(5,7,9,end="")
print(5,7,9,)
print("---------------")

print("%d" %5)
print("%f" %7.5)
print("%s" %'hello')
print("---------------")

print("%s" %5)
print("%s" %7.5)
print("%s" %'hello')
print("%s" %True)
print("---------------")

print("%s" %5)
print("%.1f" %7.5555)
print("%s" %'hello')
print("%s" %True)
print("---------------")
