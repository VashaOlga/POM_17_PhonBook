import config.AppiumConfig;
import org.testng.annotations.Test;
import screens.LoginRegistrationScreen;

public class LoginRegistration extends AppiumConfig {

@Test
    public void loginTest(){

    new LoginRegistrationScreen(driver).login();
}
}
