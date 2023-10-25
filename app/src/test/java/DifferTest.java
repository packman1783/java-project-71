import hexlet.code.Differ;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    static String expectedSimpleComparing;
    static String expectedStylish;
    static String expectedPlain;
    static String jsonPathFile1;
    static String jsonPathFile2;
    static String ymlPathFile1;
    static String ymlPathFile2;
    static String jsonTreePathFile1;
    static String jsonTreePathFile2;
    static String ymlTreePathFile1;
    static String ymlTreePathFile2;

    @BeforeAll
    public static void beforeAll() throws Exception {
        jsonPathFile1 = "src/test/resources/file1.json";
        jsonPathFile2 = "src/test/resources/file2.json";
        ymlPathFile1 = "src/test/resources/file1.yml";
        ymlPathFile2 = "src/test/resources/file2.yml";
        expectedSimpleComparing = getContent("src/test/resources/expectedSimpleComparing.txt");

        jsonTreePathFile1 = "src/test/resources/fileTree1.json";
        jsonTreePathFile2 = "src/test/resources/fileTree2.json";
        ymlTreePathFile1 = "src/test/resources/fileTree1.yml";
        ymlTreePathFile2 = "src/test/resources/fileTree2.yml";
        expectedStylish = getContent("src/test/resources/expectedStylish.txt");

        expectedPlain = getContent("src/test/resources/expectedPlain.txt");

    }


    public static String getContent(String pathString) throws Exception {
        Path path = Paths.get(pathString);
        return Files.readString(path);
    }

    @Test
    public void testJson() throws Exception {
        String actual = Differ.generate(jsonPathFile1, jsonPathFile2);
        assertThat(actual).isEqualTo(expectedSimpleComparing);
    }

    @Test
    public void testYml() throws Exception {
        String actual = Differ.generate(ymlPathFile1, ymlPathFile2);
        assertThat(actual).isEqualTo(expectedSimpleComparing);
    }

    @Test
    public void testStylishJson() throws Exception {
        String actual = Differ.generate(jsonTreePathFile1, jsonTreePathFile2, "stylish");
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void testStylishYml() throws Exception {
        String actual = Differ.generate(ymlTreePathFile1, ymlTreePathFile2, "stylish");
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void testPlainJson() throws Exception {
        String actual = Differ.generate(jsonTreePathFile1, jsonTreePathFile2, "plain");
        assertThat(actual).isEqualTo(expectedPlain);
    }

    @Test
    public void testPlainYml() throws Exception {
        String actual = Differ.generate(ymlTreePathFile1, ymlTreePathFile2, "plain");
        assertThat(actual).isEqualTo(expectedPlain);
    }
}
