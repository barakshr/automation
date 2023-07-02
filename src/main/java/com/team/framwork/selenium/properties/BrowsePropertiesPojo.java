package com.team.framwork.selenium.properties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;


public class BrowsePropertiesPojo {

    private final String key;
    private final Object value;

    @JsonCreator
    public BrowsePropertiesPojo(@JsonProperty("key")  String key,@JsonProperty("value") Object value) {
        this.key = key;
        this.value = value;
    }

    @JsonGetter("key")
    public String getKey() {
        return key;
    }

    @JsonGetter("value")
    public Object getValue() {
        return value;
    }
}
