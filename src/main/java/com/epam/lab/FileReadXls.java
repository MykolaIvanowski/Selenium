package com.epam.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.epam.lab.help.UserTestInfo;
import com.epam.lab.model.Credential;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReadXls {
    private File file = new File("src/main/resources/test.xlsx");
    private Credential credential = new Credential();
    private Map<String,String> credentials = new HashMap();

    public void readFile(){
        try{
            Workbook work = new XSSFWorkbook(new FileInputStream(file));
            Sheet sheet = work.getSheetAt(0);
            Iterator<Row> rowIterator  = sheet.rowIterator();
            int count = 0;

            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int countCell = 0;
                while(cellIterator.hasNext()){
                    Cell cell  = cellIterator.next();

                    if(count>0&& cell.getCellTypeEnum() == CellType.STRING) {

                       if(countCell == 1){
                            credential.setLogin(cell.getStringCellValue());
                        }else if(countCell == 2){
                            credential.setPassword(cell.getStringCellValue());
                        }
                    }
                    countCell++;
                }
                credentials.put(credential.getLogin(), credential.getPassword());
                count++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Object[][] toArray(){
        this.readFile();

        Object[]  value = credentials.values().toArray();
        Object[]  key = credentials.keySet().toArray();
        return new Object[][] {
                {key[1], value[1]},
                {key[2], value[2]},
                {key[3], value[3]},
                {key[4], value[4]},
                {key[5], value[5]}
        };
    }
}
