sum = 0

# for(int i=1; i<101; i++) {}
for i in range(1,101):   # (1~100)
    sum += i
    if (i % 10 == 0):
        print("%2d ~ %3d = %3d" %((i-9), i, sum))
        sum = 0

