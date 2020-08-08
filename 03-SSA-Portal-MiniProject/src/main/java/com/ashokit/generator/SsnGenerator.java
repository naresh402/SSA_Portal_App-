package com.ashokit.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


public class SsnGenerator implements IdentifierGenerator {
	
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String suffix="";
		String prefix="789 56 7987";
		Connection con=null;
		try {
			con=session.connection();
            Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery("select ssn_seq.nextval from dual");
			if(rs.next()) {
			int seqVal=rs.getInt(1);
			suffix=String.valueOf(seqVal);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	return prefix+suffix;
	}

}
