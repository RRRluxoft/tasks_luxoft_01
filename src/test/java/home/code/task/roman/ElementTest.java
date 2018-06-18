package home.code.task.roman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Date: 03.06.2018
 */
public class ElementTest {

    Collection<Element> elementCollection;
    Element element;

    @Before
    public void setUp() throws Exception {
        element = new Element();
        element.age = 25;
        element.name = "Eric Evans";
        element.num = 1;

        this.elementCollection = new ArrayList<Element>() {{
            add(element);
            add(element);
            add(element);
        }};

    }

    @Test
    public void shouldReturnOneElement() throws Exception {

        FilterElementImpl filterElement = new FilterElementImpl();

        Collection<Element> result = filterElement.filterByAgeAndDistinctName(elementCollection, 20);

        Assert.assertEquals(1, result.size());
    }

    @Test
    public void shouldReturnOneElementInCaseOfAmbiguityTest() throws Exception {

        FilterElementImpl filterElement = new FilterElementImpl();

        Collection<Element> result = filterElement.filterByAgeAndDistinctName(elementCollection, 30);

        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(element));

    }

    @Test
    public void shouldReturnOneElementInCaseOfAmbiguityWithEmptyInputCollectionTest() throws Exception {

        Collection<Element> elementCollection = Collections.emptyList();

        FilterElementImpl filterElement = new FilterElementImpl();

        Collection<Element> result = filterElement.filterByAgeAndDistinctName(elementCollection, 30);

        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(new Element()));
    }

}