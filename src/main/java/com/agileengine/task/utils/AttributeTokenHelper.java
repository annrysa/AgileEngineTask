package com.agileengine.task.utils;

import org.jsoup.nodes.Attribute;

public class AttributeTokenHelper {

    public static String getAttributeToken(String tagName, Attribute attribute) {
        String attributeToken = new StringBuilder().append(tagName)
                .append("[")
                .append(attribute.getKey())
                .append("=\"")
                .append(attribute.getValue())
                .append("\"]")
                .toString();

        return attributeToken;
    }
}
