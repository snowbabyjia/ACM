import java.util.ArrayList;
import java.util.*;

public class Compression {

	/**
	 * @param args
	 */
	public static int occur(ArrayList<String> uniqueString, String s){
		for (int i=0; i<uniqueString.size(); i++){
			if (uniqueString.get(i).equals(s))
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int linenum = Integer.parseInt(sc.nextLine());
		ArrayList<Integer> linesize = new ArrayList<Integer>();
		String line = sc.nextLine();
		String[] newnum = line.split(" ");
		linesize.add(newnum.length);
		String[] file = new String[80 * linenum];
		ArrayList<String> uniqueString = new ArrayList<String>(20);
		ArrayList<Integer> uniqueIndex = new ArrayList<Integer>(20);
		int num = 0;
		
		for (int i=0; i<linenum-1; i++){
			String newline = sc.nextLine();
			newnum = newline.split(" ");
			int last = linesize.get(linesize.size()-1);
			linesize.add(last + newnum.length);
			line += " " + newline;
		}
		file = line.split(" ");
		for (int i=0; i<file.length; i++){
			int firstOccur = occur(uniqueString, file[i].toLowerCase());
			if ( firstOccur == -1){
				uniqueString.add(file[i].toLowerCase());
				uniqueIndex.add(i+1-num);
			}
			else{
				num++;
				file[i] = "" + uniqueIndex.get(firstOccur);
			}
		}

		for (int i=0; i<file.length; i++){
			int j = -1;
			if (linesize.contains(i)){
				linesize.remove(0);
				System.out.println();
			}
			
			System.out.print(file[i]);
				System.out.print(" ");
			
		}
	}

}



