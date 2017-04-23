/**
 * 命名空间管理
 */
var org = org || {};
org.luoweidong = org.luoweidong || {};

;(function(lwd, window){
  /**
   * 不依赖jQuery的工具
   */
  lwd.tools = lwd.tools || {};
    
  /**
   * 加载文件工具
   */
  lwd.tools.loadFileTools = lwd.tools.loadFileTools || {
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
    }
  }
})(org.luoweidong, window);