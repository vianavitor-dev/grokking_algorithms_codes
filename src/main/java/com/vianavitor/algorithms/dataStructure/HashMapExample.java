package com.vianavitor.algorithms.dataStructure;

import java.util.HashMap;
import java.util.Map;

// simulates a simple DNS resolver
public class HashMapExample {    
    private static final Map<String, Integer> storage = new HashMap<>();

    public void addDomain(String domain, int ip) {
        storage.put(domain, ip);
    }

    public int getDomainIP(String domain) {
        return storage.get(domain);        
    }
}
