import openpyxl

wb = openpyxl.load_workbook('sample.xlsx')

sheet = wb.active

sheet.title = '회원정보'

wb.close()