$(document).ready(function(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/project/getLastProject.do",
        dataType:"json",
        success:function (data) {
            var projectList=data.projectList;
            for(var i=0;i<projectList.length;i++){
                var classn;
                var project=projectList[i];
                var status=project.projectstatus==1?"进行中":"已结束";
                if(i==0){
                    classn=" orange";
                }else{
                    classn="";
                }
               var div='<div class="plan-container">'
                   +'<div class="plan'+classn+'">'
                    +'<div class="plan-header">'
                   +'<div class="plan-title">'
                    +project.projectname
                    +'</div>'
                    +'<div class="plan-price">'
                    +'75<span class="term">累计工时</span>'
                    +'</div></div><div class="plan-features">'
                    +'<ul> <li><strong>项目状态:</strong>'+status+'</li>'
                    +'<li><strong>开始时间:</strong>'+project.starttime+'</li> </ul></div>'
                    +'<div class="plan-actions"></div></div></div>';
               $(".pricing-plans").append(div);
            }
        },
        error:function () {
            alert("网络错误！");
        }
    });
});