package com.example.homework.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Data
@Table(name = "dishes")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Dish extends BaseEntity {

    @NonNull
    private String name;

    private String description;

    @NonNull
    private String url;

    @ManyToOne
    private Restaurant restaurant;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dishes_orders",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"))
    private List<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        if (!super.equals(o)) return false;
        Dish dish = (Dish) o;
        return name.equals(dish.name) && Objects.equals(description, dish.description) && url.equals(dish.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, url);
    }
}
