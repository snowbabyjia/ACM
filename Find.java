import java.util.Scanner;


public class Find {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int linenum = sc.nextInt();
		String line = "";
		char[][] matrix = new char[linenum][linenum];
		char[] word;

		
		for (int i=0; i<linenum; i++){
			line = sc.next();
			matrix[i] = line.toCharArray();
		}
		word = sc.next().toCharArray();//finished getting all the input
		int length = word.length;

		int check = 0;
		for (int r=0; r<linenum; r++){
			for (int c=0; c<linenum; c++){
				int i=r, j=c;
				if (matrix[i][j] == word[0]){
					check = 1;
					for (int k=1; k<length; k++){
						if (i < 1 || j<1){
							check = 0;
							break;
						}
						else{
							i--;
							j--;
						}
						if (matrix[i][j] != word[k]){
							check = 0;
							break;
						}
					}
					if (check == 1){
						System.out.println("row "+ (r+1) + ", column" + (c+1) + ", diagonally up to the left");
					}
					
					check = 1;	
					i=r; j=c;
					for (int k=1; k<length; k++){
						if (i < 1){
							check = 0;
							break;
						}
						else{
							i--;
						}
						if (matrix[i][j] != word[k]){
							check = 0;
							break;
						}
					}
					if (check == 1){
						System.out.println("row "+ (r+1) + ", column" + (c+1) + ", up");
					}
					
					check = 1;
					i=r; j=c;
					for (int k=1; k<length; k++){
						if (i < 1 || j==linenum-1){
							check = 0;
							break;
						}
						else{
							i--;
							j++;
						}
						if (matrix[i][j] != word[k]){

							check = 0;
							break;
						}
					}
					if (check == 1){
						System.out.println("row "+ (r+1) + ", column" + (c+1) + ", diagonally up to the right");
					}
					
					check = 1;
					i=r; j=c;
					for (int k=1; k<length ; k++){
						if (j < 1){
							check = 0;
							break;
						}
						else{
							j--;
						}
						if (matrix[i][j] != word[k]){
							check = 0;
							break;
						}
					}
					if (check == 1){
						System.out.println("row "+ (r+1) + ", column" + (c+1) + ", left");
					}
					
					check = 1;
					i=r; j=c;
					for (int k=1; k<length; k++){
						if (j==linenum-1){
							check = 0;
							break;
						}
						else{
							j++;
						}
						if (matrix[i][j] != word[k]){
							check = 0;
							break;
						}
					}
					if (check == 1){
						System.out.println("row "+ (r+1) + ", column" + (c+1) + ", right");
					}
					
					check = 1;
					i=r; j=c;
					for (int k=1; k<length ; k++){
						if (i == linenum-1 || j<1){
							check = 0;
							break;
						}
						else{
							i++;
							j--;
						}
						if (matrix[i][j] != word[k]){
							check = 0;
							break;
						}
					}
					if (check == 1){
						System.out.println("row "+ (r+1) + ", column" + (c+1) + ", diagonally down to the left");
					}
					
					check = 1;
					i=r; j=c;
					for (int k=1; k<length; k++){
						if (i == linenum-1){
							check = 0;
							break;
						}
						else{
							i++;
						}
						if (matrix[i][j] != word[k]){
							check = 0;
							break;
						}
					}
					if (check == 1){
						System.out.println("row "+ (r+1) + ", column" + (c+1) + ", down");
					}
					
					check = 1;
					i=r; j=c;
					for (int k=1; k<length; k++){
						if (j ==linenum-1 || i==linenum-1){
							check = 0;
							break;
						}
						else{
							j++;
							i++;
						}
						if (matrix[i][j] != word[k]){
							check = 0;
							break;
						}
					}
					if (check == 1){
						System.out.println("row "+ (r+1) + ", column" + (c+1) + ", diagonally down to the right");
					}
				}
					
			}
		}
					
	}

}


