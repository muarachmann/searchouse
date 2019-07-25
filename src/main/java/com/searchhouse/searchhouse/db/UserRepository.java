package com.searchhouse.searchhouse.db;

import com.searchhouse.searchhouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value ="Select * from users where username=?1" , nativeQuery=true)
    User findByUsername(String username);

    @Query(value ="SELECT * FROM users WHERE  username=?1 AND  password =?2",nativeQuery =true)
    User connexionUser(String name, String password);

    @Query(value = "select * from users where email =?1 or username=?1 or telephone=?1",  nativeQuery=true)
    User findByEmailAndUsernameAndTelephone(String email);

    @Query(value = "select * from users where confirmation_token =?1",  nativeQuery=true)
    User findByConfirmationToken(String confirmationToken);
}
