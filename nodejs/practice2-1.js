var mysql = require('mysql');

var connection = mysql.createConnection({
	host:'localhost',
	database:'test',
	user:'sa',
	password:'!password123'
});

startconnect('123');

function startconnect(uid){
	connection.connect(
		function(err){
			if(err){
				console.log('connection failed');
			}
			else{
				console.log('connection success');
				goQuery(uid);
			}
		}
	);
}

function goQuery(uid){
	connection.query('SELECT * FROM test1 where id = '+uid,
		function(err,rows){
			if(err){
				console.log('query failed');
			}
			else{
				console.log(rows.length);
				for(i=0;i<rows.length;i++){
					console.log(rows[i].id+"  "+rows[i].price)
				}
				//console.log(rows);
			}
			connection.end(function(err){
				if(err){
					console.log('connection end error');
				}
				else{
					console.log('connection and success');
				}
			});
		}
	);
}

