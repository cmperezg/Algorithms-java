package randomalgorithms;


public class SecretaryProblem {
	
	public static void main(String[] args){
		double n = 8;
		double[] p = prob(n);
		for(int a = 0; a<p.length; a++){
			System.out.println("n = " + (int)n + " k = " + (a+1) + " p = " + p[a]);
		}
	}
	
	public static double[] prob(double n){
		double[] p = sum(n);
		for(int a = 0; a<p.length; a++){
			p[a] = p[a]*((a+1)/n);
		}
		return p;
	}
	public static double[] sum(double n){
		double[] ans = new double[(int)n];
		ans[(int)n-1] = 0; //if you see them all, pr                                                                                                                                             obability of getting the best is zero
		for(double a = n-2; a >=0; a--){
			double k = a+1;
			double i = k;
			ans[(int)a] = (1/i) + ans[(int)a+1];
		}
		return ans;
	}
}