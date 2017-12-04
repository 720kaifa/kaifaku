define(['utils'], function (Utils) {

  var bindings = [{
    element: '.item-content',
    event: 'click',
    handler: goDetail
  }];

  function goDetail() {
    mainView.loadPage('home-part/message-detail.html');
  }
  function init() {
    Utils.bindEvents(bindings);
  }

  return {
    init: init
  };
});
