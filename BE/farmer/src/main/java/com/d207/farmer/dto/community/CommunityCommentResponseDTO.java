package com.d207.farmer.dto.community;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityCommentResponseDTO {


    private String nickname;
    private String imagePath;
    private String commentContent;
    private String writeDatestring;



}