package com.mohit_project.serviceIpml;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.AddPayment;
import com.mohit_project.Entity.Hello;
import com.mohit_project.Repositry.HelloRepo;
import com.mohit_project.exception.ResourceNotFoundException;



@Service
public class HelloService {
	 @Autowired
	    private HelloRepo helloRepo;

	    public List<Hello> getAllHelloRecords() {
	        return helloRepo.findAll();
	    }

	    public Hello getHelloById(Long id) {
	        return helloRepo.findById(id).orElse(null);
	    }

	    public Hello punchIn(Hello Hello) {
	        return helloRepo.save(Hello);
	    }

	    public Hello punchOut(Long id, LocalDateTime punchOutTime) {
	        Hello Hello = helloRepo.findById(id).orElse(null);
	        if (Hello != null) {
	            Hello.setPunchOut(punchOutTime);
	            helloRepo.save(Hello);
	        }
	        return Hello;
	    }
	    
		public long getPresentEmployees() {
			// TODO Auto-generated method stub
			return this.helloRepo.countPresentEmployees();
		}

		
		public long getAbsentEmployees() {
			// TODO Auto-generated method stub
			return this.helloRepo.countAbsentEmployees();
		}

		
		public long getLateEmployees() {
			// TODO Auto-generated method stub
			return this.helloRepo.countLateEmployees();
		}

	
		public long getHalfDayEmployees() {
			// TODO Auto-generated method stub
			return this.helloRepo.countHalfDayEmployees();
		}
		
		public long getPaidLeaveEmployees() {
			// TODO Auto-generated method stub
			return this.helloRepo.countPaidLeaveEmployees();
		}
		public void deleteattendance(Long id) {
			// TODO Auto-generated method stub
			Hello addPayment=this.helloRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("AddPayment", "Id", id));

			this.helloRepo.delete(addPayment);
			
		}
		public Long getTotalAttendance() {
			return helloRepo.count();
		}
		 public Long countPresentDays(Long employeeId, int month, int year) {
		        return helloRepo.countPresentDays(employeeId, month, year);
		    }

		    public Long countAbsentDays(Long employeeId, int month, int year) {
		        return helloRepo.countAbsentDays(employeeId, month, year);
		    }

		    public Long countLateDays(Long employeeId, int month, int year) {
		        return helloRepo.countLateDays(employeeId, month, year);
		    }

		    public Long countHalfDays(Long employeeId, int month, int year) {
		        return helloRepo.countHalfDays(employeeId, month, year);
		    }

		    public Long countPaidLeaveDays(Long employeeId, int month, int year) {
		        return helloRepo.countPaidLeaveDays(employeeId, month, year);
		    }
		    public List<Hello>getAllHelloByEmployee(Long employeeId){
		    	return this.helloRepo.findByEmployeeId(employeeId);
		    }


}
