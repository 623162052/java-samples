/**
 * 
 */
var $ = function(id){
	return document.getElementById(id);
}


/**
 * �ɱ䳤����
 */
function dynamicArgs(){
	var args = "";
	//��ȡÿ��������ֵ
	for(var i=0; i<arguments.length; i++){
		args += " - " + arguments[i];
	}
	console.info(args);
}


//�հ�


