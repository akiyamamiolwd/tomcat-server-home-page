package org.luoweidong.home.apps.missionmanage;

import java.util.List;

import org.luoweidong.home.apps.pgeeanalysis.bean.PgEntranceExamPassInfo;
import org.luoweidong.home.apps.pgeeanalysis.dao.PgPassInfoDao;
import org.luoweidong.home.apps.pgeeanalysis.service.PgPassInfoXlsxDataParser;


/**
 * 测试类.
 *
 * @author MIO
 *
 */
public final class Test {
  /**
   * test.
   */
  private Test() {
  }

  /**
   * 测试入口.
   *
   * @param args 入参
   */
  public static void main(String[] args) {
    try {
      List<PgEntranceExamPassInfo> pgs = PgPassInfoXlsxDataParser.getAllExcelData("WebContent/test.xlsx");
      if (pgs != null) {
        PgPassInfoDao.batchUpdatePgPassInfo(pgs);
      }
    } catch (Exception e) {
      System.out.print("MYSQL ERROR:" + e.getMessage());
    }
  }

}
