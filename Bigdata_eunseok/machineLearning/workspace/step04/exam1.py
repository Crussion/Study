from sklearn import metrics

y_test = [1, 0, 1, 0, 0, 0, 1, 0] # 테스트셋의 정답데이터
y_pred = [1, 0, 1, 1, 0, 0, 1, 1] # 테스트 후 나온 값

print('정확도 : ', metrics.accuracy_score(y_test, y_pred))
print('정밀도 : ', metrics.precision_score(y_test, y_pred))
print('재현율 : ', metrics.recall_score(y_test, y_pred))
print('F1 스코어 : ', metrics.f1_score(y_test, y_pred))