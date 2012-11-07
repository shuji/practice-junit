package ch19.ex03;

import static ch19.ex03.MultiLineStringMatcher.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

/**
 * リスト19.9 複数行テキストのアサーション
 * @author shuji.w6e
 */
public class MultiLineStringTest {

    @Test
    public void joinで文字列が連結される() throws Exception {
        String ls = System.getProperty("line.separator");
        String expected = "Hello" + ls + "World" + ls;
        assertThat(MultiLineString.join("Hello", "World"), is(text(expected)));
    }

}

class MultiLineStringMatcher extends BaseMatcher<String> {

    public static Matcher<String> text(String text) {
        return new MultiLineStringMatcher(text, System.getProperty("line.separator"));
    }

    private final String expected;
    private Object actual;
    private final List<String> expectedLines = new ArrayList<String>();
    private final List<String> actualLines = new ArrayList<String>();
    private final Pattern pattern;

    public MultiLineStringMatcher(String expected, String ls) {
        this.expected = expected;
        if (ls.equals("\r")) {
            this.pattern = Pattern.compile(".+(\\r|$)");
        } else if (ls.equals("\n")) {
            this.pattern = Pattern.compile(".+(\\n|$)");
        } else {
            this.pattern = Pattern.compile(".+(\\r\\n|$)");
        }
        if (expected != null) {
            java.util.regex.Matcher m = pattern.matcher(expected);
            while (m.find()) {
                expectedLines.add(expected.substring(m.start(), m.end()));
            }
        }
    }

    @Override
    public boolean matches(Object actual) {
        this.actual = actual;
        if (expected == null) return (actual == null);
        if (!(actual instanceof String)) {
            return false;
        }
        if (expected.equals(actual)) return true;
        String actualString = (String) actual;
        java.util.regex.Matcher m = pattern.matcher(actualString);
        while (m.find()) {
            actualLines.add(actualString.substring(m.start(), m.end()));
        }
        return expectedLines.equals(actualLines);
    }

    @Override
    public void describeTo(Description desc) {
        if (expected == null || actual == null) {
            desc.appendValue(expected);
        } else {
            int lines = Math.min(expectedLines.size(), actualLines.size());
            for (int idx = 0; idx < lines; idx++) {
                String expectedLine = expectedLines.get(idx);
                String actualLine = actualLines.get(idx);
                if (!expectedLine.equals(actualLine)) {
                    desc.appendValue(expectedLine);
                    desc.appendText(", but actual is ");
                    desc.appendValue(actualLine);
                    desc.appendText(", line " + (idx + 1) + "\n");
                    desc.appendValue(expected);
                    return;
                }
            }
            desc.appendText("expected text is " + expectedLines.size() + " lines, ");
            desc.appendText("but actual text is " + actualLines.size() + " lines\n");
            desc.appendValue(expected);
        }

    }
}