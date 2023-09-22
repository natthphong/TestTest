package com.auth2.azuread;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class ThaiBinCollatedStringType implements UserType<String> {


    @Override
    public int getSqlType() {
        return Types.VARCHAR;
    }

    @Override
    public Class<String> returnedClass() {
        return String.class;
    }

    @Override
    public boolean equals(String s, String j1) {
        return Objects.equals(s, j1);
    }

    @Override
    public int hashCode(String s) {
        return s.hashCode();
    }




    @Override
    public String nullSafeGet(ResultSet rs, int i, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        RestTemplate restTemplate = new RestTemplate();

        String value = rs.getString(i);
        if (value == null) {
            return null;
        }
        return addCollation(value);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, String value, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        st.setString(i, value);
    }

    @Override
    public String deepCopy(String s) {
        return s;
    }





    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(String value) {
        return value;
    }

    @Override
    public String assemble(Serializable serializable, Object o) {
        return (String) serializable;
    }


    private String addCollation(String columnValue) {
        return columnValue + " COLLATE THAI_BIN ";
    }
}
