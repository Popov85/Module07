package com.goit.g2popov.module07task01;

import java.math.BigDecimal;

/**
 * Class {@code CashDesk} emulates a cash desk of a real online shop
 * This class is accessible from all parts of the app to increase
 * or decrease the current sum of money in the cash desk
 * @author  Andrii Popov
 */
public class CashDesk {

        // Specifies how much money is left in the cash desk
        private static BigDecimal currentSum;

        public static BigDecimal getCurrentSum() {
                return currentSum;
        }

        public static void setCurrentSum(BigDecimal currentSum) {
                CashDesk.currentSum = currentSum;
        }

        public static void increaseCurrentSum(BigDecimal addition) {
                CashDesk.currentSum = CashDesk.currentSum.add(addition);
        }

        public static void decreaseCurrentSum(BigDecimal subtraction) {
                CashDesk.currentSum = CashDesk.currentSum.subtract(subtraction);
        }
}
