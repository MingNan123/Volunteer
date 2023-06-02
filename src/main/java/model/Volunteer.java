package model;

/**
 * @author 22541
 */
public class Volunteer {

    private Integer vtId;
    private String vtSno;
    private String vtName;
    private String vtRegion;
    private String vtStartTime;
    private String vtDuration;
    private String vtStatus;

    public Volunteer(){
    }

    public Volunteer(Integer vtId, String vtSno, String vtName, String vtRegion, String vtStartTime, String vtDuration, String vtStatus) {
        this.vtId = vtId;
        this.vtSno = vtSno;
        this.vtName = vtName;
        this.vtRegion = vtRegion;
        this.vtStartTime = vtStartTime;
        this.vtDuration = vtDuration;
        this.vtStatus = vtStatus;
    }

    public int getVtId() {
        return vtId;
    }

    public void setVtId(Integer vtId) {
        this.vtId = vtId;
    }

    public String getVtSno() {
        return vtSno;
    }

    public void setVtSno(String vtSno) {
        this.vtSno = vtSno;
    }

    public String getVtName() {
        return vtName;
    }

    public void setVtName(String vtName) {
        this.vtName = vtName;
    }

    public String getVtRegion() {
        return vtRegion;
    }

    public void setVtRegion(String vtRegion) {
        this.vtRegion = vtRegion;
    }

    public String getVtStartTime() {
        return vtStartTime;
    }

    public void setVtStartTime(String vtStartTime) {
        this.vtStartTime = vtStartTime;
    }

    public String getVtDuration() {
        return vtDuration;
    }

    public void setVtDuration(String vtDuration) {
        this.vtDuration = vtDuration;
    }

    public String getVtStatus() {
        return vtStatus;
    }

    public void setVtStatus(String vtStatus) {
        this.vtStatus = vtStatus;
    }

    @Override
    public String toString() {
        return "volunteer{" +
                "vtId=" + vtId +
                ", vtSno='" + vtSno + '\'' +
                ", vtName='" + vtName + '\'' +
                ", vtRegion='" + vtRegion + '\'' +
                ", vtStartTime='" + vtStartTime + '\'' +
                ", vtDuration='" + vtDuration + '\'' +
                ", vtStatus='" + vtStatus + '\'' +
                '}';
    }
}
