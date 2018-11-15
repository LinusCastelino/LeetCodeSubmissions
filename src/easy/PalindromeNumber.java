// https://leetcode.com/problems/palindrome-number/description/

package easy;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		else {
			String num = ""+x;
			String revCopy = "";
			for(int i = num.length()-1; i>=0; i--)
				revCopy += num.charAt(i);
			
			if(num.equals(revCopy)) return true;
			else return false;
		}
        
    }
}
