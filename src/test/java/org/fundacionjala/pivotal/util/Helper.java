package org.fundacionjala.pivotal.util;

import org.testng.asserts.Assertion;

/**
 * Class containing Helper Steps.
 */
public class Helper {

    private String projectVariable;
    private String storyVariable;
    private String workspaceVariable;
    private String accountVariable;
    private String taskVariable;
    private String body;
    private int requestStatus;
    private Assertion assertion;

    /**
     * This method sets the Project Variable helper attribute.
     *
     * @param projectVariable the value to be set.
     */
    public void setProjectVariable(String projectVariable) {
        this.projectVariable = projectVariable;
    }

    /**
     * This method return the Project Variable helper attribute.
     *
     * @return the variable value.
     */
    public String getProjectVariable() {
        return projectVariable;
    }

    /**
     * This method sets the Request Status helper attribute.
     *
     * @param requestStatus the value to be set
     */
    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * This method return the Request Status helper attribute.
     *
     * @return the variable value.
     */
    public int getRequestStatus() {
        return requestStatus;
    }

    /**
     * This method set the Request body attribute.
     *
     * @param body the actual body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * This method return the Request body attribute.
     *
     * @return the actual body.
     */
    public String getRequestBody() {
        return body;
    }

    /**
     * This method sets the Account Variable helper attribute.
     *
     * @param accountVariable the value to be set.
     */
    public void setAccountVariable(String accountVariable) {
        this.accountVariable = accountVariable;
    }

    /**
     * This method return the Account Variable attribute.
     *
     * @return the variable value.
     */
    public String getAccountVariable() {
        return accountVariable;
    }

    /**
     * This method get the Story Variable helper attribute.
     *
     * @return the variable value.
     */
    public String getStoryVariable() {
        return storyVariable;
    }

    /**
     * This method sets the Story Variable helper attribute.
     *
     * @param storyVariable the variable value.
     */
    public void setStoryVariable(String storyVariable) {
        this.storyVariable = storyVariable;
    }

    /**
     * This method sets the workspace Variable helper attribute.
     *
     * @param workspaceVariable the variable value.
     */
    public void setWorkspaceVariable(String workspaceVariable) {
        this.workspaceVariable = workspaceVariable;
    }

    /**
     * This method get the workspace Variable helper attribute.
     *
     * @return the variable value.
     */
    public String getWorkspaceVariable() {
        return workspaceVariable;
    }

    /**
     * This method get the task Variable helper attribute.
     *
     * @return the variable value.
     */
    public String getTaskVariable() {
        return taskVariable;
    }

    /**
     * This method sets the task Variable helper attribute.
     *
     * @param taskVariable the variable value.
     */
    public void setTaskVariable(String taskVariable) {
        this.taskVariable = taskVariable;
    }

    /**
     * Get Assertion.
     *
     * @return a instance of Assertion.
     */
    public Assertion getAssertion() {
        return assertion;
    }

    /**
     * Set assertion instance.
     *
     * @param assertion a instance of Soft Assertion.
     */
    public void setAssertion(Assertion assertion) {
        this.assertion = assertion;
    }
}
