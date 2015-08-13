public class LongestSequence {

	// int[] sequence = {5,3,4,8,6,7,5,6,10,9,11};
	int[] sequence = { 5,6,7,2 };
	int[] table = new int[sequence.length + 1];

	public static void main(String[] args) {

		LongestSequence ls = new LongestSequence();
		ls.getLongestSequence();

	}

	private void getLongestSequence() {

		table[1] = 1;
		for (int i = 1; i < sequence.length; i++) {

			table[i + 1] = 1;
			int temp = 0;
			for (int j = i - 1; j >= 0; j--) {

				if (sequence[i] > sequence[j]) {

					if (temp == 0) {
						temp = sequence[j];
					}
					if (sequence[j] <= temp) {
						table[i + 1] = 1 + table[i + 1];
						temp = sequence[j];
					}

				} else {
					continue;

				}

			}
			if (table[i + 1] > table[i]) {

			} else {
				table[i + 1] = table[i];
			}

		}
		System.out.println("");
	}

}
