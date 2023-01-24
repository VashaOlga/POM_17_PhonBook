package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen{

    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
    MobileElement addcontact;

    public void addNew(){
        addcontact.click();
    }

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputName']")
    MobileElement name;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    MobileElement lastName;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement email;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    MobileElement phone;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    MobileElement address;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    MobileElement description;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/createBtn']")
    MobileElement createButton;
}
