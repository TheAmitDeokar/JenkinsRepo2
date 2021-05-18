package QualityKiosksTraining.CalculatorAPI;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
//import java.util.Objects;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestMultiplication
{
	Calculator Cal;
	int Result;
	@BeforeClass
	public void Init()
	{
		Cal=new Calculator();
	}
   @BeforeMethod
	public void ReinitializingResult()
	{ 
	    System.out.println("I am in TestMultiplicationWithPositiveNumbers method");
		Result=0;
		
	}
   
   @Test(priority=1,dataProvider="ProvidePositiveNumbers")
   
   public void TestMultiplicationWithPositiveNumbers(int number1,int number2,int expectedResult)
   {
	  
	   Result=Cal.Multiplication(number1,number2);
	   Assert.assertEquals(Result,expectedResult,"Multiplicatin does not work with positive  number");
   }
   
   @DataProvider
   public Object[][] ProvidePositiveNumbers()
   {
	   Object [][] SetOfValues=new Object[4][3];
	   
	   SetOfValues[0][0]=1;
	   SetOfValues[0][1]=2;
	   SetOfValues[0][2]=2;
	   
	   SetOfValues[1][0]=10;
	   SetOfValues[1][1]=20;
	   SetOfValues[1][2]=200;
	   
	   SetOfValues[2][0]=100;
	   SetOfValues[2][1]=200;
	   SetOfValues[2][2]=20000;
	   
	   SetOfValues[3][0]=1000;
	   SetOfValues[3][1]=2000;
	   SetOfValues[3][2]=2000000;
  
	   return SetOfValues;
	   
   }
   @Parameters({"RequestID"})
   @BeforeSuite
   public void CreateResultFolder(String RequestID)
   {
	   System.out.println("I am in  Before Suite");
	 try 
	 {
	    
		 Files.createDirectory(Paths.get("./"+RequestID));
   
     }
	 catch(IOException e)
	 {
	    System.out.println("Couldnt creating directory");	 
	 }
	}
   @Parameters({"RequestID"})
   @AfterSuite
    public void CopyResultFile(String RequestID)
   { 
	   System.out.println("I am in  After Suite");
	  
	   try{
		   Files.copy(Paths.get("C:\\Users\\Amit\\eclipse-workspace\\CalculatorAPI\\target\\surefire-reports\\emailable-report.html"),Paths.get("./"+RequestID+"/Result.html"),StandardCopyOption.REPLACE_EXISTING);
	      
	      }
	   catch(IOException e)
	   {
		   System.out.println("Couldnt Copy file");
	   }
	   }
   }
   

