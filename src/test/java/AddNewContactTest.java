import config.AppiumConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.LoginRegistrationScreen;

public class AddNewContactTest extends AppiumConfig {
@BeforeMethod
public void preCondition(){
    new LoginRegistrationScreen(driver).login();
}
@Test
    public void addContactTest(){
        new AddNewContactScreen(driver).addNew();
    }
}
