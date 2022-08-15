package org.example.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class SharingCar extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sharing_car_id")
    private Long id;

    @Comment("차량소속 아이디")
    private Long corpId;

    @Comment("주차장")
    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private SharingSpot SharingSpot;

    @Comment("주유잔량")
    private Double remainFuel;

    @Comment("안전옵션")
    private String safety;

    @Comment("편의옵션")
    private String convenience;

    @Comment("세차일자")
    private LocalDateTime lastWash;

    @Comment("정비일자")
    private LocalDateTime lastRepair;




}
