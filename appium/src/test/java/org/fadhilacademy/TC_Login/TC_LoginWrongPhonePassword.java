package org.fadhilacademy.TC_Login;

import org.fadhilacademy.BaseTest;
import org.fadhilacademy.pageObjects.android.HomePageVisionPlus;
import org.fadhilacademy.pageObjects.android.LoginPageVisionPlus;
import org.testng.annotations.Test;

public class TC_LoginWrongPhonePassword extends BaseTest {

	@Test
	public void TC_LoginWrongPhonePassword() throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		Thread.sleep(3000);
		homepage.lewatiButton();
		test.info("User berhasil Klik skip button");
		Thread.sleep(3000);
		homepage.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		Thread.sleep(3000);
		login.clickMasukButton();
		test.pass("User berhasil Klik Button Masuk");
		Thread.sleep(3000);
		login.inputPhoneNumber("088219626865");
		test.pass("User berhasil input Phone Number");
		login.clickButtonContinue();
		login.inputPhonePassword("ngasal");
		login.clickButtonContinue();
		login.assertWrongPhonePassword();
		test.pass("hasil Assert sesuai");
		
	}
	
}
