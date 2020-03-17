package org.fundacionjala.pivotal.pages.story;

import java.util.EnumMap;
import java.util.Map;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BasePage;
import org.fundacionjala.pivotal.pages.project.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class containing Story board Page.
 */
public class StoryBoard extends BasePage {

    @FindBy(css = "textarea[name='story[name]']")
    private WebElement storyTitleTextField;

    @FindBy(css = "button[class='autosaves button std save']")
    private WebElement storyAutoSaveButton;

    @FindBy(css = "button[class='autosaves button std close']")
    private WebElement storyAutoSaveCloseButton;

    @FindBy(css = "button[title='Delete this story']")
    private WebElement storyDelete;

    //STORY TYPE
    @FindBy(css = "div[class='dropdown story_type'] > a[class='arrow target']")
    private WebElement storyDropdownType;

    //ESTIMATE POINTS
    @FindBy(css = "div[class='dropdown story_estimate'] > a[class='arrow target']")
    private WebElement storyDropdowneEstimatePoints;

    //BLOCKERS
    @FindBy(css = "div[data-aid='BlockerAdd']")
    private WebElement storyBlockerShow;

    @FindBy(css = "textarea[id='blocker-edit-new']")
    private WebElement storyBlokerReasonTextField;

    @FindBy(css = "button[data-aid='BlockerEdit__addButton']")
    private WebElement storyBlockerAddButton;

    //DESCRIPTION
    @FindBy(css = "div[data-aid='renderedDescription']")
    private WebElement storyDescriptionShow;

    @FindBy(xpath = "//div[(@data-aid='Description')]/descendant::textarea")
    private WebElement storyDescriptionTextField;

    @FindBy(css = "button[data-aid='save']")
    private WebElement storyDescriptionSaveButton;

    //LABELS
    @FindBy(css = "input[placeholder='Add a label']")
    private WebElement storyLabelInputField;

    @FindBy(css = "div[data-aid='AlertDialog']")
    private static WebElement errorMessage;

    /**
     * This method creates a new story.
     *
     * @param attributesMap This variable contains all attributes of story.
     * @return new project page object.
     */
    public Project setStoryAttributes(Map<StoryAttributes, String> attributesMap) {
        StoryStrategyLambda.strategy(attributesMap, this);
        if (CommonActions.isVisible(storyAutoSaveButton)) {
            CommonActions.clickButton(storyAutoSaveButton);
        } else {
            CommonActions.jsClickElement(storyAutoSaveCloseButton);
        }
        return new Project();
    }

    /**
     * This method sets the name story.
     *
     * @param titleStory This variable contains the name of story.
     */
    public void setStoryTitleInputField(String titleStory) {
        CommonActions.setInputField(storyTitleTextField, titleStory);
    }

    /**
     * This method set story type.
     *
     * @param storyType This variable enum contains the types.
     */
    public void setStoryType(StoryTypes storyType) {
        CommonActions.clickButton(storyDropdownType);
        String cssSelector = String.format("li[data-value='%s']", storyType.toString().toLowerCase());
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        element.click();
    }

    /**
     * This method set story points.
     *
     * @param storyPoints This variable enum contains the points.
     */
    public void setPoints(StoryPoints storyPoints) {
        CommonActions.clickButton(storyDropdowneEstimatePoints);
        EnumMap<StoryPoints, String> mapPoints = new EnumMap<>(StoryPoints.class);
        mapPoints.put(StoryPoints.UN_ESTIMATE, "-1");
        mapPoints.put(StoryPoints.ZERO, "0");
        mapPoints.put(StoryPoints.ONE, "1");
        mapPoints.put(StoryPoints.TWO, "2");
        mapPoints.put(StoryPoints.THREE, "3");
        String cssSelector = String.format("li[data-value='%s']", mapPoints.get(storyPoints));
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        element.click();
    }

    /**
     * This method sets the blockers.
     *
     * @param storyBlockers This variable contains the blockers.
     */
    public void setBlockers(String storyBlockers) {
        CommonActions.clickButton(storyBlockerShow);
        CommonActions.setInputField(storyBlokerReasonTextField, storyBlockers);
        CommonActions.clickButton(storyBlockerAddButton);
    }

    /**
     * This Method sets story description.
     *
     * @param storyDescription This variable contains the description.
     */
    public void setDescription(String storyDescription) {
        CommonActions.clickButton(storyDescriptionShow);
        CommonActions.setInputField(storyDescriptionTextField, storyDescription);
        CommonActions.clickButton(storyDescriptionSaveButton);
    }

    /**
     * This Method sets label story.
     *
     * @param storyLabel This variable contains the label.
     */
    public void setLabel(String storyLabel) {
        CommonActions.setInputField(storyLabelInputField, storyLabel);
        CommonActions.pressEnterKey(storyLabelInputField);
    }

    /**
     * this method press the  delete the story button.
     *
     * @return Story delete dialog story.
     */
    public StoryDeleteDialog deleteStory() {
        CommonActions.clickButton(storyDelete);
        return new StoryDeleteDialog();
    }

    /**
     * this method do the validation for verify error message.
     *
     * @return a boolean answer.
     */
    public static boolean validationError() {
        return CommonActions.isVisible(errorMessage);
    }
}
