package com.app.feelog.domain.dto;

import com.app.feelog.domain.enumeration.MemberTaskPoolStatus;
import com.app.feelog.domain.vo.MemberTaskPoolVO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class MemberTaskPoolDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String mamberTaskPoolContent;
    private String mamberTaskPoolFilePath;
    private String mamberTaskPoolFileName;
    private String mamberTaskPoolFileSize;
    private MemberTaskPoolStatus memberTaskPoolStatus;
    private String createdDate;
    private String updatedDate;

    public MemberTaskPoolVO toVO() {
        return MemberTaskPoolVO.builder()
                .id(id)
                .mamberTaskPoolContent(mamberTaskPoolContent)
                .mamberTaskPoolFilePath(mamberTaskPoolFilePath)
                .mamberTaskPoolFileName(mamberTaskPoolFileName)
                .mamberTaskPoolFileSize(mamberTaskPoolFileSize)
                .memberTaskPoolStatus(memberTaskPoolStatus)
                .createdDate(createdDate)
                .updatedDate(updatedDate)
                .build();
    }
}