package com.springboot.harubi.Domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long group_id;

    @Column(nullable = false)
    private String group_name;

    // 다대다 관계 설정
    @OneToMany(mappedBy = "group")
    private List<MemberGroup> memberGroups;

    // One to Many 관계 설정
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Study> studies = new ArrayList<>();

    // One to Many 관계 설정
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reference> references = new ArrayList<>();

    @OneToOne(mappedBy = "group")
    private Star star;  // 각 그룹은 하나의 즐겨찾기 상태를 가질 수 있음
}
