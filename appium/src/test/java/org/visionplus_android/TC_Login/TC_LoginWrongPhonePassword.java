package org.visionplus_android.TC_Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.visionplus_android.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;

public class TC_LoginWrongPhonePassword extends BaseTest {

	@Test(dataProvider="getData")
	public void TC_LoginWrongPhonePassword(HashMap<String, String> input) throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		homepage.lewatiButton();
		test.info("User berhasil Klik skip button");
		homepage.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		login.clickMasukButton();
		test.pass("User berhasil Klik Button Masuk");
		login.inputPhoneNumber(input.get("phone"));
		test.pass("User berhasil input Phone Number");
		login.clickButtonContinue();
		login.inputPhonePassword(input.get("password"));
		login.clickButtonContinue();
		login.assertWrongPhonePassword();
		test.pass("hasil Assert sesuai");
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/org/fadhilacademy/TestData/LoginTestdata/TC_loginWrongPhonePassword.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
}
