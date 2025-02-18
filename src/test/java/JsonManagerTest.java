import edu.ntudp.pzks.lab4.controller.JsonManager;
import edu.ntudp.pzks.lab4.controller.UniversityCreator;
import edu.ntudp.pzks.lab4.model.University;
import org.junit.Assert;
import org.junit.Test;


public class JsonManagerTest {
    @Test
    public void testUniversitySerializationAndDeserialization() {
        String FILE_NAME = "file.txt";

        University oldUniversity = UniversityCreator.createTypicalUniversity(2, true);
        String json = JsonManager.convertUniversityToJson(oldUniversity);
        JsonManager.writeJsonToFile(json, FILE_NAME);

        University newUniversity = JsonManager.readUniversityFromFile(FILE_NAME);

        Assert.assertEquals(oldUniversity, newUniversity);
    }
}
