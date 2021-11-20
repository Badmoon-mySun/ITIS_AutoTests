package ru.kpfu.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "tests")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestsData {
    @XmlElement(name = "test")
    private List<TestData> tests;
}
