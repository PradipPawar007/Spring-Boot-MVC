package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.entity.Book;

public interface IBookRepository extends JpaRepository<Book,Integer>  {

}
