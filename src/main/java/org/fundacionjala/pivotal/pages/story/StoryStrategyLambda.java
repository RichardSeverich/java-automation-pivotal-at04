package org.fundacionjala.pivotal.pages.story;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import org.fundacionjala.pivotal.pages.Steps;

/**
 * Class containing Story strategy lambda Page.
 */
public final class StoryStrategyLambda {

    /**
     * Private constructor for the Project Strategy Lambda utility class.
     */
    private StoryStrategyLambda() {
    }

    /**
     * This method performs the strategy pattern whit lambda.
     *
     * @param attributesMap This variable contains the attributes of Story.
     * @param storyBoard    This variable contains story Page Object.
     */
    public static void strategy(Map<StoryAttributes, String> attributesMap,
                                StoryBoard storyBoard) {
        Map<StoryAttributes, Steps> strategyOption = strategySetAttributes(attributesMap, storyBoard);
        Set<StoryAttributes> attributes = attributesMap.keySet();
        attributes.forEach(attributeItem -> strategyOption.get(attributeItem).executeStep());
    }

    /**
     * This method performs the strategy pattern whit lambda.
     *
     * @param attributesMap This variable contains the attributes of story.
     * @param storyBoard    This variable contains story Page Object.
     * @return The strategy map.
     */
    private static Map<StoryAttributes, Steps> strategySetAttributes(
            Map<StoryAttributes, String> attributesMap, StoryBoard storyBoard) {

        EnumMap<StoryAttributes, Steps> strategyMap = new EnumMap<>(StoryAttributes.class);

        strategyMap.put(StoryAttributes.STORY_NAME,
                () -> storyBoard.setStoryTitleInputField(attributesMap.get(StoryAttributes.STORY_NAME)));
        strategyMap.put(StoryAttributes.STORY_TYPE,
                () -> storyBoard.setStoryType(StoryTypes.valueOf(attributesMap.get(StoryAttributes.STORY_TYPE))));
        strategyMap.put(StoryAttributes.STORY_POINTS,
                () -> storyBoard.setPoints(StoryPoints.valueOf(attributesMap.get(StoryAttributes.STORY_POINTS))));
        strategyMap.put(StoryAttributes.STORY_BLOCKERS,
                () -> storyBoard.setBlockers(attributesMap.get(StoryAttributes.STORY_BLOCKERS)));
        strategyMap.put(StoryAttributes.STORY_DESCRIPTION,
                () -> storyBoard.setDescription(attributesMap.get(StoryAttributes.STORY_DESCRIPTION)));
        strategyMap.put(StoryAttributes.STORY_LABEL,
                () -> storyBoard.setLabel(attributesMap.get(StoryAttributes.STORY_LABEL)));
        return strategyMap;
    }
}
