package org.luoweidong.home.apps.pgeeanalysis.config;

/**
 * 数据库信息.
 *
 * @author MIO
 *
 */
public final class DBConfig {
  /**
   * 私有化构造方法，使工具类无法被实例化.
   */
  private DBConfig() {
  }

  /**
   * 研究生入学考试分数线信息表.
   */
  public static final String PG_ENTRANCE_EXAM_PASS_INFO_TABLE =
      "pg_entrance_exam_pass_info";

  /**
   * 插入新的研究生入学考试分数线信息sql.
   */
  public static final String SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO =
      "INSERT INTO `" + PG_ENTRANCE_EXAM_PASS_INFO_TABLE + "` "
      + "(`year`, `enroll_unit`, `major`, `subject_type`, `subject`, "
      + "`pass_mark`, `degree_type`) "
      + "VALUES (?, ?, ?, ?, ?, ?, ?)";

  public static enum SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO_ENUM{
    YEAR(1),
    ENROLL_UNIT(2),
    MAJOR(3),
    SUBJECT_TYPE(4),
    SUBJECT(5),
    PASS_MARK(6),
    DEGREE_TYPE(7);

    private int value;

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    SQL_UPDATE_ENTRANCE_EXAM_PASS_INFO_ENUM(int value) {
        this.value = value;
    }
  
    public int getValue() {
        return value;
    }
  } 
}
