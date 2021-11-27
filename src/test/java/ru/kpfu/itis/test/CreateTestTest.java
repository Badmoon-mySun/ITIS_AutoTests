package ru.kpfu.itis.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kpfu.itis.model.TestData;
import ru.kpfu.itis.model.TestsData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class CreateTestTest extends AuthBase {
    protected static List<TestData> getTestDataFromXmlFile() throws Exception {
        File file = new File("test.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(TestsData.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        TestsData testsData = (TestsData) jaxbUnmarshaller.unmarshal(file);

        return testsData.getTests();
    }

    @ParameterizedTest
    @MethodSource("getTestDataFromXmlFile")
    public void testAddTest(TestData testData) throws Exception {
        applicationManager.getNavigationHelper().getTestCreationTest();

        applicationManager.getTestHelper().addTest(testData);
    }
}
