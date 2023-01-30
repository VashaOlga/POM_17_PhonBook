import config.AppiumConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class RemoveContactsTests extends AppiumConfig {
    @BeforeClass
    public void preCondition(){
        new AuthenticationScreen(driver)
                .fillEmail("0612test@mail.com")
                .fillPassword("14253Asd@")
                .submitLogin();
    }
    @Test(invocationCount = 10)
    public void removeSuccess(){
        new ContactListScreen(driver).removeOneContact();
    }
}
