package mobileLocatorsHelpers;

public class PromptBuilder {

    public static String buildPrompt(Locator locator, String domXML){
        return 
        "You are a mobile test automation enginner and you have to update/heal a locator with new value and type. The current locator is: " + locator.getType() + " with value: " + locator.getValue() +
        ". The DOM structure of the page is: " + domXML +
        ". Please provide the updated locator in the following JSON format: {\"type\": \"newType\", \"value\": \"newValue\"}"
        .formatted(locator.getType(), locator.getValue(), domXML);
    }
    
}
