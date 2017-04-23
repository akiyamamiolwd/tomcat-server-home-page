package org.luoweidong.home.apps.pgeeanalysis.service;

import java.util.List;

import org.luoweidong.home.apps.pgeeanalysis.bean.PgEntranceExamPassInfo;
import org.luoweidong.home.apps.pgeeanalysis.dao.PgPassInfoDao;

/**
 * 研究生入学考试分数线信息Excel数据解析,并存入数据库.
 * @author MIO
 *
 */
public final class PgPassInfoXlsxDataSaver {
  /**
   * 私有化构造方法，使工具类无法被实例化.
   */
  private PgPassInfoXlsxDataSaver() {
  }

  /**
   * 从Excel中读取研究生入学考试分数线信息.
   * 并将读取出来的信息存入数据库.
   * @param filePath 读取的文件url
   */
  public static void savePgPassInfoFromXlsx(String filePath) {
    try {
      List<PgEntranceExamPassInfo> pgs = PgPassInfoXlsxDataParser.getAllExcelData(filePath);
      if (pgs != null) {
        PgPassInfoDao.batchUpdatePgPassInfo(pgs);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
