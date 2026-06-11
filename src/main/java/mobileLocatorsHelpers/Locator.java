package mobileLocatorsHelpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Locator {
    private String elementName;
    private LocatorType type;
    private String value;

    public Locator(String elementName, LocatorType type, String value) {
        this.elementName = elementName;
        this.type = type;
        this.value = value;
    }
    
}
