package QualityKiosksTraining.CalculatorAPI;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDivisionFunctionality 
{
	Calculator Cal;
	int Res;
	@BeforeClass
	public void CreateObj()
	{
		System.out.println("I am in Before Class");
		Cal=new Calculator();
		
	}
	@BeforeMethod
	public void InitialiseRes()
	{
		System.out.println("I am in Before Method");
		Res=0;
	}
	
	@Test(priority=1)
	
	public void TestdivisionWithPositive()
	{
		System.out.println("I am in 1st TestdivisionWithPositive");
		Res=Cal.Division(100,2);
		Assert.assertEquals(Res,50,"Division does not work with positive numbers");
	
	}
	
	@Test(priority=2)
	public void TestdivisionWithNegative()
	{
		System.out.println("I am in 2nd TestdivisionWithNegative");
		Res=Cal.Division(-100,-2);
		Assert.assertEquals(Res,50,"Division does not work with positive numbers");
	
	}
	@AfterClass
	public void ReleaseObj()
	{
		System.out.println("I am in After class");
		Cal=null;
	}
	
}
