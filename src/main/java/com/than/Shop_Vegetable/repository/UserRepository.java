package com.than.Shop_Vegetable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.than.Shop_Vegetable.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

    public List<Users> findByUsername(String username);
    
}
