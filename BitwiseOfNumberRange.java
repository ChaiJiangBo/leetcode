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
	//看了别人的答案，不得不承认，自己的解法很丑，不能普适，现增加两个方法
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
	/*
	我们发现，结果只与这些数中最左边“最长”的相等的部分有关，因此，我们可以将 m 和 n 不断右移
	（题目中说了 m 和 n 不是负数，所以不存在右移符号位的问题），移到相等的时候为止。
	同时记录移动的步数。最后将相等的部分左移之前的步数（相当于补 0），就是最终要求的数。

	思路2：位运算做得题多了，我们就会知道与运算的一条性质：n & (n - 1) 可以将 n 最右边的 1 变成 0 ，
	这件事情也是很酷的，因为其实不仅把 1 变成了 0，还跳过了很多 0，
	所以我们从暴力解法的反方向去思考，倒着做按位与，就可以很快得到解了。
	*/
	
	public int rangeBitwiseAnd2(int m, int n) {
		while (n > m) {
            n &= (n - 1);
        }
        return n;
	}
	public int rangeBitwiseAnd3(int m, int n) {
		int count = 0;
		while(m != n) {
			m = m >> 1;
			n = n >> 1;
			count ++;
		}
		return (m << count);
	}

	public static void main(String[] args) {
		BitwiseOfNumberRange test = new BitwiseOfNumberRange();
		System.out.println(test.rangeBitwiseAnd(2147483646, 2147483647));
	}

}
