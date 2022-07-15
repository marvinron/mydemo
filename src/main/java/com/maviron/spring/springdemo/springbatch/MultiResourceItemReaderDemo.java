package com.maviron.spring.springdemo.springbatch;

import com.maviron.spring.springdemo.entity.Employee;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MultiResourceItemReader.java
 * @Description 读取ItemReader
 * @createTime 2022年07月14日 10:48:00
 */
@Component
public class MultiResourceItemReaderDemo<T> {
    @Value("E:\\tmp\\123.csv")
    private Resource[] inputResources;

    @Bean
    public MultiResourceItemReader<Employee> multiResourceItemReader()
    {
        MultiResourceItemReader<Employee> resourceItemReader = new MultiResourceItemReader<Employee>();
        resourceItemReader.setResources(inputResources);
        resourceItemReader.setDelegate(reader());
        return resourceItemReader;
    }

    @Bean
    public FlatFileItemReader<Employee> reader()
    {
        FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
        //跳过csv文件第一行，为表头
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        //字段名
                        setNames(new String[] { "id", "firstName", "lastName" });
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
                    {
                        //转换化后的目标类
                        setTargetType(Employee.class);
                    }
                });
            }
        });
        return reader;
    }

}
