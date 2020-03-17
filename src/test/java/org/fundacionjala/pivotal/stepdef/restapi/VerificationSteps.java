package org.fundacionjala.pivotal.stepdef.restapi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Class containing Verification Steps.
 */
public class VerificationSteps {

    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param helper is the helper utility class instance.
     */
    public VerificationSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Step definition that perform the assert of the status code.
     *
     * @param status the received status code.
     */
    @Then("^the status code should be (\\d+)$")
    public void theStatusCodeShouldBe(int status) {
        assertEquals(helper.getRequestStatus(), status);
    }

    /**
     * Step definition that perform the assert of the status code message.
     *
     * @param errorMessage about status code.
     */
    @Then("^the status code message \"([^\"]*)\" should be displayed$")
    public void verifyThatValidationErrorMessageIsDiplayed(String errorMessage) {
        assertTrue(helper.getRequestBody().contains(errorMessage));
    }
}
