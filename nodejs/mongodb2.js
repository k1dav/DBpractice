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
			
			collection.update(
				{name:'modulus user'},{$set:{enable:false}},
					function(err,numUpdated){
						if(err){
							console.log(err);
						}
						else if (numUpdated){
							console.log("Updated Successfully %d document(s).",numUpdated);
						}	
						else{
							console.log('No document found wirth defined "find" criteria!');
						}
					}
			);
			db.close();
		}
	}
);



