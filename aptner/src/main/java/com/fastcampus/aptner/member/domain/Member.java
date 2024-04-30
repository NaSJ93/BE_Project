package com.fastcampus.aptner.member.domain;


import com.fastcampus.aptner.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "memberRoleList")
@Builder
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String password;

    private String nickname;

    private String content;

    private String phone;

    private Boolean socialLogin;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private List<MemberRole> memberRoleList = new ArrayList<>();

    public void addRole(MemberRole memberRole) {
        memberRoleList.add(memberRole);
    }

    public void clearRole() {
        memberRoleList.clear();
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void changePhone(String phone) {
        this.phone = phone;
    }

    public void changeSocialLogin(Boolean socialLogin) {
        this.socialLogin = socialLogin;
    }

}
