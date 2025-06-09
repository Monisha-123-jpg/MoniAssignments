package week6.marathon3;

import java.io.IOException;
import java.util.Collections;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcelNew {

	 static int physicalNumberOfRows;

	public static  String[][] readData(String FileName) throws Exception {
		XSSFWorkbook xwb = new XSSFWorkbook("./data/" +FileName+ ".xlsx");
		XSSFSheet  xws = xwb.getSheetAt(0);
	    int	physicalNumberOfRows = xws.getPhysicalNumberOfRows();
		System.out.println("tottal rows including header--"+physicalNumberOfRows);
		int rowCount = xws.getLastRowNum();
        System.out.println("tot rows--"+rowCount);
        short columnCount = xws.getRow(0).getLastCellNum();
        System.out.println("colmn count is--"+columnCount);
        
        String[][] datas= new String[rowCount][columnCount];
        
        for(int i =1;i<=rowCount;i++) {
        	for(int j=0;j<columnCount;j++) {
        		String stringCellValue = xws.getRow(i).getCell(j).getStringCellValue();
        		
        		datas[i-1][j]=stringCellValue;
        		System.out.println("cell["+ (i-1)+  "]["+j+"]=" +stringCellValue);
        	}
        }
        xwb.close();
        return datas;
        }
	   
	

}
