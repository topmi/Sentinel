package com.alibaba.csp.sentinel.dashboard.rule.nacos.gateway;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;

import java.util.LinkedHashSet;
import java.util.Set;

public class ApiDefinition2 {
    private String apiName;
    private Set<ApiPathPredicateItem> predicateItems;
    
    public ApiDefinition2() {
    }
    
    public String getApiName() {
        return apiName;
    }
    
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
    
    public Set<ApiPathPredicateItem> getPredicateItems() {
        return predicateItems;
    }
    
    public void setPredicateItems(Set<ApiPathPredicateItem> predicateItems) {
        this.predicateItems = predicateItems;
    }
    
    @Override
    public String toString() {
        return "ApiDefinition2{" + "apiName='" + apiName + '\'' + ", predicateItems=" + predicateItems + '}';
    }
    
    
    public ApiDefinition toApiDefinition() {
        ApiDefinition apiDefinition = new ApiDefinition();
        apiDefinition.setApiName(apiName);
        
        Set<ApiPredicateItem> apiPredicateItems = new LinkedHashSet<>();
        apiDefinition.setPredicateItems(apiPredicateItems);
        
        if (predicateItems != null) {
            for (ApiPathPredicateItem predicateItem : predicateItems) {
                apiPredicateItems.add(predicateItem);
            }
        }
        
        return apiDefinition;
    }
    
}
