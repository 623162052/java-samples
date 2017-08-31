/**
 * Definition Functions 
 */

/*
 * invoke after definition
 */
window.isDeadly = function (){
	return true;
};

/*
 * within a scope, invoke before definition works
 */
function isAlive(){
	return true;
}

/*
 * invoke need add ()
 * invoke after definition
 */
var isYoung = function(){
	return true;
};


console.info(isAlive() && window.isDeadly() && isYoung());
console.info(typeof isAlive + " - " + typeof window.isDeadly + " - " + typeof isYoung + " - " + typeof isOld); 
console.info(typeof isOld == "undefined");

/**
 * Anonymous function
 */
var people = {
	name : function name(){
		return "matthew";
	},
	
	gender : function gender(){
		return "male";
	},
	
	//arguments.callee
	count : function(n){
		return n > 0 ? arguments.callee(n-1) + "a" : "hiy";
	} 
};

console.info(people.name() + " - " + people.gender());
console.info(people.count(1));



console.info(!!0);
console.info(!!1);






/*
relationship between object, function, closure
misunderstanding: timers, regular expressions
eval
*/
