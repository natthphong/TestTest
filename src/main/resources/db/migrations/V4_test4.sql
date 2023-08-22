UPDATE TOP(10) iam.iam_ms_branch
SET
    branch_name = CONCAT('Updated Branch ', branch_id),
    is_deleted = 'Y',
    updated_date = GETDATE(),
    updated_by = 'Admin'
WHERE is_deleted = 'N';