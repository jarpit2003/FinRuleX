package com.example.java_sql_connect.Services;

import com.example.java_sql_connect.Controllers.LimitRequestSet;
import java.util.Map;

public interface LimitRulesService {
    Map<String, Object> getAllRules();
    Map<String, Object> deleteRule(LimitRequestSet request);
    Map<String, Object> updateRule(LimitRequestSet request);
    Map<String, Object> addRule(LimitRequestSet request);
}
