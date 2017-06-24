/**
 * app配置js
 * 
 */
;(function($, window, _app){
  var appRoot = document.URL + 'apps/';
  _app.appConfigs = [
    {
      name : 'pgEntranceExamAnalysis',
      path : appRoot + 'pg_entrance_exam_analysis/',
      entrance : 'index.html'
    },
    {
      name : 'missionManage',
      path : appRoot + 'mission_manage/',
      entrance : 'index.html'
    }
  ];
})(jQuery, window, org.luoweidong.app);