/**
 * ��������
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
 * ���Ե�ö��
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
	
	
	//������Դ�����
	if('xxx' in obj){
		console.info("xxx in obj");
	}
	
	//���Բ������ڶ��󷵻�undefined
	if(obj.qqq == undefined){
		console.info('qqq not in obj');
	}
}


//ɾ������
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
	
	//�����ŷ��ʶ������Կ���ʵ�ֶ�̬����
	console.info(obj['xxx']);
}

/**
 * Object costructor
 * constructor: ȷ��δ֪����
 */
function testConstructor(){
	var curr = new Date();
	console.info(typeof curr == "Date");		//false
	console.info(typeof curr == "object");		//tran
	console.info(curr.constructor == Date);		//true
	console.info(curr instanceof Date);			//true,instanceof���constructor��ֵ
	
}












