package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import net.javaguides.springboot.model.RegistrationEntity;

import net.javaguides.springboot.repository.RegistrationRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmailController {
    
	@Autowired
 	private RegistrationRepository registrationRepository;
	
	@PostMapping("/register")
	public RegistrationEntity register(@Valid @RequestBody RegistrationEntity registrationEntity)
	{
		return registrationRepository.save(registrationEntity);
	}
	
	@GetMapping("/getAllAccount")
	public List<RegistrationEntity> getAllRegister() 
	{
		return registrationRepository.findAll();
	}
	 @GetMapping("/getLogin/{id}/{pass}")
		public List<RegistrationEntity> getSentMail(@PathVariable("id") String id ,@PathVariable("pass") String pass) {
		  System.out.println(id);
		  System.out.println(pass);
			return registrationRepository.findLoginId(id,pass);
	}
	 @PutMapping("/updateProfile/{id}") 
		public RegistrationEntity updateCustomer(@RequestBody RegistrationEntity updateCust, @PathVariable long id) throws Exception{
			
			Optional<RegistrationEntity> cust = registrationRepository.findById(id);
			
			if(!cust.isPresent()) {
				throw new Exception("Could not find with Customer with ID - " + id);
			}
			
			/* IMPORTANT - To prevent the overriding of the existing value of the variables in the database, 
	         * if that variable is not coming in the @RequestBody annotation object. */  
			if(updateCust.getEmailId() == null || updateCust.getEmailId().isEmpty()) {
				updateCust.setEmailId(cust.get().getEmailId());
			}

			
			updateCust.setId(id);
			
			return registrationRepository.save(updateCust);
		}
	    @GetMapping("/getAccount/{id}")
		public List<RegistrationEntity> getAccount(@PathVariable("id") String id) {
			return registrationRepository.findAccountMail(id);
		}
}