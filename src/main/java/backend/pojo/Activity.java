package backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
@Entity
@Table(name = "activity")
public class Activity {
    private String activityId;
    private String activityName;
    private Timestamp actTime;
    private String actPlace;
    private int partiNum;
    private String activityTitle;
    private String activityDescription;
    private Timestamp publishtime;

    @Id
    @Column(name = "activityID")
    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "activityName")
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Basic
    @Column(name = "actTime")
    public Timestamp getActTime() {
        return actTime;
    }

    public void setActTime(Timestamp actTime) {
        this.actTime = actTime;
    }

    @Basic
    @Column(name = "actPlace")
    public String getActPlace() {
        return actPlace;
    }

    public void setActPlace(String actPlace) {
        this.actPlace = actPlace;
    }

    @Basic
    @Column(name = "partiNum")
    public int getPartiNum() {
        return partiNum;
    }

    public void setPartiNum(Integer partiNum) {
        this.partiNum = partiNum;
    }

    public void setPartiNum(int partiNum) {
        this.partiNum = partiNum;
    }

    @Basic
    @Column(name = "activityTitle")
    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    @Basic
    @Column(name = "activityDescription")
    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    @Basic
    @Column(name = "publishtime")
    public Timestamp getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Timestamp publishtime) {
        this.publishtime = publishtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (partiNum != activity.partiNum) return false;
        if (activityId != null ? !activityId.equals(activity.activityId) : activity.activityId != null) return false;
        if (activityName != null ? !activityName.equals(activity.activityName) : activity.activityName != null)
            return false;
        if (actTime != null ? !actTime.equals(activity.actTime) : activity.actTime != null) return false;
        if (actPlace != null ? !actPlace.equals(activity.actPlace) : activity.actPlace != null) return false;
        if (activityTitle != null ? !activityTitle.equals(activity.activityTitle) : activity.activityTitle != null)
            return false;
        if (activityDescription != null ? !activityDescription.equals(activity.activityDescription) : activity.activityDescription != null)
            return false;
        if (publishtime != null ? !publishtime.equals(activity.publishtime) : activity.publishtime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = activityId != null ? activityId.hashCode() : 0;
        result = 31 * result + (activityName != null ? activityName.hashCode() : 0);
        result = 31 * result + (actTime != null ? actTime.hashCode() : 0);
        result = 31 * result + (actPlace != null ? actPlace.hashCode() : 0);
        result = 31 * result + partiNum;
        result = 31 * result + (activityTitle != null ? activityTitle.hashCode() : 0);
        result = 31 * result + (activityDescription != null ? activityDescription.hashCode() : 0);
        result = 31 * result + (publishtime != null ? publishtime.hashCode() : 0);
        return result;
    }
}
