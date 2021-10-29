import socket

class BotServer:
    def __init__(self, srv_port, listen_num):
        self.port = srv_port
        self.listen_num = listen_num
        self.mySock = None
        
    def create_sock(self):
        self.mySock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.mySock.bind(('0.0.0.0', self.port))
        self.mySock.listen(int(self.listen_num))
        return self.mySock
    
    def ready_for_client(self):
        return self.mySock.accept()
    
    def get_sock(self):
        return self.mySock