package com.mohit_project.Controller;



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
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.Service.CategoryService;
import com.mohit_project.paylode.ApiResponse;
import com.mohit_project.paylode.CategoryDto;


@RestController
@RequestMapping("/api/category")
public class CategoryControll {
	
	@Autowired
	private CategoryService categoryService;
	
	//create
		@PostMapping("/")
		public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
			CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
			return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
		}
		//update
		@PutMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Long categoryId){
			CategoryDto updateCategory=this.categoryService.updateCategory(categoryDto, categoryId);
			return ResponseEntity.ok(updateCategory);
		}

		//delete
		@DeleteMapping("/{categoryId}")
		public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long categoryId){
			this.categoryService.deleteCategory(categoryId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

		}
		//getCategoryId
		@GetMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> getCategoryId(@PathVariable Long categoryId){
			return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));
		}
		//getAllCategory
		@GetMapping("/")
		public ResponseEntity<List<CategoryDto>> getAllCategory(){
			return ResponseEntity.ok(this.categoryService.getAllCategory());
		}
		//count category
		@GetMapping("/count")
	    public ResponseEntity<Long> countUsers() {
	        long count = categoryService.countCategory();
	        return ResponseEntity.ok(count);
	    }
	
	

}
