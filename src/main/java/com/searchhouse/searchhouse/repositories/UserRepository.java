package com.searchhouse.searchhouse.repositories;

import com.searchhouse.searchhouse.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value ="Select * from user where username=?1" , nativeQuery=true)
    User creationUser(String username);

    @Query(value ="SELECT * FROM user WHERE  username=?1 AND  password =?2",nativeQuery =true)
    User connexionUser(String name, String psswd);
}
