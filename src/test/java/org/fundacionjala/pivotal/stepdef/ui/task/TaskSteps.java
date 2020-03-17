package org.fundacionjala.pivotal.stepdef.ui.task;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.pages.task.Task;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Created by Pivotal team.
 */
public class TaskSteps {

    private Task task;
    private Helper helper;

    /**
     * Default Constructor.
     * @param task Task.
     * @param helper Helper.
     */
    public TaskSteps(Task task, Helper helper) {
        this.task = task;
        this.helper = helper;
    }

    /**
     * This definition create a task.
     *
     * @param map Map.
     */
    @When("^sets task with$")
    public void setsTaskWith(Map<String, String> map) {
        task.setTaskDescription(map.get("DESCRIPTION"));
        helper.setTaskVariable(map.get("DESCRIPTION"));
    }

    /**
     * This definiton step delete a task.
     *
     * @param data String.
     */
    @When("^delete the task \"([^\"]*)\"$")
    public void deleteTheTask(String data) {
        task.clickDeleteTask(DataInterpreter.getValue(data).toString());
    }

    /**
     * This definition step check the task done.
     * @param name Task name.
     */
    @And("^check done the task \"([^\"]*)\"$")
    public void checkDoneTheTask(String name) {
        task.clickTaskDoneCheckBox(name);
    }
}
