import  java.io.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/**
 * 
 * @author Adhithya Srinivasan
 *
 */
public class TestExcel1
{
	//public static void main(String[]args) {
	public FileOutputStream getFile() throws FileNotFoundException
	{
			String filename = ".//test-output//NewExcelFile.xls" ;
			//FileOutputStream fileOut = new FileOutputStream(filename);
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("FirstSheet");  
			Font font = workbook.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			HSSFCellStyle style = workbook.createCellStyle();
			style.setFont(font);
			HSSFRow rowhead = sheet.createRow((short)0);
			HSSFCell serialno=rowhead.createCell(0);
			serialno.setCellValue("No.");
			serialno.setCellStyle(style);
			HSSFCell name=rowhead.createCell(1);
			name.setCellValue("Name");
			name.setCellStyle(style);
			HSSFCell address=rowhead.createCell(2);
			address.setCellValue("Address");
			address.setCellStyle(style);
			HSSFCell email=rowhead.createCell(3);
			email.setCellValue("Email");
			email.setCellStyle(style);
			HSSFRow row = sheet.createRow((short)1);
			//row.setRowStyle(style); Not working row style
			row.createCell(0).setCellValue("1");
			row.createCell(1).setCellValue("Sankumarsingh");
			row.createCell(2).setCellValue("India");
			row.createCell(3).setCellValue("sankumarsingh@gmail.com");
			//FileOutputStream fileOut = new FileOutputStream(filename);
			//workbook.write(fileOut);
			//fileOut.close();
			//System.out.println("Your excel file has been generated!");
			
			
		
		return new FileOutputStream(filename);
	}
	public static void main(String[]args) throws FileNotFoundException
	{
		TestExcel1 ad= new TestExcel1();
		try
		{
		ad.getFile();}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}