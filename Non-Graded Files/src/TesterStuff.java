
public class TesterStuff {
	public static void main(String[]args){
		int[] array = new int[100];
		int size = 0;
		for(int i=1; i<=10000; i++){
			if(i%10==1&&i%11==7&&i%9==4&&i%8==1){
				array[size]=i;
				size++;
			}
		}
		for(int i=0; i<size; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
