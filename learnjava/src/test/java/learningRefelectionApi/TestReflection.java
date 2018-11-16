package learningRefelectionApi;

import java.lang.reflect.Constructor;

public class TestReflection {

	int i=10;
	int j=20;
	
	public TestReflection ()
	{
		
	}
	
	TestReflection(int i)
	{
		
	}
	
	public void m1()
	{
		
	}
	
	public int m2() {
		
		return 1;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException  
		
	{
		
		
		//TestReflection obj1  = new TestReflection();
		System.out.println("");
		//System.out.println(obj1.getClass().getSimpleName());
		
		Class<TestReflection> c1 = TestReflection.class;
		
		System.out.println(c1.getName());
		Constructor[] construct = c1.getDeclaredConstructors();
		
		System.out.println(construct.length);
		
		for(Constructor c:construct) {
			System.out.println(c.getModifiers());
		}
	}
	
	
	
	
}
