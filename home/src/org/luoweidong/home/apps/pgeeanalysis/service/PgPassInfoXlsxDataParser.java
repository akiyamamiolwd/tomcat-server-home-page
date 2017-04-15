package org.luoweidong.home.apps.pgeeanalysis.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.luoweidong.home.apps.pgeeanalysis.bean.PgEntranceExamPassInfo;

/**
 * 研究生入学考试分数线信息Excel数据解析.
 * @author MIO
 *
 */
public final class PgPassInfoXlsxDataParser {
  /**
   * 私有化构造方法，使工具类无法被实例化.
   */
  private PgPassInfoXlsxDataParser() {
  }

  /**
   * Excel中 年份的列数.
   */
  private static final int CELL_NUM_YEAR = 0;
  /**
   * Excel中 招生单位的列数.
   */
  private static final int CELL_NUM_ENROLL_UNIT = 1;
  /**
   * Excel中 专业的列数.
   */
  private static final int CELL_NUM_MAJOR = 2;
  /**
   * Excel中 学位类型的列数.
   */
  private static final int CELL_NUM_DEGREE_TYPE = 3;
  /**
   * Excel中 科目的列数.
   */
  private static final int CELL_NUM_SUBJECT = 4;
  /**
   * Excel中 科目类型的列数.
   */
  private static final int CELL_NUM_SUBJECT_TYPE = 5;
  /**
   * Excel中  分数线的列数.
   */
  private static final int CELL_NUM_PASS_MARK = 6;

  /**
   * 从Excel中读取研究生入学考试分数线信息.
   *
   * @param filePath 读取的文件url
   * @return 研究生入学考试分数线信息模型
   * @throws IOException 可能出现输入输出错误，需要捕获
   */
  public static List<PgEntranceExamPassInfo> getAllExcelData(String filePath)
      throws IOException {
    FileInputStream fileIn = null;
    List<PgEntranceExamPassInfo> pgPassInfoList = new ArrayList<>();

    try {
      fileIn = new FileInputStream(filePath); //"WebContent/test.xlsx");
      XSSFWorkbook wb = new XSSFWorkbook(fileIn);
      XSSFSheet sheet = wb.getSheetAt(0);
      int rowNums = sheet.getLastRowNum();
      for (int i = 1; i <= rowNums; i++) {
        XSSFRow row = sheet.getRow(i);
        PgEntranceExamPassInfo pgInfo = new PgEntranceExamPassInfo();
        if (row != null) {
          pgInfo.setYear((int)Double.parseDouble(
              row.getCell(CELL_NUM_YEAR).toString()));
          pgInfo.setEnrollUnit(
              row.getCell(CELL_NUM_ENROLL_UNIT).toString());
          pgInfo.setMajor(
              row.getCell(CELL_NUM_MAJOR).toString());
          pgInfo.setDegreeType(
              row.getCell(CELL_NUM_DEGREE_TYPE).toString());
          pgInfo.setSubject(
              row.getCell(CELL_NUM_SUBJECT).toString());
          pgInfo.setSubjectType(
              row.getCell(CELL_NUM_SUBJECT_TYPE).toString());
          pgInfo.setPassMark((int)Double.parseDouble(
              row.getCell(CELL_NUM_PASS_MARK).toString()));
          pgPassInfoList.add(pgInfo);
        }
      }
      wb.close();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      if (fileIn != null) {
        fileIn.close();
      }
    }
    return pgPassInfoList;
  }
}
