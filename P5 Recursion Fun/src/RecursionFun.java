import java.util.Scanner;

public class RecursionFun {

	public int fibonacci(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public double addReciprocals(int n) {
		if (n == 1)
			return 1.0;
		else
			return 1.0 / n + addReciprocals(n - 1);
	}

	public int combinations(int n, int k) {
		if (k == 1)
			return n;
		if (n == k)
			return 1;
		else
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	public int GCD(int m, int n) {
		int absM = Math.abs(m);
		int absN = Math.abs(n);
		if(m==0) return n;
		if(n==0) return m;
		else{ 
			int min = Math.min(absN, absM);
			int max = Math.max(absN, absM);
			return GCD(min, max%min);
		}
	}
	
	public String subsentence(String sentence, int first, int last){
		if(first>last) return "";
		else if(!sentence.equals("")){
			Scanner scan = new Scanner(sentence);
			String curWord;
			curWord = scan.next();
			if(first==0){
				if(first==last) return curWord + " ";
				else return curWord + " " + subsentence(sentence.substring(curWord.length()+1), 0, last-1);
			}
			else {
				return subsentence(sentence.substring(curWord.length()+1), first-1, last-1);
			}
		}
		else return "";
	
	}

	public String intWithCommas(int n) {
		if(n==0) return "0";
		else{
			return intWithCommas(n, 0);
		}
	}
	
	private String intWithCommas(int n, int places){
		if(n<0) return "-" + intWithCommas(Math.abs(n), places);
		if(n>0){
			if(places==0) return intWithCommas(n/10, places+1) + n%10;
			else{
				if(places%3==0)	return  intWithCommas(n/10, places+1) + n%10 + ","; 
				else return intWithCommas(n/10, places+1) + n%10;
			}
		}
		else return "";
	}
	
	public int sumArray(int[]array, int begin, int end){
		if(begin>end) return 0;
		else return array[begin] + sumArray(array, begin+1, end);
	}

	public void reverseArray(int[] array) {
		if(array.length==0) return;
		else reverseArray(array, 0, array.length-1);
	}

	private void reverseArray(int[] array, int first, int last) {
		if(first>=last) return;
		else {
			int temp = array[first];
			array[first] = array[last];
			array[last] = temp;
			reverseArray(array, first+1, last-1);
		}
	}

	public int arrayRange(int[] array) {
		if(array.length==0) return 0;
		else{
			int max = arrayMax(array, 0, array[0]);
			int min = arrayMin(array, 0, array[0]);
			return max - min;
		}
	}

	private int arrayMin(int[] array, int first, int min) {
		if(first==array.length) return min;
		else {
			if(array[first]<=min) min = array[first];
			return arrayMin(array, first+1, min);
		}
	}

	private int arrayMax(int[] array, int first, int max) {
		if(first==array.length) return max;
		else {
			if(array[first]>=max) max = array[first];
			return arrayMax(array, first+1, max);
		}
	}
	
	public int binarySearch(String search, String[] array){
		if(array.length==0) return -1;
		else{
			if(array[0].equals(search)) return 0;
			else if(array[array.length-1].equals(search)) return array.length-1;
			else return binarySearch(search, array, 0, (array.length-1)/2, array.length-1);
		}
	}

	private int binarySearch(String search, String[] array, int begin, int middle, int end) {
		if(begin==middle) return -1;
		else{
			if(array[middle].equals(search)) return middle;
			else if(array[middle].compareTo(search)>0){
				end = middle;
				middle = (end-begin)/2 + begin;
				return binarySearch(search, array, begin, middle, end);
			}
			else{
				begin = middle;
				middle = (end-begin)/2 + begin;
				return binarySearch(search, array, begin, middle, end);
			}
		}
	}
	
}
