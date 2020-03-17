package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BaseSettingsForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class contains Workspaces Settings Page.
 */
public class WorkspaceSettings extends BaseSettingsForm {
    @FindBy(id = "workspace_name")
    private WebElement workspaceNameTextField;

    /**
     * This method input change workspace.
     *
     * @param newName is new name for workspace.
     */
    public void updateName(String newName) {
        CommonActions.setInputField(workspaceNameTextField, newName);
    }
}
