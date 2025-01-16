package com.Xsalts.TestCases;

import org.testng.annotations.Test;

public class dummy {
	dummy2 two;
	@Test
	public void launch() 
	{
		two = new dummy2();
		two.one();
	}
	@Test
	public void runch() 
	{
		two.onetwo();
	}

}
