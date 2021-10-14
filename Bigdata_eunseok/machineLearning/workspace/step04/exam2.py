from sklearn import metrics
import numpy as np

y_test = [1, 2, 3, 4, 6, 7, 8, 10]
y_pred = [1, 2, 3, 4, 5, 7, 9, 10]

print('잔차 :', metrics.mean_absolute_error(y_test, y_pred))
print('MSE :', metrics.mean_squared_error(y_test, y_pred))
print('RMSE :', np.sqrt(metrics.mean_squared_error(y_test, y_pred)))
print('R2 스코어 :', metrics.r2_score(y_test, y_pred))