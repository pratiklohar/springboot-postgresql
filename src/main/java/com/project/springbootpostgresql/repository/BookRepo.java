package com.project.springbootpostgresql.repository;

import com.project.springbootpostgresql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface BookRepo extends JpaRepository<Book, String> {
    List<Book> findByCategory(String category);

    @Transactional
    @Modifying
    @Query("UPDATE Book SET price = ?1 where id = ?2") //JPQL of JPA.
    //@Query(value = "UPDATE book SET price = ?1 where id = ?2" , nativeQuery = true ) // Native SQL Query
    int updatePrice(float price, String id);


}
