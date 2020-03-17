package org.fundacionjala.pivotal.pages.signin;

import org.fundacionjala.pivotal.pages.dashboard.Dashboard;

/**
 * Created by pivotal-test Team.
 */
public class OtherUserSignInStrategy implements SignInStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public Dashboard signIn(SignIn signIn) {
        Dashboard dashboard = new Dashboard();
        if (!dashboard.isCorrectUserLogged(signIn.getUsername())) {
            dashboard = dashboard.signOut(signIn).strategyProcess(new NormalSignInStrategy());
        }
        return dashboard;
    }
}
