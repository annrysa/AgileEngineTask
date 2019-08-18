package com.agileengine.task.utils;

import org.jsoup.nodes.Element;

import java.util.Objects;

public class AttributePathHelper {
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String EMPTY_STRING = "";
    private static final String PATH_SEPARATOR = " -> ";
    private static final String ROOT_ELEMENT_VALUE = "#root";

    public static long getTagIndex(Element element) {
        long tagIndex = element.parent().children()
                .stream()
                .filter(el -> el.tagName().equals(element.tagName()) && el.siblingIndex() < element.siblingIndex())
                .count();

        return tagIndex;
    }

    public static String getElementIndexInParentNode(long tagIndex) {
        String elementIndex = tagIndex != 0 ? new StringBuilder().append(OPEN_BRACKET)
                .append(tagIndex)
                .append(CLOSE_BRACKET)
                .toString() :
                EMPTY_STRING;

        return elementIndex;
    }

    public static StringBuilder getResultPath(StringBuilder resultPath, String elementTagName, String elementIndex) {
        if (resultPath.length() == 0) {
            resultPath = new StringBuilder(elementTagName + elementIndex);
        } else {
            resultPath.insert(0, elementTagName + elementIndex + PATH_SEPARATOR);
        }

        return resultPath;
    }

    public static String getPath(Element element) {
        StringBuilder resultPath = new StringBuilder();

        while (Objects.nonNull(element) && !ROOT_ELEMENT_VALUE.equals(element.tagName())) {

            String elementTagName = element.tagName();

            long tagIndex = Objects.nonNull(element.parent()) ? AttributePathHelper.getTagIndex(element) : 0;
            String elementIndex = AttributePathHelper.getElementIndexInParentNode(tagIndex);

            resultPath = AttributePathHelper.getResultPath(resultPath, elementTagName, elementIndex);
            element = element.parent();
        }
        return resultPath.toString();
    }
}
