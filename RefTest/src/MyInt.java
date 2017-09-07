
public class MyInt {
    public int val;

    public MyInt (MyInt obj){
        this.val = obj.getVal();
        System.out.println("Constructor");
    }

    public MyInt() {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Value{" +
                "val=" + val +
                '}';
    }
}
