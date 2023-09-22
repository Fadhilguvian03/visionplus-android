package org.visionplus_android.pageObjects.android;

import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.visionplus_android.utils.AndroidGesture;

public class LoginPageVisionPlus extends AndroidGesture{

	AndroidDriver android;
	
	public LoginPageVisionPlus(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_sign_in")
	private WebElement masukButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_register")
	private WebElement withEmail;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_google")
	private WebElement withGoogle;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_facebook")
	private WebElement withFacebook;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/et_phone")
	private WebElement withPhone;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/et_email")
	private WebElement emailTextbox;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/et_password")
	private WebElement passwordEmailTextbox;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_continue")
	private WebElement continueButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/et_password")
	private WebElement passwordPhoneTextbox;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_error_message")
	private WebElement textWrongPhoneNumber;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_msg_popup")
	private WebElement textWrongPhonePassword;
	
	
	public void clickButtonContinue() {
		continueButton.click();
	}
	
	public void assertWrongPhonePassword() {
		String expected = "Invalid password";
		String actual = textWrongPhonePassword.getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void assertWrongPhoneNumber() {
		String expected = "Format nomor handphone salah";
		String actual = textWrongPhoneNumber.getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void inputPhoneNumber(String phoneNumber) {
		withPhone.click();
		withPhone.sendKeys(phoneNumber);
	}
	
	public void inputPhonePassword(String phonePassword) {
		passwordPhoneTextbox.click();
		passwordPhoneTextbox.sendKeys(phonePassword);
	}
	
	public void clickLoginWithEmail() {
		withEmail.click();
	}
	
	public void clickMasukButton() {
		masukButton.click();
	}
	
	public void LoginVisionPlus(String loginWith, String username, String password) throws InterruptedException {
		
		if(loginWith.equalsIgnoreCase("email")) {
			withEmail.click();
			emailTextbox.click();
			emailTextbox.sendKeys(username);
			continueButton.click();
			passwordEmailTextbox.click();
			passwordEmailTextbox.sendKeys(password);
		} else if(loginWith.equalsIgnoreCase("google")) {
			withGoogle.click();
		} else if(loginWith.equalsIgnoreCase("facebook")) {
			withFacebook.click();
		} else if(loginWith.equalsIgnoreCase("phone")) {
			Thread.sleep(5000);
			withPhone.click();
			withPhone.sendKeys(username);
			continueButton.click();
			passwordPhoneTextbox.click();
			passwordPhoneTextbox.sendKeys(password);
		} else {
			System.out.println("Wrong Input Method Login");
		}
		
		Thread.sleep(3000);
	}
	
	
}
