package com.agileengine.task.utils;

import com.agileengine.task.model.QualifierAttributes;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class PrintElementsHelper {
    private static Logger LOGGER = LoggerFactory.getLogger(PrintElementsHelper.class);

    public static void printElementsPath(Map<Element, QualifierAttributes> elements) {
        LOGGER.info("-----------------------------------------------------");
        for (Map.Entry<Element, QualifierAttributes> elementEntry : elements.entrySet()) {
            LOGGER.info("FOUND ELEMENT: {}", elementEntry.getValue().getElement());
            LOGGER.info("WITH {} EQUALS ATTRIBUTES : {}", elementEntry.getValue().getAttributeName().size(), elementEntry.getValue().getAttributeName());
            LOGGER.info("PATH TO ELEMENT: {}", AttributePathHelper.getPath(elementEntry.getKey()));
            LOGGER.info("-----------------------------------------------------");
        }
    }
}
