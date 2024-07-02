package com.durga;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Locale;

public class Durga {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2020, 01, 05);
		LocalDate currentDate = LocalDate.now();
		int years = Period.between(date, currentDate).getYears();
        System.out.println(years);
	}

}
