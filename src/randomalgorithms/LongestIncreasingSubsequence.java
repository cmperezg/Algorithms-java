package randomalgorithms;


public class LongestIncreasingSubsequence {

	public static String LIS(int[] arr){
		
		int[][] ansarr = new int[arr.length][2];
		ansarr[0][0] = 1;
		ansarr[0][1] = -1;
		
		int LISlength = 1;
		int longest_at = 0;
		
		for(int i = 1; i < arr.length; i++){
			int prevind = -1;
			int bestlength = 1;
			for(int j = i-1; j>= 0; j--){
				if(arr[j] < arr[i] && ansarr[j][0] >= bestlength){
					bestlength = ansarr[j][0] + 1;
					prevind = j;
				}
			}
			ansarr[i][0] = bestlength;
			ansarr[i][1] = prevind;
			
			if(bestlength > LISlength){
				LISlength = bestlength;
				longest_at = i;
			}
		}
		return LISres(arr,ansarr,longest_at);
	}
	
	public static String LISres(int[] arr, int[][] aa, int longest_at){
		String LIS = "";
		int previndex = longest_at;
		
		while(previndex > -1){
			LIS = "," + arr[previndex] + LIS;
			previndex = aa[previndex][1];
		}
		
		return LIS;
	}
	
	static void printaa(int[][] aa){
		for(int i = 0; i<aa.length; i++){
			System.out.println(aa[i][0] + "," + aa[i][1]);
		}
	}
	
	public static void main(String[] args){
		
		//int[] arr = {10,9,33,11,39,22,38,28,30,31,32};
		int[] arr = {20,21,22,23,1,2,3,4,5};
		
		String ans = LIS(arr);
		String[] anss = ans.split(",");
		System.out.print("LIS = ");
		for(int i = 0; i<anss.length; i++){
			System.out.print(anss[i] + " ");
		}
	}
}