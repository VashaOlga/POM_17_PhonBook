package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.NewContact;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AddNewContactScreen extends BaseScreen{

    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputName']")
    MobileElement inputName;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    MobileElement inputLastName;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement inputEmail;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    MobileElement inputPhone;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    MobileElement inputAddress;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    MobileElement inputDescription;

    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/createBtn']")
    MobileElement createButton;

    public AddNewContactScreen fillNewContact(NewContact contact){
        should(createButton,3);
        type(inputName,contact.getName());
        type(inputLastName,contact.getLastName());
        type(inputEmail,contact.getEmail());
        type(inputPhone,contact.getPhone());
        type(inputAddress,contact.getAddress());
        type(inputDescription,contact.getDescription());
        return this;
    }

    public ContactListScreen submitCreate(){
        createButton.click();
        return new ContactListScreen(driver);
    }

    public AddNewContactScreen submitCreateNegative(){
        createButton.click();
        return this;
    }



}
