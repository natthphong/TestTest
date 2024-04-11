//package com.auth2.azuread.test;
//
//
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.access.method.P;
//
//import java.security.SecureRandom;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.*;
//import java.util.stream.IntStream;
//
//@Configuration
//@Slf4j
//public class MockData {
//
//    private final TransactionRepository transactionRepository;
//
//    private final JdbcTemplate jdbcTemplate;
//
//    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//    private static final SecureRandom RANDOM = new SecureRandom();
//
//    private static final Random rand = new Random();
//    private static final Map<Integer,String> typeEmail = Map.of(1,"@hotmail.com",2,"@gmail.com",3,"@example.com");
//    private static final Map<Integer,String> typeTxn = Map.of(1,"SELL",2,"BUY");
//    private static final Map<Integer,String> admin = Map.of(1,"TAR",2,"FILM", 3,"ARM",4 , "JOHN",5,"EM",6,"MOMO");
//
//
//
//
//    public MockData(TransactionRepository transactionRepository, JdbcTemplate jdbcTemplate) {
//        this.transactionRepository = transactionRepository;
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public static String generateRandomEmail(int length , String str) {
//        StringBuilder stringBuilder = new StringBuilder(length);
//        for (int i = 0; i < length; i++) {
//            stringBuilder.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
//        }
//        return stringBuilder.toString() +str ;
//    }
//
//    public static int generateRandomNumber(int min, int max) {
//        if (min >= max) {
//            throw new IllegalArgumentException("Max must be greater than min");
//        }
//
//        return rand.nextInt(min, max + 1);
//    }
//
//
//    @PostConstruct
//    public void initMock(){
//        List<Transaction> transactions = new ArrayList<>();
//        IntStream.rangeClosed(1,1120000).forEach(e->{
//            int day = generateRandomNumber(10,900);
//            LocalDateTime now = LocalDateTime.now().minusDays(day);
//            Transaction tempTransaction = new Transaction();
//            tempTransaction.setCreateDate(now);
//            tempTransaction.setCreateBy(admin.get(generateRandomNumber(1,6)));
//            tempTransaction.setRequestRef(UUID.randomUUID().toString());
//            tempTransaction.setEmail(generateRandomEmail(generateRandomNumber(10,20),typeEmail.get(generateRandomNumber(1,3))));
//            tempTransaction.setCreateDate(LocalDateTime.now());
//            tempTransaction.setTxnType(typeTxn.get(generateRandomNumber(1,2)));
//            tempTransaction.setCurrentPrice(generateRandomNumber(1000,9999999));
//            tempTransaction.setConfirmDate(now.plusDays(generateRandomNumber(3,day)));
//            tempTransaction.setSaleId("0430"+generateRandomNumber(2000,999000));
//            transactions.add(tempTransaction);
//        });
////
////        log.info("tempTransaction {}" , transactions);
////        transactionRepository.saveAll(transactions);
//
//
//        long start = System.currentTimeMillis();
//        System.out.println("START");
//        String sql = "INSERT INTO tbl_transaction (txn_type, current_price, request_ref, status, email, confirm_date, sale_id, create_date, create_by) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement statement, int i) throws SQLException {
//
//                Transaction tempTransaction = transactions.get(i);
//
//                statement.setString(1, tempTransaction.getTxnType());
//                statement.setInt(2, tempTransaction.getCurrentPrice());
//                statement.setString(3, tempTransaction.getRequestRef());
//                statement.setString(4, tempTransaction.getStatus());
//                statement.setString(5, tempTransaction.getEmail());
//                 statement.setTimestamp(6, Timestamp.valueOf(tempTransaction.getConfirmDate())); // Uncomment and set confirm_date logic
//                statement.setString(7, tempTransaction.getSaleId()); // Set sale_id
//                statement.setTimestamp(8, Timestamp.valueOf(tempTransaction.getCreateDate()));
//                statement.setString(9, tempTransaction.getCreateBy());
//
//
//            }
//
//            @Override
//            public int getBatchSize() {
//                return transactions.size();
//            }
//        });
//
//        System.out.println("STOP");
//        System.out.println(  System.currentTimeMillis() -start);
//    }
//}
