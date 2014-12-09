/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

import java.math.BigDecimal;

/**
 *
 * @author Yellow Flash
 */
public class RoundUp {
    public static Float precision(int decimalPlace, Float d) {

    BigDecimal bd = new BigDecimal(Float.toString(d));
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_UP);
    return bd.floatValue();
  }
}
