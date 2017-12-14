var listCount;
var pageSize=10;

function changePage(uid,id,lis){
    var pageNum;
    var liCount=Math.ceil(listCount/pageSize);
    if(id!=0&&id!=-1){
        var pageNum;
        $(lis).parent().siblings().removeClass("active disabled");
        $(lis).parent().addClass("active");
        pageNum=$(lis).text();
        if(liCount>=5&&parseInt(pageNum)+2<=liCount){
            setPage(pageNum,uid);
        }
        loadTable(pageSize,pageNum);
    }else{
        if(id==0){
            pageNum=$(lis).parent().parent().find(".active").find("a").text();
            if(pageNum==1){
                alert("已经是第一页！！")
            }else{
                $(lis).parent().parent().find(".active").removeClass("active");
                pageNum--;
                $("#"+pageNum).addClass("active");
                if(liCount>=5&&pageNum+2<=liCount){
                    setPage(pageNum,uid);
                }
                loadTable(pageSize,pageNum);
            }
        }
        if(id==-1){
            pageNum=$(lis).parent().parent().find(".active").find("a").text();
            if(pageNum==liCount){
                alert("已经是最后一页！！")
            }else{
                $(lis).parent().parent().find(".active").removeClass("active");
                pageNum++;
                $("#"+pageNum).addClass("active");
                if(liCount>=5&&pageNum+2<=liCount){
                    setPage(pageNum,uid);
                }
                loadTable(pageSize,pageNum);
            }
        }
    }
}

function setPage(pageNum,id){
    pageNum= parseInt(pageNum);
    var liCount=Math.ceil(listCount/pageSize);
    $("#"+id+" li").remove();
    $("#"+id).append("<li><a href='javascript:void(0);' onclick='changePage(\""+id+"\",0,this)'>&laquo;</a></li>"); //在ul标签上动态添加li标签
    if(liCount<=5){
        for(var i=1;i<=liCount;i++){
            if(i==1){
                $("#"+id).append("<li id='"+i+"' class='active'><a href='javascript:void(0);' onclick='changePage(\""+id+"\","+i+",this)'>"+i+"</a></li>");
            }else{
                $("#"+id).append("<li id='"+i+"'><a href='javascript:void(0);'onclick='changePage(\""+id+"\","+i+",this)'>"+i+"</a></li>");
            }
        }
    }else{
        if(pageNum>2){
            for(var i=pageNum-2;i<=2+pageNum;i++){
                if(i==pageNum){
                    $("#"+id).append("<li id='"+i+"' class='active'><a href='javascript:void(0);' onclick='changePage(\""+id+"\","+i+",this)'>"+i+"</a></li>");
                }else{
                    $("#"+id).append("<li id='"+i+"'><a href='javascript:void(0);'onclick='changePage(\""+id+"\","+i+",this)'>"+i+"</a></li>");
                }
            }
        }else{
            for(var i=1;i<=5;i++){
                if(i==pageNum){
                    $("#"+id).append("<li id='"+i+"' class='active'><a href='javascript:void(0);' onclick='changePage(\""+id+"\","+i+",this)'>"+i+"</a></li>");
                }else{
                    $("#"+id).append("<li id='"+i+"'><a href='javascript:void(0);'onclick='changePage(\""+id+"\","+i+",this)'>"+i+"</a></li>");
                }
            }
        }

    }
    $("#"+id).append("<li><a href='javascript:void(0);'onclick='changePage(\""+id+"\",-1,this)'>&raquo;</a></li>");

}
