package com.cognizant.flipkart;

import java.io.IOException;

public class UserDir {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));


//        File file =    new File(System.getProperty("user.dir") + "\\"+"Book1.xlsx");
//        FileInputStream inputStream = new FileInputStream(file);
//        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
    }
}
