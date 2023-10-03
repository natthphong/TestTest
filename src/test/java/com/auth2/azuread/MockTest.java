package com.auth2.azuread;

import com.auth2.azuread.controller.rest.*;

import com.auth2.azuread.test.Iam2MsUser;
import com.google.gson.reflect.TypeToken;

import jakarta.validation.constraints.Future;
import jdk.jfr.consumer.RecordingStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.batch.core.annotation.AfterStep;


import javax.crypto.*;
import java.awt.print.Book;
import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class MockTest {
    public static volatile int a3 = 5;
    @InjectMocks
    private AppController appController;

    @Before
    public void setup() {

    }

    @Test
    public void contextLoads() {


        Function<Integer, Boolean> isOdd = value -> value % 2 != 0;
        Boolean answer = isOdd.apply(1);
        String date = Constant.dateToString.apply(new Date(System.currentTimeMillis()));
        log.info("date {}", date);
        log.info("answer {}", answer);
    }


    @Test
    public void logicTest() {
        Collection<String> collection = List.of("10", "2", "3", "7", "10", "7", "1");
        List<String> lista = collection.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }).toList();
        log.info("collection {}", lista);

        List<String> list = IntStream.range(1, 100).mapToObj(e -> "test" + e).toList();
        List<String> list1 = IntStream.range(0, 100).filter(value -> value % 2 != 0).mapToObj(e -> "Odd value : " + e).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).toList();
        log.info("list {}", list);
        log.info("list1 {}", list1);
    }

    @Test
    public void TestJson() {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setUsername("tar");
//        customerModel.setTestLocalDate(LocalDate.now());
        customerModel.setTestLocalDateTime(LocalDateTime.now());
        String username = JsonHelper.objectToJsonString(customerModel);
        log.info("username {}", username);
        List<CustomerModel> customerModels = new ArrayList<>();
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        String List = JsonHelper.objectToJsonString(customerModels);
        log.info(" {}", List);

        List<CustomerModel> newCustomerModels = JsonHelper.jsonStringToObjectTypeRef(List, new TypeToken<List<CustomerModel>>() {
        });
        log.info("{}", newCustomerModels);
    }

    //    private List<Consumer<String>> eventListeners = new ArrayList<>();
//
//    public void addEventListener(Consumer<String> listener) {
//        eventListeners.add(listener);
//    }
//
//    public void produceEvent(String eventData) {
//        eventListeners.forEach(listener -> listener.accept(eventData));
//    }
//
//    @Test
//    void test() throws Exception {
//        List<RecordedEvent> events = new ArrayList<>();
//
//        try (RecordingStream rs = new RecordingStream()) {
//            MockTest eventProducer = new MockTest();
//            eventProducer.addEventListener(event -> rs.onEvent("Myevent", e -> events.add(e)));
//            rs.startAsync();
//
//            // Generate an event using EventProducer
//            eventProducer.produceEvent("Event data");
//        }
//
//        Assert.assertEquals(1, events.size());
//        RecordedEvent recordedEvent = events.get(0);
//        Assert.assertEquals("Event data", recordedEvent.getEventData("eventData"));
//    }
//}
//
// class RecordedEvent {
//    private String eventData;
//
//    public RecordedEvent(String eventData) {
//        this.eventData = eventData;
//    }
//
//    public String getEventData() {
//        return eventData;
//    }

    public int maximalNetworkRank(int n, int[][] roads) {
        log.info(" {}  {}", n, roads);
        for (int i = 0; i < roads.length; i++) {

        }
        return 0;
    }

    public void addPoint(int a) {
        a++;
    }

    public void addPoint(CustomerEntity a) {
        int temp = a.getAge() + 1;
        a.setAge(temp);
    }


    public void addPoint(int[] a) {
        a[0]++;
    }


    public void addPoint(AtomicInteger atomicInteger) {
        atomicInteger.incrementAndGet();
    }

    @Test
    public void maxNetWork() {
        int a = 5;
        int[] a2 = {5};
        AtomicInteger counter = new AtomicInteger();
        counter.set(5);
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setAge(5);
        addPoint(a2);
        addPoint(a);
        addPoint(counter);
        addPoint(customerEntity);
        System.out.println(a);
        System.out.println(a2[0]);
        System.out.println(counter.get());
        log.info("{}", customerEntity);
    }

    @Test
    public void testKey() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        String jsonData = "{\"username\":\"root\",\"password\":\"password\"}";

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey key = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(jsonData.getBytes());

        String encodedEncryptedData = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encoded and encrypted data: " + encodedEncryptedData);

        int partSize = encodedEncryptedData.length() / 5;
        String[] parts = new String[5];
        for (int i = 0; i < 5; i++) {
            int startIndex = i * partSize;
            int endIndex = (i == 4) ? encodedEncryptedData.length() : (i + 1) * partSize;
            parts[i] = encodedEncryptedData.substring(startIndex, endIndex);
        }

        log.info("parts {}", parts);

        String reconstructedEncodedEncryptedData = "fsdfsfs";
        for (String part : parts) {
            reconstructedEncodedEncryptedData += part;
        }
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(reconstructedEncodedEncryptedData));
            String decryptedData = new String(decryptedBytes);
            System.out.println("Decrypted data: " + decryptedData);
        } catch (Exception e) {
            System.out.println("Error: Failed to decrypt data. Incorrect key or data has been tampered.");
        }
    }


    @Test
    public void testMemory() {



//        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);



        int bufferSize = 1024;
        ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);
        buffer.putInt(2);
        buffer.putChar('1');
        String test = "Hello world";
        buffer.putInt(test.length());
        buffer.put(test.getBytes());
        buffer.flip();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getChar());
        int length = buffer.getInt();
        System.out.println(length);
        byte[] read = new byte[length];
        buffer.get(read);
        String hello = new String(read);
        System.out.println(hello);
        buffer.clear();
    }

    @Test
    public void testPalle() throws InterruptedException {
        int numThreads = 4;


        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        CountDownLatch latch = new CountDownLatch(numThreads);


        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();


        AtomicInteger counter = new AtomicInteger();

        for (int i = 0; i < numThreads; i++) {
            final int threadNum = i;
            executor.submit(() -> {
                System.out.println("Thread " + threadNum + " started");


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                int newValue = counter.incrementAndGet();
                System.out.println("Thread " + threadNum + " counter: " + newValue);


                concurrentMap.put("Thread " + threadNum, newValue);

                latch.countDown();

                System.out.println("Thread " + threadNum + " finished");
            });
        }


        latch.await();

        System.out.println("All threads finished");
        System.out.println("Final counter value: " + counter.get());
        System.out.println("Concurrent map: " + concurrentMap);


        executor.shutdown();
    }


    @Test
    public void testSchedule() {
        Timer timer = new Timer();
        Calendar midnight = Calendar.getInstance();
        midnight.set(Calendar.HOUR_OF_DAY, 0);
        midnight.set(Calendar.MINUTE, 0);
        midnight.set(Calendar.SECOND, 0);
        midnight.add(Calendar.DAY_OF_MONTH, 1); // Next day
        long initialDelay = midnight.getTimeInMillis() - System.currentTimeMillis();


    }

    @Test
    public void testpol() {
//        Object a = 1;
//        int b = (int) a;
//        List<Integer> test = IntStream.rangeClosed(1, 100).boxed().toList();
        int mid = (120 + 9) >> 3;   // 129  = 10000001
        log.info("mid{}" , mid);   // 64 = 01000000
        long high = 4_723_372_036_854_775_807L;
        long low =  4_723_372_036_854_775_807L;
        System.out.println("mid using >>> 1 = " + ((low + high) >>> 1));
        System.out.println("mid using / 2   = " + ((low + high) / 2));
        int bitmask = 0x000F; //        0000  0000 0000  1111 &
        int val = 0x2222;  //           0010  0010 0010  0010
                            //          0000  0000 0000  0010
        System.out.println(val & bitmask);
        int mid2 = -8 >>> 1;
        System.out.println(mid2);
        int mid3 = -8 >> 1;
        System.out.println(mid3);
        Random rand = new Random();
        Random rand2 = new SecureRandom();

        String a = String.join("|", new String[]{"natthapong", "jaroenpronprasit"});
        log.info("a {}" , a);

        log.info("{}" ,rand.nextInt(100));
        log.info("{}" ,rand2.nextInt(100));

    }

    @Test
    public void testProcess() throws IOException, InterruptedException {
        String currentPath = System.getProperty("user.dir");
        String scriptPath = currentPath + "/helloworld.sh";
        ProcessBuilder processBuilder = new ProcessBuilder("sh", scriptPath);
        processBuilder.redirectErrorStream(true);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process process = processBuilder.start();
        AtomicInteger i = new AtomicInteger(1);
//        Thread.startVirtualThread(() -> {
//            System.out.printf(" test %s  %d :  ", System.currentTimeMillis(), i.incrementAndGet());
//        });
        int exitCode = process.waitFor();
        process.destroy();
        System.out.println("Script exited with code: " + exitCode);
    }


    //1.393
    //1.236
    //1.375
    //1.383
    //1.641
    //1.345
    @Test
    public void simpleTestStream(){
        long current =  System.currentTimeMillis();
        StringBuilder test= new StringBuilder();
        IntStream.rangeClosed(1,68888897).forEach(test::append);
        long end =  System.currentTimeMillis();
        double now = (double) (end - current) /1000;
        System.out.println("test: " +test.length()+" time: "+now + " seconds");
    }

    //1.578
    //1.131
    //1.167
    //1.565
    //1.221
    //1.211
    @Test
    public void simpleTestStream2(){
        long current =  System.currentTimeMillis();
        StringBuilder test= new StringBuilder();
        for (int i = 1 ; i<=68888897;i++) {
            test.append(i);
        }
        long end =  System.currentTimeMillis();
        double now = (double) (end - current) /1000;
        System.out.println("test: " +test.length()+" time: "+now + " seconds");
    }


    //1.577
    //1.245
    //1.175
    //1.123
    //0.99
    @Test
    public void simpleTestObjectStream(){
        List<Iam2MsUser> temp = IntStream.rangeClosed(1,10000000)
                .mapToObj(e->Iam2MsUser.builder()
                        .firstNameTh("test"+e)
                        .lastNameTh("test"+e)
                        .isAdmin("True")
                        .createdDate(new java.util.Date())
                        .build())
                .toList();
        StringBuilder test= new StringBuilder();
        long current =  System.currentTimeMillis();
        temp.forEach(e->test.append("name : ")
                .append(e.getFirstNameTh())
                .append(" lastName: ")
                .append(e.getLastNameTh())
                .append(" admin :")
                .append(e.getIsAdmin()));
        long end =  System.currentTimeMillis();
        double now = (double) (end - current) /1000;
        System.out.println("test: " +test.length()+" time: "+now + " seconds");
    }

    //1.246
    //1.021
    //1.724
    //1.144
    //1.096
    @Test
    public void simpleTestObject2Stream(){
        List<Iam2MsUser> temp = IntStream.rangeClosed(1,10000000)
                .mapToObj(e->Iam2MsUser.builder()
                        .firstNameTh("test"+e)
                        .lastNameTh("test"+e)
                        .isAdmin("True")
                        .createdDate(new java.util.Date())
                        .build())
                .toList();
        StringBuilder test= new StringBuilder();
        long current =  System.currentTimeMillis();
        for (var e: temp){
            test.append("name : ")
                    .append(e.getFirstNameTh())
                    .append(" lastName: ")
                    .append(e.getLastNameTh())
                    .append(" admin :")
                    .append(e.getIsAdmin());
        }
        long end =  System.currentTimeMillis();
        double now = (double) (end - current) /1000;
        System.out.println("test: " +test.length()+" time: "+now + " seconds");
    }

    //1.215
    //1.36
    //1.629
    //1.282
    //1.29
    @Test
    public void simpleTestObject3Stream(){
        List<Iam2MsUser> temp = IntStream.rangeClosed(1,10000000)
                .mapToObj(e->Iam2MsUser.builder()
                        .firstNameTh("test"+e)
                        .lastNameTh("test"+e)
                        .isAdmin("True")
                        .createdDate(new java.util.Date())
                        .build())
                .toList();
        StringBuilder test= new StringBuilder();
        long current =  System.currentTimeMillis();
        for (int i = 0 ;i < temp.size() ; i++){
            var e  = temp.get(i);
            test.append("name : ")
                    .append(e.getFirstNameTh())
                    .append(" lastName: ")
                    .append(e.getLastNameTh())
                    .append(" admin :")
                    .append(e.getIsAdmin());
        }
        long end =  System.currentTimeMillis();
        double now = (double) (end - current) /1000;
        System.out.println("test: " +test.length()+" time: "+now + " seconds");
    }



    @Test
    public void testThread(){
        long start = System.currentTimeMillis();
        final String[] a = {null};
        final String[] b = {null};
        var th1 = new Thread(() -> a[0] =sleep("1"));
        var th2 = new Thread(() -> b[0] = sleep("2"));
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        log.info("Done :  {}", String.format("%5s ms", System.currentTimeMillis() - start));

        log.info("x {}" , a);
        log.info("x {}" , b);
    }

    public String sleep(String a){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "WAKE UP " + a;
    }

    @Test
    public void pocCom(){
        long start = System.currentTimeMillis();

        CompletableFuture<String> one = CompletableFuture.supplyAsync(() -> sleep("1"));
        CompletableFuture<String> two = CompletableFuture.supplyAsync(() -> sleep("2"));
        Map<String,String> x = null;
        try {
            x = CompletableFuture.allOf(one, two).thenApply(unused -> {
                String oneResult = one.join();
                String twoResult = two.join();
                Map<String, String> result = new HashMap<>();
                result.put("oneResult", oneResult);
                result.put("twoResult", twoResult);
                log.info("Done :  {}", String.format("%5s ms", System.currentTimeMillis() - start));
                return result;
            }).exceptionally(throwable -> {
                log.error("Error : {} ", throwable.getMessage());
                Map<String,String> result = new HashMap<>();
                result.put("ERROR", throwable.getMessage());
                return result;
            }).get();
        } catch (InterruptedException | ExecutionException e) {
           e.printStackTrace();
        }

        assert x != null;
        log.info("x {}" , x.get("oneResult"));
        log.info("x {}" , x.get("twoResult"));


    }
    @Test
    public void pocCom2(){
        long start = System.currentTimeMillis();
        sleep("1");
        sleep("2");
        log.info("Done :  {}", String.format("%5s ms", System.currentTimeMillis() - start));
    }
}



