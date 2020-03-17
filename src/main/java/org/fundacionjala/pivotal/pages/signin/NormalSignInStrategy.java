package org.fundacionjala.pivotal.pages.signin;

import org.fundacionjala.pivotal.pages.dashboard.Dashboard;

/**
 * Created by pivotal-test Team.
 */
public class NormalSignInStrategy implements SignInStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public Dashboard signIn(SignIn signInPage) {
        // This condition verifies if the SignInAs Button is visible.
        if (signInPage.isSignInAsOtherBtnVisible()) {
            signInPage.clickSignInAsOtherBtn();
        }
        return signInPage.signInActions();
    }
}
