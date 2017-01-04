<?php
	require 'vdndor/autoload.php';
	Predis\Autoloader::register();
	$client = new Predis\Client(array('host'=>'127.0.0.1','port'=>6379),array('prefix'=>'php:'));
	$client->set("string:my_key","Hello World");
	$client->get("string:my_key");

	$client->incr("string:counter");
	$client->mget(array("string:my_key","string:counter"));

	$client->rpush("list:my_list","item1","item2");
	$client->lpop("list:my_list");

	$client->hset("set:redis_books","title","Redis Essentials");
	$client->hgetall("set:redis_books");

	$client->sadd("set:users","alice","bob");
	$client->smembers("set:users");

	$client->zadd("sorted_set:programmers",1940,"Alan Kay");
	$client->zadd("sorted_set:programmers",1912,"Alan Turing");
	$cline->zrange("sorted_set:programmers",0,-1,"withscores");
?>