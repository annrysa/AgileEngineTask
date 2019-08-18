package com.agileengine.task.model;

import java.util.Set;

public class QualifierAttributes {
    private Integer count;
    private String element;
    private Set<String> attributeName;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<String> getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(Set<String> attributeName) {
        this.attributeName = attributeName;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
