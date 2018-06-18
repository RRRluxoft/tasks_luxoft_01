package home.code.task.roman;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Date: 03.06.2018
 */
public class FilterElementImpl implements FilterElement {

    @Override
    public Collection<Element> filterByAgeAndDistinctName(Collection<Element> input, int ageOlderThen) {

        Collection<Element> result = input.stream()
            .filter(e -> e.age > ageOlderThen)
            .collect(Collectors.groupingBy(Element::getName)).values().stream().map(e -> e.get(0))
            .collect(Collectors.toList());

        Optional<Element> element = input.stream().findAny();
        Element any = element.orElseGet(Element::new);

        return result.size() > 0 ? result : Collections.singletonList(any);
    }

}
