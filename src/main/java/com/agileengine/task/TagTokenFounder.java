package com.agileengine.task;

import com.agileengine.task.model.QualifierAttributes;
import com.agileengine.task.utils.AttributeMapperHelper;
import com.agileengine.task.utils.PrintElementsHelper;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;
import java.util.Objects;

public class TagTokenFounder {
    private static Logger LOGGER = LoggerFactory.getLogger(TagTokenFounder.class);

    public static void main(String[] args) {

        String originFilePath = args[0];
        String inputFilePath = args[1];
        String targetElementId = args.length > 2 ? args[2] : "make-everything-ok-button";

        File originalFile = new File(originFilePath);
        File inputFile = new File(inputFilePath);

        Element foundedElement = AgileEngineJsoupFinder.findElementById(originalFile, targetElementId).orElse(null);
        if (Objects.nonNull(foundedElement)) {
            Map<Element, QualifierAttributes> elements = AttributeMapperHelper.mapElementsByAttributes(foundedElement, inputFile);
            PrintElementsHelper.printElementsPath(elements);
        } else {
            LOGGER.info("ELEMENTS NOT FOUND");
        }
    }
}
