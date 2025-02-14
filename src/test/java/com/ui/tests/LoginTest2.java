package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {
	
public static void main(String args []) {
	
	WebDriver wd=new ChromeDriver();
	HomePage hp=new HomePage(wd);
	LoginPage loginPage=hp.gotoLoginPage();
	loginPage.doLoginWith("bloggerdelhi123@gmail.com", "Password");
}
}
