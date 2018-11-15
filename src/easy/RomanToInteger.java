/*
 * https://leetcode.com/problems/roman-to-integer/description/
 */

package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RomanToInteger {
	public static int romanToInt(String s) {
        int intValue = 0;
        
        Map<String, Integer> symbols = new HashMap<String, Integer>();
        symbols.put("I", 1);
        symbols.put("V", 5);
        symbols.put("X", 10);
        symbols.put("L", 50);
        symbols.put("C", 100);
        symbols.put("D", 500);
        symbols.put("M", 1000);
        
        
        Map<String, Integer> exceptions = new HashMap<String, Integer>();
        exceptions.put("IV", 4);
        exceptions.put("IX", 9);
        exceptions.put("XL", 40);
        exceptions.put("XC", 90);
        exceptions.put("CD", 400);
        exceptions.put("CM", 900);
        
        for(Entry<String, Integer> entry : exceptions.entrySet()) {
        	while(s.length()!= 0 && s.contains(entry.getKey())) {
        		intValue += entry.getValue();
        		int index = s.indexOf(entry.getKey());
        		s = s.substring(0, index) + s.substring(index+2, s.length());
        	}
        	if(s.length() == 0 )
        		break;    // to reduce execution time
        }
        
        for(int i=0; i<s.length(); i++) {
        	intValue += symbols.get(""+s.charAt(i));
        }
        
        return intValue;
    }
	
	public static void main(String arg[]) {
		System.out.println(romanToInt("MCMXCIV"));
	}
}
