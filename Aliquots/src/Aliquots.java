
public class Aliquots {
	
	private int[] array;
	private int size;
	private int num;
	private double sqrt;
	private boolean square;
	
	public Aliquots(){
		array = new int[1000];
		size = 0;
		square = false;
	}
	
	public String toString(int test){
		String toString = "Aliquot Factors of " + test + ": ";
		factors(test);
		if(square==false){
			for(int i=0; i<size; i++){
				toString+=array[i]+" ";
			}
			for(int j=1001-size; j<1000; j++){
				toString+=array[j]+" ";
			}
			return toString;
		}
		else{
			for(int i=0; i<size; i++){
				toString+=array[i]+" ";
			}
			for(int j=1002-size; j<1000; j++){
				toString+=array[j]+" ";
			}
			return toString;
		}
	}
	
	public void factors(int test){
		square = false;
		num = test;
		sqrt = Math.sqrt(num);
		for(int i=0; i<1000; i++){
			array[i]=0;
		}
		array[0]=1;
		size=1;
		for(int i=2; i<sqrt; i++){
			if(num%i==0){
				array[size]=i;
				array[1000-size]=num/i;
				size++;
			}
		}
		if((int)sqrt==sqrt){
			array[size]=(int)sqrt;
			size++;
			square = true;
		}
	}
	
	public int factorSum(int test){
		int sum = 0;
		factors(test);
		for(int i=0; i<1000; i++){
			sum+=array[i];
		}
		return sum;
	}
	
	public String numType(int test){
		int sum = factorSum(test);
		if(sum>test){
			return "abdundant";
		}
		else if(sum==test){
			return "perfect";
		}
		else {
			return "deficient";
		}
	}
	
	public boolean isAbundant(int test){
		int temp = test;
		int sum = factorSum(temp);
		if(sum>temp){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isPerfect(int test){
		int sum = factorSum(test);
		if(sum==test){
			return true;
		}
		return false;
	}
	
	public boolean isDeficient(int test){
		int sum = factorSum(test);
		if(sum<test){
			return true;
		}
		return false;
	}
	
	public boolean isMultiplyPerfect(int test, int multiple){
		int sum = factorSum(test);
		if(sum==multiple*test){
			return true;
		}
		return false;
	}
}
