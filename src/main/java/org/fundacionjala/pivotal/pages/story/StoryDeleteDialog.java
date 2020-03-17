package org.fundacionjala.pivotal.pages.story;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BasePage;
import org.fundacionjala.pivotal.pages.project.Project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class containing Story delete dialog Page.
 */
public class StoryDeleteDialog extends BasePage {

    @FindBy(css = "button[data-aid='DeleteButton']")
    private WebElement confirmDeleteButton;

    @FindBy(css = "button[data-aid='CancelButton']")
    private WebElement cancelDeleteButton;

    /**
     * This method confirms the deletion of the story.
     *
     * @return the Project Page Object.
     */
    public Project confirm() {
        CommonActions.clickButton(confirmDeleteButton);
        return new Project();
    }

    /**
     * This method cancels the deletion of the story.
     *
     * @return the Story Board Page Object.
     */
    public StoryBoard cancel() {
        CommonActions.clickButton(cancelDeleteButton);
        return new StoryBoard();
    }
}
