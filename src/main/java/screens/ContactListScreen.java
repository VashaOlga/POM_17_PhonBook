package screens;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.NewContact;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class ContactListScreen extends BaseScreen{

    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOption;

    @FindBy(id="com.sheygam.contactapp:id/add_contact_btn")
    MobileElement plusButton;

    @FindBy(id="com.sheygam.contactapp:id/title")
    MobileElement logoutButton;

    @FindBy(xpath="//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityView;

    public boolean isContactListPresent(){
        return shouldHave(activityView, "Contact list", 5);
//        should(activityView,5);
//        return activityView.getText().contains("Contact list");
    }

    public AuthenticationScreen logout(){

        should(moreOption,5);
        moreOption.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }

    public AddNewContactScreen clickPlusButton(){
        should(plusButton,3);
        plusButton.click();
        return new AddNewContactScreen(driver);
    }

    @FindBy(id="com.sheygam.contactapp:id/rowName")
    List<MobileElement> names;

    @FindBy(id="com.sheygam.contactapp:id/rowPhone")
    List<MobileElement> phones;

    @FindBy(id="com.sheygam.contactapp:id/rowContainer")
    List<MobileElement> contacts;

    @FindBy(id="android:id/button1")
    MobileElement yesButton;

    public ContactListScreen isContactAdded(NewContact contact){
        boolean checkName=checkContainsText(names,contact.getName());
        boolean checkPhone=checkContainsText(phones,contact.getPhone());
        Assert.assertTrue(checkPhone&&checkName);
        return this;
    }

    public boolean checkContainsText(List<MobileElement> list, String text){
        for(MobileElement e:list){
            if(e.getText().contains(text)){
                return true;
            }
        }
        return false;
    }

    public ContactListScreen removeOneContact(){
        should(plusButton,3);
        MobileElement contact=contacts.get(0);
        Rectangle rect = contact.getRect();

        int xStart = rect.getX()+rect.getWidth()/8;
        int xEnd = xStart+rect.getWidth()*6/8;
        int y= rect.getY()+rect.getHeight()/2;

        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(xStart,y))
                .moveTo(PointOption.point(xEnd,y))
                .release()
                .perform();

        should(yesButton,10);
        yesButton.click();
        return this;
    }


}
