package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Customer;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.StreamCloser;

public class CustomerDAOImplPJDBC implements CustomerDAO {

	@Override
	public Customer getCustomer(String username) {
		Customer customer = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM customer WHERE username = ?;";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setString(1, username);
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
	public boolean updateCustomer(Customer c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String query = "UPDATE customer SET name=?, username=?, userpwd=?, balance=TRUNC(CAST(? AS NUMERIC), 2) WHERE username = ?;";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getUsername());
			stmt.setString(3, c.getUserpwd());
			stmt.setDouble(4, c.getBalance());
			stmt.setString(5, c.getUsername());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return true;
	}

//	@Override
//	public Customer getCustomer(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override
//	public Customer getCustomerBalance(String username) {
//		Customer customer = null;
//		
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String query = "SELECT balance FROM public.customer WHERE username = ?;";
//			try (PreparedStatement stmt = conn.prepareStatement(query)) {
//				stmt.setString(1, username);
//				if (stmt.execute()) {
//					try (ResultSet resultSet = stmt.getResultSet()) {
//						if (resultSet.next()) {
//							customer = createCustomerFromRS(resultSet);
//						}
//					}
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return customer;
//	}

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
