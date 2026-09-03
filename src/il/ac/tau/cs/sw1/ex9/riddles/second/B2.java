package il.ac.tau.cs.sw1.ex9.riddles.second;

public class B2 {
	
	private final A2 a = new A2();
	private final BA2 b = new BA2();
	
	public A2 getA(boolean random) {
		return random ? b : a;
	}
	
	public class BA2 extends A2 {
		@Override
		public String foo(String s) {
			return s.toUpperCase();
		}
	}
}
