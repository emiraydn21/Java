package Homework5;
/**
 *
 * @author emira
 */
public class Soru4_ReverseInteger {
    public int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            reversed = reversed * 10 + digit;
        }
        
        return reversed;
    }

    public static void main(String[] args) {
        Soru4_ReverseInteger reverseInteger = new Soru4_ReverseInteger();
        int x1 = 123;
        int x2 = -473;
        int x3 = 120;
        System.out.println(reverseInteger.reverse(x1));
        System.out.println(reverseInteger.reverse(x2)); 
        System.out.println(reverseInteger.reverse(x3)); 
    }
}
