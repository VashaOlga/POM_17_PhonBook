package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthenticationScreen extends BaseScreen{

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement editTextEmail;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement editTextPassword;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/regBtn']")
    MobileElement registrationButton;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
    MobileElement loginButton;

    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

//    public void login(){
//        type(editTextEmail,"0612test@mail.com");
//        type(editTextPassword,"14253Asd@");
//        loginButton.click();
//    }

    public AuthenticationScreen fillEmail(String email){
        should(editTextEmail,5);
        type(editTextEmail,email);
        return this;
    }

    public AuthenticationScreen fillPassword(String password){
//        should(editTextPassword,5);
        type(editTextPassword,password);
        return this;
    }

    public ContactListScreen submitLogin(){
        loginButton.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen loginCW(Auth auth){
        should(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        loginButton.click();
        return new ContactListScreen(driver);
    }

    public AuthenticationScreen loginRegistrationForm(Auth auth){
        should(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        return this;
    }

    public ContactListScreen submitRegistration(){
        registrationButton.click();
        return new ContactListScreen(driver);
    }

    public AuthenticationScreen submitRegistrationNegative(){
        registrationButton.click();
        return this;
    }

//    public AuthenticationScreen isErrorMessageContainsText(String text){
//        Alert alert = new WebDriverWait(driver,5)
//                .until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert();
//        Assert.assertTrue(alert.getText().contains(text));
//        alert.accept();
//        return this;
//    }

}
