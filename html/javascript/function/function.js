/**
 * 
 */
var $ = function(id){
	return document.getElementById(id);
}


/**
 * 可变长参数
 */
function dynamicArgs(){
	var args = "";
	//获取每个参数的值
	for(var i=0; i<arguments.length; i++){
		args += " - " + arguments[i];
	}
	console.info(args);
}


//闭包


