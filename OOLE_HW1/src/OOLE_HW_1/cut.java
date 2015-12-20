// This the class used to test the TestHarness. It contains a combination of methods taking various
// Types as arguments and returns various types.
class cut 
{
   public void takeVoidReturnVoid()
   {
	   System.out.println("invoked takeVoidReturnVoid");
	   return;
   }
   
   public int takeVoidReturnInt()
   {
	   int i =2;
	   System.out.println("invoked takeVoidReturnInt");
	   return i;
   }
   
   public float takeVoidReturnFloat()
   {
	   float f = (float) 1.234;
	   System.out.println("invoked takeVoidReturnFloat");
       return f;	   
   }
   
   // taking int and returning various Types
   
   public void takeIntReturnVoid(int i)
   {
	   System.out.println("invoked  takeIntReturnVoid");
	   return;
   }
   
   public int takeIntReturnInt(int i)
   {   
	   System.out.println("invoked takeIntReturnInt");
	   return i+1;
   }
    
   public float takeIntReturnFloat(int i)
   {
	   System.out.println("invoked intReturnFloat");
	   return (float) (10/i);
   }
   
   // taking float and returning various Types
   public void takeFloatReturnVoid(float f)
   {
	   System.out.println("invoked takeFloatReturnvoid");
	   return;
   }
   public int takeFloatReturnInt (float f)
   {
	   System.out.println("invoked floatReturnvoid");
	   return Math.round(f);
   }
   
   public float takeFloatReturnFloat(float f)
   {
	System.out.println("invoked takeFloatReturnFloat");
	return f+1;
   }
   
   
   // taking string return various Types
   public int takeStringReturnint(String str)
   {
	   System.out.println("invoked stringReturnint");
	   return str.length();
   }
   
   public String takeStringReturnString(String str)
   {
	   System.out.println("invoked stringReturnString");
	   return str;
   }
   public int field1;
}  
