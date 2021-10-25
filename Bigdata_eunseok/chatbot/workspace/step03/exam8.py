import openpyxl

wb = openpyxl.load_workbook('sample.xlsx')

sheet = wb['Sheet1']

col = sheet['A']

print(col)
print('-' * 40)

for cell in col:
    print(cell.value)
    
col = sheet['A':'B']

print(col)
print('-' * 40)

for cells in col:
    for cell in cells:
        print(cell.value, end=' ')
    print()

wb.close()