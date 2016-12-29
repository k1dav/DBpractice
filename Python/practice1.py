import pymysql

config={
    'user':'sa',
    'password':'!password123',
    'host':'127.0.0.1',
    'database':'test',
}

cnx=pymysql.connect(**config)
print('mysql connect:OK')
cnx.close()
print('mysql disconnect...')