package com.simpleapp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpleapp.Model.Todo;
@Repository
public interface TodoRepository extends JpaRepository<Todo,String>{

}
