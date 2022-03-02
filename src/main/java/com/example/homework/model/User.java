package com.example.homework.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "users")
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    private String address;

    @NonNull
    private String telephone;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return email.equals(user.email) && password.equals(user.password) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && address.equals(user.address) && telephone.equals(user.telephone) && Objects.equals(orders, user.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, firstName, lastName, address, telephone, orders);
    }
}
