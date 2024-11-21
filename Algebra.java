// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    System.out.println(div(-15, 3));
		/*
		// Tests some of the operations
		System.out.println(plus(2,3));   // 2 + 3 = 5
	    System.out.println(minus(7,2));  // 7 - 2 = 7
   		System.out.println(minus(2,7));  // 2 - 7 = -5
 		System.out.println(times(3,4));  // 3 * 4 = 12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 = 10
   		System.out.println(pow(5,3));      // 5^3 = 125
   		System.out.println(pow(3,5));      // 3^5 = 243
   		System.out.println(div(12,3));   // 12 / 3 = 4
   		System.out.println(div(5,5));    // 5 / 5  = 1 
   		System.out.println(div(25,7));   // 25 / 7 = 3 
   		System.out.println(mod(25,7));   // 25 % 7 = 4
   		System.out.println(mod(120,6));  // 120 % 6 = 0  
   		System.out.println(sqrt(36)); 	   // 6
		System.out.println(sqrt(263169));    // 513
   		System.out.println(sqrt(76123));     // 275 */
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2<0) {
			int x2Converted = x2;
			for(int i = 0 ; i > x2 ; i --) {
				x2Converted ++;
				x2Converted ++;
			}
			x2 = x2Converted;
			for(int i = 0 ; i < x2 ; i ++) {
				x1 --;
			}
		}
		else {
			for(int i = 0 ; i < x2 ; i ++) {
				x1 ++;
			}
		} 
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2<0) {
			int x2Converted = x2;
			for(int i = 0 ; i > x2 ; i --) {
				x2Converted ++;
				x2Converted ++;
			}
			x2 = x2Converted;
			for(int i = 0 ; i < x2 ; i ++) {
				x1 ++;
			}
		}
		else {
			for(int i = 0 ; i < x2 ; i ++) {
				x1 --;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if(x1 == 0 || x2 == 0) return 0;
		int result = 0 ;
		if(x1 < 0 && x2 < 0) {
			x1 = abs(x1);
			x2 = abs(x2);
			for(int i = 0 ; i < x2 ; i ++) {
				result = plus(result, x1);
			}
			return result;
		} else if(x1 < 0 && x2 > 0) {
			x1 = abs(x1);

			for(int i = 0 ; i < x2 ; i ++) {
				result = plus(result, x1);
			}
			int resultConverted = result;
			for(int i = 0 ; i < result ; i ++) {
				resultConverted = minus(resultConverted, 2);
			}
			return resultConverted;
		} else if (x1 > 0 && x2 < 0) {
			x2 = abs(x2);
			for(int i = 0 ; i < x2 ; i ++) {
				result = plus(result, x1);
			}
			int resultConverted = result;
			for(int i = 0 ; i < result ; i ++) {
				resultConverted = minus(resultConverted, 2);
			}
			return resultConverted;
		} else {
			for(int i = 0 ; i < x2 ; i ++) {
				result = plus(result, x1);
			}
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		if(x==0) return 0;
		if(n==1) return x;
		if(n > 0) {
			for(int i = 0 ; i < n ; i ++) {
				result = times(result, x);
			}
		}
		if(n > 0) {
			n = times(n, -1);
			for(int i = 0 ; i < n ; i ++) {
				result = div(result, x);
			}
		}
		if(x<0 && mod(n, 2) == 1) {
			x = times(x, -1);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int times = 0;
		if((x1 < 0 && x2 < 0) || (x1 > 0 && x2 > 0)) {
			x1 = abs(x1);
			x2 = abs(x2);
			while(x1>=x2) {
				x1 = minus(x1, x2);
				times ++;
			}
			return times;
		} else {
			if(x1 < 0 ) x1 = abs(x1);
			if(x2 < 0 ) x1 = abs(x1);
			while(x1>=x2) {
				x1 = minus(x1, x2);
				times ++;
			}
			int result = times;
			for( int i = 0 ; i < times ; i ++) {
				result --;
				result --;
			}
			return result;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int div = div(x1, x2);
		int mul = times(div , x2);
		return x1 - mul;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int result = 0;
		while(times(result, result) < x) result ++ ;
		if(times(result , result) > x) result --;
		return result;
	}
	
	public static int abs(int x) {
		if(x == 0 ) return 0;
		if(x > 0) return x;
		else {
			int result = x;
			for(int i = 0 ; i > x ; i --) {
				result = plus(result, 2);
			}
			return result;
		}
	}
}