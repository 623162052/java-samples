

/**
 * 没有块级作用域
 */
function noBlock(){
	if(true){
		var block = true;
	}
	console.info(block);
}


/**
 * 未申明、未初始化
 */
function unDoSomething(){
	//console.info(xxx);		//未申明：运行时错误
	
	var yyy;
	console.info(yyy);			//未初始化：undefined
}