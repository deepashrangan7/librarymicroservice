package com.heptagon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.heptagon.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
