import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HTMLStringsTest {
    private static final Class<?> CLASS = HTMLStrings.class;

    private static PrintStream CONSOLE;
    private static PrintStream ERROR;
    private static InputStream KEYBOARD;
    private static ByteArrayOutputStream OUT;

    @BeforeClass
    public static void beforeTestsBegin() {
        KEYBOARD = System.in;
        CONSOLE = System.out;
        ERROR = System.err;
        System.setOut(new PrintStream(OUT = new ByteArrayOutputStream()));
        System.setErr(new PrintStream(new ByteArrayOutputStream()));
    }

    @AfterClass
    public static void afterTestsEnd() {
        System.setIn(KEYBOARD);
        System.setOut(CONSOLE);
        System.setErr(ERROR);
    }

    @After
    public void afterEachTest() {
        OUT.reset();
    }

    private void setKeyboardInput(String anInput) {
        ByteArrayInputStream in = new ByteArrayInputStream(anInput.getBytes());
        System.setIn(in);
    }

    private String getConsolePrintout() {
        return OUT.toString();
    }

    @Test
    public void testAllFieldsPrivateAndNoStaticUnlessFinal() {
        Field[] fields = CLASS.getDeclaredFields();

        for (Field f : fields) {
            if (!f.isSynthetic()) {
                assertTrue("Field \"" + f.getName() + "\" should be private",
                        Modifier.isPrivate(f.getModifiers()));
                assertFalse("Field \"" + f.getName() + "\" cannot be static",
                        Modifier.isStatic(f.getModifiers()));
            }
        }
    }

    // FYI
    // %d means "replace with next argument, which should be an integer"
    // %s means "replace with next argument, which should be a string"
    // %n means "replace with a newline (aka end-of-line) character"
    // (automatically makes it '\r\n' in Windows or '\n' in all others)
    @Test
    public void test00() {
        String input = String.format("%d %d %s%n", 0, 0, "");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n", "");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test01() {
        String input = String.format("%d %d %s%n", 1, 4, "abcdefg");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n", "bcd");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test02() {
        String input = String.format("%d %d %s%n", 0, 15, "Testing<b>!</b>");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n", "Testing<b>!</b>");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test03() {
        String input = String.format("%d %d %s%n", 16, 21,
                "<foo>yippy!<bar>bleep<blah>yay!</blah></bar></foo>");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n", "<foo><bar>bleep</bar></foo>");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test04() {
        String input = String.format("%d %d %s%n", 4, 4, "<b>123</b>");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n", "<b></b>");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test05() {
        String input = String.format("%d %d %s%n", 0, 16,
                "  :-/ :-> :-) :-<->");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n", "  :-/ :-> :-) :-");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test06() {
        String input = String.format("%d %d %s%n", 0, 10,
                "a<b>cd<i>e</i>f<tt>gh</tt>i</b>jk");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n", "a<b>cd<i>e</i></b>");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test07() {
        String input = String.format("%d %d %s%n", 19, 33,
                "a<b>cd<i>e</i>f<tt>gh</tt>i</b>jk");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n", "<b><tt>gh</tt>i</b>jk");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test08() {
        String input = String.format("%d %d %s%n", 10, 33,
                "a<b>cd<i>e</i>f<tt>gh</tt>i</b>jk");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n",
                "<b><i></i>f<tt>gh</tt>i</b>jk");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test09() {
        String input = String.format("%d %d %s%n", 9, 33,
                "a<b>cd<i>e</i>f<tt>gh</tt>i</b>jk");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n",
                "<b><i>e</i>f<tt>gh</tt>i</b>jk");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }

    @Test
    public void test10() {
        String input = String.format("%d %d %s%n", 10, 19,
                "a<b>cd<i>e</i>f<tt>gh</tt>i</b>jk");
        setKeyboardInput(input);

        HTMLStrings.main(new String[] {});

        String expected = String.format("%s%n", "<b><i></i>f<tt></tt></b>");
        String actual = getConsolePrintout();
        assertEquals("Unexpected result", expected, actual);
    }
}
