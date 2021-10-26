import threading

def character(low, high):
    for i in range(low, high+1):
        print(chr(i), end=' ')
        
t = threading.Thread(target=character, args=(65, 90))
t.start()

print('Main Thred')
for i in range(1, 101):
    print(i, end=' ')
    if i%10 == 0: print()