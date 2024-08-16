package com.shawnarun.firstproject.Repo;

import com.shawnarun.firstproject.Entity.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    @Query(value = "SELECT * FROM student ", nativeQuery = true)
    List<Student> findAllPaginated(PageRequest of);
    
}
