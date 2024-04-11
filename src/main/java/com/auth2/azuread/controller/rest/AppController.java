package com.auth2.azuread.controller.rest;


import com.auth2.azuread.AzureadApplication;
import com.auth2.azuread.controller.rest.cache.CustomerService;
import com.auth2.azuread.controller.rest.predict.PredictService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.pheerathach.ThaiQRPromptPay;
import com.google.zxing.WriterException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.extern.slf4j.Slf4j;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


@RestController
@RequestMapping("/api")
@Tag(name = "App", description = "AppController Document APIs")
@Slf4j
public class AppController {

    @Value("${app.namespace}")
    public String namespace;
    private final CustomerService customerService;
    private static final Logger logger = LogManager.getLogger(AppController.class);

    @Autowired
    private PredictService predictService;


    private final OAuth2AuthorizedClientService authorizedClientService;

    public AppController(CustomerService customerService, OAuth2AuthorizedClientService authorizedClientService) {
        this.customerService = customerService;

        this.authorizedClientService = authorizedClientService;
    }


    @GetMapping("/certificate")
    public String home(HttpServletRequest request) {
        // Extract client certificate from the request
        X509Certificate[] clientCertificates = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");

        // Check if client certificate exists
        if (clientCertificates != null && clientCertificates.length > 0) {
            // Perform validation or extract information from the client certificate
            // For example:
            String clientCN = clientCertificates[0].getSubjectDN().getName();
            return "Hello, " + clientCN + "! Your certificate is valid.";
        } else {
            // No client certificate provided or validation failed
            return "Client certificate not provided or validation failed.";
        }
    }
    @GetMapping
    public String index() {

        Logger logger = LogManager.getLogger(AppController.class);
        logger.info("Index :: Logging Message !");
        String foo = "";
        try {
            foo.charAt(18);
        } catch (Exception e) {
            logger.error(e);
        }



        return "index";
    }




    @PostMapping(path = "/login/Oauth/github")
    public void callBack(@RequestBody Map<Object, Object> body) {
        log.info("body {}", body);
    }

    @GetMapping(path = "/auth")
    public String hello(OAuth2AuthenticationToken authentication) {



        log.info("{}", authentication.getPrincipal().getAttributes());


        return "helloWord";
    }

    @GetMapping(path = "/init")
    public ResponseModel<String> init() {
        return customerService.init();
    }


    @Operation(
            summary = "Get List CustomerModel",
            description = "description",
            tags = {"Customer"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = ResponseModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(),mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(),mediaType = MediaType.APPLICATION_JSON_VALUE)})})
    @GetMapping(path = "/getAllData")
    @ResponseBody
    public ResponseModel<List<CustomerModel>> getAllDataCustomer() {
        return customerService.getAllDataCustomer();
    }

    @GetMapping(path = "/get/{id}")
    public ResponseModel<CustomerEntity> getById(@PathVariable(name = "id")Long id) {
        return customerService.getById(id);
    }

//    @GetMapping("/generate-qr")
//    public String generateQR() {
//        String promptPayId = "YOUR_PROMPTPAY_ID";
//        double amount = 100.0;
//
//        String promptPayQRText = "00020101021129370016A00000067701011101130066991234567890123130066"
//                + promptPayId + "5802TH53037646304" + String.format("%.2f", amount) + "53037646304" + String.format("%.2f", amount) + "6304";
//
//        ByteArrayOutputStream out = QRCode.from(promptPayQRText).to(ImageType.PNG).stream();
//        byte[] qrBytes = out.toByteArray();
//
//        File folder = new File("/qrCode");
//        if (!folder.exists()) {
//            folder.mkdir();
//        }
//        String filePath = "/qrCode/qrcode.png";
//        try (FileOutputStream fos = new FileOutputStream(filePath)) {
//            fos.write(qrBytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "http://localhost:8080/api/qr" + filePath;
//    }

    @GetMapping(value = "/generate-qr", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQR() {
        String promptPayId = "0943248965";
        double amount = 100.0;

        String promptPayQRText = "00020101021129370016A00000067701011101130066991234567890123130066"
                + promptPayId + "5802TH53037646304" + String.format("%.2f", amount) + "53037646304" + String.format("%.2f", amount) + "6304";

        ByteArrayOutputStream out = QRCode.from(promptPayQRText).to(ImageType.PNG).withSize(720, 1024).stream();
        byte[] qrBytes = out.toByteArray();

        return qrBytes;
    }

    @Operation(
            summary = "generateQR",
            description = "description",
            tags = {"QRCODE"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = MediaType.IMAGE_PNG_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ResponseModel.class),mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ResponseModel.class),mediaType = MediaType.APPLICATION_JSON_VALUE)})})
    @PostMapping("/generate/qr")
    public byte[] generateQRProm(@RequestBody QrModel qrModel) throws IOException, WriterException {

        ThaiQRPromptPay qr = new ThaiQRPromptPay.Builder().staticQR().creditTransfer().mobileNumber(qrModel.getPhone()).amount(new BigDecimal(qrModel.getAmount())).build();


        return qr.drawToByteArray(1000, 1000);
    }

    @PostMapping("/Test")
    public String Test() throws IOException, WriterException {

        return "Test Post";
    }


    @PostMapping("/predict")
    public byte[] getPredict(@RequestParam MultipartFile file){
        try {
            predictService.predict(file);
        }catch (Exception ex){
            ex.printStackTrace();
            log.info("ex {}" , ex.getMessage());
        }
        return null;
    }
    @GetMapping("/soap/test")
    public ResponseEntity<String> soapTest(){
        Envelope envelope = new Envelope();
        Body body = new Body();
        Divide divide = new Divide();
        divide.setIntA(5);
        divide.setIntB(5);
        body.setDivide(divide);
        envelope.setBody(body);

//        Class<XmlRootElement> annotationType = (Class<XmlRootElement>) envelope.getClass().getAnnotation(XmlRootElement.class).getClass();
//        Class<XmlRootElement> annotationType = (Class<XmlRootElement>) envelope.getClass().getAnnotation(XmlRootElement.class).getClass();
//
//        XmlRootElement myAnnotation = AnnotationSetter.setAnnotationValue(annotationType, namespace);



//                XmlRootElement xmlRootElement = envelope.getClass().getAnnotation(XmlRootElement.class);


//        Class<Envelope> annotationType = Envelope.class;
//
//        // Set the value of the annotation using the dynamic proxy
//        Envelope envelope1 = AnnotationSetter.setAnnotationValue(annotationType, "custom_value");
//
//        // Retrieve and print the annotation value
//        try {
//            Method method = annotationType.getMethod("namespace");
//            String annotationValue = (String) method.invoke(myAnnotation);
//            System.out.println("Annotation Value: " + annotationValue);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        log.info("Envelope {}" ,envelope.getClass().getAnnotation(XmlRootElement.class).namespace());

//        final XmlRootElement oldAnnotation = Envelope.class.getAnnotation(XmlRootElement.class);
//                System.out.println("oldAnnotation = " + oldAnnotation.namespace());
//        Annotation newAnnotation = new XmlRootElement(){
//            @Override
//            public Class<? extends Annotation> annotationType() {
//                return oldAnnotation.annotationType();
//            }
//            @Override
//            public String namespace() {
//                return namespace;
//            }
//            @Override
//            public String name() {
//                return "Body";
//            }
//        };
//
//
//
//        System.out.println("oldAnnotation = " + oldAnnotation.namespace());
//
//        try {
////            Field field = Class.class.getDeclaredField("annotations");
////            field.setAccessible(true);
////            Method method = Class.class.getDeclaredMethod("setDeclaredAnnotations", null);
////            method.setAccessible(true);
//
//            Field annotationsField = Class.class.getDeclaredField("ANNOTATIONS");
//            annotationsField.setAccessible(true);
//
//            Map<Class<? extends Annotation>, Annotation> annotations = new HashMap<>();
//            Annotation[] existingAnnotations = Envelope.class.getDeclaredAnnotations();
//            for (Annotation annotation : existingAnnotations) {
//                annotations.put(annotation.annotationType(), annotation);
//            }
//            annotations.put(XmlRootElement.class, newAnnotation);
//            annotationsField.set(Envelope.class, annotations);
//
//            XmlRootElement modifiedAnnotation =  Envelope.class.getAnnotation(XmlRootElement.class);
//            System.out.println("modifiedAnnotation = " + modifiedAnnotation.namespace());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        CustomNamespacePrefixMapper namespacePrefixMapper = new CustomNamespacePrefixMapper();
//        log.info("namespace {}" , namespace);
//        try {
//            setAnnotationValue(xmlRootElement,namespace);
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//

//        try {
//            JAXBContext context = JAXBContext.newInstance(envelope.getClass());
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.setProperty("com.sun.xml.bind.marshaller.namespacePrefixMapper", new CustomNamespacePrefixMapper(namespace,"soap"));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }


//        try {
//            JAXBContext context = JAXBContext.newInstance(Envelope.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            // Get the namespace value from Constant.getNamespace()
//            String namespace = this.namespace;
//            // Set the namespace value dynamically for the root element
//            marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new CustomNamespacePrefixMapper(namespace));
//            marshaller.marshal(envelope, System.out);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        String xmlContent = marshalToXml(envelope);

//        log.info("\n {}" , xmlContent);



        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);

//        String xmlContent = getXml(namespace);

        HttpEntity<String> httpEntity = new HttpEntity<>(xmlContent, headers);

        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<String> response = restTemplate.postForEntity("http://www.dneonline.com/calculator.asmx", httpEntity, String.class);
        log.info("response body {}" , response.getBody());
        try {
            XmlMapper xmlMapper = new XmlMapper();
            EnvelopeResponse envelopeResponse = xmlMapper.readValue(response.getBody(), EnvelopeResponse.class);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String json = objectMapper.writeValueAsString(envelopeResponse);
            return new ResponseEntity<>(json,HttpStatus.OK);

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null ,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private String marshalToXml(Object object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(object, sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void setAnnotationValue(XmlRootElement annotation, String newValue)
            throws Exception {


        Method valueMethod = annotation.getClass().getDeclaredMethod("namespace");
        valueMethod.setAccessible(true);
        String[] strings = ((String[]) valueMethod.invoke(newValue));
        log.info("strings {}" ,strings);

//        valueMethod.invoke(annotation, newValue);
    }

    public static String getXml(String namespace){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ns2:Envelope xmlns=\"http://tempuri.org/\" xmlns:ns2=\""+namespace+"\">\n" +
                "    <ns2:Body>\n" +
                "        <Divide>\n" +
                "            <intA>5</intA>\n" +
                "            <intB>5</intB>\n" +
                "        </Divide>\n" +
                "    </ns2:Body>\n" +
                "</ns2:Envelope>";
    }
    public static <T> T jsonStringToObject(String jsonStringValue, Class<T> clazz) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return  xmlMapper.readValue(jsonStringValue, clazz);
        }catch (Exception ex){

        }
        return  null;
    }
}
