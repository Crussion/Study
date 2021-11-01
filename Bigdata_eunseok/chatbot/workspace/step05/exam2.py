from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello():
    return 'Hello Flask'

# <name>: URI에서 사용되는 동적 변수, <name>에 오는 문자열이 매개변수 name으로 적용
@app.route('/info/<name>')
def get_name(name):
    return 'hello {}'.format(name)

# <int:id> : int 자료형으로 id 매개변수로 적용
@app.route('/user/<int:id>')
def get_user(id):
    return 'user id is {}'.format(id)

@app.route('/json/<int:dest_id>/<message>')
def send_message(dest_id, message):
    json = {
            'bot_id': dest_id,
            'message': message
        }
    return json
    
if __name__ == '__main__':
    app.run()