package com.sijifeng.kafka.javasdk.deprecated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.sijifeng.kafka.javasdk.thrift.Data;

public class DeprecatedKafkaTest {
    @Test
    public void OldkafkaProdecerTest(){
        
       KafkaProducerAdapter adapter = KafkaProducerAdapter.getInstance();
       KafkaConfig kafkaConfig = new KafkaConfig("192.168.78.48:9092", "192.168.78.48:2182");
        try {
            adapter.init(kafkaConfig);
            Map<String, String> dataProps = new HashMap<String, String>();
            dataProps.put("category", "category_test");
            dataProps.put("test11", "56");
            Data data = new Data("host11", "99", 1452541545, new ArrayList<>(), dataProps);
            
            long t1 = System.currentTimeMillis();
            adapter.send("testtopic", data);
            long t2 = System.currentTimeMillis();
            System.out.println("耗时1"+(t2 - t1));
            adapter.send("testtopic", data);
            long t3 = System.currentTimeMillis();
            System.out.println("耗时2"+(t3 - t2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
