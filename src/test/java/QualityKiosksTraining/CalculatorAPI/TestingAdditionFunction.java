package QualityKiosksTraining.CalculatorAPI;

public class TestingAdditionFunction 
{
	public static void main(String[] args)
	{
		Calculator Obj=new Calculator();
		int Res=Obj.Addition(10,20);
		
		if(Res==30)
			System.out.println("Addition works with 2 positive numbers...Passed");
		else
			System.out.println("Addition does not works with 2 positive numbers...Failed");
			
	}
}
