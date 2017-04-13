package org.luoweidong.home.apps.pgeeanalysis.bean;

/**
 * 研究生入学考试分数线信息.
 *
 * @author MIO
 *
 */
public class PgEntranceExamPassInfo {
  /**
   * 主键id.
   */
  private int id;

  /**
   * 考试年份.
   */
  private int year;

  /**
   * 招生单位.
   */
  private String enrollUnit;

  /**
   * 专业.
   */
  private String major;

  /**
   * 考试科目.
   */
  private String subject;

  /**
   * 考试科目类型.
   */
  private String subjectType;

  /**
   * 分数线.
   */
  private int  passMark;

  /**
   * 学位类型.
   */
  private int  degreeType;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the year.
   */
  public int getYear() {
    return year;
  }

  /**
   * @param year the year to set.
   */
  public void setYear(int year) {
    this.year = year;
  }

  /**
   * @return the enrollUnit.
   */
  public String getEnrollUnit() {
    return enrollUnit;
  }

  /**
   * @param enrollUnit the enrollUnit to set.
   */
  public void setEnrollUnit(String enrollUnit) {
    this.enrollUnit = enrollUnit;
  }

  /**
   * @return the major.
   */
  public String getMajor() {
    return major;
  }

  /**
   * @param major the major to set.
   */
  public void setMajor(String major) {
    this.major = major;
  }

  /**
   * @return the subject.
   */
  public String getSubject() {
    return subject;
  }

  /**
   * @param subject the subject to set.
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * @return the subjectType.
   */
  public String getSubjectType() {
    return subjectType;
  }

  /**
   * @param subjectType the subjectType to set.
   */
  public void setSubjectType(String subjectType) {
    this.subjectType = subjectType;
  }

  /**
   * @return the passMark.
   */
  public int getPassMark() {
    return passMark;
  }

  /**
   * @param passMark the passMark to set.
   */
  public void setPassMark(int passMark) {
    this.passMark = passMark;
  }

  /**
   * @return the degreeType.
   */
  public int getDegreeType() {
    return degreeType;
  }

  /**
   * @param degreeType the degreeType to set.
   */
  public void setDegreeType(int degreeType) {
    this.degreeType = degreeType;
  }
}
