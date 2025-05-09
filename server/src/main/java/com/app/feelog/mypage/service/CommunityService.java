// 2025.04.26 조승찬

package com.app.feelog.mypage.service;

import com.app.feelog.domain.dto.CommunityPostReplyDTO;
import com.app.feelog.domain.dto.CommunityPostReplyLikeDTO;
import com.app.feelog.domain.vo.*;
import com.app.feelog.mypage.dto.*;
import com.app.feelog.mypage.repository.CommunityDAO;
import com.app.feelog.mypage.repository.MyPageDAO;
import com.app.feelog.mypage.util.CalculateTimeAgo;
import com.app.feelog.repository.CommunityPostDAO;
import com.app.feelog.util.SixRowPagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunityService implements ToDTO{

    private final CommunityDAO communityDAO;
    private final MyPageDAO myPageDAO;
    private final CalculateTimeAgo calculateTimeAgo;
    private final CommunityPostWriteDTO communityPostWriteDTO;

    // 2025.04.26 조승찬 :: 개인채널 커뮤니티 글 목록
    public List<CommunityPostListDTO> getCommunityPostList(Long loginId, String channelUrl, SixRowPagination pagination) {

        // 페이지네이션 처리
        // pagination.create(communityDAO.getCommunityPostListTotalCount(channelUrl));
        // 커뮤니티 게시글 가져오기
        List<CommunityPostVO> communityList = communityDAO.getCommunityPostList(channelUrl, pagination);

        List<CommunityPostListDTO> resultList = new ArrayList<>();
        communityList.forEach(community -> {
            // 커뮤니티 게시글의 파일 가져오기
            List<CommunityPostFileVO> files = communityDAO.getCommunityPostFiles(community.getId());
            // 작성자 정보 가져오기
            MemberVO member = myPageDAO.getMemberById(community.getMemberId()).orElse(null);
            // 작성자 채널 정보 가져오기
            ChannelVO memberChannel = myPageDAO.getChannelByMemberId(community.getMemberId()).orElse(null);
            // 작성 시간 계산하기
            String timeAgo = calculateTimeAgo.calculateTimeAgo(community.getCreatedDate());
            // 좋아요 건수
            int likes = communityDAO.getLikeCount(community.getId());
            // 댓글 건수
            int replys =communityDAO.getReplyCount(community.getId());
            // 신고 건수
            int reports =communityDAO.getReportCount(community.getId());
            // 내가 포스트에 좋아요 했는지 알아보기
            boolean iLike = communityDAO.getILike(loginId, community.getId());
            // 내가 포스트에 신고 했는지 알아보기
            boolean iReport = communityDAO.getIReport(loginId, community.getId());

            resultList.add(toCommunityPostListDTO(community, member, files, memberChannel,
                                                    timeAgo,replys, likes, reports, iLike, iReport));
        });

        return resultList;
        // 채널 포스트 목록 가져오기
    }

    // 2025.04.26 조승찬 :: 개인채널 커뮤니티 글 저장
    public void postCommunityPost(String channelUrl, CommunityPostWriteDTO communityPostWriteDTO) {

        // 커뮤니티 포스트 저장
        CommunityPostVO communityPostVO = communityPostWriteDTO.toVO();
        communityDAO.postPost(communityPostVO);
        communityDAO.postCommunityPost(channelUrl, communityPostVO);
        // 커뮤니티 포스트 파일 저장
        if (communityPostWriteDTO.getFiles() != null) {
            communityPostWriteDTO.getFiles().forEach(file -> {
                communityDAO.postFile(file);
                communityDAO.postCommunityPostFile(file, communityPostVO.getId());
            });
        }
    }

    // 2025.04.26  조승찬 :: 포스크 글 읽어오기
    public Optional<CommunityPostWriteDTO> getCommunityPostDetail(Long postId) {

        // 포스트 내용 가져오기
        CommunityPostVO postVO = communityDAO.getCommunityPost(postId).orElse(null);
        // 포스트 파일 가져오기
        List<CommunityPostFileVO> files = communityDAO.getCommunityPostFiles(postId);

        CommunityPostWriteDTO communityPostWriteDTO = new CommunityPostWriteDTO();
        communityPostWriteDTO.setId(postId);
        communityPostWriteDTO.setPostContent(postVO.getPostContent());
        communityPostWriteDTO.setFiles(files);

        return Optional.ofNullable(communityPostWriteDTO);
    }

    // 2025.04.26 조승찬 ::  포스트 내용 수정
    public void updateCommunityPost(CommunityPostWriteDTO communityPostWriteDTO) {
        // 포스트 글 수정
        communityDAO.updateCommunityPost(communityPostWriteDTO.toVO());
        // 포스트 첨부 파일 삭제
        communityDAO.deleteCommunityPostFile(communityPostWriteDTO.getId());
        // 커뮤니티 포스트 파일 저장
        if (communityPostWriteDTO.getFiles() != null) {
            communityPostWriteDTO.getFiles().forEach(file -> {
                communityDAO.postFile(file);
                communityDAO.postCommunityPostFile(file, communityPostWriteDTO.getId());
            });
        }
    }

    // 2025.04.27  조승찬 :: 커뮤니티 게시글 삭제
    public void deleteCommunityPost(Long postId) {
        // 게시글 댓글 좋아요 삭제
        communityDAO.deleteCommunityPostReplyLike(postId);
        // 게시글 댓글 신고 삭제
        communityDAO.deleteCommunityPostReplyReport(postId);
        // 게시글 댓글 삭제
        communityDAO.deleteCommunityPostReply(postId);
        // 게시글 첨부 파일 삭제
        communityDAO.updateCommunityPostFile(postId);
        // 게시글 좋아요 삭제
        communityDAO.deleteCommunityPostLike(postId);
        // 게시글 신고 삭제
        communityDAO.deleteCommunityPostReport(postId);
        // 게시글 삭제
        communityDAO.deleteCommunityPost(postId);
    }

    // 2025.04.27 조승찬 :: 좋아요 건수 가져오기
    public int getLikeCount(Long postId) {
        return communityDAO.getLikeCount(postId);
    }

    // 2025.04.27 조승찬 :: 좋아요 저장
    public void postCommunityPostLike(Long memberId,Long postId) {
        // 슈퍼키 저장
        LikeVO likeVO = new LikeVO();
        communityDAO.postLike(likeVO);
        communityDAO.postCommunityPostLike(likeVO.getId(),memberId, postId);
    }

    // 2025.04.27 조승찬 :: 좋아요 취소
    public void cancelCommunityPostLike(Long memberId, Long postId) {
        communityDAO.cancelCommunityPostLike(memberId, postId);
    }

    // 2025.04.27 조승찬 :: 신고 건수 가져오기
    public int getReportCount(Long postId) {
        return communityDAO.getReportCount(postId);
    }

    // 2025.04.27 조승찬 :: 신고 처리
    public void postCommunityPostReport(Long memberId, Long postId) {
        // 슈퍼키 저장
        ReportVO reportVO = new ReportVO();
        communityDAO.postReport(reportVO);
        communityDAO.postCommunityPostReport(reportVO.getId(),memberId, postId);

    }

    // 2025.04.27 조승찬 :: 신고 취소
    public void cancelCommunityPostReport(Long memberId, Long postId) {
        communityDAO.cancelCommunityPostReport(memberId, postId);
    }

    // 2025.04.28 조승찬 :: 댓글 목록
    public CommunityPostReplyListDTO getCommunityPostReplyList(Long loginId, String channelUrl, Long postId) {

        // 포스트 내용 가져오기
        CommunityPostVO postVO = communityDAO.getCommunityPost(postId).orElse(null);
        // 포스트 파일 가져오기
        List<CommunityPostFileVO> files = communityDAO.getCommunityPostFiles(postId);
        // 작성자 정보 가져오기
        MemberVO member = myPageDAO.getMemberById(postVO.getMemberId()).orElse(null);
        // 작성자 채널 정보 가져오기
        ChannelVO memberChannel = myPageDAO.getChannelByMemberId(postVO.getMemberId()).orElse(null);
        // 작성 시간 계산하기
        String timeAgo = calculateTimeAgo.calculateTimeAgo(postVO.getCreatedDate());
        // 좋아요 건수
        int likes = communityDAO.getLikeCount(postId);
        // 댓글 건수
        int replys =communityDAO.getReplyCount(postId);
        // 신고 건수
        int reports =communityDAO.getReportCount(postId);
        // 내가 포스트에 좋아요 했는지 알아보기
        boolean iLike = communityDAO.getILike(loginId, postId);
        // 내가 포스트에 신고 했는지 알아보기
        boolean iReport = communityDAO.getIReport(loginId, postId);

        List<CommunityPostReplyDetailDTO> replies = new ArrayList<>();
        // 댓글 정보 가져오기
        List<CommunityPostReplyVO> replyList = communityDAO.getCommunityPostReply(postId);
        replyList.forEach(reply -> {
            // 작성자 정보 가져오기
            MemberVO memberReply = myPageDAO.getMemberById(reply.getMemberId()).orElse(null);
            // 작성자 채널 정보 가져오기
            ChannelVO memberChannelReply = myPageDAO.getChannelByMemberId(reply.getMemberId()).orElse(null);
            // 작성 시간 계산하기
            String timeAgoReply = calculateTimeAgo.calculateTimeAgo(reply.getCreatedDate());
            // 좋아요 건수
            int likesReply = communityDAO.getReplyLikeCount(reply.getId());
            // 신고 건수
            int reportsReply =communityDAO.getReplyReportCount(reply.getId());
            // 내가 댓글에 좋아요 했는지 알아보기
            boolean iLikeReply = communityDAO.getILikeReply(loginId, reply.getId());
            // 내가 댓글에 신고 했는지 알아보기
            boolean iReportReply = communityDAO.getIReportReply(loginId, reply.getId());

            replies.add(toCommunityPostReplyDetailDTO(reply, memberReply, memberChannelReply,
                    timeAgoReply, likesReply, reportsReply, iLikeReply, iReportReply));
        });

        return toCommunityPostReplyListDTO(postVO, member, files, memberChannel,
                timeAgo,replys, likes, reports, iLike, iReport, replies);
    }

    // 2025.04.28  조승찬 :: 댓글 저장
    public void postCommunityPostReply(CommunityPostReplyDTO reply) {
        CommunityPostReplyVO replyVO = reply.toVO();
        // 슈퍼키 저장
        communityDAO.postReply(replyVO);
        // 커뮤니티 포스트 댓글 저장
        communityDAO.postCommunityPostReply(replyVO);
    }

    // 2025.04.29  조승찬 :: 댓글 좋아요 건수 가져오기
    public int getReplyLikeCount(Long replyId) {
        return communityDAO.getReplyLikeCount(replyId);
    }

    // 2025.04.29  조승찬 :: 댓글 좋아요 저장
    public void postCommunityPostReplyLike(Long memberId, Long replyId) {

        // 슈퍼키 생성
        LikeVO likeVO = new LikeVO();
        communityDAO.postLike(likeVO);
        // 좋아요 저장
        communityDAO.postCommunityPostReplyLike(likeVO.getId(), memberId, replyId);
    }

    // 2025.04.29  조승찬 :: 댓글 좋아요 취소
    public void cancelCommunityPostReplyLike(Long memberId, Long replyId) {
        communityDAO.cancelCommunityPostReplyLike(memberId, replyId);
    }

    // 2025.04.29  조승찬 :: 댓글 신고 건수 가져오기
    public int getReplyReportCount(Long replyId) {
        return communityDAO.getReplyReportCount(replyId);
    }

    // 2025.04.29  조승찬 :: 댓글  신고  저장
    public void postCommunityPostReplyReport(Long memberId, Long replyId) {

        // 슈퍼키 생성
        ReportVO reportVO = new ReportVO();
        communityDAO.postReport(reportVO);
        // 신고 저장
        communityDAO.postCommunityPostReplyReport(reportVO.getId(), memberId, replyId);

    }

    // 2025.04.29  조승찬 :: 댓글  신고  취소
    public void cancelCommunityPostReplyReport(Long memberId, Long replyId) {
        communityDAO.cancelCommunityPostReplyReport(memberId, replyId);
    }

    // 2025.04.29  조승찬 :: 댓글  삭제
    public void deleteCommunityPostReply(Long id) {
        // 댓글 좋아요 삭제
        communityDAO.deleteCommunityPostReplyLikeByReplyId(id);
        // 댓글 신고 삭제
        communityDAO.deleteCommunityPostReplyReportByReplyId(id);
        // 댓글 삭제
        communityDAO.deleteCommunityPostReplyByReplyId(id);
    }
}
