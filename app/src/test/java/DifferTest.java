import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


class DifferTest {
    private String filePathJson = "src/test/resources/file.json";
    private String filePathJson1 = "src/test/resources/file1.json";
    private String filePathYML1 = "src/test/resources/file.yml";
    private String filePathYML2 = "src/test/resources/file1.yml";
    private String filePathJson2 = "src/test/resources/file2.json";
    private String filePathJson3 = "src/test/resources/file3.json";

    private Path trueAnswerJson = Paths.get("src/test/resources/checkJson");
    private Path trueAnswerYML = Paths.get("src/test/resources/checkYML");

    @Test
    public void correctJson() throws Exception {
        var actual = Differ.generate(filePathJson, filePathJson1, "json");
        var expected = Files.readString(trueAnswerJson);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void correctJsonAll() throws Exception {
        var actual = Differ.generate(filePathJson2, filePathJson3, "json");
        var expected = Files.readString(Paths.get("src/test/resources/CheckIncludJson"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void correctYML() throws Exception {
        var actual = Differ.generate(filePathYML1, filePathYML2, "yml");
        var expected = Files.readString(trueAnswerYML);
        assertThat(actual).isEqualTo(expected);
    }
}
