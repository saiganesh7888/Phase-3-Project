package com.simplilearn.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.webapp.dao.ProductDao;
import com.simplilearn.webapp.model.Product;
import com.simplilearn.webapp.model.User;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;
	
	
	//list_products
	@RequestMapping(value = "/list-products", method = RequestMethod.GET)
	public ModelAndView listProducts() {
		ModelAndView mv = new ModelAndView("list-products");
		List<Product> list = productDao.getProducts();
		mv.addObject("list", list);
		
		return mv;
	}
	
	//list-users
	@RequestMapping(value = "/list_users", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		ModelAndView mv = new ModelAndView("list_users");
		List<User> list = productDao.getUsers();
		mv.addObject("list", list);
		return mv;
	}
	

	// load add product
	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView mv = new ModelAndView("add-product");
		Product product = new Product();
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv = new ModelAndView("success-reponse");
		productDao.addProduct(product);
		mv.addObject("action", "created");
		return mv;
	}

	// load update product
	@RequestMapping(value = "/update-product", method = RequestMethod.GET)
	public ModelAndView updateProduct() {
		ModelAndView mv = new ModelAndView("update-product");
		Product product = new Product();
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping(value = "/update-product", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv = new ModelAndView("success-reponse");
		productDao.updateProduct(product);
		mv.addObject("action", "updated");
		return mv;
	}
	
	

	// load delete product
	@RequestMapping(value = "/delete-product", method = RequestMethod.GET)
	public ModelAndView deleteProduct() {
		ModelAndView mv = new ModelAndView("delete-product");
		Product product = new Product();
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping(value = "/delete-product", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv = new ModelAndView("success-reponse");
		productDao.deleteProduct(product);
		mv.addObject("action", "deleted");
		return mv;
	}
	
	
	//RegisterUser
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public ModelAndView registerUser() {
			ModelAndView mv = new ModelAndView("register");
			User user = new User();
			mv.addObject("user", user);
			return mv;
		}

		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public ModelAndView saveProduct(@ModelAttribute("user") User user) {
			ModelAndView mv = new ModelAndView("UserSucessRegisterResponse");
			productDao.registerUser(user);
			mv.addObject("action", "created");
			return mv;
		}
		
		
		//login
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new User());

		    return mav;
		  }

		  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
		  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
		  @ModelAttribute("login") User login) {
		    ModelAndView mav = null;

		    User user = productDao.validateUser(login);

		    if (null != user) {
		    mav = new ModelAndView("welcome");
		    mav.addObject("name", user.getName());
		    } else {
		    mav = new ModelAndView("login");
		    mav.addObject("message", "Username or Password is wrong!!");
		    }

		    return mav;
		  }
		  
		  

			// logout
			@RequestMapping(value = "/logout")
			public String logoutUser() {
				
				return "logout";
			}
			
			//cart_link
			@RequestMapping(value = "/cart_link")
			public String cart_link() {
				
				return "cart_link";
			}
			


}