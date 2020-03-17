package org.fundacionjala.pivotal.pages.signin;

import org.fundacionjala.pivotal.core.browser.DriverManager;
import org.fundacionjala.pivotal.pages.base.BasePage;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.core.util.Navigator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class page for Sign In options.
 */
public class SignIn extends BasePage {

    private static final int TIME_WAIT_DURATION = 3;
    private final String username;
    private final String password;

    @FindBy(id = "credentials_username")
    private WebElement usernameInputField;

    @FindBy(className = "app_signin_action_button")
    private WebElement signInButton;

    @FindBy(className = "credentials_password")
    private WebElement passwordInputField;

    @FindBy(css = "div.app_signin_switch_accounts > a")
    private WebElement signInAsOtherButton;

    /**
     * This method is the constructor class.
     *
     * @param username This variable contains the username.
     * @param password This variable contains the password.
     */
    public SignIn(String username, String password) {
        this.username = username;
        this.password = password;
        Navigator.loadDashboardPage();
    }

    /**
     * This method sets the user name to the username Input Field
     * and presses the SignIn Button.
     */
    protected void enterUserName() {
        CommonActions.setInputField(usernameInputField, username);
        clickSignInButton();
    }

    /**
     * This method sets the Password to the password Input Field
     * and presses the SignIn Button.
     */
    protected void enterPassword() {
        CommonActions.setInputField(passwordInputField, password);
        clickSignInButton();
    }

    /**
     * This method presses the SignIn Button.
     */
    private void clickSignInButton() {
        CommonActions.clickButton(signInButton);
    }

    /**
     * This method presses the SignIn As Other User Button.
     */
    protected void clickSignInAsOtherBtn() {
        CommonActions.clickButton(signInAsOtherButton);
    }

    /**
     * This method executes the actions of the SignIn process.
     *
     * @return The Dashboard page.
     */
    protected Dashboard signInActions() {
        enterUserName();
        enterPassword();
        return new Dashboard();
    }

    /**
     * This method perform the sign in process with a username and password.
     *
     * @param username This variable contains the username.
     * @param password This variable contains the password.
     * @return The dashboard page.
     */
    public static Dashboard signInAs(String username, String password) {
        Dashboard dashboard;
        try {
            DriverManager.getInstance().updateTimeWait(TIME_WAIT_DURATION);
            dashboard = new SignIn(username, password).createStrategy();
        } finally {
            DriverManager.getInstance().restorePreviousTimeWait();
        }
        Navigator.loadDashboardPage();
        return dashboard;
    }

    /**
     * This method creates the strategy object,
     * According to the process that is required.
     *
     * @return dashboard object.
     */
    private Dashboard createStrategy() {
        return isUserLogged()
                ? strategyProcess(new OtherUserSignInStrategy())
                : strategyProcess(new NormalSignInStrategy());
    }

    /**
     * This method verifies if the user is logged in.
     *
     * @return True if the user is Logged in or False if the user is not Logged.
     */
    private boolean isUserLogged() {
        return CommonActions.getPageTitle().contains("Dashboard");
    }

    /**
     * This method performs the strategy pattern process.
     *
     * @param signInStrategy Is the object of the strategy to be used .
     * @return dashboard page object.
     */
    protected Dashboard strategyProcess(SignInStrategy signInStrategy) {
        return signInStrategy.signIn(this);
    }

    /**
     * This method verifies if the SigInAs button is visible.
     *
     * @return True if the SignInAs button is visible or false if it is not.
     */
    protected boolean isSignInAsOtherBtnVisible() {
        return CommonActions.isVisible(signInAsOtherButton);
    }

    /**
     * This method return the username.
     *
     * @return the username.
     */
    protected String getUsername() {
        return username;
    }
}
