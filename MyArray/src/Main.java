public class Main {

	public static void main(String[] args) {

		MyArrayList<Integer> firstList = new MyArrayList<>(10);

		for (int i = 0; i < 100; i++) {

			firstList.add(i);
			System.out.println(firstList.getById(i));
		}
	}
}
