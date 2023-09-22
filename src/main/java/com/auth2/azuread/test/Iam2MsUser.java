package com.auth2.azuread.test;

import com.auth2.azuread.ThaiBinCollatedStringType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.core.annotation.AliasFor;

import java.util.Date;

@Entity
@Table(name = "iam2_ms_user", schema = "iam2")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Iam2MsUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "user_code", nullable = false)
    private String userCode;

    @Column(name = "first_name_th")
    private String firstNameTh;

    @Column(name = "middle_name_th")
    private String middleNameTh;

    @Column(name = "last_name_th")
    private String lastNameTh;

    @Column(name = "first_name_en")
    private String firstNameEn;

    @Column(name = "middle_name_en")
    private String middleNameEn;

    @Column(name = "last_name_en")
    private String lastNameEn;

    @Column(name = "no_of_fail_time")
    private Integer noOfFailTime;

    @Column(name = "status")
    private String status;

    @Column(name = "life_license_no")
    private String lifeLicenseNo;

    @Column(name = "life_license_expired_date")
    private Date lifeLicenseExpiredDate;

    @Column(name = "non_life_license_no")
    private String nonLifeLicenseNo;

    @Column(name = "non_life_license_expired_date")
    private Date nonLifeLicenseExpiredDate;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "is_admin", nullable = false)
    private String isAdmin;

    @Column(name = "is_deleted", nullable = false)
    private String isDeleted;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;
}
