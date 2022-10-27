
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Demo how object created from child class
		MethodsDemoChild m = new MethodsDemoChild();
		String s =m.MethodOne();
		System.out.println(s);
		// Demo how object created from non static method-no need to create object
		MethodsDemo m1 = new MethodsDemo();
		String s1 = m1.getData1();
		System.out.println(s1);
		// Demo how object created from child static method - need to create object
		String s2 = getData();
		System.out.println(s2);
	}

	public static String getData() {
		System.out.println("hello from static class method");
		return "return text from static class method";
	}
	
	public String getData1() {
		System.out.println("hello from non static class method");
		return "return text from non static class method";
	}
}
