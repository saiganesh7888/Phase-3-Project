package com.simplilearn.webapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simplilearn.webapp.model.Product;
import com.simplilearn.webapp.model.User;

public class ProductDao {
	
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// list all products
	public List<Product> getProducts() {
		String READ_PRODUCT ="select * from product_data";
		List<Product> productsList = template.query(READ_PRODUCT, new RowMapper<Product>() {
			// map result set row value to product object
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDescription(rs.getString(4));
				return product;
			}
		});
		return productsList;
	}
	
	//list_users
	// list all products
		public List<User> getUsers() {
			String READ_PRODUCT ="select * from user_data";
			List<User> userList = template.query(READ_PRODUCT, new RowMapper<User>() {
				// map result set row value to product object
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setPassword(rs.getString(3));
					
					return user;
				}
			});
			return userList;
		}
	
	// create product
	public int addProduct(Product product) {
		String ADD_PRODUCT = "insert into product_data(id,name, price,description) values (?, ?,?,?)";
		return template.update(ADD_PRODUCT,product.getId(),product.getName(), product.getPrice(),product.getDescription());
	}
	
	// update product
	public int updateProduct(Product product) {
		String UPDATE_PRODUCT = "UPDATE product_data set name=?, price=? ,description=? where id=?";
		return template.update(UPDATE_PRODUCT,product.getName(), product.getPrice(),product.getDescription(), product.getId());
	}
	
	// delete product
	public int deleteProduct(Product product) {
		String DELETE_PRODUCT = "delete from product_data where id=?";
		return template.update(DELETE_PRODUCT,product.getId());
	}
	

	//Register
	public int registerUser(User user) {
		String ADD_USER = "insert into user_data(id,name,password) values (?, ?,?)";
		return template.update(ADD_USER,user.getId(), user.getName(),user.getPassword());
	}
	
	
	//login
	public User validateUser(User login) {

	    String sql = "select * from user_data where id='" + login.getId()+"' and name='" + login.getName() + "' and password='" + login.getPassword()
	    + "'";

	    List<User> users = template.query(sql, new UserMapper());

	    return users.size() > 0 ? users.get(0) : null;
	    }

	  }

	  class UserMapper implements RowMapper<User> {

	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();

	    user.setId(rs.getInt("id"));
	    user.setPassword(rs.getString("password"));
	    user.setName(rs.getString("name"));
	    

	    return user;
	  }
	  

		//logout
		public String logoutUser(User user) {
			return "logout";
		}
		
		

	
}