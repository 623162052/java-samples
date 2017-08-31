/**
 * JavaScriptÀ¬»ø»ØÊÕ»úÖÆ
 * JavaScript²»ÐèÒªÊÖ¶¯µØÊÍ·ÅÄÚ´æ£¬ËüÊ¹ÓÃÒ»ÖÖ×Ô¶¯À¬»ø»ØÊÕ»úÖÆ£¨garbage collection£©
 * µ±Ò»¸ö¶ÔÏóÎÞÓÃµÄÊ±ºò£¬¼´³ÌÐòÖÐÎÞ±äÁ¿ÒýÓÃÕâ¸ö¶ÔÏóÊ±£¬¾Í»á´ÓÄÚ´æÖÐÊÍ·ÅµôÕâ¸ö±äÁ¿
 */

var s = [ 1, 2 ,3];
var s = null;			//Êý×é¾Í»á±»ÊÍ·Åµô


/**
 * Ñ­»·ÒýÓÃ
 *
 * Èý¸ö¶ÔÏó A ¡¢B ¡¢C
 * A->B->C:  		Èç¹û½«AÇå³ý£¬ÄÇÃ´B¡¢CÒ²±»ÊÍ·Å
 * A->B->C->B:   	Èç¹ûÇå³ýA£¬ÄÇÃ´B¡¢C²»»á±»ÊÍ·Å£¬ÒòÎªBºÍCÖ®¼ä²úÉúÁËÑ­»·ÒýÓÃ
 */


 /**
 * Ñ­»·ÒýÓÃ
 *
 * Èý¸ö¶ÔÏó A ¡¢B ¡¢C
 * A->B->C:  		Èç¹û½«AÇå³ý£¬ÄÇÃ´B¡¢CÒ²±»ÊÍ·Å
 * A->B->C->B:   	Èç¹ûÇå³ýA£¬ÄÇÃ´B¡¢C²»»á±»ÊÍ·Å£¬ÒòÎªBºÍCÖ®¼ä²úÉúÁËÑ­»·ÒýÓÃ
 */
 function outer(){
     var obj = {};
     function inner(){ 
         //ÕâÀïÒýÓÃÁËobj¶ÔÏó
     }
     obj.inner = inner;
 }
 /*
 ÕâÊÇÒ»ÖÖ¼°ÆäÒþ±ÎµÄÑ­»·ÒýÓÃ£¬¡£µ±µ÷ÓÃÒ»´ÎouterÊ±£¬¾Í»áÔÚÆäÄÚ²¿´´½¨objºÍinnerÁ½¸ö¶ÔÏó£¬
 objµÄinnerÊôÐÔÒýÓÃÁËinner£»Í¬ÑùinnerÒ²ÒýÓÃÁËobj£¬ÕâÊÇÒòÎªobjÈÔÈ»ÔÚinnerFunµÄ·â±Õ»·¾³ÖÐ£¬
 ×¼È·µÄ½²ÕâÊÇÓÉÓÚJavaScriptÌØÓÐµÄ¡°×÷ÓÃÓòÁ´¡±¡£
 Òò´Ë£¬±Õ°ü·Ç³£ÈÝÒ×´´½¨Ñ­»·ÒýÓÃ£¬ÐÒÔËµÄÊÇJavaScriptÄÜ¹»ºÜºÃµÄ´¦ÀíÕâÖÖÑ­»·ÒýÓÃ¡£
 */


 //IEÖÐµÄÄÚ´æÐ¹Â©----------------------------------------------------
/*
	Ñ­»·ÒýÓÃËùÔì³ÉµÄÄÚ´æÐ¹Â©:µ±ÔÚDOMÔªËØ»òÒ»¸öActiveX¶ÔÏóÓëÆÕÍ¨JavaScript¶ÔÏóÖ®¼ä´æÔÚÑ­»·ÒýÓÃÊ±£¬IEÔÚÊÍ·ÅÕâÀà±äÁ¿Ê±´æÔÚÌØÊâµÄÀ§ÄÑ£¬
							 ×îºÃÊÖ¶¯ÇÐ¶ÏÑ­»·ÒýÓÃ£¬Õâ¸öbugÔÚIE 7ÖÐÒÑ¾­±»ÐÞ¸´ÁË
*/
function init(){
     var elem = document.getElementByid( 'id' );
     elem.onclick = function(){
         alert('rain-man');
         //ÕâÀïÒýÓÃÁËelemÔªËØ
     };
 }

//½â¾ö·½·¨:»ù±¾µÄ·½·¨¾ÍÊÇÊÖ¶¯Çå³ýÕâÖÖÑ­»·ÒýÓÃ£¬ÏÂÃæÒ»¸öÊ®·Ö¼òµ¥µÄÀý×Ó£¬Êµ¼ÊÓ¦ÓÃÊ±¿ÉÒÔ×Ô¼º¹¹½¨Ò»¸öaddEvent()º¯Êý£¬²¢ÇÒÔÚwindowµÄunloadÊÂ¼þÉÏ¶ÔËùÓÐÊÂ¼þ°ó¶¨½øÐÐÇå³ý
function outer(){
     var one = document.getElementById( 'one' );
     one.onclick = function(){};
 }
 window.onunload = function(){
     var one = document.getElementById( 'one' );
     one.onclick = null;
 };


/**
  * ±éÀúÄ³Ò»ÔªËØ½Úµã¼°ÆäËùÓÐºó´úÔªËØ
  *
  * @param Elem node  ËùÒªÇå³ýµÄÔªËØ½Úµã
  * @param function func  ½øÐÐ´¦ÀíµÄº¯Êý
  * 
  */
 function walkTheDOM(node, func) {
     func(node); 
     node = node.firstChild; 
     while (node) { 
         walkTheDOM(node, func); 
         node = node.nextSibling; 
     } 
 } 
 /**
  * Çå³ýdom½ÚµãµÄËùÓÐÒýÓÃ£¬·ÀÖ¹ÄÚ´æÐ¹Â¶
  *
  * @param Elem node  ËùÒªÇå³ýµÄÔªËØ½Úµã
  * 
  */
 function purgeEventHandlers(node) {
     walkTheDOM(node, function (e) {
         for (var n in e) {            
             if (typeof e[n] === 
                     'function') {
                 e[n] = null;
             }
         }
     });
 }
 

 /**
 JavaScriptÄÚ´æÐ¹Â©£¬Ö÷Òª¾ÍÊÇÓÉÓÚä¯ÀÀÆ÷µÄÁ½ÖÖÀ¬»ø»áÊÕ¼¯»úÖÆ
 £¨Ò»ÖÖÊÇJavaSciptºËÐÄ²¿·ÖµÄ¶ÔÏóµÄ»ØÊÕ»úÖÆ£¬ÁíÒ»ÖÖÊÇ¶ÔDom¶ÔÏóµÄÒýÓÃ¼ÆÊýµÄ»ØÊÕ»úÖÆ£©²»ÄÜÏà»¥¼æÈÝËùÒýÆðµÄ
 */

 /*
Ê¹ÓÃwindowµÄunloadÊÂ¼þµÄ¼àÌýº¯Êý¶ÔµÄÊÂ¼þ°ó¶¨½øÐÐ×îºóµÄÇå³ý£¬Ò²ÊÇÒ»ÖÖ²»´íµÄÑ¡Ôñ¡£
²»Ó¦µ±Ö»ÔÚ×îºó½øÐÐÇå³ý£¬Ó¦µ±ÔÚÕû¸öÓ¦ÓÃ³ÌÐòµÄºÏÊÊµÄÊ±ºò¼°Ê±µØ¶ÔÑ­»·ÒýÓÃ½øÐÐÊÖ¶¯Çå³ýºÍÇÐ¶Ï¡£
 */



 //Àý×Ó
function init(){
 	var elem = document.getElementByid( 'id' );
	 elem.onclick = function(){						//»á³öÏÖÄÚ´æÐ¹Â©
		 //...
	};
}

