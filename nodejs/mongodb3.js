var mongodb = require('mongodb');
var MongoClient = mongodb.MongoClient;
var url = 'mongodb://localhost:27017/sampledb';

MongoClient.connect(url,
	function(err,db){
		if(err){
			console.log('Unable to connect to the mongoDB sv. Error:',err);
		}
		else{
			console.log('Connection established to',url);
			var collection = db.collection('users');
			
			var cursor = collection.find({name:'modulus admin'});
			cursor.sort({age:-1});
			cursor.limit(10);
			cursor.skip(0);
			cursor.each(
				function(err,doc){
					if(err){
						console.log(err);
					}
					else{
						console.log('Fetched:',doc);
					}
				}
			);
			db.close();
		}
	}
);



