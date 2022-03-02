package com.example.homework.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Restaurant extends BaseEntity{

    @NonNull
    private String name;
    private String  description;
    @NonNull
    private String url;
    @NonNull
    private String address;
    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        if (!super.equals(o)) return false;
        Restaurant that = (Restaurant) o;
        return name.equals(that.name) &&
                Objects.equals(description, that.description) &&
                url.equals(that.url) && address.equals(that.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, url, address);
    }
}
