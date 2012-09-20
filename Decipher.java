import java.util.*;


public class Decipher {
	
	public static float modOne(float x){
		float y = x;
		while (y >= 1){
			y--;			
		}
		return y;				
	}
	
	public static String binary(int x){
		int y=x;
		String result = "";
		for (int i=16; i>=1; i /= 2){
			if (y >= i){
				result += "|";
				y -= i;
			}
			else
				result += ":";	
			
		}
		return result;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		float A = sc.nextFloat();
		float m = sc.nextInt();
		int linenum = sc.nextInt();
		String[] encode = new String[10];
		
		for (int i=0; i<9; i++)
			encode[i] = "";
		
		for (int n=0; n<10; n++){
			float step1 = (n+1) * A;

			float step2 = modOne(step1);
			float step3 = step2 * m;
			int step4 = (int)step3/1;	
			encode[n] = binary(step4);	
		}
		
		for (int i=0; i<linenum; i++){
			int[] num = new int[6];
			for (int j=0; j<6; j++){
				String code = sc.next();
				for (int k=0; k<10; k++){
					if (code.equals(encode[k])){
						num[j] = k;
						break;
					}
				}
					
			}
			int sum=0;
			for (int l=0; l<5; l++){
				System.out.print(num[l]);
				sum += num[l];
			}
			if ((10-sum%10) != num[5] )
				System.out.println("*   "+num[5]);
			else
				System.out.println("    "+num[5]);
				
			
			
			
		}

	}

}
