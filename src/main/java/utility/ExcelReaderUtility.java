package utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojo.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {


    public static Iterator<User> readExcelData() {

        File file = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/LoginData.xlsx");
        FileInputStream fileInputStream;
        XSSFWorkbook workbook = null;
        List<User> userList = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet("LoginTestData");

               //Approach 1
//            int lastRowNum = sheet.getLastRowNum();
//            int lastCellNum = sheet.getRow(0).getLastCellNum();
//            for (int i = 1; i <=lastRowNum; i++) {
//                XSSFRow row = sheet.getRow(i);
//                    String email = row.getCell(0).toString();
//                    String password = row.getCell(1).toString();
//                    User user =  new User(email, password);
//                    userList.add(user);
//
//            }
//            for (User us :userList){
//                System.out.println("us = " + us);
//            }

                  // Approach 2
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            while (iterator.hasNext()){
                Row row = iterator.next();
                String firstCell = row.getCell(0).getStringCellValue();
                String secondCell = row.getCell(1).getStringCellValue();
            User user = new User(firstCell.toString(),secondCell.toString());
            userList.add(user);
//                System.out.println("stringCellValue = " + stringCellValue);
//
           }
            workbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList.iterator();
    }

    public static void main(String[] args) {
        readExcelData();
    }
}
