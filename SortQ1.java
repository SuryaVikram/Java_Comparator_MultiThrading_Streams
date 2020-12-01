package assignment1;

//Creating class to implement the sort function
public class SortQ1 {

	int[] array;

	public void sort(int[] array) { // array length must be a power of 2
		this.array = array;
		sort(0, array.length);

	}

	private void sort(int low, int n) {

		if (n > 1) {
			int mid = n >> 1;

			sort(low, mid);
			sort(low + mid, mid);

			combine(low, n, 1);
		}
	}

	private void combine(int low, int n, int st) {

		int m = st << 1;

		if (m < n) {
			combine(low, n, m);
			combine(low + st, n, m);

			for (int i = low + st; i + st < low + n; i += m)
				compareAndSwap(i, i + st);

		} else
			compareAndSwap(low, low + st);
	}

	private void compareAndSwap(int i, int j) {
		if (array[i] > array[j])
			swap(i, j);
	}

	private void swap(int i, int j) {
		int h = array[i];
		array[i] = array[j];
		array[j] = h;
	}

	public static void main(String[] args) { // Main method to execute

		int[] unSorted = { 15, 222, 3, 6, 5, 4, 7, 8, 9, 10, 11, 12, 13, 15, 14, 16 }; // initialise the array

		// print unsorted array
		System.out.print("Before Sorting" + "\n");

		for (int i = 0; i < unSorted.length; i++) {
			System.out.print(unSorted[i] + " ");

		}
		System.out.print("\n");

		SortQ1 sort = new SortQ1(); // creates object for the Sort Class to implement the method
		sort.sort(unSorted); // call the sort method for the int array

		// print Sorted array
		System.out.print("After Sorting" + "\n");
		for (int i = 0; i < unSorted.length; i++) {
			System.out.print(unSorted[i] + " ");
		}

	}

}
