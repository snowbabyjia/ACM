import java.util.*;
class Palin {
	public static boolean isLetter(char c){
		return ((c - 'a' >= 0) && (c - 'a' <= 26))? true:false;
	}
	public static int has(char[] unique, char c){
		for (int i=0; i<unique.length; i++){
			if (unique[i] == c)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int linenum = Integer.parseInt(sc.nextLine());
		int odd = 0;
		String letters = "";
		for (int l=0; l<linenum; l++){
			String newline = sc.nextLine();
			char[] line = newline.toLowerCase().toCharArray();
			char[] unique = new char[26];
			String result = "";
			letters = "";
			for (int i=0; i<line.length; i++)
				if (isLetter(line[i])){
					letters += line[i];
				}
			for (int i=0; i<letters.length(); i++){
				int check = has(unique, letters.charAt(i));
				if (check != -1){
					unique[check] = '|';
				}
				else{
					char c = letters.charAt(i);
					unique[c - 'a'] = c;
				}	
			}
			for (int i=0; i<unique.length; i++){
				if (isLetter(unique[i])){
					result += unique[i];
				}
			}
			odd = result.length();
			if (odd >= 2)
				System.out.println("No palindrome:" + newline);
			else
				System.out.println("Palindrome:" + newline);
			
		}
		
	}
}
