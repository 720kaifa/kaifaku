$(document).ready(function(){
    addMenus();
});

function changeClass(a,url){
    $("#span9").load(url);
    $(a).parent().siblings().removeClass("active");
    $(a).parent().attr("class", "active");
}

function addMenus() {
    $.ajax({
        type:"post",
        url:simpleUrl+"/menu/getMenu.do",
        dataType:"json",
        success:function (data) {
            $("#main-nav li").remove()
            for(var i=0;i<data.menuList.length;i++){
                var menu=data.menuList[i];
                var url="\""+simpleUrl+"/views/pages/"+menu.url+".jsp\"";
                var icon="icon-"+menu.icon;
                if(i==0){
                    var li="<li id='"+menu.lid+"' class='active'><a href='javascript:void(0);' onclick='changeClass(this,"+url+")'> <i class='"+icon+"'></i>"+menu.title+" </a> </li>";
                }else{
                    var li="<li id='"+menu.lid+"'><a href='javascript:void(0);' onclick='changeClass(this,"+url+")'> <i class='"+icon+"'></i>"+menu.title+" </a> </li>";
                }
                $("#main-nav").append(li);
            }
        },
        error:function () {
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });
}
