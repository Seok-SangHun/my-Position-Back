package com.app.positionback.domain.notice;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NoticeVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long corporationId;
    private String noticeTitle;
    private String noticeCareer;
    private String noticeEducation;
    private String noticeEndDate;
    private String createdDate;
    private String updatedDate;
    private String noticeWorkStartTime;
    private String noticeWorkEndTime;
    private String noticeWorkStartDate;
    private String noticeWorkEndDate;
    private String noticeJobCategoryName;
    private int noticeReadCount;
}
