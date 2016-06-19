package com.goit.g2popov.module07task01;

import java.math.BigDecimal;

/**
 * Class {@code Guitar} specifies guitars as a commodity in the online shop
 * @author  Andrii Popov
 */

public class Guitar extends Instrument {

        public Guitar() {
                super();
                this.setRetailPrice(Prices.getPrice("Guitar"));
        }
}
