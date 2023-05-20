package com.bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bank.dao.BankDAO;
import com.bank.model.Bank;


@RestController

@EnableWebMvc 
public class BankController {
	
	@Autowired
	 Bank bank;
	
	@Autowired
	BankDAO bankdao;

    
    @SuppressWarnings("static-access")
	@RequestMapping(value="/insert.htm",method=RequestMethod.POST)
	public @ResponseBody String insertUser(@RequestBody String jsonString) {
		ObjectMapper mapper=null;
		try {
			mapper=new ObjectMapper();
		    bank=mapper.readValue(jsonString, Bank.class);
			int cnt=bankdao.add(bank);
			System.out.println(cnt);
			if(cnt==0)
				return "Insertion Failed".toString();
			
			
		} catch (Exception e) {
			System.out.println("Error occured in insertUser"+e.getMessage());
			e.fillInStackTrace();
			return "Error";
		}
		
		return "Inserted Successfully".toString();
	}
    @SuppressWarnings("static-access")
	@RequestMapping(value="/delete.htm", method=RequestMethod.POST)
	public @ResponseBody String deleteUser(@RequestBody String jsonString) {
		
		ObjectMapper mapper=null;
		try {
			mapper=new ObjectMapper();
			bank=mapper.readValue(jsonString, Bank.class);
			
			if (bankdao.remove(bank)==0) {
				return "Bank does not exists,try again with a new Bank name";
				
				
			}
		} catch (Exception e) {
			System.out.println("Error occured in deleteUser"+e.getMessage());
			e.fillInStackTrace();
			return "Error";
		}
		
		return "Deleted Successfully".toString();
	}
	
    @SuppressWarnings("static-access")
	@RequestMapping(value="/get.htm", method=RequestMethod.GET)
	public @ResponseBody String getBank(@RequestBody String jsonString) {
		ObjectMapper mapper=null;
		Bank userRetrived=null;
		String response=null;
		try {
			mapper=new ObjectMapper();
			bank=mapper.readValue(jsonString, Bank.class);
			
			userRetrived=bankdao.get(bank.getBankName());
			if (userRetrived== null) {
				response="Bank does not exists. Try again with a new Bank";
			} else {
				response=mapper.writeValueAsString(userRetrived);

			}
		} catch (Exception e) {
			System.out.println("Error occured in getUser"+e.getMessage());
			e.fillInStackTrace();
			return "Error";
		}
		return response;
	}
	
    @SuppressWarnings("static-access")
	@RequestMapping(value="/getAll.htm", method=RequestMethod.GET)
	public @ResponseBody String getAllUser() {
		String response= null;
		List<Bank> banks=null;
		List<String> bankStr=null;
		ObjectMapper mapper=null;
		
		try {
			mapper=new ObjectMapper();
			banks=bankdao.getAll();
			if (banks==null) {
				return "List is null , kindly add Bank";
				
				
			} else {
				bankStr=new ArrayList<String>();
				for(Bank u:banks)
					bankStr.add(mapper.writeValueAsString(u));
				response=bankStr.toString();

			}
			
		} catch (Exception e) {
			System.out.println("Error occured in getAll"+e.getMessage());
			e.fillInStackTrace();
			return "Error";
		}
		
		return response;
		
	}
 
    @PostMapping("/{id}")
    public @ResponseBody String updateBankData(
            @PathVariable Long id,
            @RequestBody String updatedBankJson
    ) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Bank updatedBank = mapper.readValue(updatedBankJson, Bank.class); 
            updatedBank.setBankId(id);
            int cnt = bankdao.updateBank(updatedBank);
            if (cnt == 0) {
                return "Update failed";
            }
        } catch (JsonProcessingException e) {
            return "Error parsing JSON";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

        return "Updated successfully";
    }


    
	

	@RequestMapping("/home")
	public String test() {
		return "hey Sanatan";
		
	}

    
    
    
    
    

	}

