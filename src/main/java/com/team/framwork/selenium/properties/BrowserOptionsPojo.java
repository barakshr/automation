package com.team.framwork.selenium.properties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BrowserOptionsPojo {
    List<BrowsePropertiesPojo> browsePropertiesPojoList;


    @JsonCreator
    public BrowserOptionsPojo(@JsonProperty("options") List<BrowsePropertiesPojo> browsePropertiesPojoList ) {
        this.browsePropertiesPojoList = browsePropertiesPojoList;
    }

    @JsonGetter("options")
    public List<BrowsePropertiesPojo> getBrowsePropertiesPojoList() {
        return browsePropertiesPojoList;
    }
}
