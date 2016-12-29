var chunk={id:"12",data:"123556",details:{"name":"alan","age":"12"}}
//var jsonobj = JSON.parse(chunk);
console.log(chunk.details);
console.log(chunk.details.name);

var str = '{"foo": "bar"}';
console.log(str.foo);
//=> undefined

// parse str into an object
var obj = JSON.parse(str);

console.log(obj.foo);
//=> "bar" 