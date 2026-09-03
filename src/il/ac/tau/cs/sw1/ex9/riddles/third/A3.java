package il.ac.tau.cs.sw1.ex9.riddles.third;

public class A3 extends Exception {
    private static final long serialVersionUID = 1L;

    protected final String s;

    public A3(String s) {
        super(s);
        this.s = s;
    }

    public void foo(String value) throws A3 {
        if (value.equals(s)) {
            throw this;
        }
    }
}
