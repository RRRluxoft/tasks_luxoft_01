package home.code.task.roman;

import java.util.Collection;

/**
 * Date: 03.06.2018
 */
public interface FilterElement {
    Collection<Element> filterByAgeAndDistinctName(Collection<Element> input, int ageOlderThen);
}
