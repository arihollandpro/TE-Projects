package com.techelevator;

import java.math.BigDecimal;

public class experiment {
    public static void main(String[] args) {

        BigDecimal balance = BigDecimal.valueOf(7.35);


//        public BigDecimal returnChange (BigDecimal balance){
            BigDecimal totalCents = balance.multiply(BigDecimal.valueOf(100));

            BigDecimal quarters = totalCents.divide(BigDecimal.valueOf(25));
            BigDecimal remaining = quarters.remainder(totalCents);
            remaining = quarters.subtract(remaining.multiply(BigDecimal.valueOf(0.25)));

        System.out.println(remaining);

//            BigDecimal dimes = remaining.divide(BigDecimal.valueOf(10));
//            BigDecimal remaining2 = dimes.remainder(remaining);
//            remaining2 = dimes.subtract(remaining2.multiply(BigDecimal.valueOf(0.10)));
//
//            BigDecimal nickels = remaining2.divide(BigDecimal.valueOf(5));
//
//           return

        }

    }



