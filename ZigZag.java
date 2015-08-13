public class ZigZag {
	
	public static void main(String[] args)
	{
		int[] sequence ={ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		int result=longestZigZag(sequence);
		System.out.println(result);
	}

	public static int longestZigZag(int[] sequence) {
		int[] states = new int[sequence.length + 1];
		int[] decrementState = new int[sequence.length + 1];
		int current_d=0;
		states[1] = 1; // A sequence with fewer than two elements is trivially a
						// zig-zag sequence
		if(sequence.length>1)
		states[2] = 2; // A sequence with two elements is trivially a zig-zag
						// sequence
		// intialize the value of d inside the state (i,d)
		decrementState[1] = -1;
		if(sequence.length>1)
		decrementState[2]=computeDecrementState(sequence[0], sequence[1]);
		for (int i = 2; i < sequence.length; i++) {

			states[i + 1] = 1;
			int temp = 0;
			for (int j = 0; j <= i-1; j++) {
				int d=computeDecrementState(sequence[j],sequence[i]);
				if(decrementState[j+1]==-1 || (decrementState[j+1]==1 && d==0) || (decrementState[j+1]==0 && d==1))  // check to see if there is alternate pattern of sign
				{
					states[i+1]=states[j+1]+1;
					decrementState[i+1]=d;
					continue;
				}
			}
			if (!(states[i + 1] > states[i])) {
				states[i+1]=states[i];
				decrementState[i+1]=decrementState[i];
			} 
		}
		
		return states[sequence.length];
	}
	
	
	public static int computeDecrementState(int x,int y)
	{
		if (y > x) {
			return 1;
		} else {
			return 0;
		}
	}
}
