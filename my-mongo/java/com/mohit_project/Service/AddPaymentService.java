package com.mohit_project.Service;

import java.util.List;

import com.mohit_project.paylode.AddPaymentDto;






public interface AddPaymentService {
	
	AddPaymentDto createAddPayment(AddPaymentDto addPaymentDto);
	AddPaymentDto updateAddPayment(AddPaymentDto addPaymentDto,Long addPaymentId);
	void deleteAddPayment(Long addPaymentId);
	AddPaymentDto getAddPaymentId(Long addPaymentId);
	List<AddPaymentDto> getAllAddPayment();

}
