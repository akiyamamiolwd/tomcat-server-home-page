var org = org || {};
if(!org.luoweidong){
  console.log('[ERROR]namespace org.luoweidong is not defined!!');
}
else{
  (function(window, lwd){
    lwd.pathConfig = lwd.pathConfig || {};
    
    var tpRoot = './thirdparty/';
    var dataTableRoot = tpRoot + 'DataTables-1.10.15/';
    lwd.pathConfig.thirdPartyPath = {
      jquery : tpRoot + 'jquery-3.2.1.js',
      echarts3 : tpRoot + 'echarts-3.5.3.js',
      dataTableJS : dataTableRoot + 'jquery.dataTables.js',
      dataTableCSS : dataTableRoot + 'jquery.dataTables.css'
    };
    
    var sdkRoot = './sdk/';
    lwd.pathConfig.sdkPath = {
      sdks : sdkRoot + 'sdk.js'
    };

    var appsRoot = './apps/';
    lwd.pathConfig.myAppPath = {
      appConfig : appsRoot + 'app_config.js',
      appManager : appsRoot + 'app_manager.js',
      appView : appsRoot + 'app_view.js'
    };
    
    var _paths = lwd.pathConfig;
    
    if(!lwd.sdk){
      console.log('[ERROR]namespace org.luoweidong.tools is not defined, maybe sdk.js is not loaded!!');
    }
    else{
      var _sdk = lwd.sdk;
      var _loadFileTool = _sdk.loadFileTools;
      //加载js和css
      var scripts = [];
      var csssheets = [];
      with(_paths.thirdPartyPath){
        scripts.push(jquery);
        scripts.push(echarts3);
        scripts.push(dataTableJS);
        csssheets.push(dataTableCSS);
      }
      with(_paths.myAppPath){
        //scripts.push(appConfig);
        scripts.push(appManager);
        //scripts.push(appView);
      }
      _loadFileTool.loadCssFiles(csssheets);
      _loadFileTool.loadJsFiles(scripts, false, function(){
        console.log('scripts begin');
        window.appManager = lwd.app.getAppManager();
      });
      /*
      scripts.forEach(function(item, index, array){
        _loadFileTool.loadJsFile(item, false);
      });
      csssheets.forEach(function(item, index, array){
        _loadFileTool.loadCssFile(item);
      });
      */
    }
    
  })(window, org.luoweidong);
}