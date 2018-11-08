package com.yantra.test.selenium.driver;



import java.io.File;
import java.util.Date;
import java.util.List;

import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import org.uncommons.reportng.HTMLReporter;

public class CustomHtmlReporter extends HTMLReporter{
	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String arg2) {		
		super.generateReport(arg0, arg1, arg2);
		System.out.println("arg2: "+arg2);
		System.out.println("arg1: "+arg1.size());
		System.out.println("arg0: "+arg0.size());
		System.out.println("Customer Reporter");
		// TODO Auto-generated method stub
//		EmailReport.sendMail("CSSP -TestNG Report-" + new Date(),
//				"Hi,\n\tPlease download the attachement to view the TestNG report.\nThanks,\nQA team.", false, true,
//				"test-output\\html");
		
		try {
			Thread.sleep(5000);
			File dir = new File("test-output").getAbsoluteFile();
			File file[] = dir.listFiles();
			File htmlDir = new File("test-output/html").getAbsoluteFile();
			File htmlDirFile[]=htmlDir.listFiles();
			for(int i=0;i<htmlDirFile.length;i++)
			{
				File p=htmlDirFile[i];
				String name=p.getAbsoluteFile().getName();
				System.out.println(name);
				if(name.endsWith(".js"))
				{
					htmlDirFile[i].delete();
				}
				
			}
			if (dir.isDirectory())
//			   {
//				
//			         dir.delete();
//			         System.out.println("Deleted file");}
			EmailReport.sendMail("CSSP -Blastpay sanity test report-" + new Date(),
					"Hi,\n\tPlease download all the attachement to view the TestNG report.\nThanks,\n CSSP-QA team.", false, true,
					"test-output/html");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}








	


	
    
   
