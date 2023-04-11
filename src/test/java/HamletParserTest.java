import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;
   private Matcher matcher;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        hamletParser.changeHomletLeon();
        Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        Assert.assertFalse(matcher.find());
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.changeHoratioToTariq();
        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        Assert.assertFalse(matcher.find());
    }

    @Test
    public void testFindHoratio() {
        int expected = 158;
        int actual = hamletParser.findHoratio();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        int expected = 472;
        int actual = hamletParser.findHamlet();
        Assert.assertEquals(expected, actual);
    }

}