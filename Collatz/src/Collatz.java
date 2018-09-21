public class Collatz {
	private int num;

	public Collatz() {
		num = 0;
	}

	public String collatz(int test) {
		if (test >= 1) {
			num = test;
			int steps = 0;
			String toString = "Results for " + num + ":" + '\n' + " " + num
					+ '\n';
			while (num != 1) {
				if (num % 2 == 0) {
					num = num / 2;
					toString += " " + num + '\n';
					steps++;
				} else {
					num = 3 * num + 1;
					toString += " " + num + '\n';
					steps++;
				}
			}
			return toString + "Steps: " + steps;
		} else {
			return "Invalid starting int";
		}
	}
}
