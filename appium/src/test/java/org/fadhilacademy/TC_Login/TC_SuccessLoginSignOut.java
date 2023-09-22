package org.fadhilacademy.TC_Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.fadhilacademy.BaseTest;
import org.fadhilacademy.pageObjects.android.HomePageVisionPlus;
import org.fadhilacademy.pageObjects.android.LainnyaMenuPage;
import org.fadhilacademy.pageObjects.android.LoginPageVisionPlus;
import org.fadhilacademy.pageObjects.android.PengaturanPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class TC_SuccessLoginSignOut extends BaseTest{
	
	
	@Test(dataProvider="getData")
	public void TC_SuccessLoginSignOut (HashMap<String, String> input) throws InterruptedException{
		
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		homepage.lewatiButton();
		test.info("User berhasil Klik skip button");
		homepage.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		login.clickMasukButton();
		test.info("User berhasil Klik Button Masuk");
		login.LoginVisionPlus(input.get("loginWith"), input.get("username"), input.get("password"));
		login.clickButtonContinue();
		test.pass("User memilih login dengan Phone");
		homepage.removePopupSub();
		homepage.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		LainnyaMenuPage lainnya = new LainnyaMenuPage(android);
		lainnya.pengaturanLainnya();
		PengaturanPage pengaturan = new PengaturanPage(android);
		pengaturan.SignOut();
		test.info("User berhasil Sign out dari Aplikasi");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/org/fadhilacademy/TestData/LoginTestdata/login.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
	
}
