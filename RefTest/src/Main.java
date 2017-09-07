public class Main {

    public static void main(String[] args) {

        MyInt value = new MyInt();
        value.setVal(25);

        MyInt value2 = new MyInt(value);

        increment(value);

        System.out.println(value2);
    }

    static void increment (MyInt i){
        //int v = i.getVal();
        //v++;
        //i.setVal(v);
        i.val++;
    }
}
