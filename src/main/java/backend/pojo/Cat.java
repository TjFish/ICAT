package backend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @author: OY
 * @date: 20:11 2019/11/27
 */
@Entity
@Table(name = "cat")
public class Cat {
    private String catId;
    private String catName;
    private String catColor;
    private String catGender;
    private Integer age;
    private String headPortrait;
    private Boolean isSterilization;
    private Boolean isAdopt;
    private Boolean isLost;
    private String hint;
    private String locate;
    private String characteristics;
    private String appearance;

    public Cat() {
    }

//    @JsonIgnore
//    List<DiseaseRecord> diseaseRecords;
//
//    @OneToMany(targetEntity=DiseaseRecord.class, mappedBy="cat", fetch=FetchType.LAZY)
//    public List<DiseaseRecord> getDiseaseRecords() {
//        return diseaseRecords;
//    }
//
//    public void setDiseaseRecords(List<DiseaseRecord> diseaseRecords) {
//        this.diseaseRecords = diseaseRecords;
//    }


    @Id
    @Column(name = "catID")
    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }


    @Basic
    @Column(name = "catName")
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Basic
    @Column(name = "catColor")
    public String getCatColor(){
        return catColor;
    }

    public void setCatColor(String catColor){
        this.catColor = catColor;
    }

    @Basic
    @Column(name = "catGender")
    public String getCatGender() {
        return catGender;
    }

    public void setCatGender(String catGender) {
        this.catGender = catGender;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "headPortrait")
    public String getHeadPortrait(){
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait){
        this.headPortrait = headPortrait;
    }

    @Basic
    @Column(name = "isSterilization")
    public boolean getIsSterilization() {
        return isSterilization;
    }

    public void setIsSterilization(boolean isSterilization) {
        this.isSterilization = isSterilization;
    }

    @Basic
    @Column(name = "isAdopt")
    public boolean getIsAdopt() {
        return isAdopt;
    }

    public void setIsAdopt(boolean isAdopt) {
        this.isAdopt = isAdopt;
    }

    @Basic
    @Column(name = "isLost")
    public boolean getIsLost() {
        return isLost;
    }

    public void setIsLost(boolean isLost) {
        this.isLost = isLost;
    }

    @Basic
    @Column(name = "hint")
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Basic
    @Column(name = "locate")
    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    @Basic
    @Column(name = "characteristics")
    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    @Basic
    @Column(name = "appearance")
    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (isAdopt.equals(cat.isAdopt)) return false;
        if (isLost.equals(cat.isLost)) return false;
        if (catId != null ? !catId.equals(cat.catId) : cat.catId != null) return false;
        if (catName != null ? !catName.equals(cat.catName) : cat.catName != null) return false;
        if (catGender != null ? !catGender.equals(cat.catGender) : cat.catGender != null) return false;
        if (age != null ? !age.equals(cat.age) : cat.age != null) return false;
        if (isSterilization != null ? !isSterilization.equals(cat.isSterilization) : cat.isSterilization != null)
            return false;
        if (hint != null ? !hint.equals(cat.hint) : cat.hint != null) return false;
        if (locate != null ? !locate.equals(cat.locate) : cat.locate != null) return false;
        if (characteristics != null ? !characteristics.equals(cat.characteristics) : cat.characteristics != null)
            return false;
        if (appearance != null ? !appearance.equals(cat.appearance) : cat.appearance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catId != null ? catId.hashCode() : 0;
        result = 31 * result + (catName != null ? catName.hashCode() : 0);
        result = 31 * result + (catGender != null ? catGender.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (isSterilization != null ? isSterilization.hashCode() : 0);
        result = 31 * result + (isAdopt != null ? isAdopt.hashCode() : 0);
        result = 31 * result + (isLost != null ? isLost.hashCode() : 0);
        result = 31 * result + (hint != null ? hint.hashCode() : 0);
        result = 31 * result + (locate != null ? locate.hashCode() : 0);
        result = 31 * result + (characteristics != null ? characteristics.hashCode() : 0);
        result = 31 * result + (appearance != null ? appearance.hashCode() : 0);
        return result;
    }


    public String formattedOutput() {

        String string = "[catId]: " + catId
                + "\t | \t[catName]: " + catName
                + "\t | \t[catColor]: " + catColor
                + "\t | \t[catGender]: " + catGender
                + "\t | \t[headPortrait]: " + headPortrait
                + "\t | \t[age]: " + age
                + "\t | \t[isSterilization]: " + isSterilization
                + "\t | \t[isAdopt]: " + isAdopt
                + "\t | \t[isLost]: " + isLost
                + "\t | \t[hint]: " + hint
                + "\t | \t[locate]: " + locate
                + "\t | \t[characteristics]: " + characteristics
                + "\t | \t[appearance]: " + appearance
                + "\n";
        return string;

    }
}
