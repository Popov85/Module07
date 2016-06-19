package com.goit.g2popov.module07task01;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Class {@code Runner} Module 07 task 01
 * Task 01. Find anti-patterns in the code
 * Anti-pattern: double as price
 * Solution: replace double by BigDecimal (much safer)
 * Test example gives us the following:
 * double sum = 1.14d;
 * BigDecimal sum1 = new BigDecimal("1.14");
 * System.out.println(sum*75);
 * System.out.println(sum1.multiply(new BigDecimal("75")));
 * 85.49999999999999
 * 85.50
 * Loss of accuracy is obvious
 * So we have fixed this
 */
public class Runner {
        public static void main (String[] args) throws Exception {
                // Set prices on instruments
                Prices.changePrices("Piano", new BigDecimal("9700.75"));
                Prices.changePrices("Trumpet", new BigDecimal("6655.35"));
                Prices.changePrices("Guitar", new BigDecimal("2999.90"));
                // Create instances of musical instruments
                Instrument aPiano = new Piano();
                Instrument aTrumpet = new Trumpet();
                Instrument aGuitar = new Guitar();
                CashDesk.setCurrentSum(new BigDecimal("500000"));
                // Fill StoreHouse with some musical instruments
                HashMap<Instrument, Integer> mapInstance = new HashMap<Instrument, Integer>();
                mapInstance.put(aPiano, 200);
                mapInstance.put(aTrumpet, 700);
                mapInstance.put(aGuitar, 1600);
                StoreHouse.setStock(mapInstance);
                // Print the current state of StoreHouse
                StoreHouse.printStockState();
                /*Let's make a dozen of orders to be printed out and add them to an ArrayList*/
                List<Order> orderList = createOrders(12, aPiano, aTrumpet, aGuitar);
                // Traverse through the list of orders made and prepareInstruments
                prepareAllInstruments(orderList);
                // Print the current state of StoreHouse
                StoreHouse.printStockState();
                // See the current state of the cash desk
                System.out.println("Money left: " + CashDesk.getCurrentSum());
        }

        /**
         * Fills an ArrayList with test Orders
         * Each order may contain x-pianos, y-guitars, z-trumpets
         * If all x,y,z are zeros - order is considered to be cancelled
         * x,y,z [0-3]
         * @param quantity
         * @return
         */
        private static List<Order> createOrders(int quantity, Instrument aPiano, Instrument aTrumpet, Instrument aGuitar) throws MoreThanIsLeftException {
                Random rand = new Random();
                List<Order> orders = new ArrayList<Order>();
                for (int i = 1; i <= quantity; i++) {
                        // Randomly select the quantity of each instrument in an order
                        int randPiano = rand.nextInt(4);
                        int randGuitar = rand.nextInt(4);
                        int randTrumpet = rand.nextInt(4);
                        if (randPiano == 0 && randGuitar == 0 && randTrumpet == 0 ) {
                                System.out.println("User has changed his mind and refused to buy anything");
                        }
                        else {
                                Order myOrder = new Order();
                                myOrder.addItem(randPiano, aPiano);
                                myOrder.addItem(randTrumpet, aTrumpet);
                                myOrder.addItem(randGuitar, aGuitar);
                                // Put just created Order object to ArrayList
                                orders.add(myOrder);
                        }
                }
                return orders;
        }

        /**
         * Ships all the prepared orders and replenishes the shop's treasury
         * @param orderList
         * @throws Exception
         */
        private static void prepareAllInstruments(List<Order> orderList) throws Exception {
                for (Order nextOrder : orderList) {
                        nextOrder.prepareInstruments();
                }
        }
}
