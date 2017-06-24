/**
 * 声明自己的命名空间
 */
var org = org || {};
org.luoweidong = org.luoweidong || {};

/**
 * sdk manage management
 */
;(function(lwd, window){
  /**
   * 不依赖jQuery的开发工具库
   */
  lwd.sdk = lwd.sdk || {};
  var _sdk = lwd.sdk;
  
  /**
   * namespace manage module
   */
  _sdk.namespace = _sdk.namespace || {
    /**
     * determine if there is a namespace
     * 
     * @param ns name of namespace
     * @return true/false namespace exist/not exist
     */
    isNSExisted : function(ns){
      if(typeof ns !== 'string'){
        console.trace("[WRAN]The name of namespace is illegal!");
        return false;
      }
      else{
        var nss = ns.split('.');
        if(eval('typeof ('+ nss[0] +') === undefined')){
          console.trace("[WRAN]The namespace "+ nss[0] +" is not existent!");
          return false;
        }
        else{
          var s = eval('('+ nss[0] +')');
          var ss = nss[0];
          for(var i = 1;i < nss.length;i++){
            ss = ss + '.' + nss[i];
            if(s[nss[i]] === undefined){
              console.trace("[WRAN]The namespace "+ ss +" is not existent!");
              return false;
            }
            s = s[nss[i]];
          }
          return true;
        }
      }
    },
    /**
     * regist new namespace to a existing namespace
     * 
     * @param ens existing namespace
     * @param newns new namespace
     */
    registNewNSToENS : function(ens, newns){
      if(typeof ens !== 'string' || typeof newns !== 'string'){
        console.trace("[WRAN]The name of namespace is illegal!");
      }
      else{
        var newnss = newns.split('.');
        var s = eval('('+ ens +')');
        for(var i = 0;i < newnss.length;i++){
          s[newnss[i]] = s[newnss[i]] || {};
          s = s[newnss[i]];
        }
      }
    },
    /**
     * regist new namespace to window(global)
     * 
     * @param newns new namespace
     */
    registNewNSToWindow : function(newns){
      this.registNewNSToENS('window', newns);
    },
    /**
     * regist new namespace to a namespace
     * 
     * @param oldns old namespace
     * @param newns new namespace
     */
    registNewNSToNS : function(oldns, newns){
      if(typeof oldns !== 'string' || typeof newns !== 'string'){
        console.trace("[WRAN]The name of namespace is illegal!");
      }
      else{
        this.registNewNSToWindow(oldns);
        this.registNewNSToENS(oldns, newns);
      }
    }
  };
    
  /**
   * 加载文件工具
   */
  _sdk.loadFileTools = _sdk.loadFileTools || {
    /**
     * 判断js或css文件是否已经加载
     * 判断script,link标签是否已经存在
     * 
     * @param url 文件的路径
     * @param type 文件的类型,css或者js
     */
    isFileExist : function(url, type){
      var target_tag = (type === 'js')?'script':'link';
      var link_attr = (type === 'js')?'src':'href';
      var files = document.getElementsByTagName(target_tag);
      var i = files.length - 1;
      while(i >= 0){
        if(files[i][link_attr] === url){
          console.trace("[WRAN]The file has loaded!");
          return true;
        }
        i--;
      }
      return false;
    },
    /**
     * 判断CSS文件是否已经加载
     * 判断link标签是否已经存在
     * 
     * @param url css文件的路径
     */
    isCssFileExist : function(url){
      return this.isFileExist(url, 'css');
    },
    /**
     * 判断JS文件是否已经加载
     * 判断script标签是否已经存在
     * 
     * @param url js文件的路径
     */
    isJsFileExist : function(url){
      return this.isFileExist(url, 'js');
    },
    /**
     * 加载单个JS文件
     * 添加script标签
     * 
     * @param url js文件的路径
     * @param async 是否异步加载
     */
    loadJsFile : function(url, async){
      if(url && !this.isJsFileExist(url)){
        var s = document.createElement('script');
        s.type = 'text/javascript';
        s.async = (async === true)?true:false;
        s.src = url;
        var body = document.getElementsByTagName('body')[0];
        body.appendChild(s);
      }
    },
    /**
     * 加载单个CSS文件
     * 添加link标签
     * 
     * @param url js文件的路径
     * @param async 是否异步加载
     */
    loadCssFile : function(url){
      if(url && !this.isCssFileExist(url)){
        var css = document.createElement('link');
        css.href = url;
        css.rel = 'stylesheet';
        css.type = 'text/css';
        var head = document.getElementsByTagName('head')[0];
        head.appendChild(css);
      }
    },
    /**
     * 加载多个JS文件
     * 添加script标签
     * 
     * @param urls js文件的路径的数组
     * @param async 是否异步加载
     */
    loadJsFiles : function(urls, async){
      var _this = this;
      if(urls && (urls instanceof Array)){
        urls.forEach(function(item, index, array){
          _this.loadJsFile(item, async);
        });
      }
    },
    /**
     * 加载多个CSS文件
     * 添加link标签
     * 
     * @param url js文件的路径的数组
     * @param async 是否异步加载
     */
    loadCssFiles : function(urls){
      var _this = this;
      if(urls && (urls instanceof Array)){
        urls.forEach(function(item, index, array){
          _this.loadCssFile(item);
        });
      }
    }
  }

  /**
   * sdk manage
   */
  _sdk.sdkRoot = document.URL + 'sdk/';
   
  _sdk.sdkPaths = [
    _sdk.sdkRoot + 'tools.js'
  ];
  
  _sdk.loadFileTools.loadJsFiles(_sdk.sdkPaths);
  
})(org.luoweidong, window);
