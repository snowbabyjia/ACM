import java.util.Scanner;


public class Victim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int linenum = sc.nextInt();
		int curline;
		float[] first = new float[10];
		float[] second = new float[10];
		float[] avr = new float[10];
		
		
		while (linenum != 0){
			for (curline = 0; curline < linenum; curline ++){
				first[curline] = sc.nextFloat();
				second[curline] = sc.nextFloat();
				avr[curline] = (first[curline] + second[curline]) / 2;
			}
			
			
			int i, j, vic, totalvic=0;
			for (i=0; i < linenum; i++){
				vic = 1;
				for (j=0; j<linenum; j++){
					if ((i!=j)&&(avr[i] >= avr[j]/2)){
						vic = 0;
					}
				}
			 	
			
				if (vic == 1){
					System.out.println("Victim has average antibody level of: " + avr[i]);
					totalvic = 1;
					break;
				}
			}
			if (totalvic == 0){
				System.out.println("No victim.");
			}
			
			
			
			linenum = sc.nextInt();
		}
		

	}

}
