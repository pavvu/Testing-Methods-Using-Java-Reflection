import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

// This is the TestHarness class which instantiates the Class Under Test and invokes it's methods using Reflection. 
public class TestHarness 
{
  public static void main(String[] args) throws Exception 
  {
	 Class c = Class.forName(args[0]);
	 cut obj = (cut)c.newInstance();
	 //Taking inputs from text file.
	 BufferedReader br = new BufferedReader(new FileReader("input.txt") );
	 String inputLine = br.readLine();
	 ArrayList intInput = new ArrayList();
	 //Reading inputs of int Type
	 for (String str : inputLine.split(", ")) 
	 {
		 intInput.add(Integer.parseInt(str));
	 }
	 inputLine = br.readLine();
	 ArrayList floatInput = new ArrayList();
	//Reading inputs of float Type
	 for (String str : inputLine.split(", ")) 
	 {
		 floatInput.add(Float.parseFloat(str));
	 }
	 
	 inputLine = br.readLine();
	 ArrayList stringInput = new ArrayList();
	//Reading inputs of String Type
	 for (String str : inputLine.split(", ")) 
	 {
		 stringInput.add(str);
	 }
	 Random rnd = new Random();
	 Object o=null;
	 Class expectedReturnType; 
	 PrintWriter pw = new PrintWriter("output.txt");
	 // Executing all the test cases in multiple runs. Here we are executing for 5 Runs.
	 // The executed test cases and it's status are written to output.txt file
	 for(int run=1; run<=5; run+=1)
	 {
		 pw.write("*************************************************** RUN : " + run + " *************************************" +'\n');
		 int testcase=0;
		 // Invoking all the methods of CUT.
		 for (Method m1 : c.getDeclaredMethods()) 
		  {  
			 testcase+=1;
			 expectedReturnType = m1.getReturnType();
			 Class[] params1 = m1.getParameterTypes();
			 try
			 {
				 if(params1.length!=0)
				 {   
					 //Invoking methods by passing input values, that are read from file.
					if(params1[0].getName().equals("int"))
						o= m1.invoke(obj, intInput.get(rnd.nextInt(15)));
					else if(params1[0].getName().equals("float"))
						o = m1.invoke(obj, floatInput.get(rnd.nextInt(15)));
					else if(params1[0].getName().equals("java.lang.String"))
						o = m1.invoke(obj, stringInput.get(rnd.nextInt(15)));
				 }
				 else
				 {
					 o = m1.invoke(obj);
				 }
				 pw.write("Test Case " + testcase + " : " + m1.getName() + "\tSuccess" + '\n');
			 }
			catch (Exception e) 
			{
				// If an exception rises, that means the test case is failed
				pw.write("Test Case " + testcase + " : " + m1.getName() + " Failed" + '\n');
			}
		  }
		 /**************************************************************************************/
		 // two level chaining
		 // Checking all valid combinations for 2 level chaining
		  for (Method m1 : c.getDeclaredMethods()) 
		  {  
			 Class[] params1 = m1.getParameterTypes();
			 for (Method m2 : c.getDeclaredMethods()) 
			 { 
				 Class[] params = m2.getParameterTypes();
				 if(params.length!=0)
				 {
					try
					{
						if(m1.getReturnType().toString().equals(params[0].getName()))
						{
						    testcase+=1;	
							if(params1.length!=0)
							{
								//Invoking methods by chaining at level 2
								if(params1[0].getName().equals("int"))
									m2.invoke(obj, m1.invoke(obj, intInput.get(rnd.nextInt(15))));
								else if(params1[0].getName().equals("float"))
								    m2.invoke(obj, m1.invoke(obj, floatInput.get(rnd.nextInt(15))));
								else if(params1[0].getName().equals("void"))
								    m2.invoke(obj, m1.invoke(obj));
								else if(params1[0].getName().equals("java.lang.String"))
								    m2.invoke(obj, m1.invoke(obj, stringInput.get(rnd.nextInt(15))));
							}
							else
							{
							  m2.invoke(obj, m1.invoke(obj));
							}
							pw.write("Test Case " + testcase + " : " + m2.getName() + "(" + m1.getName() + ")" + "\tSuccess\n");
						}
					}
					catch (Exception e)
					{
						// If an exception rises, that means the test case is failed
						pw.write("Test Case " + testcase + " : " + m2.getName() + "(" + m1.getName() + ")" + "\tFailed\n");
					}
				 }
			 }
		  }
		 
		 /**************************************************************************************/
		 // Three level chaining 
		 //Checking all valid combination for 3 level chaining
		  for (Method m1 : c.getDeclaredMethods()) 
		  {
			  Class[] params1 = m1.getParameterTypes();
			 for (Method m2 : c.getDeclaredMethods()) 
			 { 
				 for (Method m3 : c.getDeclaredMethods()) 
				 {
					 Class[] params2 = m2.getParameterTypes();
					 Class[] params3 = m3.getParameterTypes();
						 if(params2.length!=0 && params3.length!=0)
						 {	 
							if(m1.getReturnType().toString().equals(params2[0].getName()) &&
							   m2.getReturnType().toString().equals(params3[0].getName())		)
							{
								try
								{
									testcase+=1;
									if(params1.length!=0)
									{
										//Invoking valid methods in chaining of level 3
										if(params1[0].getName().equals("int"))
											m3.invoke(obj, m2.invoke(obj, m1.invoke(obj, intInput.get(rnd.nextInt(15)))));
										else if(params1[0].getName().equals("float"))
										    m3.invoke(obj, m2.invoke(obj, m1.invoke(obj, floatInput.get(rnd.nextInt(15)))));
										else if(params1[0].getName().equals("java.lang.String"))
										    m3.invoke(obj, m2.invoke(obj, m1.invoke(obj, stringInput.get(rnd.nextInt(15)))));
									}
									else
										m3.invoke(obj, m2.invoke(obj, m1.invoke(obj)));
									pw.write("Test Case " + testcase + " : " + m3.getName() + "(" + m2.getName() + "(" + m1.getName() +"))" + "\tSuccess\n");
								}
								catch (Exception e) 
								{
									// If an exception rises, that means the test case is failed
									pw.write("Test Case " + testcase + " : " + m3.getName() + "(" + m2.getName() + "(" + m1.getName() +"))" + "\tFailed\n");
								}
							}
						 }
					 
				 }
			 }
		  }
	 }
	 pw.close();
  }	 
}

