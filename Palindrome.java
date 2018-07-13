package leetcode.test.chaijb;

/**
 * @author Lrving
 * @category 回文数
 */
public class Palindrome {

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		boolean flag = palindrome.isPalindrome(12321);
		System.out.println(flag);

	}

	private boolean isPalindrome(int x) {
		String numStr = String.valueOf(x);
		char[] charArr1 = numStr.toCharArray();
		char[] charArr2 = new char[charArr1.length];
		for (int i = 0; i < charArr1.length; i++) {
			charArr2[i] = charArr1[charArr1.length-i-1];
		}
		String str1 = String.valueOf(charArr1);
		String str2 = String.valueOf(charArr2);
		if (str1.equals(str2)) {
			return true;
		}
		return false;
	}
}
