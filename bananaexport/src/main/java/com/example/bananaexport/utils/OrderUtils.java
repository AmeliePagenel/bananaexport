package com.example.bananaexport.utils;

import java.util.Calendar;
import java.util.Date;

public class OrderUtils {

	public static Date calculateDeliveryDate() {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(today);
		calendar.add(Calendar.DATE, 10);

		return calendar.getTime();
	}

	public static boolean isQuantityValid(int quantity) {
		if (quantity <= 0 || quantity > 10000) {
			return false;
		} else if (quantity % 25 != 0) {
			return false;
		} else {
			return true;
		}
	}

	public static double calculateDeliveryPrice(int quantity) {
		double price = quantity * 2.5;
		return price;
	}

}
