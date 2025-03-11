import edu.ntudp.pzks.lab5.controller.JsonManager;
import edu.ntudp.pzks.lab5.controller.UniversityCreator;
import edu.ntudp.pzks.lab5.model.University;
import org.junit.Assert;
import org.junit.Test;


public class JsonManagerTest {
    @Test
    public void testUniversitySerializationAndDeserialization() {
        String FILE_NAME = "file.txt";
        UniversityCreator universitycreator = new UniversityCreator();
        JsonManager jsonManager = new JsonManager();

        University oldUniversity = universitycreator.createTypicalUniversity(2, true);
        String json = jsonManager.convertUniversityToJson(oldUniversity);
        jsonManager.writeJsonToFile(json, FILE_NAME);

        University newUniversity = jsonManager.readUniversityFromFile(FILE_NAME);

        Assert.assertEquals(oldUniversity, newUniversity);
    }
}
