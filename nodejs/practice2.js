var mysql = require('mysql');

var conn = mysql.createConnection({
	host:'localhost',
	database:'test',
	user:'sa',
	password:'!password123'
});

conn.connect(
	function(err){
		if(err){
			console.log("connection failed");
		}
		else{
			console.log("connection success");
		}
	}
);

conn.query('SELECT * FROM test1 LIMIT 100',
	function(err,rows){
		if(err){
			console.log('query failed');
		}
		else{
			console.log(rows.length);
			for(i=0;i<rows.length;i++){
				console.log(rows[i].id);
			}
		}
	}
);

conn.end(
	function(err){
		if(err){
			console.log('connection end error');
		}
		else{
			console.log('connection end success');
		}
	}
)
