package com.oww.OhWoonWanBackend.domain;

import com.oww.OhWoonWanBackend.common.type.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false, length = 30)
    private String username;        // 아이디

    @Column(unique = true)
    private String nickname;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Board> boardList;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Likes> likeList;


    /* 소셜로그인시 이미 등록된 회원이라면 수정날짜만 업데이트하고
    * 기존 데이터는 그대로 보존하도록 예외처리 */
    public Account updateModifiedDate() {
        this.onPreUpdate();
        return this;
    }

    public String getRoleValue() {
        return this.role.getValue();
    }

    public void update(String nickname, Role role) {
        this.nickname = nickname;
        this.role = Role.USER;
    }
}
