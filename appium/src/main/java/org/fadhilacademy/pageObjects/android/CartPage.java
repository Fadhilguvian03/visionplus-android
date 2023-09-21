package org.fadhilacademy.pageObjects.android;

import java.util.List;

import org.fadhilacademy.utils.AndroidGesture;
import org.fadhilacademy.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidGesture{
	
	AndroidDriver android;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrices;
	
	public CartPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	public void termsButtonLongPress() {
		LongPress(termsButton);
		android.findElement(By.id("android:id/button1")).click();
	}
	
	public void clickCheckbox() {
		checkBox.click();
	}
	
	public void clickProceed() {
		proceedButton.click();
	}
	
	public void checkPriceAssert() {
		int size = productPrices.size();
		
        int count = productPrices.size();
		
		double totalSum = 0;
		double tolerance = 0.01;
		for(int i = 0; i < count;i++) {
			String amountString = productPrices.get(i).getText();
			Double price = Double.parseDouble(amountString.substring(1));
			totalSum = totalSum + price;	
		}
		
		String displaySum = android.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double hasilnya = Double.parseDouble(displaySum.substring(1));
		
		Assert.assertEquals(totalSum, hasilnya, tolerance, "Total harga tidak sesuai");
	}
	
	

}
