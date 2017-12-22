$(document).ready(function(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/project/getLastProject.do",
        dataType:"json",
        async:false,
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
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });

    $.ajax({
        type:"post",
        url:simpleUrl+"/notice/getLastNotice.do",
        dataType:"json",
        async:false,
        success:function (data) {
            $("#vnotice").empty();
            var notice=data.notice
            var div;
            if(notice=="errorNull"){
                div='<p  style="text-align:  center;font-size: 15px;margin-bottom: 0px;padding-bottom: 0px"><strong>'
                    +'暂无数据！'+'</strong></p>'
            }else {
                div='<p  style="text-align:  center;font-size: 15px;margin-bottom: 0px;padding-bottom: 0px"><strong>'
                    +notice.title+'</strong></p>' +
                    '<p  style="text-align:  center ;font-size: 10px;margin-top: 0px;padding-top: 0px">'+notice.CREATE_TIME+'</p>' +
                    '<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+notice.content+'</p><p  style="text-align:right">'+notice.relname+'</p>';
            }
            $("#vnotice").append(div);
        },
        error:function () {
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });

    $.ajax({
        type:"post",
        url:simpleUrl+"/news/getLastNews.do",
        dataType:"json",
        async:false,
        success:function (data) {
            $("#vnews").empty();
            var news=data.news
            var div;
            if(news=="errorNull"){
                div='<p  style="text-align:  center;font-size: 15px;margin-bottom: 0px;padding-bottom: 0px"><strong>'
                    +'暂无数据！'+'</strong></p>'
            }else {
                div='<p  style="text-align:  center;font-size: 15px;margin-bottom: 0px;padding-bottom: 0px"><strong>'
                    +news.title+'</strong></p>' +
                    '<p  style="text-align:  center ;font-size: 10px;margin-top: 0px;padding-top: 0px">'+news.CREATE_TIME+'</p>' +
                    '<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+news.content+'</p><p  style="text-align:right">'+news.relname+'</p>';
            }
            $("#vnews").append(div);
        },
        error:function () {
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });
});