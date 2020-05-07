<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">  
html{height:100%}  
body{height:100%;margin:0px;padding:0px}  
#container{height:100%}  
</style>  
<script src="static/comp/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/getscript?v=3.0&ak=9OTRu3GGB0COQTkcB29wrC1n61f0cH0d"></script>
</head>
<body>
<div id="container"></div> 
<script type="text/javascript"> 

$(document).ready(function () {

	    
	    
	    	var map = new BMap.Map("container");
	    	
	    	var end ="";
	    	var start="";
	    	var myGeo = new BMap.Geocoder();      
	    	// 将地址解析结果显示在地图上，并调整地图视野    
	    	myGeo.getPoint("北京市海淀区苏州街长远天地大厦A1座502", function(point){  

	    	    if (point) {   
	    	    	end=point
	    	    	var riding = new BMap.RidingRoute(map, { 
	    	    	    renderOptions: {map: map} 
	    	    	}); 
	    	    	riding.search(start, end);      
	    	    }      
	    	 }, 
	    	"北京市");
	    	
	    	myGeo.getPoint("北京中关村科学院南路2号 融科资讯中心C座北楼12层", function(point){  

	    	    if (point) {   
	    	    	start=point
	 
	    	    	var riding = new BMap.RidingRoute(map, { 
	    	    	    renderOptions: {map: map} 
	    	    	}); 
	    	    	riding.search(start, end);
    
	    	    }      
	    	 }, 
	    	"北京市");
	    	


	    
	
});

</script>  
</body>
</html>