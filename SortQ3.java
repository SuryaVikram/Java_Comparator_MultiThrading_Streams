package assignment1;

import java.util.Comparator;

//Class uses generic type T so as to deal with different types of data
public class SortQ3<T> {

	T[] array; // array of generic type
	Comparator<T> comparator; // comparator object

	public void sort(T[] array, Comparator<T> c) { // array length must be a power of 2, method takes comparator object
		// as argument
		this.array = array;
		sort(0, array.length, c);
	}

	private void sort(int low, int n, Comparator<T> c) { // method takes comparator object as argument
		if (n > 1) {
			int mid = n >> 1;
			sort(low, mid, c);
			sort(low + mid, mid, c);
			combine(low, n, 1, c);
		}
	}

	private void combine(int low, int n, int st, Comparator<T> c) { // method takes comparator object as argument

		int m = st << 1;
		if (m < n) {
			combine(low, n, m, c);
			combine(low + st, n, m, c);
			for (int i = low + st; i + st < low + n; i += m)
				compareAndSwap(i, i + st, c);
		} else
			compareAndSwap(low, low + st, c);
	}

	private void compareAndSwap(int i, int j, Comparator<T> c) { // method takes comparator object as argument

		if (c.compare(array[i], array[j]) > 0)
			swap(i, j);
	}

	private void swap(int i, int j) {
		T h = array[i];
		array[i] = array[j];
		array[j] = h;
	}

}

//Main Class
class MainQ3 {

	// Main method for execution
	public static void main(String[] args) {

		// Initialise the string and double values
		String[] strings = new String[] { "aav", "Is", "Well", "eede", "Nothing", "but", "easy", "than", "is", "not",
				"good", "enough", "asd", "qwe", "sss", "lgr", "aav", "Is", "Well", "eede", "Nothing", "but", "easy",
				"than", "is", "not", "good", "enough", "asd", "qwe", "sss", "lgr" };
		Double[] doubles = new Double[] { 7d, 2d, 6d, 4d, 4.5d, 33.4d, 22d, 11d, 23d, 23d, 44d, 3d, 4d, 5d, 6d, 7d };

		// String comparator as lambda function
		Comparator<String> stringComparator = (String arg0, String arg1) -> arg0.toLowerCase()
				.compareTo(arg1.toLowerCase()); // lambda function for the compare method

		// Creates a object of comparator for Double type using the class SortByDouble
		Comparator<Double> doubleComparator = (Double arg0, Double arg1) -> arg0.compareTo(arg1); // lambda function for
		// the compare
		// method

		// Print Strings before sort
		System.out.print("Before Sort" + "\n");
		for (String string : strings) {
			System.out.print(string + " ");
		}

		// Creates an object for the sort class
		SortQ3 sort = new SortQ3();

		// Calls on the sort method
		sort.sort(strings, stringComparator);

		// Print Strings after sort
		System.out.print("\n" + "After Sort" + "\n");
		for (String string : strings) {
			System.out.print(string + " ");
		}

		// Print Double before sort
		System.out.print("\n" + "Before Sort" + "\n");
		for (Double doubleValue : doubles) {
			System.out.print(doubleValue + " ");
		}

		// Calls on the sort method for Double data type
		sort.sort(doubles, doubleComparator);

		// Print Double after sort
		System.out.print("\n" + "After Sort" + "\n");

		for (Double doubleValue : doubles) {
			System.out.print(doubleValue + " ");
		}

	}
}
