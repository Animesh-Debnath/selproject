package mobileLocatorsHelpers;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class LocatorRepo {
    private static final ThreadLocal<Map<String, Locator>>
        locators = new ThreadLocal<>();
    
    private static final ThreadLocal<String> 
        locatorPage = new ThreadLocal<>();    

    private static final ObjectMapper mapper = new ObjectMapper();
    
    public void loadLocators(String pageName){
        try {
            String pagePath = System.getProperty("user.dir") 
            + "src/resources/mobileLocators/" + pageName + ".json";
            Map<String, Locator> locatorMap = mapper.readValue(
            new File(pagePath), new com.fasterxml.jackson.core.type
            .TypeReference<Map<String, Locator>>() {});
            locators.set(locatorMap);
            locatorPage.set(pageName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load locators for page: " + pageName, e);
        }
    }

    public Locator get(String elementName){
        return locators.get().get(elementName);
    }

    public void update(String elementName, Locator newLocator){
        try {
            Map<String, Locator> locatorMap = locators.get();
            locatorMap.put(elementName, newLocator);
            String path = System.getProperty("user.dir") + "src/resources/mobileLocators/" + 
            locatorPage.get() + ".json";
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), locatorMap);

        } catch (Exception e) {
            throw new RuntimeException("Failed to update locator: " + elementName, e);  
        }
    }   

    public void clear(){
        locators.remove();
        locatorPage.remove();
    }   
}

