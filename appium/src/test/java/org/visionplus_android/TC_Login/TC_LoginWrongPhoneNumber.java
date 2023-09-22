package org.visionplus_android.TC_Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.visionplus_android.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;

public class TC_LoginWrongPhoneNumber extends BaseTest {
	
	
	@Test(dataProvider="getData")
	public void TC_LoginWrongPhoneNumber(HashMap<String, String> input) throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		homepage.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		login.clickMasukButton();
		login.inputPhoneNumber(input.get("phone"));
		test.info("User input nomor yang salah");
		login.clickButtonContinue();
		login.assertWrongPhoneNumber();
		test.pass("hasil Assert sesuai");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/org/fadhilacademy/TestData/LoginTestdata/TC_loginWrongPhoneNumber.json");
		return new Object[][] {{data.get(0)}};
		
	}

}
