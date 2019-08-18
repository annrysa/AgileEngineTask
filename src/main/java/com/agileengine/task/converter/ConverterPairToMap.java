package com.agileengine.task.converter;

import com.agileengine.task.model.QualifierAttributes;
import com.agileengine.task.utils.AttributeMapperHelper;
import javafx.util.Pair;
import org.jsoup.nodes.Element;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConverterPairToMap {

    public static Map<Element, QualifierAttributes> converterPairToMap(Map<String, Pair<Element, QualifierAttributes>> comparingMap) {
        LinkedHashMap<Element, QualifierAttributes> result = comparingMap.entrySet()
                .stream()
                .filter(c1 -> AttributeMapperHelper.getMaxCountOfOccurrence(comparingMap).equals(c1.getValue().getValue().getAttributeName().size()))
                .collect(Collectors.toMap(stringPairEntry -> stringPairEntry.getValue().getKey(), stringPairEntry -> stringPairEntry.getValue().getValue(), (e1, e2) -> e1, LinkedHashMap::new));

        return result;
    }
}
