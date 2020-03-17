package org.fundacionjala.pivotal.pages.project;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import org.fundacionjala.pivotal.pages.Steps;

/**
 * Class applying Strategy with Projects.
 */
public final class ProjectStrategyLambda {

    /**
     * Private constructor for the Project Strategy Lambda utility class.
     */
    private ProjectStrategyLambda() {

    }

    /**
     * This method execute the steps to perform the fill of the fields in the Create Project Form.
     *
     * @param attributesMap is the Map that contains the attributes.
     * @param page          is the Create Project Form instance.
     */
    public static void strategy(Map<ProjectAttributes, String> attributesMap, ProjectCreateForm page) {
        Map<ProjectAttributes, Steps> strategyOption = setAttributes(attributesMap, page);
        Set<ProjectAttributes> attributes = attributesMap.keySet();
        attributes.forEach(attributeItem -> strategyOption.get(attributeItem).executeStep());
    }

    /**
     * This method completes the fields in the Create Project Form with a specific strategy.
     *
     * @param attributesMap is the Map that contains the attributes.
     * @param page          is the Create Project Form instance.
     * @return the Map that contains Project Attributes with a specific Project Step.
     */
    private static Map<ProjectAttributes, Steps> setAttributes(
            Map<ProjectAttributes, String> attributesMap, ProjectCreateForm page) {
        Map<ProjectAttributes, Steps> strategyMap = new EnumMap<>(ProjectAttributes.class);
        strategyMap.put(ProjectAttributes.NAME,
                () -> page.setNameInputField(attributesMap.get(ProjectAttributes.NAME)));
        strategyMap.put(ProjectAttributes.ACCOUNT,
                () -> page.setAccount(attributesMap.get(ProjectAttributes.ACCOUNT)));
        strategyMap.put(ProjectAttributes.PRIVACY,
                () -> page.setPrivacy(attributesMap.get(ProjectAttributes.PRIVACY)));
        return strategyMap;
    }
}
