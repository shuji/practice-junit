package ch04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MatcherApiExamples {

    @Test
    public void CoreMatchers_is() throws Exception {
        String actual = "Hello" + " " + "World";
        String expected = "Hello World";
        assertThat(actual, is(expected));
    }
    
    @Test
    public void CoreMatchers_nullValue() throws Exception {
        String actual = null;
        assertThat(actual, is(nullValue()));
    }
    
    @Test
    public void CoreMatchers_not() throws Exception {
        int actual = 100;
        assertThat(actual, is(not(0)));
    }
    
    @Test
    public void CoreMatchers_notNullValue() throws Exception {
        String actual = "Hello";
        assertThat(actual, is(notNullValue()));
        assertThat(actual, is(not(nullValue())));
    }
    
    @Test
    public void CoreMatchers_sameInstance() throws Exception {
        Foo actual = new Foo();
        Foo expected = actual;
        assertThat(actual, is(sameInstance(expected)));
    }
    
    @Test
    public void CoreMatchers_instanceOf() throws Exception {
        Foo actual = new Foo();
        assertThat(actual, is(instanceOf(Serializable.class)));
    }
    
    @Test
    public void JUnitMatchers_hasItem() throws Exception {
        Foo sut = new Foo();
        List<String> actual = sut.getList();
        assertThat(actual, is(hasItem("World")));
    }
    
    @Test
    public void JUnitMatchers_hasItems() throws Exception {
        Foo sut = new Foo();
        List<String> actual = sut.getList();
        assertThat(actual, is(hasItems("Hello", "World")));
    }
    
    @SuppressWarnings("serial")
    static class Foo implements Serializable {
        List<String> getList() {
            List<String> list = new ArrayList<String>();
            list.add("Hello");
            list.add("JUnit");
            list.add("World");
            return list;
        }
    }
    
}
