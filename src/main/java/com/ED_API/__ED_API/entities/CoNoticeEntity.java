package com.ED_API.__ED_API.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "CO_NOTICES")
public class CoNoticeEntity {
    @Id
    @GeneratedValue
    private Integer noticeId;

    private Long caseNum;

    private String noticeStatus;

    private String noticeUrl;

    private Integer edgTraceId;

    private LocalDate noticePrintDate;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Long getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(Long caseNum) {
        this.caseNum = caseNum;
    }

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public String getNoticeUrl() {
        return noticeUrl;
    }

    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl;
    }

    public Integer getEdgTraceId() {
        return edgTraceId;
    }

    public void setEdgTraceId(Integer edgTraceId) {
        this.edgTraceId = edgTraceId;
    }

    public LocalDate getNoticePrintDate() {
        return noticePrintDate;
    }

    public void setNoticePrintDate(LocalDate noticePrintDate) {
        this.noticePrintDate = noticePrintDate;
    }
}
