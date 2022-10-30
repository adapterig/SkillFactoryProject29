package model;

import enums.StudyProfile;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Statistics")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "profile")
    private StudyProfile profile;
    @XmlElement(name = "avgExamScore")
    private float avgExamScore;
    @XmlTransient
    private int numberOfStudents;
    @XmlTransient
    private int numberOfUniversities;
    @XmlTransient
    private String universityNames;

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public Statistics setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public Statistics setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
        return this;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public Statistics setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
        return this;
    }
}
