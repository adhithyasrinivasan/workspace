package com.test;

import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class TestDemo {		
	    	
		@Test				
		public void testEasy() {	
			System.out.println("at test"); 		
		}	
		@BeforeTest
		public void beforeTest() {	
			System.out.println("at set");  
		}		
		@AfterTest
		public void afterTest() {
			System.out.println("at tear");			
		}		
}	