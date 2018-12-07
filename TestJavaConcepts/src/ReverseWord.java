import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseWord { 

	public static void main(String[] args) { 

		String str = "Good morning to everyone"; 

		String strArray[] = new String[] {"Good" ,"morning" ,"to"," everyone"};
		//System.out.println(strArray.length);
		for (int i = strArray.length - 1; i >= 0; i--) { 
			System.out.print(strArray[i]+" "); 
		} 
	} 
}



