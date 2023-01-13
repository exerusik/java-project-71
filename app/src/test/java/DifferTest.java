import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DifferTest {
    @Test
    public void correct() throws Exception {
        var actual = Differ.generate("/home/ruslan/java-project-71/app/filepath1.json",
                                    "/home/ruslan/java-project-71/app/filepath2.json");
        var expected = "{\n"
                +
                "+ follow : false\n"
                +
                "  host : hexlet.io\n"
                +
                "+ proxy : 123.234.53.22\n"
                +
                "- timeout : 50\n"
                +
                "+ timeout : 20\n"
                +
                "+ verbose : true\n"
                +
                "}*";

        Assertions.assertEquals(actual, expected);

    }
}
