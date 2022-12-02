package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	Sheet page;
	public String getDataFromExcel(String file,String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(file);
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter df = new DataFormatter();
		page = book.getSheet(sheet);
		 String value = df.formatCellValue(page.getRow(row).getCell(cell));
		 return value;
	}

	public String[][] getTwoDimensionalData(String file1,String sheet1)
	{
		FileInputStream fis1=null;
		try {
			fis1 = new FileInputStream(file1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook book=null;
		try {
			book = WorkbookFactory.create(fis1);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet page1 = book.getSheet(sheet1);
		DataFormatter df = new DataFormatter();
		String[][] obj = new String[page1.getLastRowNum()][page1.getRow(0).getLastCellNum()];
		for(int i=1;i<page1.getLastRowNum();i++)
		{
			for(int j=0;j<page1.getRow(0).getLastCellNum();j++)
			{
				obj[i-1][j]=df.formatCellValue(page1.getRow(i).getCell(j));
			}
		}
		return obj;	
	}
	
	/**
	 * this method is used to close the excel 
	 */
	public void closeExcelBook()
	{
		try {
			((FileInputStream) page).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setdata(String path, int i,int j, String v) throws EncryptedDocumentException, IOException
	{
	FileInputStream file = new FileInputStream(path);
	Workbook book = WorkbookFactory.create(file);
	Sheet sh = book.getSheet("Sheet1");
	Row row = sh.getRow(i);
	row.createCell(j).setCellValue(v);
FileOutputStream fout = new FileOutputStream(path);
book.write(fout);
book.close();
	
	
	
	}

}
