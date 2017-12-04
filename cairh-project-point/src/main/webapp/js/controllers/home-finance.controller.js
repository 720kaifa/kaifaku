define(['utils'], function (Utils) {

  var bindings = [];

  function init() {
    Utils.bindEvents(bindings);
  }

  return {
    init: init
  };
});
