import java.util.ArrayList;

public class ArrayIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i[] = {1,2,3,4,5};
		
		for(int j=0; j<i.length; j++)
		{
			System.out.println(i[j]);
		}
		
		String k[] = {"BOBO", "BASHA", "ASSHA", "BASHA"};
		for(int j=0; j<k.length; j++)
		{
			System.out.println(k[j]);
		}
		
		System.out.println("enhanced for loop:");
		for(String s: k)
		{
			System.out.println(s);
		}
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("BOBO");
		arr.add("BACHA");
		arr.add("ACCHA");
		arr.add("BACHA");
		
		for(int l=0; l<arr.size(); l++)
		{
			System.out.println(arr.get(l));
		}
		
		
			
	}

	
}
