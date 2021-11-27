package ru.kpfu.itis;

import com.github.javafaker.Faker;
import ru.kpfu.itis.model.QuestionData;
import ru.kpfu.itis.model.TestData;
import ru.kpfu.itis.model.TestsData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class TestDataGenerator {
    private final String filepath;

    public static void main(String[] args) {
        int testsCount = 0;
        int questionsCount = 0;
        if (args.length > 0) {
            try {
                testsCount = Integer.parseInt(args[0]);

                if (args.length > 1) {
                    questionsCount = Integer.parseInt(args[1]);
                }
            } catch (NumberFormatException ignore) {}
        }

        TestDataGenerator testDataGenerator = new TestDataGenerator("test.xml");
        testDataGenerator.generateTests(testsCount, questionsCount);
    }

    public TestDataGenerator(String filename) {
        filepath = filename;
    }

    public void generateTests(int testsCount, int questionsCount) {
        Faker faker = new Faker();

        List<TestData> tests = new ArrayList<>();
        for (int i = 0; i < testsCount; i++) {
            List<QuestionData> questions = new ArrayList<>();

            for (int j = 0; j < questionsCount; j++) {
                QuestionData question = QuestionData.builder()
                        .question(faker.book().title())
                        .answer(faker.book().title())
                        .mark(String.valueOf(getRandomNumber(1, 10)))
                        .build();

                questions.add(question);
            }

            TestData testData = TestData.builder()
                    .title(faker.app().name())
                    .theme(faker.book().title())
                    .subject("Информатика")
                    .questions(questions)
                    .build();

            tests.add(testData);
        }

        jaxbObjectToXML(new TestsData(tests));
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void jaxbObjectToXML(TestsData tests) {
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(TestsData.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(tests, sw);

            File file = new File(filepath);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(sw.toString());
            printWriter.close();

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
