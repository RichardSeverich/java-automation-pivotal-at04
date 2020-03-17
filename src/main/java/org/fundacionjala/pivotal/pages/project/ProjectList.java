package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.pages.base.BasePage;
import org.fundacionjala.pivotal.core.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by pivotal-test Team.
 */
public class ProjectList extends BasePage {

    @FindBy(className = "project_name")
    private List<WebElement> projectsList;

    /**
     * This method perform a search of a Project name in the Project List page.
     *
     * @param name is the parameter search value.
     * @return a boolean value that represents the search result.
     */
    public boolean isProjectNameRegistered(String name) {
        return CommonActions.findWebElement(projectsList, name) != null;
    }
}
