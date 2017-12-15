$(document).ready(function(){

});

$("#headscu").blur(function(){
   if($("#headscu").val()!=null&&$('#headscu').val()!=""){
       alert($("#headscu").text());
   }else{
       $("#errorMessage").html("不能为空！");
   }
});

function checkfile(){
    var filename=$("#headscu").val();
    if(filename==""&&filename==""){
        alert("请选择头像");
        alert(filename);
        return false;
    }else{
        return true;
    }
}