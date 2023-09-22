package org.visionplus_android.utils;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidGesture extends AppiumUtils {
	
	AndroidDriver android;
	
	public AndroidGesture(AndroidDriver android) {
		super(android);
		this.android = android;
	}
	
	public void scrollToText(String text) {
		android.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
	}
	
	public void scrollDownNoParameter() {
		Dimension size = android.manage().window().getSize();
	    int startX = size.getWidth() / 2;
	    int startY = size.getHeight() / 2;
	    int endX = startX;
	    int endY = (int) (size.getHeight() * 0.05);
	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    Sequence sequence = new Sequence(finger1, 1)
	        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(200)))
	        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    android.perform(Collections.singletonList(sequence));
	}
	
	public void scrollUpNoParameter() {
		Dimension size = android.manage().window().getSize();
	    int startX = size.getWidth() / 2;
	    int startY = size.getHeight() / 2;
	    int endX = startX;
	    int endY = (int) (size.getHeight() * 1);
	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    Sequence sequence = new Sequence(finger1, 1)
	        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(200)))
	        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    android.perform(Collections.singletonList(sequence));
	}

	public void LongPress(WebElement peopleNames) {
		((JavascriptExecutor) android).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) peopleNames).getId(), "duration",2000));
	}
	
	public void SwipeGesture(WebElement firstElement) {
		((JavascriptExecutor) android).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) firstElement).getId(),
			    "direction", "left",
			    "percent", 0.75
			));
	}
	
}
