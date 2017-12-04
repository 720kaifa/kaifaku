define(['utils'], function (Utils) {
  // replace 二次更新时替换内容， str 模板内容
  function render(selector, data, type, str) {
    var template, templateStr, parent, compiledTemplate;
    if (!type) {
      type = 'append';
    }
    switch (type) {
    case 'append' : // 模板写在html页面时追加
      template = $$('script' + selector);
      templateStr = template.html();
      parent = template.parent();
      compiledTemplate = Template7.compile(templateStr);
      parent.append(compiledTemplate(data));
      break;
    case 'replace': // 替换
      compiledTemplate = Template7.compile(str);
      $$(selector).html(compiledTemplate(data));
      break;
    case 'def_append': // 模板写在js页面时在元素内部添加
      compiledTemplate = Template7.compile(str);
      $$(selector).append(compiledTemplate(data));
      break;
    }
  }


  return {
    render: render
  };
});
