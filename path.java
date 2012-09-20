import java.util.*;
/**
 * @author apple
 *
 */
public class path {

	//Detect if a string contains crossover
	public static boolean crossover(String full){
		if (full.contains("U")&&full.contains("L"))
			return true;
		if (full.contains("U")&&full.contains("R"))
			return true;
		if (full.contains("D")&&full.contains("L"))
			return true;
		if (full.contains("D")&&full.contains("R"))
			return true;
		return false;
	}
	
	//Detect if a string contains backtrack
	public static boolean backtrack(String full){
		if (full.contains("U")&&full.contains("D"))
			return true;
		if (full.contains("R")&&full.contains("L"))
			return true;
		return false;
	}
	
	//Detect if a string contains retrace
	public static boolean retrace(String full){
		if (full.indexOf("U") != full.lastIndexOf("U"))
			return true;
		if (full.indexOf("D") != full.lastIndexOf("D"))
			return true;
		if (full.indexOf("L") != full.lastIndexOf("L"))
			return true;
		if (full.indexOf("R") != full.lastIndexOf("R"))
			return true;
		return false;
	}
	
	//Detect if two instructions are opposite
	public static boolean oppo(char a, char b){
		if ((a=='U') && (b=='D'))
			return true;
		if ((a=='D') && (b=='U'))
			return true;
		if ((a=='L') && (b=='R'))
			return true;
		if ((a=='R') && (b=='L'))
			return true;
		return false;
	}
				
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc= new Scanner(System.in);
			//Number of instructions, 1-dim array to store the instructions, 2-dim array to store all the instructions
			//and 2-dim array to store the result
			int linenum = Integer.parseInt(sc.nextLine())-1;
			char[] ins = new char[linenum];
			String[][] allins = new String[31][31];
			char[][] result = new char[31][31];
			
			//Initialize the ins array
			int i=0,j=0,insind=0; // insind is looping through ins.
			for (i=0; i<linenum; i++){
				ins[i] = sc.next().charAt(0);
			}
			//Initialize the allins array
			for (i=0; i<31; i++){
				for (j=0; j<31; j++){
					allins[i][j] = "";
				}
			}
			allins[15][15] += ins[0];
			//Initialize the result array
			for (i=0; i<31; i++){
				for (j=0; j<31; j++){
					result[i][j] = ' ';
				}
			}
			
			//first time: find the end point and, record all the instructions at each position 
			//mark result[][] for the first time
			i=j=15;
			result[i][j] = 'S';
			int endpointi=0, endpointj=0;
			int ci,cj;
			for (insind=0; insind<linenum; insind++){
				ci=0; cj=0;
				// move the cursor
				if (ins[insind] == 'U')	{		
					ci = -1;
					i--;	
					result[i][j] = '^';
				}
				else if (ins[insind] == 'D'){
					ci = 1;
					i++;
					result[i][j] = 'V';
				}
				else if (ins[insind] == 'L'){
					cj = -1;
					j--;
					result[i][j] = '<';
				}
				else if (ins[insind] == 'R'){
					cj = 1;
					j++;
					result[i][j] = '>';
				}
				else
					;
				//store the instruction at the right place
				allins[i][j] += ins[insind];
				//if two neighbor instructions are opposite, mark that
				if ((insind!=0)&&(oppo(ins[insind], ins[insind-1]) == true)){
					allins[i-ci][j-cj] += ins[insind];
				}
				if (insind == linenum-1){
					endpointi=i; endpointj=j;
				}		
			}
			result[endpointi][endpointj] = 'F';
			
			//second time: detect crossover
			for (i=0; i<31; i++){
				for (j=0; j<31; j++){
					if ((allins[i][j].length()>=2) && (crossover(allins[i][j]) == true)){	
						if (i==15 && j==15)
							result[i][j] = '?';
						else if(i == endpointi && j == endpointj)
							result[i][j] = '!';
						else
							result[i][j] = '+';
					}
					
				}
				
			}
			
			//third time: detect backtrack
			for (i=0; i<31; i++){
				for (j=0; j<31; j++){
					if ((allins[i][j].length()>=2) && (backtrack(allins[i][j]) == true)){
						if (i==15 && j==15)
							result[i][j] = '$';
						else if(i == endpointi && j == endpointj)
							result[i][j] = '&';
						else
							result[i][j] = '*';
					}
				}
			}
			
			//fourth time: detect retrace
			for (i=0; i<31; i++){
				for (j=0; j<31; j++){
					if ((allins[i][j].length()>=2) && (retrace(allins[i][j]) == true)){
						if (i==15 && j==15)
							result[i][j] = '%';
						else if(i == endpointi && j == endpointj)
							result[i][j] = '#';
						else
							result[i][j] = 'X';
					}
				}
			}
			for (i=8; i<22; i++){
				for (j=8; j<22; j++)
					System.out.print(result[i][j]);
				System.out.println();
			}
			
	}

}
