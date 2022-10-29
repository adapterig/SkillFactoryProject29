package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "University")
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("universityId")
    @XmlElement(name = "universityId")
    private String id;
    @SerializedName("universityName")
    @XmlElement(name = "universityName")
    private String fullName;
    @SerializedName("universityShortName")
    @XmlElement(name = "universityShortName")
    private String shortName;
    @SerializedName("foundation")
    @XmlElement(name = "foundation")
    private int yearOfFoundation;
    @SerializedName("profile")
    @XmlElement(name = "profile")
    private StudyProfile mainProfile;

    public University() {
    }

    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return String.format("id = %s, fullName = %s, shortName = %s, yearOfFoundation = %s, mainProfile = %s",
                this.id,
                this.fullName,
                this.shortName,
                this.yearOfFoundation,
                this.mainProfile.getProfileName());
    }
}
