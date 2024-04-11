package com.auth2.azuread.test;


import jakarta.persistence.Column;
import jakarta.persistence.criteria.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tar/map")
@Slf4j
public class Iam2MsUserSpecificationsTest {

    private final Iam2MsUserRepository iam2MsUserRepository;

    public Iam2MsUserSpecificationsTest(Iam2MsUserRepository iam2MsUserRepository) {
        this.iam2MsUserRepository = iam2MsUserRepository;
    }



    public static Specification<Iam2MsUser> firstNameTh(String keyword) {
        return (root, query, criteriaBuilder) -> {
            Root<Iam2MsUser> iamMsUserRoot = root;

//            String collatedExpression = iamMsUserRoot.get("firstNameTh").as(String.class) + " COLLATE THAI_BIN";
//            Expression<String> collatedPath = criteriaBuilder.literal(collatedExpression);
//
//
//            Predicate likePredicate = criteriaBuilder.like(collatedPath, "%" + keyword + "%");
//            Expression<String> collatedColumn = criteriaBuilder.function(
//                    "collate", String.class, iamMsUserRoot.get("firstNameTh"), criteriaBuilder.literal("THAI_BIN")
//            );
//
//
//            Expression<String> collatedKeyword = criteriaBuilder.function(
//                    "collate", String.class, criteriaBuilder.literal(keyword), criteriaBuilder.literal("THAI_BIN")
//            );
//
//            Predicate likePredicate = criteriaBuilder.like(collatedColumn, "%" + collatedKeyword + "%");

//            Expression<String> collatedColumn = criteriaBuilder.function("CONCAT", String.class, root.get("firstNameTh"),
//                    criteriaBuilder.literal(" COLLATE THAI_BIN"));
            // Constructing a custom SQL fragment for collation
//            Predicate likePredicate = criteriaBuilder.like(collatedColumn, "%" + keyword + "%");
            String collationSqlFragment = " COLLATE THAI_BIN";

            Predicate likePredicate = criteriaBuilder.like(
                    root.get("firstNameTh"),
                    "%" + keyword + "%"
            );




            return likePredicate;
        };
    }

    public static Specification<Iam2MsUser> firstNameThTest(String keyword) {
        return (root, query, criteriaBuilder) -> {
            Root<Iam2MsUser> iamMsUserRoot = root;

            return criteriaBuilder.
                    like(criteriaBuilder.function("collate THAI_BIN", String.class, iamMsUserRoot.get("firstNameTh")), "%" + keyword + "%");
        };
    }


    @GetMapping
    public void test(@RequestParam(name = "f") String f) {
        log.info("f {}", f);
        int a = 1;
        iam2MsUserRepository.findById(1).ifPresentOrElse((e)->{

        },()->{

        });
        var res = iam2MsUserRepository.findAll(firstNameTh(f));
        var test =iam2MsUserRepository.findAll();
        log.info("res {}", res);

    }
}
