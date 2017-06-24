/**
 * app逻辑管理js
 * 
 */
;(function($, window, lwd){
  /**
   * 注册app的管理模块
   */
  var _sdk = lwd.sdk;
  var _ns = _sdk.namespace;
  var _ft = _sdk.loadFileTools;

  //注册app的命名空间
  _ns.registNewNSToWindow('org.luoweidong.app');
  var _app = lwd.app;

  /**
   * 管理模块类
   * 单例实现
   */
  var AppManager = function(appConf, appView){
    var _am = this;
    
    //读取app的配置文件和视图文件
    var appRoot = document.URL + 'apps/';
    appConf = appConf || appRoot + 'app_config.js';
    appView = appView || appRoot + 'app_view.js';
    //同步加载
    _ft.loadJsFiles([appConf, appView], false, function(){
      console.log("all app configs has loaded");
    });
    var _apps = _app.appConfigs; 
    
    //TODO 展示所有app
    this.showAllApps = function($container){
      $.each(_apps, function(e, i){
        $container.append('<div id="app_'+e.name+'">'+e.name+'</div>');
      });
    }
    
    //TODO 打开某个app
    this.openApp = function($container){
      
    }
    
  }
    
  _app.appManager = null;
  
  _app.getAppManager = function(appConf, appView){
    if(!_app.appManager){
      _app.appManager = new AppManager(appConf, appView);
    }
    return _app.appManager;
  }
    
})(jQuery, window, org.luoweidong);