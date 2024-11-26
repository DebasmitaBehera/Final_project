package com.Easy_Purse.S_S.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public int getrandomnu() {
		Random random = new Random();
		int randomnumber = random.nextInt(5000);
		return randomnumber;
	}

}
