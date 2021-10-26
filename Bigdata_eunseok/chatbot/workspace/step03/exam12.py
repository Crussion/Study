import threading

class Character(threading.Thread):
    def __init__(self, low, high):
        threading.Thread.__init__(self)
        self.low = low
        self.high = high
        
    # 쓰레드로 동작되어질 함수, 이름이 run 이여야 된다
    def run(self):
        for i in range(self.low, self.high + 1):
            print(chr(i), end=' ')
            
c = Character(65, 90)
c.start()

