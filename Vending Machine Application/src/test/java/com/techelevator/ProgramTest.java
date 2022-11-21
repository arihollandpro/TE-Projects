package com.techelevator;

import com.techelevator.Items;
import com.techelevator.Program;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProgramTest {

	@Test
	public void sample_test_always_passes() {
		Assert.assertTrue("Sample message", true);
	}
//
//	@Test
//	public void total_Cents_Test () {
//		BigDecimal returnChange
//	}

//	@Test
//	public void getAmountAvailableTest () {
//		Items testItem = new Items("kitkat", "K1", 1.75);
//		int actual = Program.getAmountAvailable(7,testItem.getQuantity());
//		int actual2 = testItem.getQuantity();
//		Assert.assertEquals(2, actual);
//
//	}

}
