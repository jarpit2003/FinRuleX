package com.example.java_sql_connect.Services.Impl;
import com.example.java_sql_connect.Controllers.LimitRulesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.java_sql_connect.Entities.LimitRules;
import com.example.java_sql_connect.Entities.Entityinterface.repository;
import com.example.java_sql_connect.Services.LimitRulesService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.LinkedHashMap;
import com.example.java_sql_connect.BasicControllers.BaseController;
import com.example.java_sql_connect.Controllers.LimitRequestSet;
import org.slf4j.LoggerFactory;
@Service
public class ServiceImp implements LimitRulesService{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LimitRulesController.class);
    @Autowired
    private repository limitRule;
    @Override
    public Map<String, Object> getAllRules() {
        try{
            List<LimitRules> rules = limitRule.findAll();
            logger.info("GETTING VALUES");
            Map<String, Object> response2=BaseController.sucessMeta(rules);
            logger.info("META -- SUCCESS");
            return response2;
        }catch (Exception e){
            logger.error("ERROR -- CONVERTING to JSON :",e);
            Map<String,Object> result=BaseController.failure();
            return result;
        }
    }
    public Map<String,Object> deleteRule(LimitRequestSet request) {
            try{
            limitRule.deleteQuery(request.getRuleCode(),request.getRuleId());
            logger.info("DELETED QUERY EXECUTED");
            Map<String,Object> response2=BaseController.deleteMeta();
            return response2;
        }
        catch( Exception e){
                logger.error("AN ERROR HAS OCCURED"+e.getMessage(),e);
            throw new RuntimeException("Failed to insert data: " + e.getMessage(), e);
        }
    }

    public Map<String,Object> updateRule(LimitRequestSet request){

        try{
            limitRule.updateQuery(request.getKeyTemplate(),request.getRuleId() );
            logger.info("UPDATE QUERY EXECUTED");
            Map<String,Object> response2=BaseController.updateMeta();
            return response2;
        } catch (Exception e){
            logger.error("ERROR OCCURED IN UPDATING"+e.getMessage(),e);
            throw new RuntimeException("Failed to insert data: " + e.getMessage(), e);
        }
    }


    public Map<String,Object> addRule(LimitRequestSet request) {
        try {
            int check_occ = limitRule.checkIfExists(request.getRuleCode());
            logger.info("values received for check");
            System.out.println(check_occ);

            if (check_occ > 0) {
                logger.info("DATA ALREADY EXISTS FOR THIS RULE CODE");
                Map<String, Object> response2 = BaseController.alreadyExistMeta();
                return response2;
            } else {
                try {
                    LimitRules newRule = new LimitRules();
                    newRule.setRuleId(request.getRuleId());
                    newRule.setServiceId(request.getServiceId());
                    newRule.setKeyTemplate(request.getKeyTemplate());
                    newRule.setTimeFrame(request.getTimeFrame());
                  newRule.setAmountLimit(BigDecimal.valueOf(request.getAmountLimit()));
                    newRule.setCountLimit(request.getCountLimit());
                    newRule.setStartDateTime(LocalDateTime.parse(request.getStartDateTime(), DateTimeFormatter.ISO_DATE_TIME));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    newRule.setEndDateTime(LocalDateTime.parse(request.getEndDateTime(), formatter));
                    newRule.setPrecedence(request.getPrecedence());
                    newRule.setEligibility(request.getEligibility());
                    newRule.setMinAmount(BigDecimal.valueOf(request.getMinAmount()));
                    newRule.setMaxAmount(BigDecimal.valueOf(request.getMaxAmount()));
                    newRule.setStatus(request.getStatus());
                    newRule.setRuleCode(request.getRuleCode());
                    newRule.setRuleGroup(request.getRuleGroup());
                    limitRule.save(newRule);
                    logger.info("DATA ADDED IN TABLE");
                    Map<String, Object> response2 = BaseController.sucessMeta2();
                    return response2;

                } catch (Exception e) {
                    logger.error("ERROR OCCURED IS ",e);
                    throw new RuntimeException("Failed to insert data: " + e.getMessage(), e);
                }
            }
        }
        catch (Exception e){
            Map<String,Object> result=new LinkedHashMap<>();
            logger.error("ERROR OCCURRED IN INSERTING THE VALUES: " + e.getMessage(), e);
            result = new LinkedHashMap<>();
            result.put("Error", e.getMessage());
            return result;
        }
    }
}