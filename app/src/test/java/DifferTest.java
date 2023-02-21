import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


class DifferTest {

    private final String fileYml = "src/main/resources/file2.yml";
    private final String file1Yml = "src/main/resources/file3.yml";
    private final String fileJson = "src/main/resources/file2.json";
    private final String file1Json = "src/main/resources/file3.json";

    private final Path trueAnswerPlainStyle = Paths.get("src/test/resources/CheckPlain");
    private final Path trueAnswerStylish = Paths.get("src/test/resources/CheckStylish");


    @Test
    public void testStylishWithJson() throws Exception {
        var actual = Differ.generate(fileJson, file1Json);
        var expected = Files.readString(trueAnswerStylish);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testPlainWithJson() throws Exception {
        String actual = Differ.generate(fileJson, file1Json, "plain");
        String expected = Files.readString(trueAnswerPlainStyle);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testStylishWithYml() throws Exception {
        var actual = Differ.generate(fileYml, file1Yml);
        var expected = Files.readString(trueAnswerStylish);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testPlainWithYml() throws Exception {
        String actual = Differ.generate(fileYml, file1Yml, "plain");
        String expected = Files.readString(trueAnswerPlainStyle);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testJson() throws Exception {
        String actual = Differ.generate(fileJson, file1Json, "json");
        String expected = Files.readString(Paths.get("src/test/resources/checkJsonFile.json"));
        assertThat(actual).isEqualTo(expected);

    }
}
