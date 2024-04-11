package com.auth2.azuread;


import com.auth2.azuread.controller.rest.JsonHelper;
import com.auth2.azuread.controller.rest.TestMoesl;
import com.google.gson.reflect.TypeToken;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class OkTest {


    @Test
    public void test() {
//        BeanUtils.copyProperties();
//        Semaphore
        final Pattern COLON_SEPARATED_HEX_PAIRS =
                Pattern.compile("^[0-9a-fA-F]{2}(:[0-9a-fA-F]{2})+$");
        String valid = "12:34:56:78:9A:BC";
        String inValid = "1234:5678:9ABC";
        log.info("COLON_SEPARATED_HEX_PAIRS.matcher(valid).matches(); {}", COLON_SEPARATED_HEX_PAIRS.matcher(valid).matches());
        log.info("COLON_SEPARATED_HEX_PAIRS.matcher(valid).matches(); {}", COLON_SEPARATED_HEX_PAIRS.matcher(inValid).matches());
        System.out.println("haha");
    }

    @Test
    public void test2() throws InterruptedException {
//        var map = new ConcurrentSkipListMap<String, String>();
//
//        var vThreads = IntStream.range(0, 10).mapToObj(
//                index -> Thread.ofVirtual().unstarted(() -> {
//                    String before = Thread.currentThread().toString();
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    map.put(before, Thread.currentThread().toString());
//                })
//        ).toList();
//
//        vThreads.forEach(Thread::start);
//        for (Thread t : vThreads) {
//            t.join();
//        }
//        map.forEach((k,v) -> System.out.printf("%1s -> %2s%n", k, v));
    }


//    private static void copyProperties(Object source, Object target) throws BeansException {
//        Assert.notNull(source, "Source must not be null");
//        Assert.notNull(target, "Target must not be null");
//        Class<?> actualEditable = target.getClass();
//        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
//        PropertyDescriptor[] var7 = targetPds;
//        int var8 = targetPds.length;
//        for(int var9 = 0; var9 < var8; ++var9) {
//            PropertyDescriptor targetPd = var7[var9];
//            Method writeMethod = targetPd.getWriteMethod();
//            if (writeMethod != null ) {
//                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
//                if (sourcePd != null) {
//                    Method readMethod = sourcePd.getReadMethod();
//                    if (readMethod != null) {
//                        ResolvableType sourceResolvableType = ResolvableType.forMethodReturnType(readMethod);
//                        ResolvableType targetResolvableType = ResolvableType.forMethodParameter(writeMethod, 0);
//                        boolean isAssignable = !sourceResolvableType.hasUnresolvableGenerics() && !targetResolvableType.hasUnresolvableGenerics() ? targetResolvableType.isAssignableFrom(sourceResolvableType) : ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType());
//                        if (isAssignable) {
//                            try {
//                                if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
//                                    readMethod.setAccessible(true);
//                                }
//                                Object value = readMethod.invoke(source);
//                                if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
//                                    writeMethod.setAccessible(true);
//                                }
//                                writeMethod.invoke(target, value);
//                            } catch (Throwable var18) {
//                                throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", var18);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//    }

    @Test
    public void date() {
        String dateString = "2023/10/09 12:50:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        log.info("{}", LocalDateTime.parse(dateString, formatter).plusSeconds(10));
        log.info("{}", LocalDateTime.now());
        log.info("{}", LocalDateTime.now().isBefore(LocalDateTime.parse(dateString, formatter).plusSeconds(10)));

        AtomicInteger atomicInteger = new AtomicInteger(21);

        String property = System.getProperty("user.home");

        System.out.println("User home directory (with privilege): " + property);
        atomicInteger.set(atomicInteger.intValue() % 20 == 0 ? 20 : atomicInteger.intValue() % 20);

        log.info("a {}", atomicInteger.get());

        List<TestMoesl> testMoesls = new ArrayList<>();
        TestMoesl testMoesl = new TestMoesl();
        testMoesl.setTest("KEY");
        testMoesl.setNum("1");
        TestMoesl testMoesl2 = new TestMoesl();
        testMoesl2.setTest("KEY");
        testMoesl2.setNum("1");
        testMoesls.add(testMoesl);
        testMoesls.add(testMoesl2);

        Map<String, String> s = new HashMap<>();

        s.put("a", "a");
        s.put("a", "a");
        Object a = "11";
        Object b = 11;

        System.out.println(a.getClass().getSimpleName());

        System.out.println(b.getClass().getSimpleName());


    }

    public static String hashSHA256(MessageDigest md, String input) {
        byte[] hash = md.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public void hash(Map<String, Object> s) {
        List<String> sensitive = List
                .of("accountNo", "cisNo", "nameEng", "nameTh", "surnameTh", "accountName", "email", "occupationID", "accountNo", "cisNo", "nameEng", "nameTh", "surnameTh", "accountName", "email", "occupationID", "accountNo", "cisNo", "nameEng", "nameTh", "surnameTh", "accountName", "email", "occupationID", "accountNo", "cisNo", "nameEng", "nameTh", "surnameTh", "accountName", "email", "occupationID", "accountNo", "cisNo", "nameEng", "nameTh", "surnameTh", "accountName", "email", "occupationID", "accountNo", "cisNo", "nameEng", "nameTh", "surnameTh", "accountName", "email", "occupationID", "accountNo", "cisNo", "nameEng", "nameTh", "surnameTh", "accountName", "email", "occupationID", "accountNo", "cisNo", "nameEng", "nameTh", "surnameTh", "accountName", "email", "occupationID");

        sensitive.forEach(e -> {
            if (s.containsKey(e)) {
                Object originalValue = s.get(e);
                if (originalValue != null && !(originalValue instanceof Number || originalValue instanceof CharSequence)) {
                    Map<String, Object> temp = JsonHelper.objectToObjectTypeRef(originalValue, new TypeToken<>() {
                    });
                    hash(temp);
                    s.put(e, temp);
                } else if (sensitive.contains(e)) {
                    if (originalValue != null) {
                        String hashedValue = hashSHA256(md, String.valueOf(originalValue));
//                        String hashedValue = String.valueOf(originalValue)+"hash";
                        s.put(e, hashedValue);
                    }
                }
            }
        });
//            for (String key : s.keySet()) {
//                Object originalValue =  s.get(key);
//                if (originalValue != null && !(originalValue instanceof Number || originalValue instanceof CharSequence)){
//                    Map<String,Object> temp =JsonHelper.objectToObjectTypeRef(originalValue,new TypeToken<>(){});
//                    hash(temp);
//                    s.put(key,temp);
//                }
//                else if (sensitive.contains(key)) {
//                    if (originalValue!=null){
//                        String hashedValue = hashSHA256(md, String.valueOf(originalValue));
////                        String hashedValue = String.valueOf(originalValue)+"hash";
//                        s.put(key, hashedValue);
//                    }
//                }
//            }


    }


    @Test
    public void testfslfs() throws NoSuchAlgorithmException {

        long start = System.currentTimeMillis();
        String resBody = """
                {
                    "cisNo": "1000000002",
                    "requestRef" : "397bac3a-0ff6-11ee-be56-0242ac120002",
                    "openAcctType": "ONLINE",
                    "channel": "KMA",
                    "accountName": "Christ Brown",
                    "holderType": "70",
                    "nationality": "TH",
                    "occupationID": 99,
                    "sellingAgentID": "BAY",
                    "referenceType": "1",
                    "referenceID": "1100811234693",
                    "birthDate": "1999-05-20",
                    "titleThCode": "1",
                    "titleTh": "นาย",
                    "nameTh": "พิเศษ",
                    "surnameTh": "สกุลยาว",
                    "titleEngCode": "1",
                    "titleEng": "Mr",
                    "nameEng": "Special",
                    "surnameEng": "Surlong",
                    "sex": "M",
                    "dividendBankCode": "999",
                    "dividendAccNo": "1007890001",
                    "cAAccNameTh": "พิเศษ",
                    "cAAccNameEng": "สกุลยาว",
                    "taxID": "1100811234693",
                    "homePhone": "",
                    "workPhone": "",
                    "mobilePhone": "0659991234",
                    "email": "ok@gmail.com",
                    "addressNo": "123",
                    "building": "World",
                    "soi": "2",
                    "road": "Land Rd.",
                    "subDistrict": "บางเขน",
                    "district": "เมือง",
                    "province": "กทม",
                    "zipCode": "10987",
                    "shareHolderType": "a",
                    "countryCode": "TH",
                    "portClientFlag": "Y",
                    "botCT": "bot",
                    "effDate": "1999-05-20",
                    "scriplessWTHTax": "Y",
                    "exerciseDWFlag": "Y",
                    "test": {
                      "accountNo":"43201221212"
                    }
                }
                """;

//        Map<String,Object> re = JsonHelper.jsonStringToObjectTypeRef(resBody,new TypeToken<>(){});
//        hash(re);
//        log.info("re {}" , re);
        var res = doMask(resBody);
        log.info("res {}", res);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static String combinedRegex = "(?<=(?i)cisNo|accountNo|citizenId|email|mobile|mobileNo|firstName|lastName|middleName|fullName|customerName|otp|passport|creditCard|laser|mobileOtpNo|nameTh|nameEn|customerEmail|passportNo|firstNameTh|lastNameTh|middleNameTh|firstNameEn|lastNameEn|middleNameEn|dateOfBirth|homePhone|mobilePhone|officePhone|smsMobilePhone|accessToken|contactNo|claimContactNo|confirmedEmail|firstBeneficiaryName|secondBeneficiaryName|requesterName|authorization|x-api-key|thaiName|thaiFName|thaiMname|thaiLName|engName|engFName|engLName|engMName|birthDate|dathOfBirth|idCard|issuredDate|expiredDate|createBy|updateBy|accountName|acctName1|acctName2|englishAcctName)(.*?\"\\s?:\\s?\")(null|\"\"\\s|.?\\b[^\"]*)";
    private static Pattern combinedPattern = Pattern.compile(combinedRegex);
    public static final String MASK_CHAR = "x";
    public static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String format(String string, String format) {
        if (Objects.isNull(string) || Objects.isNull(format)) {
            return string;
        }

        return Try.of(() -> {
            int index = 0;
            StringBuilder resultString = new StringBuilder();
            for (int i = 0; i < format.length(); i++) {
                char c = format.charAt(i);
                if (c == '#') {
                    resultString.append(string.charAt(index));
                    index++;
                } else if (c == 'x' || c == 'X') {
                    resultString.append(c);
                    index++;
                } else {
                    resultString.append(c);
                }
            }
            return resultString.toString();
        }).getOrElse(string);
    }

    public static String doMask(String txt) throws NoSuchAlgorithmException {
        Matcher combinedMatcher = combinedPattern.matcher(txt);

        return combinedMatcher.replaceAll(mr -> mr.group(1) + hashSHA256(md, mr.group(2)));
    }

    public static String maskAllButFirstAndLast(String toMask) {
        if (StringUtils.isBlank(toMask) || StringUtils.equalsIgnoreCase(toMask, "null")) {
            return toMask;
        }
        if (toMask.length() < 4) {
            return MASK_CHAR.concat(MASK_CHAR);
        }
        return toMask.replaceAll("(?!^)(.)(?!$)", MASK_CHAR);
    }

    @Test
    public void testfsf() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());
        String formattedDateTime = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        String date = LocalDateTime.now().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        log.info("foat{}", formattedDateTime);
        log.info("date{}", date);

    }

    @Test
    public void realStickWithReal() {
        try {


            SecureRandom secureRandom = new SecureRandom();
            byte[] secretKey = "SECRET_KEY".getBytes();
            log.info("s{}"  , secretKey);
            int[] secretChunk = new int[secretKey.length];

            for (int i =  0 ;  i < secretKey.length ; i++){
                byte[] temp  = new byte[12];
                secureRandom.nextBytes(temp);
                secretChunk[i] = (secretKey[i] & 0xff) << 24;
            }


                log.info("a{}"  , secretChunk);


            String message = "Hello, World!";
            byte[] messageBytes = message.getBytes();
            int[] H = {
                    0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a,
                    0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19
            };
            int[] K = {
                    0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5,
                    0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
            };
//            for (int i = 0; i < messageBytes.length; i += 64) {
//                int[] chunk = new int[16];
//                for (int j = 0; j < 15; j++) {
//                    chunk[j] = (messageBytes[i + j * 4] & 0xff) << 24 |
//                            (messageBytes[i + j * 4 + 1] & 0xff) << 16 |
//                            (messageBytes[i + j * 4 + 2] & 0xff) << 8 |
//                            (messageBytes[i + j * 4 + 3] & 0xff);
//                }
//                for (int j = 0; j < 8; j++) {
//                    H[j] += chunk[j];
//                }
//            }

            StringBuilder hexString = new StringBuilder();
            for (int h : H) {
                hexString.append(String.format("%08x", h));
            }

            System.out.println("SHA-256: " + hexString.toString());

            String base64Encoded = encodeBase64(secretKey);
            System.out.println("BASE64 "  + base64Encoded);
            System.out.println("decode" + new String(decodeBase64(base64Encoded), StandardCharsets.UTF_8));
            byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);
            String decodedString = new String(decodedBytes);
            System.out.println(decodedString);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private static final char[] BASE64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    private static String encodeBase64(byte[] input) {
        StringBuilder result = new StringBuilder();

        int paddingCount = (3 - (input.length % 3)) % 3;

        for (int i = 0; i < input.length; i += 3) {
            int chunk = ((input[i] & 0xFF) << 16) |
                    ((i + 1 < input.length ? input[i + 1] & 0xFF : 0) << 8) |
                    ((i + 2 < input.length ? input[i + 2] & 0xFF : 0));

            for (int j = 0; j < 4; j++) {
                int index = (chunk >> (18 - j * 6)) & 0x3F;
                result.append(BASE64_CHARS[index]);
            }
        }

        for (int i = 0; i < paddingCount; i++) {
            result.setCharAt(result.length() - 1 - i, '=');
        }

        return result.toString();
    }

    private static byte[] decodeBase64(String input) {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        for (int i = 0; i < input.length(); i += 4) {
            int chunk = 0;
            for (int j = 0; j < 4; j++) {
                if (i + j < input.length()) {
                    chunk |= getBase64Index(input.charAt(i + j)) << (18 - j * 6);
                }
            }

            for (int j = 0; j < 3; j++) {
                int shift = (2 - j) * 8;
                if (i + j < input.length() - 1) {
                    result.write((byte) ((chunk >> shift) & 0xFF));
                }
            }
        }

        return result.toByteArray();
    }


    private static int getBase64Index(char c) {
        for (int i = 0; i < BASE64_CHARS.length; i++) {
            if (BASE64_CHARS[i] == c) {
                return i;
            }
        }
        return -1;
    }


    @Test
    public void testtestse(){
        String url = "/bond-profile/admin/v1/list-all//bond-profile/admin/v1/batch/export-bond-profile//bond-profile/admin/v1/inquiry//bond-account/admin/v1/batch/export-open-account//bond-account/admin/v1/customer/search//bond-account/admin/v1/export//bond-account/admin/v1/list//system-configuration/admin/v1/noti/list//system-configuration/v1/bot/toggle//bond-passbook/admin/v1/book/inquiry//bond-passbook/admin/v1/book/list//bond-passbook/admin/v1/book/txn//bond-passbook/admin/v1/print/preview//bond-profile/admin/v1/list-bond-summary//bond-txn/admin/v1/bond-txn//bond-txn/admin/v1/bond-payment-list//bond-orchestrator/admin/v1/primary/slf/gen-bond-file///bond-orchestrator/admin/v1/primary/slf/send-bond-file//bond-passbook/admin/v1/import/list//bond-txn/admin/v1/export/no-bot//bond-profile/admin/v1/update//bond-profile/admin/v1/publish//bond-txn/admin/v1/maintenance/list//bond-profile/admin/v1/audit-log//bond-passbook/admin/v1/book/update//system-configuration/admin/v1/msg-template/list//bond-account/admin/v1/inquiry//bond-orchestrator/admin/v1/maintenance/refund//bond-account/admin/v1/maintenance/list//system-configuration/admin/v1/channel/list//bond-txn/admin/v1/bond-txn/export//bond-profile/admin/v1/pause//bond-passbook/admin/v1/book/list/export//bond-account/admin/v1/update/shareholder-id//bond-passbook/admin/v1/confirm//bond-orchestrator/admin/v1/maintenance/check-txn//bond-profile/admin/v1/list-bond-summary//bond-txn/admin/v1/account-txn//system-configuration/admin/v1/channel/save//system-configuration/admin/v1/channel/add//system-configuration/admin/v1/msg-template/save//system-configuration/admin/v1/msg-template/add//system-configuration/admin/v1/channel/list///bond-orchestrator/admin/v1/primary/inquiry//bond-orchestrator/admin/v1/maintenance/credit";
        String [] urlSplit = url.split("/");
        List<String> not = new ArrayList<>();
        StringJoiner  list = new StringJoiner(",");

        Arrays.stream(urlSplit).forEach(e->{
            if (StringUtils.isNotBlank(e)&&!not.contains(e)){
                not.add(e);
                list.add("/"+e+"");
            }
        });

        log.info("\n{}",list);
    }

    @Test
    public void dsjkljkllk(){
        List<String> listObjectCode = Arrays.stream("a,b,c".split(",")).toList();
        List<String> listObjectCode2 = Arrays.stream("b,d".split(",")).toList();
        log.info("{}",listObjectCode);
        log.info("{}",listObjectCode2);


        log.info("{}" , listObjectCode.contains("b"));

        double scientificNumber = 2.456456e9;

        // Convert scientific notation to whole number
        long wholeNumber = (long) scientificNumber;

        // Convert the whole number to a string and remove trailing zeros
//        String result = String.valueOf(wholeNumber).replaceAll("0*$", "");

        System.out.println("Converted number: " + wholeNumber);
    }
}

