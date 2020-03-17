package org.fundacionjala.pivotal.pages.task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BasePage;


/**
 * Created by pivotal-test Team.
 */
public class Task extends BasePage {

    @FindBy(css = "div[data-aid='TaskAdd']")
    private WebElement addNewTaskIcon;

    @FindBy(css = "textarea[data-aid='new']")
    private WebElement descriptionTaskInputField;

    @FindBy(css = "button[data-aid='addTaskButton']")
    private WebElement addTaskButton;

    @FindBy(css = "div[data-aid='TaskDescription']")
    private List<WebElement> descriptionList;


    @FindBy(xpath = "//span[@data-aid='taskCounts']")
    private WebElement taskCountLabel;

    /**
     * This method perform a click on the add new task icon WebElement.
     */
    private void clickAddNewTask() {
        CommonActions.clickButton(addNewTaskIcon);
    }

    /**
     * This method sets the task description parameter in the Task description input field.
     *
     * @param taskDescription String.
     */
    public void setTaskDescription(String taskDescription) {
        clickAddNewTask();
        CommonActions.setInputField(descriptionTaskInputField, taskDescription);
        CommonActions.pressEnterKey(descriptionTaskInputField);
    }

    /**
     * This method Check done the checkbox.
     * @param name String the name.
     */
    public void clickTaskDoneCheckBox(String name) {
        String xPathSelector = String.format(
                "//div[p='%s']/parent::div/child::input", name);
        WebElement element = webDriver.findElement(By.xpath(xPathSelector));
        CommonActions.jsClickElement(element);
    }

    /**
     * This method perform a click on the delete task button WebElement.
     *
     * @param taskDescription is name field for task.
     */
    public void clickDeleteTask(String taskDescription) {
        String xPathSelector = String.format(
                "//div[@data-aid='TaskDescription']/p[text()='%s']"
                       + "/parent::div/following-sibling::nav/descendant::button[@data-aid='delete']", taskDescription);
        WebElement element = webDriver.findElement(By.xpath(xPathSelector));
        CommonActions.jsClickElement(element);
    }

    /**
     * This method is used for know if a task is shown in the story board.
     *
     * @param taskVariable is the task description.
     * @return webElement.
     */
    public boolean isDisplayed(String taskVariable) {
        WebElement webElement = CommonActions.findWebElement(descriptionList, taskVariable);
        return webElement != null;
    }

    /**
     * This method is used to have control of task with done check.
     * @return Text Content.
     */
    public String getTaskCounts() {
        return CommonActions.getTextContent(taskCountLabel);
    }
}
