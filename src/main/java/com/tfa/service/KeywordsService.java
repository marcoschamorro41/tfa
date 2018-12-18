package com.tfa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.tfa.connectors.DataBaseManager;
import com.tfa.entities.KeyWord;

@Service
public class KeywordsService {

    public boolean isLimitValid(String slimit) {
        int limit = Integer.valueOf(slimit);
        return (limit > 0) && (limit <= 100);
    }

    public static ArrayList<KeyWord> obtnerKeyWords(String company) {
    	
		ArrayList<KeyWord> keywords = new ArrayList<>();
		try {
			MysqlDataSource dataSource = DataBaseManager.getMysqlDataSource();
			String query = "SELECT * FROM keyword INNER JOIN company ON keyword.idCompany = company.idCompany WHERE company.companyName = ? ORDER BY company.idCompany ASC;";
			Connection conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1,company);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				KeyWord  keyword = new KeyWord();
				keyword.setKeyword(rs.getString("keyword"));
			    keywords.add(keyword);
			}
			
			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return keywords;
	}
}