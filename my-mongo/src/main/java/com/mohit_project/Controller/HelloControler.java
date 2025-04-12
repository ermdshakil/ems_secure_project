package com.mohit_project.Controller;

import java.time.LocalDateTime;



import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.Entity.Hello;
import com.mohit_project.paylode.ApiResponse;
import com.mohit_project.serviceIpml.HelloService;



@RestController
@RequestMapping("/api/Hello")
public class HelloControler {
	
	@Autowired
	private HelloService helloService;
	
	 @GetMapping
	    public List<Hello> getAllHelloRecords() {
	        return helloService.getAllHelloRecords();
	    }

	    @GetMapping("/{id}")
	    public Hello getHelloById(@PathVariable Long id) {
	        return helloService.getHelloById(id);
	    }

	    @PostMapping("/punchIn")
	    public Hello punchIn(@RequestBody Hello Hello) {
	        Hello.setPunchIn(LocalDateTime.now());
	        return helloService.punchIn(Hello);
	    }

	    @PutMapping("/punchOut/{id}")
	    public Hello punchOut(@PathVariable Long id) {
	        return helloService.punchOut(id, LocalDateTime.now());
	    }
	    
	    @GetMapping("/countP")
		public ResponseEntity<Long> countPresentEmployees(){
			return ResponseEntity.ok(this.helloService.getPresentEmployees());

		}

		@GetMapping("/countA")
		public ResponseEntity<Long> countAbsentEmployees(){
			return ResponseEntity.ok(this.helloService.getAbsentEmployees());

		}

		@GetMapping("/countL")
		public ResponseEntity<Long> countLateEmployees(){
			return ResponseEntity.ok(this.helloService.getLateEmployees());

		}

		@GetMapping("/countH")
		public ResponseEntity<Long> countHalfDayEmployees(){
			return ResponseEntity.ok(this.helloService.getHalfDayEmployees());

		}
		@GetMapping("/countPl")
		public ResponseEntity<Long> countPaidLeaveEmployees(){
			return ResponseEntity.ok(this.helloService.getPaidLeaveEmployees());

		}
		@GetMapping("/count")
		public ResponseEntity<Long> countTotalAttendance(){
			return ResponseEntity.ok(this.helloService.getTotalAttendance());

		}
		@DeleteMapping("/{id}")
		public ResponseEntity<ApiResponse> deleteAddPayment(@PathVariable Long id){
			this.helloService.deleteattendance(id);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

		}
		 @GetMapping("/present-days/{employeeId}")
		    public Long getPresentDays(@PathVariable Long employeeId, @RequestParam int month, @RequestParam int year) {
		        return helloService.countPresentDays(employeeId, month, year);
		    }

		    @GetMapping("/absent-days/{employeeId}")
		    public Long getAbsentDays(@PathVariable Long employeeId, @RequestParam int month, @RequestParam int year) {
		        return helloService.countAbsentDays(employeeId, month, year);
		    }

		    @GetMapping("/late-days/{employeeId}")
		    public Long getLateDays(@PathVariable Long employeeId, @RequestParam int month, @RequestParam int year) {
		        return helloService.countLateDays(employeeId, month, year);
		    }

		    @GetMapping("/half-days/{employeeId}")
		    public Long getHalfDays(@PathVariable Long employeeId, @RequestParam int month, @RequestParam int year) {
		        return helloService.countHalfDays(employeeId, month, year);
		    }

		    @GetMapping("/paid-leave-days/{employeeId}")
		    public Long getPaidLeaveDays(@PathVariable Long employeeId, @RequestParam int month, @RequestParam int year) {
		        return helloService.countPaidLeaveDays(employeeId, month, year);
		    }
		    @GetMapping("employee/{employeeId}")
		    public ResponseEntity<List<Hello>> getAllHelloByEmployee(@PathVariable Long employeeId){
		    	List<Hello> hellos=this.helloService.getAllHelloByEmployee(employeeId);
		    	return ResponseEntity.ok(hellos);
		    }
		

	

}
