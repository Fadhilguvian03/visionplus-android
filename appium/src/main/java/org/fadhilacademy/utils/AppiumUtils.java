package org.fadhilacademy.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {
	
	AndroidDriver android;
	
	public AppiumUtils(AndroidDriver driver) {
		this.android = android;
	}
	
	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(android, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, "text", "Cart"));
	}

}
