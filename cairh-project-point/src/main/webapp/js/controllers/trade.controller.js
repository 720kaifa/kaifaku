define(['utils'], function (Utils) {

  var bindings = [{
    element: '.left',
    event: 'click',
    handler: addActive
  }];

  function addActive() {
    $$(this).find('i').toggleClass('active');
  }
  function init() {
    Utils.bindEvents(bindings);
  }

  return {
    init: init
  };
});
