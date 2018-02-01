package ru.shaldnikita.forms.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Data {

    @Id
    private String ssoid;

    private String ts;

    private String grp;

    private String type;
    private String subType;
    private String url;

    private String orgId;

    private String formId;

    private String code;

    private String ltpa;
    private String suDirResponse;

    private LocalDateTime ymdh;

    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSuDirResponse() {
        return suDirResponse;
    }

    public void setSuDirResponse(String suDirResponse) {
        this.suDirResponse = suDirResponse;
    }

    public LocalDateTime getYmdh() {
        return ymdh;
    }

    public void setYmdh(LocalDateTime ymdh) {
        this.ymdh = ymdh;
    }

    @Override
    public String toString() {
        return "Data{" +
                "ssoid='" + ssoid + '\'' +
                ", ts=" + ts +
                ", grp='" + grp + '\'' +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", url='" + url + '\'' +
                ", orgId='" + orgId + '\'' +
                ", formId='" + formId + '\'' +
                ", code='" + code + '\'' +
                ", ltpa='" + ltpa + '\'' +
                ", suDirResponse='" + suDirResponse + '\'' +
                ", ymdh=" + ymdh +
                '}';
    }
}
