define(['utils','template'], function (Utils, Template) {
	  var bindings = [
	      {
	      element: '.left_a',
	      event: 'click',
	      handler: js_method
          },
	      {
	      element: '#ifBinDing4',
	      event: 'click',
	      handler: binDing
          }
	  ];
  
	  var browser={versions:function()
			  {var a=navigator.userAgent,b=navigator.appVersion;
			  return{trident:a.indexOf("Trident")>-1,presto:a.indexOf("Presto")>-1,
			  webKit:a.indexOf("AppleWebKit")>-1,gecko:a.indexOf("Gecko")>-1&&a.indexOf("KHTML")==-1,
			  mobile:!!a.match(/AppleWebKit.*Mobile.*/),ios:!!a.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
			  android:a.indexOf("Android")>-1||a.indexOf("Linux")>-1,iPhone:a.indexOf("iPhone")>-1,
			  iPad:a.indexOf("iPad")>-1,webApp:a.indexOf("Safari")==-1}}(),
			  language:(navigator.browserLanguage||navigator.language).toLowerCase()};
	  
  function init(query) {

    Utils.bindEvents(bindings);
    var url = "./CM3003.json";
    var param = arguments[0] || {};
    param.pageSize = 10;
    var max = 0;
    param.pageNum=1;
    $$.ajax({
      url:url,
      data :param,
      method :"GET",
      dataType:"json",
      success:function(response){
        // var totalIntegral = response.totalIntegral;//这是总积分，单独拿出来渲染
    	  if(response.error_no!=0){
    		  f7.modal({
    			   text: '<span class="modal-red-text left-text">'+response.error_info+'</span>',
    		      });
    		  return;
    	  }
    	  $$('.integral').text(response.availablePoints);
    	  if(response.ifAccount==0){
    		  $$("#ifBinDing1").hide();
    		  $$("#ifBinDing2").hide();
    		  $$("#ifBinDing3").hide();
    	  }else{
        	  if(response.funAccountId==null){
        		  $$("#ifBinDing1").hide();
        		  $$("#ifBinDing2").show();
        		  $$("#ifBinDing3").hide();
        	  }else{
        		  $$("#ifBinDing1").show();
        		  $$("#ifBinDing2").hide();
        		  $$("#ifBinDing3").show();
            	  $$('#account').text(response.funAccountId);
        	  }
    	  }
    	  max=response.page.totalPages;
          Template.render('#listContent',response);
      }
    })
    var loading = false;
    //下面是分页效果，开发自己写逻辑
    $$('.page-integral .infinite-scroll').on('infinite', function () {
      if (loading) return;
      loading = true;
      param.pageNum++;
      if(param.pageNum>max) return;
      setTimeout(function () {
        loading = false;
        $$.ajax({
          url:"./CM3003.json",
          data :param,
          method :"GET",
          dataType:"json",
          success:function(response){
            Template.render('#listContent', response, 'append');
          }
        })
      }, 1000);
    });          
  }

  function js_method() {	  
		if (browser.versions.ios) {	//iphone
			window.location.href = "objc://callIOSQuit/";
		} else if (browser.versions.android) {
			jtoJHandle.closeSJKH();
		}
  }
  
  function binDing() {	  
		if (browser.versions.ios) {	//iphone
			window.location.href = "objc://getFundsAcount/?fundsAcount";
		} else if (browser.versions.android) {
			jtoJHandle.getFundsAcount("fundsAcount");
		}
  }
  
  window.fundsAcount=fundsAcount;
  
  function fundsAcount(accountValue,accountType,accountValue2,accountType2){
	  	Utils.bindEvents(bindings);
	    var url = "./CM3004.json";
	    var param = arguments[0] || {};
	    param.accountValue = accountValue;
	    param.accountType = accountType;
	    param.accountValue2 = accountValue2;
	    param.accountType2 = accountType2;
	    $$.ajax({
	      url:url,
	      data :param,
	      method :"GET",
	      dataType:"json",
	      success:function(response){
	        // var totalIntegral = response.totalIntegral;//这是总积分，单独拿出来渲染
	    	  if(response.error_no!=0){
	    		  f7.modal({
	    			   text: '<span class="modal-red-text left-text">'+response.error_info+'</span>',
	    		      });
	    		  return;
	    	  }
	    	  f7.modal({
   			   text: '<span class="modal-red-text left-text">'+response.error_info+'</span>',
   		      });
	    	  $$('#ifBinDing').text(response.funAccountId);
	      }
	    })
  }
  
  return {
    init: init
  };
});