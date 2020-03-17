package org.fundacionjala.pivotal.pages.profile;

import org.fundacionjala.pivotal.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pivotal-test Team.
 */
public class Profile extends BasePage {

    @FindBy(css = "ul.rows.read > li > div")
    private WebElement usernameLabel;

    @FindBy(css = "#email_and_password > ul.rows.read > li > div")
    private WebElement userEmailLabel;

    /**
     * This method verifies if the correct user is logged.
     *
     * @param username Is the user name.
     * @return true or false.
     */
    public boolean isCorrectUserLogged(String username) {
        return username.equals(userEmailLabel.getText()) || username.equals(usernameLabel.getText());
    }
}
