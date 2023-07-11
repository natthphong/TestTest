package com.auth2.azuread.controller.rest;


import com.auth2.azuread.controller.rest.cache.CustomerService;
import com.github.pheerathach.ThaiQRPromptPay;
import com.google.zxing.WriterException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
@Tag(name = "App", description = "AppController Document APIs")
@Slf4j
public class AppController {
    private final CustomerService customerService;


    private final OAuth2AuthorizedClientService authorizedClientService;

    public AppController(CustomerService customerService, OAuth2AuthorizedClientService authorizedClientService) {
        this.customerService = customerService;

        this.authorizedClientService = authorizedClientService;
    }

    @GetMapping
    public String index() {


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
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = ResponseModel.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(),mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(),mediaType = MediaType.APPLICATION_JSON_VALUE)})})
    @GetMapping(path = "/getAllData")
    public ResponseModel<List<CustomerModel>> getAllDataCustomer() {
        return customerService.getAllDataCustomer();
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
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(),mediaType = MediaType.APPLICATION_JSON_VALUE)})})
    @PostMapping("/generate/qr")
    public byte[] generateQRProm(@RequestBody QrModel qrModel) throws IOException, WriterException {

        ThaiQRPromptPay qr = new ThaiQRPromptPay.Builder().staticQR().creditTransfer().mobileNumber(qrModel.getPhone()).amount(new BigDecimal(qrModel.getAmount())).build();


        return qr.drawToByteArray(1000, 1000);
    }

    @PostMapping("/Test")
    public String Test() throws IOException, WriterException {

        return "Test Post";
    }

}
