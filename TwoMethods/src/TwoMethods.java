
public class TwoMethods {

	public boolean isEven(int i) {
		if(i%2==0){
			return true;
		}
		else{
			return false;
		}
	}//end isEven
	
	public String reverse(String testString){
		String reversed = "";
		for(int i=1; i<=testString.length(); i++){
			reversed += testString.charAt(testString.length()-i);
		}
		return reversed;
	}//end reverse

}
