package ru.kpfu.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "questionData")
@XmlRootElement
public class QuestionData {
    private String question;
    private String answer;
    private String mark;
}
