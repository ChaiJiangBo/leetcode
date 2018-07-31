package leetcode.test.chaijb;

/**
 * -100.0 < x < 100.0 
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */
public class MyPower {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		if (x == 1) {
			return 1.0;
		}
		double result = 1.0;
		if (n > 0) {
			return myRowReccursive(x, n);
		} else {
			result = x * myRowReccursive(x, -(n + 1));
			return 1.0 / result;
		}
    }
	public double myRowReccursive(double x, int n) {
		if (n == 0 ) {
			return 1.0;
		}
		if (n == 1) {
			return x;
		}
		double res;
		res = myRowReccursive(x, n / 2);
		if(n % 2 == 1) {
			return x * res * res;
		}else {
			return res * res;
		}
	}

	public static void main(String[] args) {
		MyPower myPower = new MyPower();
		System.out.println(myPower.myPow(2.0, Integer.MIN_VALUE));
//		System.out.println(Math.pow(2, Integer.MIN_VALUE));
	}

}
