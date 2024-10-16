package com.springboot.harubi.Domain.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String sign_id;

    @Column (nullable = false)
    private String password;

    @Column (nullable = false)
    private String nickname;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private boolean agreed;

    @Column
    private Integer status;

    @Column
    private String icon;

    @Column
    private String bio;

    @Column
    private String affiliation;

    // 다대다 관계 설정
    @OneToMany(mappedBy = "member")
    private List<MemberGroup> memberGroups;

    // One to Many 관계 설정
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Goal> goals = new ArrayList<>();

    // One to Many 관계 설정
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plan> plans = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Star> stars;  // 멤버가 여러 그룹을 즐겨찾기할 수 있음
}
