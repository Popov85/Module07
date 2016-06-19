package com.goit.g2popov.module07task01;

import java.math.BigDecimal;

/**
 * Class {@code Instrument} specifies guitars as a commodity in the online shop
 * @author  Andrii Popov
 */

public abstract class Instrument {

        // Wholesale price of an instrument
        private BigDecimal wholesalePrice;

        // Retail price of an instrument
        private BigDecimal retailPrice;

        public BigDecimal getRetailPrice() {
                return retailPrice;
        }

        public BigDecimal getWholesalePrice() {
                return wholesalePrice;
        }

        public void setWholesalePrice(BigDecimal wholesalePrice) {
                this.wholesalePrice = wholesalePrice;
        }

        public void setRetailPrice(BigDecimal retailPrice) {
                this.retailPrice = retailPrice;
        }

        public String getInstrumentName() {
                String line = this.getClass().getName();
                String[] parts = line.split("\\.");
                return parts[4];
        }
}
