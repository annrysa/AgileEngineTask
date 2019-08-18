package com.agileengine.task.utils;

import com.agileengine.task.AgileEngineJsoupFinder;
import com.agileengine.task.converter.ConverterPairToMap;
import com.agileengine.task.model.QualifierAttributes;
import javafx.util.Pair;
import org.jsoup.nodes.Element;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AttributeMapperHelper {
    private static final String ID_ATTRIBUTE = "id";

    public static Map<Element, QualifierAttributes> mapElementsByAttributes(Element foundedElement, File file) {
        Map<String, Pair<Element, QualifierAttributes>> comparingMap = new HashMap<>();

        foundedElement.attributes().asList().forEach(attribute -> {
            if (!attribute.getKey().equals(ID_ATTRIBUTE)) {
                String attributeToken = AttributeTokenHelper.getAttributeToken(foundedElement.tagName(), attribute);

                AgileEngineJsoupFinder.findElementsByQuery(file, attributeToken).ifPresent(elementsResult ->
                        elementsResult.forEach(element -> {

                            if (comparingMap.containsKey(element.outerHtml() + element.parent().outerHtml())) {
                                Set<String> value = comparingMap.get(element.outerHtml() + element.parent().outerHtml()).getValue().getAttributeName();
                                value.add(attributeToken);

                                comparingMap.put(element.outerHtml() + element.parent().outerHtml(), new Pair<>(element, new QualifierAttributes() {{
                                    setCount(comparingMap.get(element.outerHtml() + element.parent().outerHtml()).getValue().getCount() + 1);
                                    setAttributeName(value);
                                    setElement(element.outerHtml());
                                }}));

                            } else {
                                Set<String> collect = Stream.of(attributeToken).collect(Collectors.toSet());

                                comparingMap.put(element.outerHtml() + element.parent().outerHtml(), new Pair<>(element, new QualifierAttributes() {{
                                    setCount(1);
                                    setAttributeName(collect);
                                    setElement(element.outerHtml());
                                }}));
                            }
                        }));
            }
        });

        Map<Element, QualifierAttributes> collect = ConverterPairToMap.converterPairToMap(comparingMap);
        return collect;
    }

    public static Integer getMaxCountOfOccurrence(Map<String, Pair<Element, QualifierAttributes>> comparingMap) {
        Optional<Map.Entry<String, Pair<Element, QualifierAttributes>>> max = comparingMap.entrySet().stream().max(Comparator.comparing(c -> c.getValue().getValue().getAttributeName().size()));
        Integer maxCount = max.map(pairEntry -> pairEntry.getValue().getValue().getAttributeName().size()).orElse(1);

        return maxCount;
    }
}
