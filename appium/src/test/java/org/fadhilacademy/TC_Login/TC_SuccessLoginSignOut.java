package org.fadhilacademy.TC_Login;

import org.fadhilacademy.BaseTest;
import org.fadhilacademy.pageObjects.android.HomePageVisionPlus;
import org.fadhilacademy.pageObjects.android.LainnyaMenuPage;
import org.fadhilacademy.pageObjects.android.LoginPageVisionPlus;
import org.fadhilacademy.pageObjects.android.PengaturanPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class TC_SuccessLoginSignOut extends BaseTest{
	
	@Test
	public void TC_SuccessLoginSignOut () throws InterruptedException{
		
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		Thread.sleep(3000);
		homepage.lewatiButton();
		test.info("User berhasil Klik skip button");
		Thread.sleep(3000);
		homepage.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		login.clickMasukButton();
		test.info("User berhasil Klik Button Masuk");
		login.LoginVisionPlus("phone", "088219626865", "4321lupa");
		login.clickButtonContinue();
		test.pass("User memilih login dengan Phone");
		homepage.removePopupSub();
		homepage.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		Thread.sleep(3000);
		LainnyaMenuPage lainnya = new LainnyaMenuPage(android);
		lainnya.pengaturanLainnya();
		PengaturanPage pengaturan = new PengaturanPage(android);
		pengaturan.SignOut();
		test.info("User berhasil Sign out dari Aplikasi");
		Thread.sleep(3000);
	}
	
	
}
