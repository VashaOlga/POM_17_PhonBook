import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess(){
        boolean res = new SplashScreen(driver).gotoAuthenticationScreen()
                .fillEmail("0612test@mail.com")
                .fillPassword("14253Asd@")
                .submitLogin()
                .isContactListPresent();
        Assert.assertTrue(res);

    }

    @Test
    public void loginSuccessModel(){
        boolean res = new SplashScreen(driver).gotoAuthenticationScreen()
                .loginCW(Auth.builder()
                        .email("0612test@mail.com")
                        .password("14253Asd@").build())
                .isContactListPresent();
        Assert.assertTrue(res);
    }

    @AfterMethod
    public void postCondition(){
//        if(new ContactListScreen(driver).isContactListPresent()){
//            new ContactListScreen(driver).logout();
//            new SplashScreen(driver);
//        }
    }

}
