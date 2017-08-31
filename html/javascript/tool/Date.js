/**
 * 
 */

//new Date()
var date1 = new Date();
console.log("new Date(): " + date1);
console.log("toDateString: " + date1.toDateString());				//Sat Apr 14 2012
console.log("toTimeString: " + date1.toTimeString());				//15:59:58 UTC+0800
console.log("toLocaleString: " + date1.toLocaleString());			//2012��4��14�� 15:59:58 
console.log("toLocaleDateString: " + date1.toLocaleDateString());	//2012��4��14��
console.log("toLocalTimeString: " + date1.toLocaleTimeString());	//16:01:29

console.log(Date.parse("2011-01-01"));


var date3 = new Date();
console.log(date3.getFullYear());
console.log("getFullYear: " + date3.getFullYear());		//Get 4-digit year
console.log("getMonth: " + date3.getMonth());			//Get month, from 0 to 11
console.log("getDay: " + date3.getDay());				//Get the number of day in a week, from 0(Sunday) to 6(Saturday)
console.log("getDate: " + date3.getDate());				//Get day, from 1 to 31
console.log("getUTCFullYear: " + date3.getUTCFullYear());	//UTC	Э������ʱ
console.log("getUTCMonth: " + date3.getUTCMonth());
console.log("getUTCDay: " + date3.getUTCDay());
console.log("getTime: " + date3.getTime());				//Returns number of milliseconds passed from 1 Jan 1970, midnight. 

	
var startDate1 = new Date('2012-01-01 22:22:22'.replace(/\-/g, "\/"));
var endDate2 = new Date('2012-01-01 22:22:22'.replace(/\-/g, "\/"));
if(startDate1 !="" && endDate2 != "" && startDate1 > endDate2) {
	alert("��ʼ���ڱ���С�ڻ���ڽ������ڣ�");
//	return false;
} 