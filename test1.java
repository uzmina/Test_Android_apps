import java.net.URL;
import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import static org.junit.Assert.assertEquals;

public class test1 {
@SuppressWarnings("rawtypes")
AppiumDriver driver;
String invalidEmail = "auto_android@mailinator.com";
String password = "test";
String validEmail ="uzmina@hotmail.com";
String errMsg = "Invalid email or password.";
String genreErrMsg = "Please select at least one genre to continue.";
String logOutConfirmMsg = "You have been logged out of the application.";
String signupText = "Sign Up or Log In";
String connectProtocol1 = "Please connect to your car stereo";
String connectProtocol2 = "using Bluetooth or AUX cable.";
@SuppressWarnings("rawtypes")

@Before

public void setUp() throws Exception{
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("deviceName","SAMSUNG-SM-G920V");
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	
	
}

@Test
public void fux() throws InterruptedException,Exception{
	//maybe later button
	WebElement maybeLaterButton = (new WebDriverWait(driver,700)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.clearchannel.iheartradio.connect:id/maybe_later_btn")));
	maybeLaterButton.click();
	//select genre-negative
	WebElement continueBtn = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/continue_button"));
	continueBtn.click();
	
	WebElement errPopup = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/text_desc"));
	assertEquals(errPopup.getText(),genreErrMsg);
	
	WebElement errPopBtn = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/button_white_top"));
	errPopBtn.click();
	//select genre positive
	WebElement genre1 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/item_name"));
	genre1.click();
	WebElement continueBtn1 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/continue_button"));
	continueBtn1.click();

//options button
	WebElement optionsButton = (new WebDriverWait(driver,70)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.clearchannel.iheartradio.connect:id/options_btn")));
	optionsButton.click();
	
    WebElement authenticatebtn = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/signup_or_login"));
    authenticatebtn.click();
		
	WebElement loginButton = (new WebDriverWait(driver,700)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.clearchannel.iheartradio.connect:id/login_btn")));
	//WebElement loginButton = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/login_btn"));
	loginButton.click();
	//enter content on in email textfield
	WebElement emailTextField = (new WebDriverWait(driver,700)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.clearchannel.iheartradio.connect:id/email_text")));
	emailTextField.sendKeys(invalidEmail);
	WebElement nextButton = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/next_btn"));
	nextButton.click();
	//enter values in pwd field
	WebElement pwdField = (new WebDriverWait(driver,70)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.clearchannel.iheartradio.connect:id/password_text")));
	pwdField.sendKeys(password);
	WebElement nextButton1 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/next_btn"));
	nextButton1.click();
	WebElement doneButton = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/next_btn"));
	doneButton.click();
	
	//conforming error dialog
	
	WebElement errDesc1 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/text_desc"));
	assertEquals(errDesc1.getText(),errMsg);
	
	
	//close error pop up
	WebElement errCloseBtn = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/button_white_top"));
	errCloseBtn.click();
	emailTextField.clear();
	
	//WebElement emailTextField1 = (new WebDriverWait(driver,70)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.clearchannel.iheartradio.connect:id/email_text")));
	emailTextField.sendKeys(validEmail);
	WebElement nextButton2 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/next_btn"));
	nextButton2.click();
	//enter values in pwd field
	/*pwdField.clear();
	WebElement pwdField1 = (new WebDriverWait(driver,70)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.clearchannel.iheartradio.connect:id/password_text")));
	
	pwdField1.sendKeys(password);*/
	WebElement nextButton3= driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/next_btn"));
	nextButton3.click();
	WebElement doneButton1 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/next_btn"));
	doneButton1.click();
	//verify user is prompted to connect to AUX
	
	WebElement cp1 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/connect_text_1"));
	assertEquals(cp1.getText(),connectProtocol1);
	WebElement cp2 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/connect_text_2"));
	assertEquals(cp2.getText(),connectProtocol2);
	WebElement optionsButton1 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/options_btn"));
	optionsButton1.click();
	
	WebElement userid = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/loggedIn_email"));
	userid.click();
	
	WebElement logoutBtn = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/button_red_top"));
	logoutBtn.click();
	
	WebElement logoutConfirm = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/text_desc"));
	assertEquals(logoutConfirm.getText(),logOutConfirmMsg);
	WebElement logoutConfirmBtn = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/button_white_top"));
	logoutConfirmBtn.click();
	
	WebElement userid1 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/signup_or_login"));
	assertEquals(userid1.getText(),signupText);
	
	//tap on done button to be back on sign/login 
	WebElement done1 = driver.findElement(By.id("com.clearchannel.iheartradio.connect:id/option_done_btn"));
	done1.click();
}	


@After
public void tearDown() throws Exception{
	//driver.quit();
}
}
