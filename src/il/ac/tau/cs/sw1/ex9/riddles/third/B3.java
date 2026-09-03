package il.ac.tau.cs.sw1.ex9.riddles.third;

@SuppressWarnings("serial")
public class B3 extends A3 {
	
	public B3(String s) {
		super(s);
	}
	
	public void foo (String s) throws B3 {
		if (s.equals(this.s)){
			throw this;
		}
	}
	
	public String getMessage() {
		return super.s;
	}
	
}