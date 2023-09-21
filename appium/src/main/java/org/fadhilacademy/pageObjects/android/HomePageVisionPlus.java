package org.fadhilacademy.pageObjects.android;

import org.fadhilacademy.utils.AndroidGesture;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageVisionPlus extends AndroidGesture{

	AndroidDriver android;
	
	public HomePageVisionPlus(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_notification")
	private WebElement removePopupSub;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Lainnya\"]")
	private WebElement lainnyaButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_skip_intro")
	private WebElement skipButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_showcase_category_oke")
	private WebElement btnShowcaseOk;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_connect")
	private WebElement btnShowcaseTvConnect;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Gaya Hidup & Hobi']")
	private WebElement textGayaHidup;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/iv_presentation")
	private WebElement banner;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_see_more")
	private WebElement btnSelengkapnya;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_cluster")
	private WebElement clickRandom;
	
	public void clickBtnShowcaseTvConnect() {
		btnShowcaseTvConnect.click();
	}
	
	public void clickRandom() {
		clickRandom.click();
	}
	
	public void clickBtnSelengkapnya() {
		btnSelengkapnya.click();
	}
	
	public void scrollToText(String text) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollToText(text);
	}
	
	public void scrollDownNoParameter() {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollDownNoParameter();
	}
	
	public void scrollUpNoParameter() {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollUpNoParameter();
	}
	
	public void clickBtnShowcaseOk() {
		btnShowcaseOk.click();
	}
	
	public void removePopupSub() {
		removePopupSub.click();
	}
	
	public void lainnyaButton() {
		lainnyaButton.click();
	}
	
	public void lewatiButton() {
		skipButton.click();
	}
	
}
