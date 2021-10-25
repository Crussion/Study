import openpyxl

wb = openpyxl.load_workbook('sample.xlsx')

sheet = wb['Sheet1']

for v in list(sheet.values)[1:]:
    print(v)
print('-' * 40)

for row in sheet.iter_rows(2):
    for cell in row:
        print(cell.value, end=' ')
    print()
print('-' * 40)

wb.close()