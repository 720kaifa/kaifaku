define([], function () {

  /**
   * Bind DOM event to some handler function in controller
   * @param  {Array} bindings
   */
  function bindEvents(bindings) {
    if ($$.isArray(bindings) && bindings.length > 0) {
      bindings.forEach(function (binding) {
        if (binding.target) { // Live binding
          $$(binding.element).on(binding.event, binding.target, binding.handler);
        } else {
          $$(binding.element).on(binding.event, binding.handler);
        }
      });
    }
  }

  /**
   * Set the position of buttons, which queried by selector, dynamic
   * @param {String} selector
   */
  function setButtonPosition(selector) {
    var pageContent = $$(selector).parents('.page-content')[0];
    var isScrollable = isScroll(pageContent);

    if (isScrollable) {
      $$(selector).removeClass('fixed-bottom');
    } else {
      $$(selector).addClass('fixed-bottom bottom-button');
    }
  }

  function setBottomTip() {
    if ($$('.bottom-img-tip')) {
      var pageContent = $$('.bottom-img-tip').parents('.page-content')[0];
      var hasBigbutton = $$('.bottom-img-tip').parents('.page-content').find('.button-big')[0];
      var isScrollable = isScroll(pageContent);

      if (isScrollable) {
        $$('.bottom-img-tip').removeClass('fixed-bottom-img');
      } else {
        if (hasBigbutton) {
          $$('.bottom-img-tip').addClass('fixed-bottom-img');
        } else {
          $$('.bottom-img-tip').addClass('fixed-bottom-img').css('bottom','12px');
        }

      }
    }
  }

  /**
   * Detect whether the element has scrollbar
   * @param  {HTMLElement}  elem
   * @return {Boolean}      true: has scrollbar; false: hasn't
   */
  function isScroll(elem) {
    return elem.scrollHeight > elem.clientHeight;
  }

  /**
   * 重新设置 document.body 的高度
   * 因为 body 的默认高度为 100%，在
   * Android 下会造成一些问题，比如：
   * 键盘弹起使得一些元素定位出错
   */
  function resetBodyHeight() {
    var windowHeight;

    if (localStorage.getItem('wh')) {
      windowHeight = JSON.parse(localStorage.getItem('wh'));
    } else {
      windowHeight = document.documentElement.clientHeight;
      localStorage.setItem('wh', windowHeight);
    }

    document.body.style.height = windowHeight + 'px';
  }

  function resizeTextarea() {
    var textarea = this;
    $$(textarea).css({height: ''});
    var oh = textarea.offsetHeight;
    var diff = oh - textarea.clientHeight;
    var sh = textarea.scrollHeight;
    if (sh + diff > oh) {
      var ah = sh + diff;
      $$(textarea).css('height', ah + 'px');
    }
    this.onfocus = function(){
      var pos = this.value.length;
      this.setSelectionRange(pos,pos)
    }
  }

  function render(selector,data,type,str) {
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
    }
  }

  function loginAlert(content, isLinkToLoginPage) {
    var modal =
      '<div id="l-modal">' +
        '<div id="l-modal-content">' + content + '</div>' +
      '</div>';
    var body = document.body;
    body.insertAdjacentHTML('beforeend', modal);
    setTimeout(function() {
      $$('#l-modal').remove();
      if (isLinkToLoginPage) {
        mainView.loadPage('login.html');
      }
    }, 2000);
  }

  //撒花效果,lxc
  function FlowerFunc() {

  };
  FlowerFunc.prototype.setInter = {};
  //开始撒花效果
  FlowerFunc.prototype.initFlower = function(text) {
    var rand1,rand2,rand3,rand_left,color;
      //颜色是随机的
      rand1 = parseInt(Math.random() * 255);
      rand2 = parseInt(Math.random() * 255);
      rand3 = parseInt(Math.random() * 255);
      rand_time = 10000;
        //在页面的左右位子也是随机的
        rand_left = Math.random();
        color = 'rgb(' + rand1 +',' + rand2 +',' + rand3 +')';

    var timer = 5000;//5秒内下降完毕，然后删除这个节点,下落速度的end是在css里面写好的,要修改这个时间，那么css里面的end也要记得修改
    var child_flower = document.createElement('div');
    child_flower.setAttribute('class','flower-text');
    $$('.article').append(child_flower);
    $$(child_flower).text(text);
    var left = rand_left * ($$('.article').width() - $$(child_flower).width());
    $$(child_flower).css('left',left + 'px');
    $$(child_flower).css('color',color);
    setTimeout(function() {
      $$(child_flower).addClass('end');
    },1);
    setTimeout(function() {
      $$(child_flower).remove();
    },timer)
  };
  //撒花效果的具体实现
  FlowerFunc.prototype.startFlower = function(status,text) {
      var rand_time;//出现文字的时间也是随机的
      rand_time = 1000;
      var flower = this;
      this.setInter = setTimeout(function timeoutFunc(){
        if(status){
          flower.setInter = setTimeout(timeoutFunc,rand_time);
          flower.initFlower(text);
          rand_time = parseInt(Math.random() * 1000);
        }
        else {
          clearTimeout(flower.setInter);
        }
      },rand_time);
    };
  var Flower = new FlowerFunc();
  function setDynamicMarginTop(marginTargetDom, fixedDom, spaceToBottom) {
    // 相对于marginTargetDom设置margin-top
    var marginTargetDom = document.querySelector(marginTargetDom);
    var footer = document.querySelector(fixedDom);
    var posBottom = marginTargetDom.getBoundingClientRect().bottom;
    console.log(posBottom)
    var winHeight = window.innerHeight;
    var footerHeight = footer.offsetHeight;

    var delta = winHeight - posBottom - footerHeight - spaceToBottom;
    if (delta < 10) {
      delta = 30;
    }
    footer.style.marginTop = delta + 'px';
  }
  function GetRequest() {   
	   var url = location.search; //获取url中"?"符后的字串   
	   var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) {   
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
	      }   
	   }   
	   return theRequest;   
	}   

  return {
    bindEvents: bindEvents,
    setButtonPosition: setButtonPosition,
    resetBodyHeight: resetBodyHeight,
    resizeTextarea: resizeTextarea,
    setBottomTip: setBottomTip,
    render: render,
    loginAlert: loginAlert,
    Flower: Flower,
    setDynamicMarginTop: setDynamicMarginTop,
    GetRequest: GetRequest
  };
});
