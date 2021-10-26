import pickle

f = open('setting.txt', 'wb')

try:
    setting = [{'title':'python program'}, {'author':'홍길동'},
               {'title':'java program'}, {'author':'이영희'}]
    pickle.dump(setting, f)
except Exception as e:
    print('[Error]', e)
finally:
    f.close()
    
f = open('setting.txt', 'rb')

try:
    result = pickle.load(f)
    print(result)
except Exception as e:
    print('[Error]', e)
finally:
    f.close()