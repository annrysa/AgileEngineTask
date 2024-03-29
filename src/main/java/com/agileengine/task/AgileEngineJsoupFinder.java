package com.agileengine.task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public abstract class AgileEngineJsoupFinder {

    private static Logger LOGGER = LoggerFactory.getLogger(AgileEngineJsoupFinder.class);
    private static String CHARSET_NAME = "utf8";

    public static Optional<Elements> findElementsByQuery(File htmlFile, String cssQuery) {
        try {
            Document doc = Jsoup.parse(
                    htmlFile,
                    CHARSET_NAME,
                    htmlFile.getAbsolutePath());

            return Optional.of(doc.select(cssQuery));

        } catch (IOException e) {
            LOGGER.error("Error reading [{}] file", htmlFile.getAbsolutePath(), e);
            return Optional.empty();
        } catch (NullPointerException e) {
            LOGGER.error("There isn't {} element in file {}", cssQuery, htmlFile.getAbsolutePath());
            return Optional.empty();
        }
    }

    public static Optional<Element> findElementById(File htmlFile, String targetElementId) {
        try {
            Document doc = Jsoup.parse(
                    htmlFile,
                    CHARSET_NAME,
                    htmlFile.getAbsolutePath());

            return Optional.of(doc.getElementById(targetElementId));

        } catch (IOException e) {
            LOGGER.error("Error reading [{}] file", htmlFile.getAbsolutePath(), e);
            return Optional.empty();
        } catch (NullPointerException e) {
            LOGGER.error("There isn't {} element in file {}", targetElementId, htmlFile.getAbsolutePath());
            return Optional.empty();
        }
    }

}
