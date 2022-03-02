package com.example.homework.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Order extends BaseEntity{

    private String status;

    @NonNull
    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "orders")
    private List<Dish> dishes;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), status);
    }
}
