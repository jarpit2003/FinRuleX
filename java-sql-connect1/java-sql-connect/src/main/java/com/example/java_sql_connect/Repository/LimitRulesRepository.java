package com.example.java_sql_connect.Repository;
//package com.example.limitrules.repository;
import com.example.java_sql_connect.Entities.LimitRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimitRulesRepository extends JpaRepository<LimitRules, Long> {
}

