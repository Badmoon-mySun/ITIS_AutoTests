package ru.kpfu.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "testData")
@XmlRootElement
public class TestData {
    private String title;
    private String theme;
    private String subject;
    private List<QuestionData> questions;
}
