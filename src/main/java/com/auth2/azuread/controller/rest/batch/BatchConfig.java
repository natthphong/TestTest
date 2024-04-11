//package com.auth2.azuread.controller.rest.batch;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//
////@Configuration
////@EnableBatchProcessing
////@EnableAutoConfiguration
//@Slf4j
//public class BatchConfig {
//    @Bean
//    public FlatFileItemReader<Person> reader() {
//        Resource resource = new ClassPathResource("sample-data.csv");
//
//        log.info("resource {}");
//        return new FlatFileItemReaderBuilder<Person>()
//                .name("personItemReader")
//                .resource(new ClassPathResource("sample-data.csv"))
//                .delimited()
//                .names(new String[]{"firstName", "lastName"})
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//                    setTargetType(Person.class);
//                    log.info("hello");
//                }})
//                .build();
//    }
//
//    @Bean
//    public PersonItemProcessor processor() {
//        return new PersonItemProcessor();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Person> writer(DataSource dataSource)  {
//        log.info("writer {}");
//        return new JdbcBatchItemWriterBuilder<Person>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
//                .dataSource(dataSource)
//                .build();
//    }
//
////    @Bean(name = "step1")
////    public Step step1(JobRepository jobRepository,
////                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Person> writer) {
////        log.info("hello step1{}");
////        return new StepBuilder("step1", jobRepository)
////                .<Person, Person>chunk(10, transactionManager)
////                .reader(reader())
////                .processor(processor())
////                .writer(writer)
////                .build();
////    }
//
//    @Bean
//    public Job importUserJob(JobRepository jobRepository,
//                             JobCompletionNotificationListener listener, @Qualifier
//                                         ("step1")Step step1) {
//        log.info("importUserJob{}",step1.getStartLimit());
//        return new JobBuilder("importUserJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1)
//                .end()
//                .build();
//    }
//
//
//
//
//}
