
public class OneMethod {

	public String season(int month) {
		String season = "Winter";
		if(month>=3&&month<=5){
			season = "Spring";
		}
		else if(month>=6&&month<=8){
			season = "Summer";
		}
		else if(month>=9&&month<=11){
			season = "Fall";
		}
		return season;
	}

}
