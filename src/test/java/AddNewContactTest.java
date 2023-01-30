import config.AppiumConfig;
import models.NewContact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactTest extends AppiumConfig {
//@BeforeMethod
//public void preCondition(){
//    new AuthenticationScreen(driver).loginCW();
//}
//@Test
//    public void addContactTest(){
//        new AddNewContactScreen(driver).addNew();
//    }
    @BeforeClass
    public void preCondition(){
        new AuthenticationScreen(driver)
                .fillEmail("0612test@mail.com")
                .fillPassword("14253Asd@")
                .submitLogin();
    }
    @Test
    public void addOneContactPositive(){
        int i = new Random().nextInt(1000)+1000;
        NewContact contact = NewContact.builder()
                .name("Ralf"+i)
                .lastName("D"+i)
                .email("ralf"+i+"@mail.com")
                .phone("055"+i+"1234")
                .address("Israel")
                .description("good man").build();

        new ContactListScreen(driver).clickPlusButton()
                .fillNewContact(contact)
                .submitCreate()
                .isContactAdded(contact)
                ;
    }

    @Test
    public void addOneContactNegativeEmptyPhone(){
        int i = new Random().nextInt(1000)+1000;
        NewContact contact = NewContact.builder()
                .name("Ralf"+i)
                .lastName("D"+i)
                .email("ralf"+i+"@mail.com")
                .phone("empty phone")
                .address("Israel")
                .description("good man").build();

        Assert.assertTrue(new ContactListScreen(driver).clickPlusButton()
                .fillNewContact(contact)
                .submitCreateNegative()
                .isErrorMessageContainsText("phone=Phone number must contain only digits! And length min 10, max 15!"));
    }

    @Test
    public void addOneContactNegativeEmptyName() {
        int i = new Random().nextInt(1000) + 1000;
        NewContact contact = NewContact.builder()
                .name("Ralf" + i)
                .lastName("D" + i)
                .email("ralf" + i + "@mail.com")
                .phone("empty phone")
                .address("Israel")
                .description("good man").build();

        Assert.assertTrue(new ContactListScreen(driver).clickPlusButton()
                .fillNewContact(contact)
                .submitCreateNegative()
                .isErrorMessageContainsText("phone=Phone number must contain only digits! And length min 10, max 15!"));
    }

    @AfterMethod
    public void postCondition(){
        if(!(new ContactListScreen(driver).isContactListPresent())){
            driver.navigate().back();
        }
    }
}
