package com.d207.farmer.domain.farm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Farm {

    @Id @GeneratedValue
    @Column(name = "farm_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_plant_id")
    private UserPlant userPlant;

    @Column(name = "farm_seed_date")
    private LocalDateTime seedDate;

    @Column(name = "farm_pred_date")
    private LocalDateTime predDate;

    @Column(name = "farm_growth_step")
    private int growthStep;

    @Column(name = "farm_is_completed")
    private Boolean isCompleted;

    @Column(name = "farm_complete_date")
    private LocalDateTime completeDate;

    @Column(name = "farm_create_date")
    private LocalDateTime createDate;

    @Column(name = "farm_is_deleted")
    private Boolean isDeleted;

    @Column(name = "farm_delete_date")
    private LocalDateTime deletedDate;

    @Column(name = "farm_memo")
    private String memo;
}