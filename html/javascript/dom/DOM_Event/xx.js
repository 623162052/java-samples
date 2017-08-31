

var alerInfo = function(){
	alert("info");
	var divElement = document.getElementById("xx"); 
	divElement.detachEvent("onclick", alerInfo);
};


/**
 * DOMº”‘ÿ∫Û÷¥––
 * 
 * In IE, every element and window object has two methods: attachEvent() and detachEvent();
 * 
 */
window.onload = function(){
	var divElement = document.getElementById("xx");  
	if(divElement){
		divElement.attachEvent("onclick", alerInfo);
		alert("event added");
	}
};




