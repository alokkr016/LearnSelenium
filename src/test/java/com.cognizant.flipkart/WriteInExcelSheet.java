package com.cognizant.flipkart;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteInExcelSheet {

    public static void writeExcelData() throws Exception  {         //DO NOT change the method signature
        //Implement code to write the names 'John', 'Peter', 'Sam' to in the excel sheet on the first column
        //As shown in the image

        XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet sheet=wb.createSheet("TestCase");
        String names[][]={{"John","Peter","Sam"},
                {"Walker","Parker","Wilson"}};
        for(int i=0;i < names.length;i++){
            XSSFRow row=sheet.createRow(i);
            for(int j=0;j<names[i].length;j++){
                XSSFCell cell=row.createCell(j);
                cell.setCellValue(names[i][j]);
            }
        }

//        File f=new File("CusReg.xlsx");
        FileOutputStream os=new FileOutputStream("src/test/java/com.cognizant.flipkart/CustReg.xlsx");

        wb.write(os);
//        wb.close();

    }
    public static void main(String[] args) throws Exception
    {
        WriteInExcelSheet customer = new WriteInExcelSheet();
        customer.writeExcelData();
        //Add required code
    }
}
