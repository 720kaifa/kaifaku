define(['utils'], function (Utils) {

  var bindings = [{
    element: '.left',
    event: 'click',
    handler: goMessage
  },{
    element: '.finance-part',
    event: 'click',
    handler: goFinancePart
  }];

  function goMessage() {
    // $$(this).find('i').toggleClass('active');
    mainView.loadPage('home-part/message.html');

  }
  function goFinancePart () {
    mainView.loadPage('home-part/home-finance.html');
  }
  function init() {
    $$('.navbar').addClass('navbar-home');
    Utils.bindEvents(bindings);
  }

  return {
    init: init
  };
});
