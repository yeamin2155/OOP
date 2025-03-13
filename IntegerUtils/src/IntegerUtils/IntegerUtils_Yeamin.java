package IntegerUtils;

import java.util.HashSet;
import java.util.Set;

public class IntegerUtils_Yeamin {
	
    /**
     * Determines if the given integer is even by checking its divisibility by 2
     * Straightforward case:
     * isEven(4) returns true
     * 4 divided by 2 has remainder 0
     * 
     * Extreme case:
     * isEven(-2147483648) returns true
     * Minimum integer value is divisible by 2
     * 
     * Bizarre case:
     * isEven(0) returns true
     * Zero divided by 2 has remainder 0
     */
    public static boolean isEven(int k) {
        return (k % 2 == 0);
    }

    /**
     * Determines if a number is odd by checking two conditions:
     * 1. It is not divisible by 2
     * 2. It has a remainder of 1 when divided by 2
     * Straightforward case:
     * isOdd(5) returns true
     * 5 divided by 2 gives remainder 1
     * 
     * Extreme case:
     * isOdd(2) returns false
     * 2 divided by 2 gives remainder 0
     * 
     * Bizarre case:
     * isOdd(0) returns false
     * 0 divided by 2 gives remainder 0
     */
    public static boolean isOdd(int k) {
        return (k % 2 != 0);
    }

    /**
     * Determines if a number is prime using the definition:
     * A number is prime if it is greater than 1 and has exactly two positive divisors: 1 and itself.
     * * Checks if a number is prime using the simplest possible way:
     * 1. First check if the number is bigger than 1
     * 2. Then count its divisors - it should have exactly 2 divisors to be prime
     * 
     * 
     * Examples:
     * 1. Straightforward case:
     * isPrime(2) returns true
     * Greater than 1 and only divisible by 1 and 2
     * 
     * 2. Extreme case:
     * isPrime(-7) returns false
     * Not greater than 1, so cannot be prime
     * 
     * 3. Bizarre case:
     * isPrime(1) returns false
     * Not prime as it only has one divisor (1)
     */
    public static boolean isPrime(int k) {
        if (k <= 1) {
            return false;
        }
        
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * * Finds greatest common factor using two rules:
     * 1. Must divide both numbers exactly (no remainder)
     * 2. Must be the largest such divisor
     * Straightforward case:
     * greatestCommonFactor(3, 3) returns 3
     * 
     * Extreme case:
     * greatestCommonFactor(-1, 1) returns 1
     * Only 1 divides both -1 and 1
     * 
     * Bizarre case:
     * greatestCommonFactor(0, 10) returns 10
     * 10 is the largest number that divides both 0 and 10
     */
    public static int greatestCommonFactor(int m, int n) {
        if (m == 0) return Math.abs(n);
        if (n == 0) return Math.abs(m);
        
        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        
        return Math.abs(m);
    }

    /**
     * Finds GCF of two numbers and subtracts the first number.
     * Straightforward case:
     * getGreatestConstrainedMultiple(3, 3) returns 0
     * GCF of 3,3 is 3, then 3-3 = 0
     * 
     * Extreme case:
     * getGreatestConstrainedMultiple(-1, 1) returns 2
     * GCF of -1,1 is 1, then 1-(-1) = 2
     * 
     * Bizarre case:
     * getGreatestConstrainedMultiple(0, 10) returns 10
     * GCF of 0,10 is 10, then 10-0 = 10
     */
    public static int getGreatestConstrainedMultiple(int k, int maximum) {
        int gcf = greatestCommonFactor(k, maximum);
        return gcf - k;
    }

    /**
     * A customized method for computing a value based on two integers.
     * Examples:
     * - Straightforward: getIntegerH(5, 3) -> 23
     * - Extreme: getIntegerH(0, 1) -> 1
     * - Bizarre/Exotic: getIntegerH(-2, -1) -> -11
     */
    public static int getIntegerH(int h_q_3, int h_r_5) {
        int tripleValue = h_q_3 * 3;      
        int divided = tripleValue / 5;     
        int multiplied = divided * 5;      
        int answer = multiplied + h_r_5;
        return answer;
    }

    /**
     * Finds the biggest number in a Set.
     * Examples:
     * 1. Straightforward case:
     * getMaximum([0, 24]) returns 24
     * Looking at 0 and 24, 24 is bigger
     * 
     * 2. Extreme case:
     * getMaximum([3, 6]) returns 6
     * Looking at 3 and 6, 6 is bigger
     * 
     * 3. Bizarre case:
     * getMaximum([0, 0, 2, 0]) returns 2
     * Among 0,0,2,0 the number 2 is biggest
     */
    public static int getMaximum(Set<Integer> integerSet) {
        if (integerSet == null || integerSet.isEmpty()) {
            throw new IllegalArgumentException("Set cannot be null or empty");
        }
        
        int maxNumber = Integer.MIN_VALUE;
        
        for (int num : integerSet) {
            if (num > maxNumber) {
                maxNumber = num;
            }
        }
        
        return maxNumber;
    }

    /**
     * Checking if array is sorted from smallest to biggest.
     * 
     * 1. Straightforward case:
     * isSorted([2,4,6,8,10]) returns true
     * Numbers go up: 2,4,6,8,10
     * 
     * 2. Extreme case:
     * isSorted([15,15,15]) returns true
     * Same number is fine: 15,15,15
     * 
     * 3. Bizarre case:
     * isSorted([]) returns true
     * Empty array is sorted
     */
    public static boolean isSorted(int[] intArray) {
        if (intArray == null || intArray.length <= 1) {
            return true;
        }
        
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < intArray[i - 1]) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Finds the index of the first occurrence of the target value in the array.
     * Examples:
     * - Straightforward: getSmallestIndexOfMatch({4, 5, 6}, 5) -> 1
     * - Extreme: getSmallestIndexOfMatch({15, 25, 35}, 40) -> -1
     * - Bizarre/Exotic: getSmallestIndexOfMatch({9, 9, 9}, 9) -> 0
     */
    public static int getSmallestIndexOfMatch(int[] intArray, int target) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == target) {
                return i;
            }
        }
        
        return -1;
    }

    /**
     * Finds common decimal digits between two integers.
     * Examples:
     * - Straightforward: getCommonDecimalDigits(456, 654) -> [4, 5, 6]
     * - Extreme: getCommonDecimalDigits(2000, 3333) -> []
     */
    public static Set<Integer> getCommonDecimalDigits(int a, int b) {
        int[] countA = new int[10];
        int[] countB = new int[10];

        while (a > 0) {
            countA[a % 10]++;
            a /= 10;
        }

        while (b > 0) {
            countB[b % 10]++;
            b /= 10;
        }

        Set<Integer> commonDigits = new HashSet<>();
        
        for (int i = 0; i < 10; i++) {
            if (countA[i] > 0 && countB[i] > 0) {
                commonDigits.add(i);
            }
        }

        return commonDigits;
    }

    /**
     * Reverses the digits of a number.
     * Examples:
     * - Straightforward: reverse(987) -> 789
     * - Extreme: reverse(5000) -> 5
     * - Bizarre/Exotic: reverse(-789) -> -987
     */
    public static int reverse(int k) {
        int reversed = 0;
        boolean isNegative = k < 0;
        if (isNegative) {
            k = -k;
        }

        while (k != 0) {
            reversed = reversed * 10 + k % 10;
            k /= 10;
        }

        return isNegative ? -reversed : reversed;
    }

    /**
     * Straightforward: sumthing(12345) -> 6
     * Extreme: sumthing(100000000) -> 1
     * Bizarre/Exotic: sumthing(987654321) -> 9
     */
    public static int sumthing(long k) {
        if (k < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }

        int sum = 0;
        while (k > 0) {
            sum += k % 10;
            k /= 10;
        }

        while (sum >= 10) {
            sum = sumOfDigits(sum);
        }

        return sum;
    }

    
    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}


	
	
	
	
	
