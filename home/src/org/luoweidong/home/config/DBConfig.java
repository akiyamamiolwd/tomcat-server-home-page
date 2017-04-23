package org.luoweidong.home.config;

/**
 * 主页数据库信息.
 * @author MIO
 *
 */
public final class DBConfig {
  /**
   * 私有化构造方法，使工具类无法被实例化.
   */
  private DBConfig() { }

  /**
   * 数据库名.
   */
  public static final String HOME_DB_NAME = "home";

  /**
   * 测试用户数据库名.
   */
  public static final String TEST_USER_DB_NAME = "testuser";

}
