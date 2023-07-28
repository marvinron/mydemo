package com.maviron.spring.springdemo.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName CsvTest.java
 * @Description
 * @createTime 2023年07月26日 11:20:00
 */
public class CsvTest {
    public static void readCsv(String path, RBloomFilter<Object> blackDeviceBloomFilter) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(new File(path)));
            CSVReader csvReader = new CSVReader(new InputStreamReader(in, "UTF-8"), CSVParser.DEFAULT_SEPARATOR,
                    CSVParser.DEFAULT_QUOTE_CHARACTER, CSVParser.DEFAULT_ESCAPE_CHARACTER, 0);
            String[] strs;

            while ((strs = csvReader.readNext()) != null) {
                String s = strs[1];
                //boolean add = blackDeviceBloomFilter.add("5f60541dfc654605a874ce0986c13ac5_oaid_" +s);
                System.out.println(strs[1]);
            }

            csvReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RedissonClient redissonClient = getRedissonClient();
        RBloomFilter<Object> blackDeviceBloomFilter = redissonClient.getBloomFilter("blackOAIDBloomFilter");
        blackDeviceBloomFilter.tryInit(100000000L, 0.05);
        readCsv("src/main/resources/xintongyuan-oaid-1.csv", blackDeviceBloomFilter);
        redissonClient.shutdown();
    }

    private static RedissonClient getRedissonClient() {
        String auth = "Gameley668";
        String clusterUrl = "bj-crs-934sdw1s.sql.tencentcdb.com";
        String clusterPort = "22022";
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + clusterUrl + ":" + clusterPort);
        config.useSingleServer().setPassword(auth);
        return Redisson.create(config);
    }
}
