package com.app.feelog.domain.dto;

import com.app.feelog.domain.enumeration.PostType;
import com.app.feelog.domain.vo.ChannelPostVO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ChannelPostDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private PostType postType;
    private String postFilePath;
    private String postFileName;
    private String postFileSize;
    private Long memberId;
    private Long channelId;

    public ChannelPostVO toVO() {
        return ChannelPostVO.builder()
                .id(id)
                .postType(postType)
                .postFilePath(postFilePath)
                .postFileName(postFileName)
                .postFileSize(postFileSize)
                .memberId(memberId)
                .channelId(channelId)
                .build();
    }
}