/**
 * 创建对象
 */
function createObj(){
	var empty = {};
	var point = {x:0, y:1};

	
	var circle = {x:point.x, y:point.y+1, radius:2};
	var home = {
		"name" : "aoaoa",
		"age" : 34,
		"email" : "aoaoxiong@gmail.com"
	};
}


/**
 * 属性的枚举
 */
function displayPropertyNames(){
	var obj = {
		xxx : 'xxx',
		yyy : 'yyy',
		zzz : 'zzz'
	};
	
	var resultStr = "";
	for(var name in obj){
		resultStr += name + " - ";
	}
	console.info(resultStr);
	
	
	//检查属性存在性
	if('xxx' in obj){
		console.info("xxx in obj");
	}
	
	//属性不存在于对象返回undefined
	if(obj.qqq == undefined){
		console.info('qqq not in obj');
	}
}


//删除属性
function deleteObjAttr(){
	var obj = {
		xxx : 'xxxx',
		yyy : 'yyyy',
		zzz : 'zzzz'
	};
	
	delete obj.zzz;
	
	var resultStr = "";
	for(var name in obj){
		resultStr += name + " - ";
	}
	console.info(resultStr);
	
	//中括号访问对象属性可以实现动态访问
	console.info(obj['xxx']);
}

/**
 * Object costructor
 * constructor: 确定未知类型
 */
function testConstructor(){
	var curr = new Date();
	console.info(typeof curr == "Date");		//false
	console.info(typeof curr == "object");		//tran
	console.info(curr.constructor == Date);		//true
	console.info(curr instanceof Date);			//true,instanceof检查constructor的值
	
}












