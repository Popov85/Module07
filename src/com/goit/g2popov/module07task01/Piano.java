package com.goit.g2popov.module07task01;

/**
 * Class {@code Piano} specifies pianos as a commodity in the online shop
 * @author  Andrii Popov
 */

public class Piano extends Instrument {
        public Piano() {
                super();
                this.setRetailPrice(Prices.getPrice("Piano"));
        }
}
