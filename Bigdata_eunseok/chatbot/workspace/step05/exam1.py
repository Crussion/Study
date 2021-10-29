from flask import Flask

app = Flask(__name__)

# 뷰(view) 함수
# http://localhost:5000 으로 호출되면 동작되는 함수
# @app.route('요청값')
@app.route('/')
def hello():
    return 'Hello Flask'

@app.route('/home')
def home():
    return 'Homepage'

app.run()