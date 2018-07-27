package leetcode.test.chaijb;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。 示例 1:
 * 
 * 输入: [5,7] 输出: 4 示例 2:
 * 
 * 输入: [0,1] 输出: 0
 *
 */
public class BitwiseOfNumberRange {
	public int rangeBitwiseAnd(int m, int n) {
		int max;
		if (n == Integer.MAX_VALUE) {
			max = n;
		} else {
			int temp = (int) (Math.log(m) / Math.log(2));
			max = 2 << temp;
			max = max > n ? n : max;
		}
		int result = m;
		if (m < n) {
			for (int i = max - 1; i >= m; i--) {
				result = result & (i + 1);
				if (result == 0) {
					break;
				}
			}
		} else if (m == n) {
			result = result & result;
		}
		return result;
	}

	public static void main(String[] args) {
		BitwiseOfNumberRange test = new BitwiseOfNumberRange();
		System.out.println(test.rangeBitwiseAnd(2147483646, 2147483647));
	}

}
