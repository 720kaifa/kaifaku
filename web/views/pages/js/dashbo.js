$(document).ready(function(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/main/getWorkTime.do",
        dataType:"json",
        success:function (data) {
            for(var i=0;i<data.workTime.length;i++){
                $("#time"+i).html(data.workTime[i]);
            }
        },
        error:function () {
            alert("网络错误！");
        }
    });
});