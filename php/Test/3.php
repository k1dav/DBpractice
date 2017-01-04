<?php
	require 'vdndor/autoload.php';
	Predis\Autoloader::register();
	$client = new Predis\Client(array('host'=>'127.0.0.1','port'=>6379),array('prefix'=>'php:'));
	$client->transaction()
	->set('transaction:key','A string in a transactional block')
	->incr('transaction:counter')
	->get('transaction:key')
	->execute();
?>