package com.maviron.spring.springdemo.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.*;
import java.math.BigDecimal;
import java.util.UUID;

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
    public static String readTxt(File file) throws IOException {
        String s = "";
        InputStreamReader in = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader br = new BufferedReader(in);
        StringBuffer content = new StringBuffer();
        while ((s=br.readLine())!=null){
            System.out.println(s);
        }
        return content.toString();
    }

    public static void main(String[] args) throws Exception{
        RedissonClient redissonClient = getRedissonClient();
        RRateLimiter rateLimiter = redissonClient.getRateLimiter("rqps_3157");
        boolean b = rateLimiter.tryAcquire();
        System.out.println(b);
        //RBloomFilter<Object> blackDeviceBloomFilter = redissonClient.getBloomFilter("pddstate0822BloomFilter");
        //boolean contains = blackDeviceBloomFilter.contains("72f8c713d9174c158b3ee769d3d5db03_oaid_07D7D3C3A8A94045882A54E5AAD9D8F19b19c62594852d831242a1ad5f227c84");
        //System.out.println(contains);
        //blackDeviceBloomFilter.tryInit(100000000L, 0.05);
        //readCsv("src/main/resources/xintongyuan-oaid-1.csv", blackDeviceBloomFilter);
        //redissonClient.shutdown();
        //readTxt(new File("E:\\myproject\\maviron\\src\\main\\resources\\123.txt"));
        //String replace = UUID.randomUUID().toString().replace("-", "");
        //System.out.println(replace);
        //String bigDecimal = new BigDecimal(5).add((new BigDecimal(5).multiply(new BigDecimal(1).divide(new BigDecimal("100"))))).setScale(2,BigDecimal.ROUND_DOWN).toString();
        //System.out.println(bigDecimal);
        //String result = new BigDecimal(5.05).add((new BigDecimal(5.05).multiply(new BigDecimal(15).divide(new BigDecimal("100"))))).setScale(2,BigDecimal.ROUND_DOWN).toString();
        //System.out.println(result);
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
