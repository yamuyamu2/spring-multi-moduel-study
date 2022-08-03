package org.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class SharingSpot extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    @Deprecated(since = "쉐어링 주차존 이름")
    private String spotName;
    @Column(nullable = false)
    @Deprecated(since = "주차존 위도")
    private Double spotLat;
    @Column(nullable = false)
    @Deprecated(since = "주차존 경도")
    private Double spotLon;
    @Deprecated(since = "사용가능 차량")
    private Integer carCount;
    @Deprecated(since = "이벤트 주차존")
    private Long eventSpot;


}
