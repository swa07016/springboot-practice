// package com.example.accessingdatamysql;
package project.repository;


import org.springframework.data.repository.CrudRepository;
import project.domain.post.Post;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// @Repository
public interface MysqlPostRepository extends CrudRepository<Post, Long> {
    
} 