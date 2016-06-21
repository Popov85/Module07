package com.goit.g2popov.module07task01;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Class {@code Prices} defines prices on all instruments
 * @author  Andrii Popov
 */

public class Prices {

        // Current retail prices of instruments
        private static Map<String,BigDecimal> prices = new HashMap<String, BigDecimal>();

        public static Map<String, BigDecimal> getPrices() {
                return prices;
        }

        public static void setPrices(Map<String, BigDecimal> prices) {
                Prices.prices = prices;
        }

        public static void changePrices(String instrument, BigDecimal newPrice) {
                Prices.prices.put(instrument,newPrice);
        }

        public static BigDecimal getPrice(String instrument) {
                return Prices.getPrices().get(instrument);
        }
}
