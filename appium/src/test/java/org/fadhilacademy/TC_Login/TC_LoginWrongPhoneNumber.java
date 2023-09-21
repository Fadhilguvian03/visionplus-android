package org.fadhilacademy.TC_Login;

import org.fadhilacademy.BaseTest;
import org.fadhilacademy.pageObjects.android.HomePageVisionPlus;
import org.fadhilacademy.pageObjects.android.LoginPageVisionPlus;
import org.testng.annotations.Test;

public class TC_LoginWrongPhoneNumber extends BaseTest {
	
	
	@Test
	public void TC_LoginWrongPhoneNumber() throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		Thread.sleep(3000);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(4000);
		homepage.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		login.inputPhoneNumber("088219626865322");
		test.info("User input nomor yang salah");
		login.clickButtonContinue();
		login.assertWrongPhoneNumber();
		test.pass("hasil Assert sesuai");
	}

}
