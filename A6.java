public class A6 {

	public static void main(String[] args) {
		Member m [] = new Member[5];
		
	     m[0] = new Member("Lee", 50000);
	     m[1] = new Member("Wang", 30000);
	     m[2] = new Member("Chen", 80000);
	     m[3] = new Member("Wu", 40000);
	     m[4] = new Member("Lin", 40000);
	     String output =""; //儲存所有會員資訊
	     double total = 0.0;   
		
	     for(int n = 0;n< m.length ;n++)
	     {
	    	 output += m[n] +"\n";
	    	
	     }
	     System.out.print(output);
	}

}