package home.code.task.roman;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Date: 03.06.2018
 */
public class Element  {
    int num;
    String name;
    int age;

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        return new EqualsBuilder()
            .append(num, element.num)
            .append(age, element.age)
            .append(name, element.name)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(num)
            .append(name)
            .append(age)
            .toHashCode();
    }
}
