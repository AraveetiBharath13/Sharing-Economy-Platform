
package com.J2EE.SEP.Controller;
  
 import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.J2EE.SEP.DTO.ProductDTO;
import com.J2EE.SEP.Entity.AdmincredEntity;
import com.J2EE.SEP.Entity.Category;
import com.J2EE.SEP.Entity.CustomerRegistration;
import com.J2EE.SEP.Entity.ProductEntity;
import com.J2EE.SEP.Entity.SerCatEntity;
import com.J2EE.SEP.Entity.ServiceEntity;
import com.J2EE.SEP.Entity.VendorRegistration;
import com.J2EE.SEP.Global.GlobalData;
import com.J2EE.SEP.Services.AdmincredService;
import com.J2EE.SEP.Services.CategoryService;
import com.J2EE.SEP.Services.CuslogService;
import com.J2EE.SEP.Services.CusregService;
import com.J2EE.SEP.Services.ProductService;
import com.J2EE.SEP.Services.SerCatService;
import com.J2EE.SEP.Services.ServiceService;
import com.J2EE.SEP.Services.VenlogService;
import com.J2EE.SEP.Services.VenregService;



  
  
  
  @Controller public class SEPConteroller {
	  
	  @Autowired
	  private ServiceService serservice;
	  
	  @Autowired
	  private ProductService productservice;
	  
	  @Autowired
	  private AdmincredService admincredservice;
	  
	  @Autowired 
	  private VenlogService venlogservice;
	  
	  @Autowired 
		private CategoryService categoryservice;
	  
	  @Autowired
	  private VenregService venregservice;
	  
	  @Autowired
	  private CusregService cusregservice;
	  
	  @Autowired 
	  private CuslogService cuslogservices;
		  
	  @Autowired 
	  private SerCatService sercatservice;
		 
  
  @GetMapping("/") 
  public String home() 
  { 
	  return "index";
  }
  
  @GetMapping("/paymentpage")
  public String Payment() {
	  return "PaymentPage";
  }
  
  @GetMapping("/customerloginpage") 
  public String Customerloginbutton() 
  {
  return "CustomerLoginPage"; 
  }
  
  @GetMapping("/vendorloginpage") 
  public String Vendorloginbutton() 
  { return
  "VendorLoginPage"; 
  }
  
  @GetMapping("/adminloginpage") 
  public String Adminloginbutton() 
  { return
  "AdminLogin"; 
  }
  
  @GetMapping("/customerregistrationpage") 
  public String Customerregistrationbutton() 
  { return "CustomerRegistrationPage"; 
  }
  
  @GetMapping("/vendorregistrationpage")
  public String vendorregistrationbutton() 
  { return "VendorRegistrationPage"; 
  }
  @GetMapping("/customerhomepage") 
  public String Customerloginsubmitbutton(Model m) 
  {
	  List<Category> cat= categoryservice.getAllCategory();
	  m.addAttribute("cat", cat);
	  
	  List<ProductEntity> pro= productservice.getAllProduct();
	  m.addAttribute("pro", pro);
	  
	  m.addAttribute("cartCount", GlobalData.cart.size());
	
  return "CustomerHomePage"; 
  }
  
  
  @GetMapping("/customerservicehomepage") 
  public String
  CustomerHomePageServicebutton(Model m) 
  
  { 
	  
	  List<ServiceEntity> ser= serservice.getAllServices();
	  m.addAttribute("ser", ser);
	  
	  List<SerCatEntity> sercat= sercatservice.getAllCategory();
	  m.addAttribute("sercat", sercat);
	  
	  return "CustomerServiceHomePage"; 
	  }
  
  @GetMapping("/vendorhomepage") 
  public String VendorHomePagebutton(Model m) 
  {
	  List<ProductEntity> pro=  productservice.getAllProduct();
	  m.addAttribute("pro", pro);
	  
	  List<Category> cat= categoryservice.getAllCategory();
	  m.addAttribute("cat", cat);
	  
		
	  List<ServiceEntity> ser= serservice.getAllServices(); 
	  m.addAttribute("ser", ser);
		  
	  List<SerCatEntity> sercat= sercatservice.getAllCategory();
	  m.addAttribute("sercat", sercat);
		 
	  return "VendorHomePage";
	  }
  
  @GetMapping("/vendorproserformpage") 
  public String
  VendorProSerFormPagebutton() 
  { return "VendorProSerFormPage";
  }
  
  @GetMapping("/adminhomepage") 
  public String AdminLoginButton(Model m) 
  {
	  List<Category> cat= categoryservice.getAllCategory();
	  m.addAttribute("cat", cat);
	  
	  List<SerCatEntity> sercat= sercatservice.getAllCategory();
	  m.addAttribute("sercat", sercat);
		  

		 
	  return "AdminHomePage";
	 
	   
  }
  
  @GetMapping("/cartpage") 
  public String opencart(@ModelAttribute GlobalData cart, Model m) 
  { 
	 m.addAttribute("cartCount", GlobalData.cart.size());
	 m.addAttribute("total", GlobalData.cart.stream().mapToDouble(ProductEntity::getPrice).sum());
	 m.addAttribute("cart", GlobalData.cart);
	  
	  return "CartPage"; 
  }
  //adding products to cart
  
	
	  @GetMapping("/Addtocart/{id}") public String addToCart(@PathVariable int id)
	  { GlobalData.cart.add(productservice.getProductById(id).get()); 
	  
	  System.out.println("Item Added to the cart successfully");
	  
	  return "CartPage"; }
	 
  
  @PostMapping("/createCategory")
  public String createcat(@ModelAttribute Category category, Model m) {
		  categoryservice.createCategory(category);
		  System.out.println(category);
		  // Reflects the updated details in the same page
		  List<Category> cat= categoryservice.getAllCategory();
		  m.addAttribute("cat", cat);
			return "AdminHomePage";  
			
		}
  
  @PostMapping("/registerVendor")
  public String registerven(@ModelAttribute VendorRegistration venreg) {
	  venregservice.registerVendor(venreg);
	  System.out.println(venreg);
	  return "VendorLoginPage";
  }
  
  @PostMapping("/registerCustomer")
  public String registercus(@ModelAttribute CustomerRegistration cusreg) {
	  cusregservice.registerCustomer(cusreg);
	  System.out.println(cusreg);
	  return"CustomerLoginPage";
  }
  
  @PostMapping("/customerlogin")
  public String cuslogin(@ModelAttribute("customer") CustomerRegistration customer) {
	  
	  CustomerRegistration oauthCustomer= cuslogservices.Login(customer.getCustomerId(), customer.getPassword());
	  
	  System.out.print(oauthCustomer);
	  if(Objects.nonNull(oauthCustomer)) {
		  
		  System.out.println("Loggedin Successfully");
		  return "CustomerHomePage";
		  
	  }else {
		  System.out.println("Failed to login");
		  return "CustomerLoginPage";
	  

	  
  }
 
  }
  
  
  @PostMapping("/vendorlogin")
  public String venlogin(@ModelAttribute("vendor") VendorRegistration vendor) {
	  
	  VendorRegistration oauthVendor= venlogservice.Login(vendor.getVendorId(), vendor.getPassword());
	  
	  System.out.print(oauthVendor);
	  if(Objects.nonNull(oauthVendor)) {
		  
		  System.out.println("Loggedin Successfully");
		  return "VendorHomePage";
		  
	  }else {
		  System.out.println("Failed to login");
		  return "VendorLoginPage";
		  
	  }
	  

	  
  }
  
  @PostMapping("/adminlogin")
  public String adminlogin(@ModelAttribute("admin") AdmincredEntity admin) {
	  
	  AdmincredEntity oauthAdmin= admincredservice.Login(admin.getAdminId(), admin.getPassword());
	  
	  System.out.print(oauthAdmin);
	  if(Objects.nonNull(oauthAdmin)) {
		  
		  System.out.println("Loggedin Successfully");
		  return "AdminHomePage";
		  
	  }else {
		  System.out.println("Failed to login");
		  return "AdminLoginPage";
		  
	  }
	  

	  
  }
  
  
  
  @PostMapping("/createServiceCategory")
  public String createsercat(@ModelAttribute SerCatEntity sercategory, Model m ) {
	  sercatservice.createSerCategory(sercategory);
		  System.out.println(sercategory);
		  // Reflects the updated details in the same page
			
			  List<SerCatEntity> sercat= sercatservice.getAllCategory();
			  m.addAttribute("sercat", sercat);
			 
			return "AdminHomePage";  
		}
  
  @GetMapping("/adminhomepage/category/delete/{id}")
  public String deleteCat(@PathVariable int id ) {
	  categoryservice.removeCategoryById(id);
	  System.out.println( "Category Deleted Successfully");
	return "AdminHomePage";
  }
  
  //deleting service in Admin home page
  
  @GetMapping("/adminhomepage/service/delete/{id}")
  public String deleteSer(@PathVariable int id ) {
	 sercatservice.removeServiceById(id);
	  System.out.println( "Service Deleted Successfully");
	return "AdminHomePage";
  }
  
  // deleting product in vendor home page
  
  @GetMapping("/vendorhomepage/product/delete/{id}")
  public String deleteProduct(@PathVariable int id ) {
	  productservice.removeProductById(id);
	  System.out.println( "Product Deleted Successfully");
	return "VendorHomePage";
  }
  
  
  // deleting service in vendor home page
  
  @GetMapping("/vendorhomepage/service/delete/{id}")
  public String deleteService(@PathVariable int id ) {
	  serservice.removeServiceById(id);
	  System.out.println( "Service Deleted Successfully");
	return "VendorHomePage";
  }
  
  
  @GetMapping("/adminhomepage/category/update/{id}")
  public String updateCat(@PathVariable int id , Model m) {
	  Optional<Category> category= categoryservice.getCatgeoryById(id);
	  
	  if(category.isPresent()) {
		  m.addAttribute("category", category.get());
		  return"AdminHomePage";
	  }else
		  return "404";
	  
  }
  
  
  //VendorSection
  //ProductsAdding
	
	
	/*
	 * @GetMapping("/vendor/products") public String showProduct(Model m) {
	 * m.addAttribute("products", productservice.getAllProduct()); return
	 * "VendorHomePage"; }
	 * 
	 * @GetMapping("/vendor/products/add") public String productAddGet( Model m) {
	 * m.addAttribute("productDTO", new ProductDTO());
	 * m.addAttribute("category",categoryservice.getAllCategory() );
	 * 
	 * System.out.println("Product Added Successfully"); return "VendorHomePage";
	 * 
	 * 
	 * }
	 */
	 
	 
  
	
	
	
	  @PostMapping("/createProduct") 
	  public String createProduct(@ModelAttribute ProductEntity addproduct, Model m ) 
	  {
	  productservice.createproduct(addproduct); 
	  System.out.println(addproduct); //
	  //Reflects the updated details in the same page
	  List<ProductEntity> pro= productservice.getAllProduct();
	  m.addAttribute("pro", pro);
	  return "VendorHomePage"; 
	  
	  }
	  
	  @PostMapping("/createService") 
	  public String createService(@ModelAttribute ServiceEntity addservice, Model m ) 
	  {
		  serservice.createservice(addservice); 
	  System.out.println(addservice); //
	  //Reflects the updated details in the same page
	  List<ServiceEntity> ser= serservice.getAllServices();
	  m.addAttribute("ser", ser);
	  return "VendorHomePage"; 
	  
	  }
	 
	 
	 
  
  }
  
 
