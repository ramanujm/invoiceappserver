package com.duke.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.duke.db.HibernateDao;
import com.duke.db.beans.CountryMaster;
import com.duke.db.beans.Dao;
import com.duke.db.beans.IndustryMaster;
import com.duke.db.beans.Login;
import com.duke.db.beans.UserDao;
import com.duke.presentation.beans.DropDownItemVO;
import com.duke.presentation.beans.RegisterVO;
import com.duke.service.exception.EmailAlreadyExistsException;
import com.duke.service.exception.InvalidPasswordException;
import com.duke.service.exception.UserNotFoundException;

@Transactional
@Repository
public class InvoiceService {

//	 @Autowired
//	  private Dao dao;
	 //@Autowired
	// private UserDao userDao;
	 
	 @Autowired
	 private HibernateDao hibenrateDao;
	 
	 public void registerUser(RegisterVO registerVo) throws EmailAlreadyExistsException , Exception{
		 
		 Login existLogin =  hibenrateDao.getByField("email", registerVo.getEmail(), Login.class);
		 if (existLogin != null) {
			 throw new EmailAlreadyExistsException(registerVo.getEmail());
		 }
		 
		 Login newLogin = new Login();
		 newLogin.setEmail(registerVo.getEmail());
		 newLogin.setPassword(registerVo.getPassword());
		 
		 //save the login detail.
		 hibenrateDao.save(newLogin);
		 
	 }
	 
    public boolean login(String email,String password) throws UserNotFoundException , InvalidPasswordException , Exception{
		 
		 Login existLogin =  hibenrateDao.getByField("email", email, Login.class);
		 if (existLogin == null) {
			 throw new UserNotFoundException(email);
		 }
		 
		 if (!existLogin.getPassword().equals(password)) {
			 throw new InvalidPasswordException(email);
		 }
		 
		 return true;
	 }
    
    public List<DropDownItemVO> getAllCountries() throws Exception {
    	
    	List<CountryMaster> countries = hibenrateDao.getAll(CountryMaster.class);
    	
    	if (countries.isEmpty()) return null;
    	List<DropDownItemVO> dropDownItems = new ArrayList();
    	for (CountryMaster country : countries) {
    		DropDownItemVO item = new DropDownItemVO();
    		item.setId(String.valueOf(country.getId()));
    		item.setValue(country.getName());
    	     dropDownItems.add(item);	
    	}
    	return dropDownItems;
    	
    }
    
 public List<DropDownItemVO> getAllIndustry() throws Exception {
    	
    	List<IndustryMaster> induistries = hibenrateDao.getAll(IndustryMaster.class);
    	
    	if (induistries.isEmpty()) return null;
    	List<DropDownItemVO> dropDownItems = new ArrayList();
    	for (IndustryMaster industry : induistries) {
    		DropDownItemVO item = new DropDownItemVO();
    		item.setId(String.valueOf(industry.getId()));
    		item.setValue(industry.getDescription());
    	     dropDownItems.add(item);	
    	}
    	return dropDownItems;
    	
    }
   
    
}
