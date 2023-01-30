import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationPositiveTest extends AppiumConfig {

    @BeforeClass
    public void preCondition(){
        new SplashScreen(driver).gotoAuthenticationScreen();
    }

    @Test
    public void registrationSuccess(){
//        int ran=(int) (System.currentTimeMillis() / 1000) % 3600;
        int ran = new Random().nextInt(1000)+1000;
        new AuthenticationScreen(driver)
                .loginRegistrationForm(Auth.builder().email("Tom"+ran+"@mail.com")
                        .password("Zxc"+ran+"@").build())
                .submitRegistration()
                .isContactListPresent();
    }

    @Test
    public void registrationWrongEmailNegative(){

        int ran = new Random().nextInt(1000)+1000;
        new AuthenticationScreen(driver)
                .loginRegistrationForm(Auth.builder().email("Tom"+ran+"mail.com")
                        .password("Zxc"+ran+"@").build())
                .submitRegistrationNegative()
                .isErrorMessageContainsText("username=must be a well-formed email address");
    }

    @Test
    public void registrationPasswordWithoutSymbolNegative(){

        int ran = new Random().nextInt(1000)+1000;
        new AuthenticationScreen(driver)
                .loginRegistrationForm(Auth.builder().email("Tom"+ran+"@mail.com")
                        .password("Zxc"+ran).build())
                .submitRegistrationNegative()
                .isErrorMessageContainsText("Can contain special characters [@$#^&*!]");
    }

    @Test
    public void registrationPasswordLess8charactersNegative(){

        int ran = new Random().nextInt(1000)+1000;
        new AuthenticationScreen(driver)
                .loginRegistrationForm(Auth.builder().email("Tom"+ran+"@mail.com")
                        .password("Zx3@").build())
                .submitRegistrationNegative()
                .isErrorMessageContainsText("At least 8 characters;");
    }

    @AfterMethod
    public void postCondition(){
        if(new ContactListScreen(driver).isContactListPresent()){
            new ContactListScreen(driver).logout();
        }
    }
}
