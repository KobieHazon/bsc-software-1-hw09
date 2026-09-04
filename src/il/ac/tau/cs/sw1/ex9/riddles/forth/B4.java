package il.ac.tau.cs.sw1.ex9.riddles.forth;

import java.util.Iterator;

public class B4 implements Iterator<String> {

	private String[] strings;
	private int k;
	private int returns;

	public B4(String[] strings, int k) {
		this.strings = strings;
		this.k = k;
		this.returns = 0;
	}

	@Override
	public boolean hasNext() {
		return returns != strings.length*k;
	}

	@Override
	public String next() {
		return strings[(returns++)%strings.length];
	}

}
