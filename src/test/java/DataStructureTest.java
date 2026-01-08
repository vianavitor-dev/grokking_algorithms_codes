import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.vianavitor.algorithms.dataStructure.HashMapExample;

public class DataStructureTest {
    @Test
    @DisplayName("Data Structure - HashMap/HashTable")
    public void hashMapExampleTest() {
        HashMapExample dnsResolver = new HashMapExample();

        dnsResolver.addDomain("nasa.com", 12360);
        dnsResolver.addDomain("facebook.com", 15911);
        dnsResolver.addDomain("twitter.com", 14093);
        dnsResolver.addDomain("minecraft.com", 1039);
        
        int facebookIP = dnsResolver.getDomainIP("facebook.com");
        int nasaIP = dnsResolver.getDomainIP("nasa.com");
        int minecraftIP = dnsResolver.getDomainIP("minecraft.com");

        System.out.println(
            "IPs\n facebook: %s\n nasa: %s\n minecraft: %s\n".formatted(facebookIP, nasaIP, minecraftIP)
        );    
        
        List<Integer> results = Stream.of(facebookIP, nasaIP, minecraftIP).toList();
        List<Integer> expectedResults = Stream.of(15911, 12360, 1039).toList();            
    
        assertEquals(expectedResults, results);
    }
}
