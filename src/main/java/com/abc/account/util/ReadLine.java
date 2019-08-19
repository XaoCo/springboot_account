package com.abc.account.util;

import com.abc.account.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * package: com.abc.account.util
 * auther： abc
 * date: 2019/8/3 10:35
 * introduce: 读取文件的每一行内容
 * HSSFWorkbook、XSSFWorkbook、SXSSFWorkbook的区别:
 * <p>
 * ◎HSSFWorkbook一般用于Excel2003版及更早版本(扩展名为.xls)的导出。
 * <p>
 * ◎XSSFWorkbook一般用于Excel2007版(扩展名为.xlsx)的导出。
 * <p>
 * ◎SXSSFWorkbook一般用于大数据量的导出。
 * <p>
 * 注：HSSFWorkbook和XSSFWorkbook的Excel Sheet导出条数上限(<=2003版)是65535行、256列,(>=2007版)是
 * 1048576行,16384列,如果数据量超过了此上限,那么可以使用SXSSFWorkbook来导出。实际上上万条数据，
 * 甚至上千条数据就可以考虑使用SXSSFWorkbook了。
 */
public class ReadLine {
    private static String PATH;
    private static String PATH1;

    public static void main(String[] args) {

        PATH = "E:\\ceshi\\aa.txt";
        PATH1 = "E:\\ceshi\\公司内部通讯录2019年8月.xls";

//        readLine(PATH);
//        readExcel(PATH1);
        writeInto();
    }

    //读取文本
    public static void readLine(String filename) {
        File file = new File(filename);
        String tmp;
        int line = 1;
        if (!file.exists()) {
            System.out.println("目标文件不存在！");
        } else {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                while ((tmp = randomAccessFile.readLine()) != null) {
                    if (StringUtils.isBlank(tmp)) {
                        System.out.println("第" + line + "行为空或者全部为空格！");

                    } else {
                        System.out.println("第" + line + "行的内容为："
                                + new String(tmp.getBytes("ISO-8859-1"), "GBK"));

//                        "\\|"或者"[|]"
                        String[] split = tmp.split("\\|");
                        int length = split.length;
                        System.out.println("split的长度=" + length);
                        if (length > 0) {
//                            for (String s:split
//                                 ) {

                            for (int i = 0; i < split.length; i++) {
                                System.out.println(new String(split[i].getBytes("ISO-8859-1"), "GBK"));
                            }
//                                System.out.println(new String(s.getBytes("ISO-8859-1"), "GBK"));
//                                System.out.println("第" + line + "行的内容为：split[0]="
//                                        + new String(split[0].getBytes("ISO-8859-1"), "GBK")
//                                        +",split[1]="+ new String(split[1].getBytes("ISO-8859-1"), "GBK"));
//                            }

                        } else {
                            System.out.println("读取的该行格式不正确！");
                        }

                    }
                    line++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //读取Excel文件
    public static void readExcel(String path) {

        File file = new File(path);

        List<List<String>> lists = new ArrayList<>();

        try {
            Workbook wb = WorkbookFactory.create(new FileInputStream(file));

            Sheet sheet = wb.getSheetAt(0);
//            System.out.println(sheet);

            for (Row row : sheet) {

                List<String> list = new ArrayList<>();
                for (Cell cell : row) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    list.add(cell.getStringCellValue());
                }
                lists.add(list);


            }

            for (List lists1 : lists) {
                System.out.println(lists1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }

    //    写入Excel文件
    public static void writeInto() {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet("用户列表");
        XSSFCellStyle styleHeader = getAndSetXSSFCellStyleHeader(workbook);
        XSSFCellStyle cellStyleOne = getAndSetXSSFCellStyleOne(workbook);
        XSSFCellStyle cellStyleTwo = getAndSetXSSFCellStyleTwo(workbook);

        SXSSFRow row = sheet.createRow(0);

        SXSSFCell cell = row.createCell(0);

        cell.setCellStyle(styleHeader);
        cell.setCellValue("ID");
        cell = row.createCell(1);
        cell.setCellStyle(styleHeader);
        cell.setCellValue("姓名");
        cell = row.createCell(2);
        cell.setCellStyle(styleHeader);
        cell.setCellValue("年龄");
        cell = row.createCell(3);
        cell.setCellStyle(styleHeader);
        cell.setCellValue("JOB");
        cell = row.createCell(4);
        cell.setCellStyle(styleHeader);
        cell.setCellValue("密码");


//         模拟数据
        List<User> list = new ArrayList<User>();
        list.add(new User(11, "zs", 12, "it", "1234"));
        list.add(new User(12, "zs1", 12, "it", "1234"));
        list.add(new User(13, "zs2", 12, "it", "1234"));
        list.add(new User(14, "zs3", 12, "it", "1234"));


        for (int i = 0; i < list.size(); i++) {
//            System.out.println(user);
            SXSSFRow row1 = sheet.createRow(i + 1);
            User user = list.get(i);
            for (int j = 0; j < 5; j++) {
                SXSSFCell cell1 = row1.createCell(j);
                if (i % 2 == 1) {
                    cell1.setCellStyle(cellStyleOne);
                } else {
                    cell1.setCellStyle(cellStyleTwo);
                }
                if (j == 0) {
                    cell1.setCellValue(user.getId());
                } else if (j == 1) {
                    cell1.setCellValue(user.getName());
                } else if (j == 2) {
                    cell1.setCellValue(user.getAge());
                } else if (j == 3) {
                    cell1.setCellValue(user.getJob());
                } else if (j == 4) {
                    cell1.setCellValue(user.getPassword());
                }
            }

        }


        setSheet(sheet);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\ceshi\\用户.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void setSheet(Sheet sheet) {
        // 设置各列宽度(单位为:字符宽度的1/256)
        sheet.setColumnWidth(0, 32 * 256);
        sheet.setColumnWidth(1, 32 * 256);
        sheet.setColumnWidth(2, 20 * 256);
        sheet.setColumnWidth(3, 20 * 256);
        sheet.setColumnWidth(4, 20 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 20 * 256);
        sheet.setColumnWidth(7, 20 * 256);
        sheet.setColumnWidth(8, 20 * 256);
        sheet.setColumnWidth(9, 20 * 256);
        sheet.setColumnWidth(10, 32 * 256);
    }


    /**
     * 获取并设置header样式
     */
    private static XSSFCellStyle getAndSetXSSFCellStyleHeader(SXSSFWorkbook sxssfWorkbook) {
        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
        Font font = sxssfWorkbook.createFont();
        // 字体大小
        font.setFontHeightInPoints((short) 14);
        // 字体粗细
//        font.setBoldweight((short) 20);
        // 将字体应用到样式上面
        xssfCellStyle.setFont(font);
        // 是否自动换行
        xssfCellStyle.setWrapText(false);
        // 水平居中
        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 垂直居中
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return xssfCellStyle;
    }

    /**
     * 获取并设置样式一
     */
    private static XSSFCellStyle getAndSetXSSFCellStyleOne(SXSSFWorkbook sxssfWorkbook) {
        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
        XSSFDataFormat format = (XSSFDataFormat) sxssfWorkbook.createDataFormat();
        // 是否自动换行
        xssfCellStyle.setWrapText(false);
        // 水平居中
        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 垂直居中
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 前景颜色
        xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        xssfCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        // 边框
        xssfCellStyle.setBorderBottom(BorderStyle.THIN);
        xssfCellStyle.setBorderRight(BorderStyle.THIN);
        xssfCellStyle.setBorderTop(BorderStyle.THIN);
        xssfCellStyle.setBorderLeft(BorderStyle.THIN);
        xssfCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        xssfCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        xssfCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        xssfCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // 防止数字过长,excel导出后,显示为科学计数法,如:防止8615192053888被显示为8.61519E+12
        xssfCellStyle.setDataFormat(format.getFormat("0"));
        return xssfCellStyle;
    }

    /**
     * 获取并设置样式二
     */
    private static XSSFCellStyle getAndSetXSSFCellStyleTwo(SXSSFWorkbook sxssfWorkbook) {
        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
        XSSFDataFormat format = (XSSFDataFormat) sxssfWorkbook.createDataFormat();
        // 是否自动换行
        xssfCellStyle.setWrapText(false);
        // 水平居中
        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 边框
        xssfCellStyle.setBorderBottom(BorderStyle.THIN);
        xssfCellStyle.setBorderRight(BorderStyle.THIN);
        xssfCellStyle.setBorderTop(BorderStyle.THIN);
        xssfCellStyle.setBorderLeft(BorderStyle.THIN);
        xssfCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        xssfCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        xssfCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        xssfCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // 垂直居中
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 防止数字过长,excel导出后,显示为科学计数法,如:防止8615192053888被显示为8.61519E+12
        xssfCellStyle.setDataFormat(format.getFormat("0"));
        return xssfCellStyle;
    }

}

