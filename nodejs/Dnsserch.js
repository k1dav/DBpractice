var http = require('http'),
	dns = require('dns'),
	fs = require('fs'),
	url = require('url'),
	querystring = require('querystring');

http.createServer(
	function(req,res){
		var pathname =url.parse(req.url).pathname;
		res.writeHead(200,{'Content-Type':'text/html;charset=utf8'});
		req.setEncoding("utf8");
		router(res,req,pathname);
	}
).listen(3000,"127.0.0.1");

console.log('Server running at http://127.0.0.1:3000/');

function router(res,req,pathname){
	console.log(pathname);
	switch(pathname){
		case "/parse":
			parseDns(res,req);
			break;
		default:
			goIndex(res,req);
	}
}

function parseDns(res,req){
	var postData="";
	req.addListener("data",
		function(postDataChunk){
			postData+=postDataChunk;
		}
	);
	req.addListener("end",
		function(){
			var resData=getDns(postData,
				function(domain,addresses){
					res.writeHead(200,{'Content-Type':'text/html'});
					res.end("<html><head>"+
							"<meta http-equiv = 'Content-Type'content='text/html;charset=utf8'></head>"+
							"<div style='text-align:center'>"+
							"Domain:<span style ='color:red'>"+domain+
							"</span>IP:<span style='color:red'>"+addresses.join(',')+"</span></div>"+
							"</html>");
				}
			);
			return;
		}
	);
}

function goIndex(res,req){
	var readPath = __dirname + '/' + url.parse('index.html').pathname;
	var indexPage = fs.readFileSync(readPath);
	res.end(indexPage);
}

function getDns(postData,callback){
	var domain = querystring.parse(postData).search_dns;
	console.log(postData);
	console.log(querystring.parse(postData));
	console.log(domain);   

	dns.resolve(domain,function(err,addresses){
		if(!addresses){
			addresses=['不存在的網址名稱']
		}
		console.log(addresses)
		callback(domain,addresses);
	});
}


