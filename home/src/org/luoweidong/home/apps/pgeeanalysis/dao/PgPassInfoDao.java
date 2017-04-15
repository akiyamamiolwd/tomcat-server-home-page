package org.luoweidong.home.apps.pgeeanalysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.luoweidong.home.apps.pgeeanalysis.bean.PgEntranceExamPassInfo;
import org.luoweidong.home.apps.pgeeanalysis.config.DBConfig;
import org.luoweidong.home.config.DBConfigSec;

/**
 * 研究生入学考试分数线信息数据库操作类.
 * @author MIO
 *
 */
public final class PgPassInfoDao {
  /**
   * 私有化构造方法，使工具类无法被实例化.
   */
  private PgPassInfoDao() {
  }

  /**
   * 批量插入研究生入学考试分数线信息数据库.
   * @param pgBatchInfo 批量信息
   */
  public static void batchUpdatePgPassInfo(
      List<PgEntranceExamPassInfo> pgBatchInfo) {
    try {
      Connection conn = DBConfigSec.getHomeDBConnection();
      PreparedStatement ps = conn.prepareStatement(
          DBConfig.SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO);
      for (PgEntranceExamPassInfo tp : pgBatchInfo) {
        ps.setInt(
            DBConfig.SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO_ENUM.YEAR.getValue(),
            tp.getYear());
        ps.setString(
            DBConfig.SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO_ENUM.ENROLL_UNIT.getValue(),
            tp.getEnrollUnit());
        ps.setString(
            DBConfig.SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO_ENUM.MAJOR.getValue(),
            tp.getMajor());
        ps.setString(
            DBConfig.SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO_ENUM.DEGREE_TYPE.getValue(),
            tp.getDegreeType());
        ps.setString(
            DBConfig.SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO_ENUM.SUBJECT.getValue(),
            tp.getSubject());
        ps.setString(
            DBConfig.SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO_ENUM.SUBJECT_TYPE.getValue(),
            tp.getSubjectType());
        ps.setInt(
            DBConfig.SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO_ENUM.PASS_MARK.getValue(),
            tp.getPassMark());
        ps.addBatch();
      }
      ps.executeBatch();
//      conn.commit();
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
