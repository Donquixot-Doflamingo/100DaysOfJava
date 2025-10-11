package org.dsa.revamp.easy;

public class PalindromeNumber {
    public boolean solution(int x) {
        // remove the cases where the number is negative or zero divisible by 10 as they will be false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        // until the x is not smaller than reversed it won't be small
        while (x > reversed) {
            // picking the last element of current x
            reversed = (reversed * 10) + (x % 10);
            // removig the last element of x from x
            x = x / 10;
        }
        // in case of even the like 1221 the number will perfectly halved but in case of
        // 121 the rev will reach 12 and x will be 1
        //so we divide the reversed by 10 to make it reach to x level and compare them
        return (reversed == x) || ((reversed / 10) == x);
    }
}
