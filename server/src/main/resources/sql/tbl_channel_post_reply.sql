-- post 댓글 테이블
create table tbl_channel_post_reply (
    id 		                    bigint primary key,
    member_id 	                bigint not null,
    post_id 		            bigint not null,
    constraint fk_channel_post_reply_reply foreign key (id)
    references tbl_reply (id) ,
    constraint fk_channel_post_reply_member foreign key (member_id)
    references tbl_member (id) ,
    constraint fk_channel_post_reply_channel_post foreign key (post_id)
    references tbl_channel_post (id)
);

