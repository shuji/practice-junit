public class CalculatorTest {

    @Test
    public void addは3と4で7を返す() throws Exception {
        Calculator sut = new Calculator();
        assertThat(sut.add(3, 4), is(7));
    }
}
