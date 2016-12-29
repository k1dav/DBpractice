import pymysql

config={
    'user':'sa',
    'password':'!password123',
    'host':'127.0.0.1',
    'database':'test',
}

cnx = pymysql.connect(**config)
cursor = cnx.cursor()
query=("SELECT * FROM test1 WHERE price > 600 LIMIT 10")
cursor.execute(query)

for (id,amount,price) in cursor :
	print("{},{},{}".format(id,amount,price))
	

cursor.close()
cnx.close()