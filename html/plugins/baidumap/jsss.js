// �ٶȵ�ͼAPI����
	var map = new BMap.Map("l-map");          // ������ͼʵ��
	var point = new BMap.Point(116.403694,39.927552);  // ����������
	map.centerAndZoom(point, 15);                 // ��ʼ����ͼ���������ĵ�����͵�ͼ����
	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl());  //���Ĭ������ƽ�ƿؼ�
	var customLayer;
	function addCustomLayer(keyword) {
		if (customLayer) {
			map.removeTileLayer(customLayer);
		}
		customLayer=new BMap.CustomLayer({
			geotableId: 30960,
			q: '', //�����ؼ���
			tags: '', //�ո�ָ��Ķ��ַ���
			filter: '' //��������,�ο�http://developer.baidu.com/map/lbs-geosearch.htm#.search.nearby
		});
		map.addTileLayer(customLayer);
		customLayer.addEventListener('hotspotclick',callback);
	}
	function callback(e)//�����ȵ�ͼ��
	{
			var customPoi = e.customPoi;//poi��Ĭ���ֶ�
			var contentPoi=e.content;//poi���Զ����ֶ�
			var content = '<p style="width:280px;margin:0;line-height:20px;">��ַ��' + customPoi.address + '<br/>�۸�:'+contentPoi.dayprice+'Ԫ'+'</p>';
			var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
				title: customPoi.title, //����
				width: 290, //���
				height: 40, //�߶�
				panel : "panel", //����������
				enableAutoPan : true, //�Զ�ƽ��
				enableSendToPhone: true, //�Ƿ���ʾ���͵��ֻ���ť
				searchTypes :[
					BMAPLIB_TAB_SEARCH,   //�ܱ߼���
					BMAPLIB_TAB_TO_HERE,  //������ȥ
					BMAPLIB_TAB_FROM_HERE //���������
				]
			});
			var point = new BMap.Point(customPoi.point.lng, customPoi.point.lat);
			searchInfoWindow.open(point);
	}
	document.getElementById("open").onclick = function(){
		addCustomLayer();
	};
	document.getElementById("close").onclick = function(){
		if (customLayer) {
			map.removeTileLayer(customLayer);
		}
	};

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	