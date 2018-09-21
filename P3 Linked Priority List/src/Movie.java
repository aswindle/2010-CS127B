/*Alex Swindle
 * C SC 127B
 * Class that stores a movie title plus rating, with a simple title getter and toSting
 */

public class Movie {

		//instance variables
		private String title;
		private int rating;
		
		//constructor
		public Movie(String setTitle, int setRating){
			title = setTitle;
			rating = setRating;
		}
		
		//getter for title
		public String getTitle(){
			return title;
		}
		
		//toString that prints rating as a # of  *'s
		public String toString(){
			String stars = "";
			for(int i=1; i<=rating; i++){
				stars+="*";
			}
			return title + " " + stars;
		}
}
