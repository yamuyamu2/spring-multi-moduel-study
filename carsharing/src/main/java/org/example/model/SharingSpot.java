package org.example.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.type.SpotType;
import org.hibernate.annotations.Comment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class SharingSpot extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sharing_spot_id")
    private Long id;

    @Column(nullable = false, length = 100)
    @Comment("주차장명")
    private String spotName;

    @Column(nullable = false)
    @Comment("주차장위도")
    private Double spotLat;

    @Column(nullable = false)
    @Comment("주차장 경도")
    private Double spotLon;

    @Column(length = 255)
    @Comment("주차장 주소")
    private String addr;

    @Column(length = 255)
    @Comment("주차장 소개")
    private String comment;

    @Comment("주차장 티스토리 Lint")
    private String spotLink;

    @Comment("주차장 배차지역 ex)서울,부산,대전")
    private String spotAreaName;

    @Column(nullable = false,length = 2)
    @Comment("주차장 형식")
    private SpotType spotType;

    @Comment("주차장 운영요일")
    private String weakDay;

    @Comment("주차장 운영시간")
    private String time;

    @Comment("쉐어링 차량")
    @OneToMany(mappedBy = "parkingLot")
    private List<SharingCar> sharingCar;



}
