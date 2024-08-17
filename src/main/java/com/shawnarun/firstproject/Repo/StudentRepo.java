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

    @Query(value = "SELECT * FROM student WHERE full_name LIKE %?1% OR nic LIKE %?1%", nativeQuery = true)
    List<Student> findAllBySearchText(String searchText,PageRequest of);

    @Query(value = "SELECT * FROM student WHERE age >= ?1", nativeQuery = true)
    List<Student> findAllByAge(int age, PageRequest of);
    @Query(value = "SELECT * FROM student WHERE age>=?2 AND full_name LIKE %?1%", nativeQuery = true)
    List<Student> findAllByAgeAndSearch(String searchText, int age, PageRequest of);
}
