package ICAT.backend.pojo;

import javax.persistence.*;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
@Entity
@Table(name = "catColor")
public class CatColor {
    private String colorId;
    private String colorName;
    private String colorDescription;

    @Id
    @Column(name = "colorID")
    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    @Basic
    @Column(name = "colorName")
    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @Basic
    @Column(name = "colorDescription")
    public String getColorDescription() {
        return colorDescription;
    }

    public void setColorDescription(String colorDescription) {
        this.colorDescription = colorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatColor catColor = (CatColor) o;

        if (colorId != null ? !colorId.equals(catColor.colorId) : catColor.colorId != null) return false;
        if (colorName != null ? !colorName.equals(catColor.colorName) : catColor.colorName != null) return false;
        if (colorDescription != null ? !colorDescription.equals(catColor.colorDescription) : catColor.colorDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = colorId != null ? colorId.hashCode() : 0;
        result = 31 * result + (colorName != null ? colorName.hashCode() : 0);
        result = 31 * result + (colorDescription != null ? colorDescription.hashCode() : 0);
        return result;
    }
}
