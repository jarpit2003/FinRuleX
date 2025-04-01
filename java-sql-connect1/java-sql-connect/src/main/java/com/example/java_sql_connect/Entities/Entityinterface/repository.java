package com.example.java_sql_connect.Entities.Entityinterface;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.java_sql_connect.Entities.LimitRules;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface repository extends JpaRepository <LimitRules,Integer>{
       @Modifying
       @Query(value = "DELETE FROM LIMIT_RULES WHERE RULE_CODE= :ruleCode AND RULE_ID= :ruleId",nativeQuery = true)
       public void deleteQuery(@Param("ruleCode") String ruleCode, @Param("ruleId") int ruleId);
       @Modifying
       @Query(value = "UPDATE LIMIT_RULES SET KEY_TEMPLATE= :keyTemplate WHERE RULE_ID= :ruleId",nativeQuery = true)
       public void updateQuery(@Param("keyTemplate") String keyTemplate, @Param("ruleId") int ruleId);
       @Query(value = "SELECT COUNT(*) FROM LIMIT_RULES WHERE RULE_CODE = :ruleCode ", nativeQuery = true)
       public int checkIfExists(@Param("ruleCode") String ruleCode);
}