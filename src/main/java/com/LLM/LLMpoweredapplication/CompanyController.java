package com.LLM.LLMpoweredapplication;

import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class CompanyController {

     @Autowired
    private CompanyRepository companyRepository;


     @PostMapping("/add")
     public Company addCompany(@RequestBody Company company){

            if(company.getStartDate()==null && company.getEndDate()==null){

               SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

               Date date=new Date();
               Calendar c=Calendar.getInstance();
               c.setTime(date);
               c.add(Calendar.YEAR,-1);
               Date newdate=c.getTime();
               company.setStartDate(newdate);
               company.setEndDate(new Date());
           }

         else if(company.getStartDate()==null ){

             SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

             Date date=new Date();
             Calendar c=Calendar.getInstance();
             c.setTime(date);
             c.add(Calendar.YEAR,-1);
             Date newdate=c.getTime();
             company.setStartDate(newdate);
         }
           else{
                Date date=new Date();
                company.setEndDate(date);
           }
            return companyRepository.save(company);
     }

     @GetMapping("/getAll")
     public List<Company> getAll(){
          return companyRepository.findAll();
     }
}
