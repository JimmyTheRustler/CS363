
public class RainbowAttack {
	public static void main(String[] args) {
		int MAX = 100;
		double ans = 0.0;
		int[] foundPins = new int[10_000];
		int[][] chain = new int[MAX][2];
		int start = 9800;
		int end = 9900;

		//Generate Chain
		chain = generateChain(MAX, start, end);
		//Compare Hash's to Chain to find a match
		double correct = findHash(foundPins, MAX, chain, start, end);
		ans = (correct / MAX);
		System.out.println("Success Rate: " +  ans + "%");

	}

	public static double findHash(int[] foundPins, int MAX, int[][] chain, int start, int end) {
		int correct = 0;
		for(int i = 0; i < MAX; i++){
			for(int j = 0; j < 10_000; j++){
				//finds correct hashes
				if(hash(j) == chain[i][1]){
					correct++;
					//finds PinPrime and stores in foundPins[]
					for(int h = start; h < end-1; h++){
						foundPins[j] = hash(h);
					}	
				}
			}
		}
		return correct;
	}

	public static int[][] generateChain(int MAX, int start, int end) {
		int[][] rainbow = new int[MAX][2];
		for(int i = start; i < end; i++){
			rainbow[i - start][0] = i;
			int tempHash = hash(i);
			for(int k = 1; k < MAX; k++){
				tempHash = hash(reduce(tempHash));	
			}
			rainbow[i - start][1] = tempHash;
		}
		return rainbow;
	}

	public static int hash(int pin){
		int top = (pin + 25 % 10000) * (pin + 25 % 10000);
		int ans = (top / 100) % 10000;
		return ans;
	}


	public static int reduce(int hash){
		return hash;
	}
}
