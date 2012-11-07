package ch19.ex02;

import static ch19.ex02.EmployeeMatcher.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;


/**
 * リスト19.8 EmployeeクラスのカスタムMatcher
 * @author shuji.w6e
 */
public class EmployeeMatcherTest {

    @Test
    public void loadでEmplyoeeの一覧を取得できる() throws Exception {
        // SetUp
        InputStream input = getClass().getResourceAsStream("Employee.txt");
        Employee expected = new Employee();
        expected.setFirstName("Ichiro");
        expected.setLastName("Tanaka");
        expected.setEmail("ichiro@example.com");
        // Exercise
        List<Employee> actual = Employee.load(input);
        // Verify
        assertThat(actual, is(notNullValue()));
        assertThat(actual.size(), is(1));
        assertThat(actual.get(0), is(employee(expected)));
    }
}

class EmployeeMatcher extends BaseMatcher<Employee> {

    private final Employee expected;
    private String field;
    private Object expectedValue;
    private Object actualValue;

    public static Matcher<Employee> employee(Employee expected) {
        return new EmployeeMatcher(expected);
    }

    EmployeeMatcher(Employee expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object actual) {
        if (expected == null) return (actual == null);
        if (!(actual instanceof Employee)) return false;
        Employee other = (Employee) actual;
        if (notEquals(expected.getFirstName(), other.getFirstName())) {
            field = "firstName";
            expectedValue = expected.getFirstName();
            actualValue = other.getFirstName();
            return false;
        }
        if (notEquals(expected.getLastName(), other.getLastName())) {
            field = "lastName";
            expectedValue = expected.getLastName();
            actualValue = other.getLastName();
            return false;
        }
        if (notEquals(expected.getEmail(), other.getEmail())) {
            field = "email";
            expectedValue = expected.getEmail();
            actualValue = other.getEmail();
            return false;
        }
        return true;
    }

    private boolean notEquals(Object obj, Object other) {
        if (obj == null) return other != null;
        return !obj.equals(other);
    }

    @Override
    public void describeTo(Description desc) {
        if (expected == null || field == null) {
            desc.appendValue(expected);
        } else {
            desc.appendText(field + " is ").appendValue(expectedValue)
                .appendText(", but ").appendValue(actualValue);
        }
    }

}
