package com.goit.g2popov.module07task01;

/**
 * Class {@code Trumpet} specifies trumpets as a commodity in the online shop
 * @author  Andrii Popov
 */

public class Trumpet extends Instrument {
        public Trumpet() {
                super();
                this.setRetailPrice(Prices.getPrice("Trumpet"));
        }
}
