package com.example.homework.dao;

import com.example.homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Query("UPDATE User u SET u.email = :email,u.password = :password, u.first_name = :firstName," +
            "u.last_name = :firstName,u.address = :address,u.telephone = :telephone WHERE id = :id")
    void updateUser(@Param("id") long id, @Param("email")String email,
                          @Param("password") String password, @Param("first_name") String firstName,
                          @Param("last_name") String lastName,@Param("address") String address,@Param("telephone") String telephone);
}
