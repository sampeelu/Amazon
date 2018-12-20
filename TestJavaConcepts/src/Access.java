
public class Access {
	public static void main(String args[]) {
	Sample a= new Sample();
	a.getBalance();

	
	
	int i;
	for(i=0;i<5;i++) {
	
		for(int j=0;j<i;j++) {
			System.out.print(" ");
			
		}
		
		for(int j=0;j<i;j++) {
			System.out.print("* ");
			
		}
		System.out.println();
		
	}
	
	for(int k=i-1;k>0;k--) {
		
		for(int l=k;l>0;k--) {
			
			System.out.print("* ");
			
		}
		System.out.println();
	}
	
	
	
	
	
	

}
	}
