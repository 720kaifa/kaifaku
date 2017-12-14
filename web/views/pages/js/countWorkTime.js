$(document).ready(function(){
    $("#worktimelist").css("height", "560");
    getCount();
    loadTable(pageSize,1);
    setPage(1,"simpleoapage_wtl");
});

function getCount(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/workTime/getCount.do",
        dataType:"json",
        async: false,
        data:{"id":1},
        success:function (data) {
            listCount=data.conut;
        },
        error:function () {
            alert("发生未知错误，请联系管理员！");
        }
    });
}
function  loadTable(pageSize,pageNum){
    $.ajax({
        type:"post",
        url:simpleUrl+"/workTime/workTimeList.do?number=Math.random()",
        dataType:"json",
        data:{"pageSize":pageSize,"pageNum":pageNum},
        success:function (data) {
            $(".table-striped tbody").html("");
            for(var i=0;i<data.workTimeList.length;i++){
                var workTime=data.workTimeList[i];
                var projectstatus=(workTime.projectstatus==1)?"进行中":"已结束";
                var num=i+1;
                var tr="<tr><td style='text-align: center;'>"
                    + num
                    + " </td><td style='text-align: center;' title='"
                    + workTime.relname+"'>"
                    + workTime.relname
                    + " </td><td style='text-align: center;' title='"
                    + workTime.projectname+"'>"
                    + workTime.projectname
                    + " </td><td style='text-align: center;' title='"
                    + projectstatus+"'>"
                    + projectstatus
                    + " </td><td style='text-align: center;' title='"
                    + workTime.tmworktime+"小时'>"
                    + workTime.tmworktime
                    + "小时</td><td style='text-align: center;' title='"
                    + workTime.twworktime+"小时'>"
                    + workTime.twworktime
                    + "小时</td><td style='text-align: center;' title='"
                    + workTime.coworktime+"小时'>"
                    + workTime.coworktime
                    + "小时</td>";

                $(".table-striped").append(tr);
            }
            $(".table-striped td").attr("class", "simpleoa-wrap");
        },
        error:function () {
            alert("发生未知错误，请联系管理员！");
        }
    });
}

function setProject(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/user/getProject.do",
        dataType:"json",
        success:function (data) {
            var projectList=data.projectList;
            var sel=$("#projectid");
            sel.append("<option value='0'>全部！</option>");
            for(var i=0;i<projectList.length;i++){
                sel.append("<option value='"+projectList[i].id+"'>"+projectList[i].projectname+"</option>");
            }
        },
        error:function () {
            alert("项目列表获取失败！");
        }
    });
}