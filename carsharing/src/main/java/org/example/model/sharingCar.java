package org.example.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class sharingCar extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="sharing_sopt_id")
    private SharingSpot sharingSpot;
    @Comment("차량번호")
    private String carNumber;
    @Comment("차량 위도")
    private Double carLat;
    @Comment("차량 경도")
    private Double carLon;
    @Comment("마지막 세차일")
    private LocalDateTime lastWash;
    @Comment("마지막 점검일")
    private LocalDateTime lastRepair;
    @Comment("주유 잔량")
    private String fuelRate;
    @Comment("차량이미지")
    private String carImgPath;
    @Comment("차량 소속 아이디")
    private Integer CorpId;

    @Comment("Test")
    private String test;


}
