
public class AliquotsFun {
	
	public static void main(String[] args){
		
		Aliquots test = new Aliquots();
		for(int i=121; i<10000000; i++){
			if(test.isMultiplyPerfect(i, 2)==true){
				System.out.println("2*"+i+"="+test.factorSum(i));
				System.out.println(test.toString(i)+'\n');
			}
		}
		
	
	}
}
