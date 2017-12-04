define(['utils'], function (Utils) {

  var Router = {
    init: function() {
      f7.onPageInit('*', function(page) {
        load(page.name, page.query);
      });

      bootApp();
    }
  };

  /**
   * Load (or reload) controller from js code (another controller) - call it's init function
   * @param  controllerName
   * @param  query
   */
  function load(name, query) {
    if (!name || name.indexOf('smart-select') !== -1) {
      return;
    }

    $$('.navbar').removeClass('navbar-home');
    $$('.view').removeClass('view-no-toolbar');
    $$('.toolbar-inner .link').removeClass('active');
    switch (name) {
      case 'home':
        $$('.link-home').addClass('active');
        break;
      case 'market':
        $$('.link-market').addClass('active');
        break;
      case 'trade':
        $$('.link-trade').addClass('active');
        break;
      case 'finance':
        $$('.link-finance').addClass('active');
        break;
      case 'my':
        $$('.link-my').addClass('active');
        break;
      default:
        $$('.view').addClass('view-no-toolbar');
        break;
    }
    require(['controllers/' + name + '.controller'], function (controller) {
      controller.init(query);
    });
  }

  function bootApp() {
    // var firstPage = 'home-part/message.html';
	  var obj = Utils.GetRequest();
	  var accountValue = obj.accountValue ;
	  var accountType = obj.accountType ;
	  if(accountValue==undefined){
		  accountValue = "";
	  }
	  if(accountType==undefined){
		  accountValue = "";
	  }
	  
    var firstPage = 'integral.html?accountValue='+accountValue+'&accountType='+accountType;
    mainView.router.load ({
      url: firstPage,
      animatePages: false
    });
  }

  return Router;
});
