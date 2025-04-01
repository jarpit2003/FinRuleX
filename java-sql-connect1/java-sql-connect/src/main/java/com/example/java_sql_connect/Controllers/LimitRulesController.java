package com.example.java_sql_connect.Controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.java_sql_connect.Services.LimitRulesService;
import java.util.LinkedHashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/v1/limit_rules")
public class LimitRulesController {
    private static final Logger logger = LoggerFactory.getLogger(LimitRulesController.class);

    @Autowired
    private LimitRulesService rule;  // Use interface instead of implementation

    @GetMapping("/get-rule")
    public Map<String, Object> getAllRules() {
        return rule.getAllRules();
    }

    @PostMapping("/add-rule")
    public Map<String, Object> addRules(@RequestBody LimitRequestSet request) {
        try {
            return rule.addRule(request);
        } catch (Exception e) {
            logger.error("Error while adding rule: {}", e.getMessage());
            Map<String, Object> errorResponse = new LinkedHashMap<>();
            errorResponse.put("Error", "Failed to add rule: " + e.getMessage());
            return errorResponse;
        }
    }

    @PatchMapping("/update-rule")
    public Map<String, Object> updateRules(@RequestBody LimitRequestSet request) {
        try {
            return rule.updateRule(request);
        } catch (Exception e) {
            logger.error("Error while updating rule: {}", e.getMessage());
            Map<String, Object> errorResponse = new LinkedHashMap<>();
            errorResponse.put("Error", "Failed to update rule: " + e.getMessage());
            return errorResponse;
        }
    }

    @DeleteMapping("/remove-rule")
    public Map<String, Object> deleteRules(@RequestBody LimitRequestSet request) {
        try {
            return rule.deleteRule(request);
        } catch (Exception e) {
            logger.error("Error while deleting rule: {}", e.getMessage());
            Map<String, Object> errorResponse = new LinkedHashMap<>();
            errorResponse.put("Error", "Failed to delete rule: " + e.getMessage());
            return errorResponse;
        }
    }
}