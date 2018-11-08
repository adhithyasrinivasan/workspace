import java.io.*;
import java.io.FileInputStream.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
public class TestExcel
{
	public static List<List<String>> readExcel() throws IOException
	{
		String filePath=".//InputData";
		String fileName="test.xls";
		List<List<String>> rowList = new ArrayList();
		File xl=new File(filePath+"//"+fileName);
		FileInputStream fs=new FileInputStream(xl);
		Workbook workbook = null;
		String fileXtn= fileName.substring(fileName.indexOf("."));
		workbook=new HSSFWorkbook(fs);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i = 1; i < rowcount + 1; i++)
		{
			Row row = sheet.getRow(i);
			rowList.add(new ArrayList<String>());
			for (int j = 0; j < row.getLastCellNum(); j++) 
			{
				// Print excel data in console
				//rowList.setCellType(row.getCell(j).CELL_TYPE_STRING); 
				//System.out.println("Cell value: "+row.getCell(j).toString());
				if(row.getCell(j)!=null)
				rowList.get(i-1).add(row.getCell(j).toString());
			}
		}
		return rowList;
	}
	public static List<String> loadData() throws IOException
	{
		List<List<String>> kill= readExcel();
		Map<String,List<List<String>>> data= new HashMap<String,List<List<String>>>();
		data.put("test",kill);
		List<List<String>> inputParams = data.get("test");
		System.out.println(inputParams.get(2).get(3));
		return inputParams.get(0);
	}
	public static void main(String args[]) throws IOException
	{
		TestExcel a =new TestExcel();
		/*try 
		{
			a.readExcel();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		a.loadData();
	}
}
