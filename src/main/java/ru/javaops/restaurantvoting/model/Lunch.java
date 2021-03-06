package ru.javaops.restaurantvoting.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "lunch", uniqueConstraints =
        {@UniqueConstraint(name = Lunch.UNIQUE_RESTAURANT_DATE_INDEX, columnNames = {"restaurant_id", "date"})})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class Lunch extends BaseEntity {
    public static final String UNIQUE_RESTAURANT_DATE_INDEX = "lunch_unique_restaurant_date_idx";

    @Column(name = "date", columnDefinition = "DATE DEFAULT CURRENT_DATE", insertable = false, updatable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "lunch")
    private List<LunchDish> lunchDishes;
}
