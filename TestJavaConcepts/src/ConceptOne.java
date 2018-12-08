
public class ConceptOne {

	public static void main(String[] args) {
		
		/*char []ch = {'j','a','v','a'};
		String s = new String(ch);
		System.out.println(s);*/
		
		String s = "java";
		System.out.println(s.length());
		for(int i=s.length()-1;i>=0;i--) {
			
			System.out.println(s.charAt(i));
			
		}
		
		
		
		
		/*	ConceptOne c1 = new ConceptOne();
			System.out.println(c1.addTwoNumbers("2", 6));*/
	}
	
	/*int addTwoNumbers(int a,int b) {
		return a+b;
	}*/
	
  Object addTwoNumbers(Object a,Object b) {
	 if(a instanceof Integer && b instanceof Integer) {
		 Integer i = (Integer)a+(Integer)b;
		 return (Object)i;
	 }
	 else if(a instanceof Double && b instanceof Double ) {
		 Double j = (Double)a + (Double)b;
		 return (Object)j;
	 }
	 else if(a instanceof String && b instanceof String ) {
		 String j = (String)a + (String)b;
		 return (Object)j;
	 }
	 return "enter valid number";
	}
//	System.out.println("updated");
  
  
}
  
