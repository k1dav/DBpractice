var mysql = require('mysql');
var conn = mysql.createConnection({
	host:'localhost',
	user:'sa',
	password:'!password123',
	database:'test'
});

conn.connect();

conn.query('SELECT * FROM test1 LIMIT 10',
		function(err,rows,fields){
			if(!err){
				console.log('The solution is: ', rows);
			}
			else{
				console.log('Error whule performing Query.');
			}
		}
);

conn.end();