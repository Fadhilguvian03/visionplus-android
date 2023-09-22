package org.fadhilacademy.TC_Homepage;

import java.time.Duration;
import java.util.Collections;

import org.fadhilacademy.BaseTest;
import org.fadhilacademy.pageObjects.android.HomePageVisionPlus;
import org.fadhilacademy.pageObjects.android.LoginPageVisionPlus;
import org.fadhilacademy.utils.AndroidGesture;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class TC_ScrollDownUp extends BaseTest{
	
	@Test
	public void TC_ScrollDownUp() throws InterruptedException {
	HomePageVisionPlus homepage = new HomePageVisionPlus(android);
	LoginPageVisionPlus login = new LoginPageVisionPlus(android);
	homepage.lewatiButton();
	test.pass("User berhasil Klik skip button");
	homepage.clickBtnShowcaseTvConnect();
	test.pass("User berhasil Klik Button Showcase TV Connect");
	homepage.clickBtnShowcaseOk();
	test.pass("User berhasil Klik Button Showcase OK");
	homepage.scrollDownNoParameter();
	homepage.assertTextExploreByCategories();
    Thread.sleep(3000);
	test.pass("user berhasil Scrolldown Homepage");
	homepage.scrollUpNoParameter();
	homepage.assertTextVisionPlusOriginal();
    Thread.sleep(3000);
    test.pass("user berhasil Scrollup Homepage");
	}
	
	

}
