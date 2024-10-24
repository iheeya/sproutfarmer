package com.d207.farmer.domain.farm;

import com.d207.farmer.domain.common.Address;
import com.d207.farmer.domain.place.Place;
import com.d207.farmer.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserPlace {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_place_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_place_name")
    private String name;

    @Column(name = "user_place_latitude")
    private String latitude;

    @Column(name = "user_place_longitude")
    private String longitude;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "sido", column = @Column(name = "user_place_sido")),
            @AttributeOverride(name = "sigugun", column = @Column(name = "user_place_sigugun")),
            @AttributeOverride(name = "bname1", column = @Column(name = "user_place_bname1")),
            @AttributeOverride(name = "bname2", column = @Column(name = "user_place_bname2")),
            @AttributeOverride(name = "bunji", column = @Column(name = "user_place_bunji")),
            @AttributeOverride(name = "jibun", column = @Column(name = "user_place_jibun")),
            @AttributeOverride(name = "zoneCode", column = @Column(name = "user_place_zonecode"))
    })
    private Address address;

    /**
     * 비즈니스 메서드
     */
    public UserPlace(User user, Place place, String lati, String longi, String defaultPlaceName, Address address) {
        this.user = user;
        this.place = place;
        this.name = defaultPlaceName;
        this.latitude = lati;
        this.longitude = longi;
        this.address = address;
    }

    public void modifyName(String userPlaceName) {
        this.name = userPlaceName;
    }
}
