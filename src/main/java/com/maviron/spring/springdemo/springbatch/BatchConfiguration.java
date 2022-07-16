package com.maviron.spring.springdemo.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BatchConfiguration.java
 * @Description 批处理配置
 * @createTime 2022年07月15日 14:15:00
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job importUserJob ;

    @Scheduled(fixedRate = 5000000)
    public void printMessage() {
        try {
            JobParameters jobParameters = new JobParametersBuilder().addLong(
                    "time", System.currentTimeMillis()).toJobParameters();
            jobLauncher.run(importUserJob, jobParameters);
            System.out.println("I have been scheduled with Spring scheduler");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Bean
    public JdbcBatchItemWriter<User> writer(){
        JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO user(name,age) VALUES (:name,:age)");
        writer.setDataSource(dataSource);

        return writer;
    }

    @Bean
    public FlatFileItemReader<User> reader(){
        FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
        reader.setResource(new ClassPathResource("users.csv"));
        reader.setLineMapper(new DefaultLineMapper<User>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "name","age"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{
                setTargetType(User.class);
            }});

        }});

        return reader;
    }

    @Bean
    public UserItemProcessor processor(){
        return new UserItemProcessor();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<User, User> chunk(1)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }

}
