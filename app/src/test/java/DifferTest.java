import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


class DifferTest {
    private String filePath1 = "/home/ruslan/java-project-71/app/filepath1.json";
    private String filePath2 = "/home/ruslan/java-project-71/app/filepath2.json";

    private Path trueAnswer = Paths.get("/home/ruslan/java-project-71/app/src/test/resources/check");

    @Test
    public void correct() throws Exception {
        var actual = Differ.generate(filePath1, filePath2);

        var expected = Files.readString(trueAnswer);

        assertThat(actual).isEqualTo(expected);
    }
}
