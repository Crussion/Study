# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 12:59:16 2021

@author: eunse
"""

import packages.image.io_file.imgRead

packages.image.io_file.imgRead.pngread()
packages.image.io_file.imgRead.jpgread()
print('-' * 20)

import packages.image.io_file.imgRead as ir2

ir2.pngread()
ir2.jpgread()
print('-' * 20)

from packages.image.io_file import imgRead

imgRead.pngread()
imgRead.jpgread()
print('-' * 20)

from packages.image.io_file import imgRead as ir4

ir4.pngread()
ir4.jpgread()
print('-' * 20)

from packages.image.io_file.imgRead import pngread
from packages.image.io_file.imgRead import jpgread

pngread()
jpgread()
print('-' * 20)