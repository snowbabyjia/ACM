8
"*       "
"** M*   "
" *  *   "
"    **  "
"  **    "
"  *  *  "
" ** C   "
"    ****"
import java.util.*;
public class Flu {

	public static int check_disease(String[][] area, int rsize, int csize){
		int d = 0;
		for (int i=0; i<rsize; i++){
			for (int j=0; j<csize; j++)
				if (area[i][j].equals("I"))
					d = 1;			
		}
		return d;		
	}
	
	public static void printa(String[][] area, int rsize, int csize){
		for (int i=0; i<rsize; i++){
			for (int j=0; j<csize; j++)
			{
				System.out.print(area[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	public static int numI(String[][] area, int rsize, int csize, int i, int j){
		int inum=0;
		if (i+1<rsize){
			if (area[i+1][j].equals("toE"))
				inum++;
			if (j+1<csize){
				if (area[i+1][j+1].equals("toE"))
					inum++;
			}
			if (j-1 >=0)
				if (area[i+1][j-1].equals("toE"))
					inum++;
		}
		if (i-1>=0){
			if (area[i-1][j].equals("toE"))
				inum++;
			if (j+1<csize){
				if (area[i-1][j+1].equals("toE"))
					inum++;
			}
			if (j-1 >=0)
				if (area[i-1][j-1].equals("toE"))
					inum++;
		}
		if (j+1<csize){
			if (area[i][j+1].equals("toE"))
				inum++;
		}
		if (j-1>=0){
			if (area[i][j-1].equals("toE"))
				inum++;
		}
		return inum;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int prob = Integer.parseInt(sc.nextLine());
		int threshold = Integer.parseInt(sc.nextLine());
		String[][] area = new String[50][50];
		String[] line;
		int rownum=0, colnum=0;
		int clock = 0;
		int disease = 1;
		int rsize=0, csize=0;
		int change = 0;
		
		while (sc.hasNextLine()){
			line = sc.nextLine().split(" ");
			csize = line.length;
			System.out.println("");
			for (colnum=0; colnum < csize; colnum++)
				area[rownum][colnum] = line[colnum];
			rownum++;	

		}


		rsize = rownum;
		
		while (disease == 1){
			for (int i=0; i<rsize; i++){
				for (int j=0; j<csize; j++){
					if (area[i][j].equals("I")){
						area[i][j] = "toE";
						change = 1;
					}
				}
				
			}
			
			for (int i=0; i<rsize; i++){
				for (int j=0; j<csize; j++){
					if (area[i][j].equals("P")){
						if ( numI(area,rsize,csize,i,j) * prob > threshold){
							area[i][j] = "I";
							change = 1;
						}
					}
				}
					
			}
			
			for (int i=0; i<rsize; i++){
				for (int j=0; j<csize; j++){
					if (area[i][j].equals("toE")){
						area[i][j] = "E";
					}
				}
				
			}
			disease = check_disease(area, rsize, csize);


			if (change == 1)
				clock++;
			change = 0;
			if ( disease == 0) {
				System.out.println("Number of clock ticks: " + clock);
				for (int i=0; i<rsize; i++)
					for (int j=0; j<csize; j++)
						if (area[i][j].equals("P")){
							System.out.println("Row: " + i + "Column: " + j);
						}
			}
			
		}
	}

}
