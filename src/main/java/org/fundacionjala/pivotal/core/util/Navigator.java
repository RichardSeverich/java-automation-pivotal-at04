package org.fundacionjala.pivotal.core.util;

import org.fundacionjala.pivotal.core.browser.DriverManager;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.Project;

/**
 * Created by pivotal-test Team.
 */
public final class Navigator {

    /**
     * Private constructor for the Navigator utility class.
     */
    private Navigator() {
    }

    /**
     * This method Navigate to the Dashboard page.
     *
     * @return a Dashboard class instance.
     */
    public static Dashboard loadDashboardPage() {
        DriverManager.getInstance().getWebDriver()
                .navigate().to(Environment.getInstance().getBaseUrl().concat("/dashboard"));
        return new Dashboard();
    }

    /**
     * This method Navigate to a Main Project Page specified by its id.
     *
     * @param projectId is the Project identifier.
     * @return a Project class instance.
     */
    public static Project loadProjectPage(String projectId) {
        DriverManager.getInstance().getWebDriver()
                .navigate().to(String.format("%s%s%s",
                Environment.getInstance().getBaseUrl(), "/projects/", projectId));
        return new Project();
    }
}
