package org.luoweidong.home.apps.pgeeanalysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.luoweidong.home.apps.pgeeanalysis.bean.PgEntranceExamPassInfo;
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
   * @param args
   *          入参
   */
  public static void main(String[] args) {
    PgEntranceExamPassInfo testInfo = new PgEntranceExamPassInfo();
    testInfo.setDegreeType("专硕");
    testInfo.setYear(2017);
    try {
      Connection con = null; // 定义一个MYSQL链接对象
      Class.forName("com.mysql.jdbc.Driver").newInstance(); // MYSQL驱动
      // 链接本地MYSQL
      con = DriverManager.getConnection(
          "jdbc:mysql://127.0.0.1:3306/home", "root", "123456");
      System.out.print("yes");
//      String sql = "";
//      PreparedStatement ps = con.prepareStatement(sql);
//      ps.execute();
      
//      PgPassInfoXlsxDataParser.getAllExcelData();

    } catch (Exception e) {
      System.out.print("MYSQL ERROR:" + e.getMessage());
    }
  }

}
