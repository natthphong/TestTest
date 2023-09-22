
TRUNCATE TABLE iam2.iam2_ms_user;
INSERT INTO iam2.iam2_ms_user (mobile_no, user_code, first_name_th, middle_name_th, last_name_th, first_name_en, middle_name_en, last_name_en, no_of_fail_time, status, life_license_no, life_license_expired_date, non_life_license_no, non_life_license_expired_date, department_code, is_admin, is_deleted, created_date, created_by)
VALUES
('0801234567', 'U000', 'มือถือหมายเลข 0801234567', 'รหัสผู้ใช้ U001', 'ชื่อจริง ภาษาไทย', 'John', 'Middle', 'Doe', 0, 'ใช้งาน', '123456', '2023-12-31', '789012', '2023-11-30', 'DPT001', 'Y', 'N', '2023-08-24', 'ผู้ดูแลระบบ'),
( '0801234567', 'U001', 'โอชาย', 'มีกลาง', 'สุดท้าย', 'John', 'Middle', 'Doe', 0, 'Active', '123456', '2023-12-31', '789012', '2023-11-30', 'DPT001', 'Y', 'N', '2023-08-24', 'Admin' ),
( '0859876543', 'U002', 'แสน', 'คล้ายกัน', 'ดี', 'Jane', 'Similar', 'Good', 3, 'Suspended', '654321', '2024-05-15', '987654', '2023-10-20', 'DPT002', 'N', 'N', '2023-08-24', 'Supervisor' ),
( '0895551234', 'U003', 'สมชาย', 'มาก', 'เต็ม', 'Sam', 'Much', 'Full', 1, 'Active', '555666', '2023-09-30', '222333', '2023-11-10', 'DPT001', 'N', 'N', '2023-08-24', 'Clerk' ),
( '0812345678', 'U004', 'รัก', 'น้อย', 'สุข', 'Love', 'Little', 'Happy', 5, 'Inactive', '777888', '2024-03-28', '333444', '2023-12-25', 'DPT003', 'N', 'N', '2023-08-24', 'Operator' ),
( '0866669999', 'U005', 'สุขใจ', 'แสนมาก', 'ใจดี', 'Joyful', 'VeryMuch', 'Kind', 0, 'Active', '444555', '2023-11-15', '111222', '2023-09-18', 'DPT002', 'N', 'N', '2023-08-24', 'Staff' ),
( '0827778888', 'U006', 'สมรัก', 'อุ่นใจ', 'สวัสดี', 'Samarak', 'Heartwarming', 'Hello', 2, 'Active', '888999', '2024-01-05', '666777', '2023-10-08', 'DPT003', 'N', 'N', '2023-08-24', 'Employee' ),
( '0831112222', 'U007', 'อรุณ', 'สดใส', 'ราตรี', 'Orn', 'Fresh', 'Morning', 0, 'Active', '999000', '2023-10-10', '444555', '2023-09-20', 'DPT001', 'N', 'N', '2023-08-24', 'Manager' ),
( '0843334444', 'U008', 'ชุติมา', 'รักน้อย', 'เย็น', 'Chutima', 'LittleLove', 'Cool', 4, 'Suspended', '333444', '2024-04-20', '888999', '2023-11-12', 'DPT002', 'N', 'N', '2023-08-24', 'Supervisor' ),
( '0878885555', 'U009', 'สมร', 'รักเยอะ', 'ดี', 'Somroh', 'MuchLove', 'Good', 0, 'Active', '666777', '2023-11-30', '111222', '2023-10-05', 'DPT003', 'N', 'N', '2023-08-24', 'Clerk' ),
( '0882226666', 'U010', 'สุขสม', 'รักมาก', 'มากที่สุด', 'Suksom', 'VeryMuchLove', 'MostGood', 2, 'Active', '222333', '2024-02-10', '555666', '2023-09-15', 'DPT001', 'N', 'N', '2023-08-24', 'Operator' );
