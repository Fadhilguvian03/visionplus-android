package org.visionplus_android.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.visionplus_android.utils.AndroidGesture;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidGesture {
	
	AndroidDriver android;

	public FormPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement loginButton;
	
	public void setName(String name) {
		nameField.sendKeys(name);
	}
	
	public void pressLoginButton() {
		loginButton.click();
	}
	
	public void setCountrySelection(String Text) {
		countrySelection.click();
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollToText(Text);
		android.findElement(By.xpath("//android.widget.TextView[@text='"+Text+"']")).click();
	}
	
	public void setGender(String gender) {
		if(gender.equalsIgnoreCase("Male")) {
			maleOption.click();
		} else {
			femaleOption.click();
		}
	}
	
}
