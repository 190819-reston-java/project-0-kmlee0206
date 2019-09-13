package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Customer;
import com.revature.utils.ConnectionUtil;

public class CustomerDAOImplPJDBC implements CustomerDAO {

	@Override
	public Customer getCustomer(long id) {
		Customer customer = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM customer WHERE id = ?;";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setLong(1, id);
				if (stmt.execute()) {
					try (ResultSet resultSet = stmt.getResultSet()) {
						if (resultSet.next()) {
							customer = createCustomerFromRS(resultSet);
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	@Override
	public Customer getCustomer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Customer createCustomerFromRS(ResultSet resultSet) throws SQLException {
		return new Customer(
				resultSet.getLong("id"),
				resultSet.getString("name"),
				resultSet.getString("username"), 
				resultSet.getString("userpwd"),
				resultSet.getDouble("balance"));
	}

}
