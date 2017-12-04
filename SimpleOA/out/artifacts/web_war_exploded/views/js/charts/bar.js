$(function () {
	var data = new Array ();
    var ds = new Array();
    var lab=["本月","本周","昨日"];
    var tic=[[1, "弯针"], [2, "管理员"], [3, "李四"], [4, "王五"], [5, "赵谦"]];

    data.push ([[1,25],[2,34],[3,37],[4,45],[5,80]]);
    data.push ([[1,13],[2,29],[3,25],[4,23],[5,31]]);
    data.push ([[1,8],[2,13],[3,19],[4,15],[5,14]]);
 
    for (var i=0, j=data.length; i<j; i++) {
    	
	     ds.push({
			 label:lab[i],
	        data:data[i],
	        grid:{
            hoverable:true
        },
	        bars: {
	            show: true, 
	            barWidth: 0.2, 
	            order: 1,
	            lineWidth: 0.5, 
				fillColor: { colors: [ { opacity: 0.65 }, { opacity: 1 } ] }
	        }
	    });
	}
	    
    $.plot($("#bar-chart"), ds, {
    	colors: ["#F90", "#3C4049", "#666", "#BBB"],
        xaxis: { ticks: tic, min: 0.5, max: 5.5},  //指定固定的显示内容
    });

});