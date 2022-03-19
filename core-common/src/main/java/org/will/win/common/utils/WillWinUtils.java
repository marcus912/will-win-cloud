package org.will.win.common.utils;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class WillWinUtils {

  static final private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
  final private Random r = new Random(System.currentTimeMillis());

  public int generatePoNumber() {
    int n = r.nextInt(99999);
    return n;
  }

  static public String concatPurchaseOrderNumber(Date purchaseDate, int orderNumber) {
    return String.format("%s-%05d", format.format(purchaseDate), orderNumber);
  }

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    WillWinUtils willWinUtils = new WillWinUtils();
    for (int i = 0; i < 5000; i++) {
      int n = willWinUtils.generatePoNumber();
      System.out.println(n);
      set.add(n);
    }
    System.out.println(String.format("Size: %d", set.size()));
  }
}
