package com.revature.repository;

import java.util.List;

import com.revature.models.Status;
import com.revature.models.Reimbursement;

public interface ReimbursementRepositoryDAO 
{
	//Get Reimbursement by ID
	Reimbursement findByReimbursmentByID(int id);
    
	//Get Reimbursement by User - Author
    List<Reimbursement> findAllReimbursmentsByAuthor(int id);
    
    //Get Reimbursement by User - Resolver
    List<Reimbursement> findAllReimbursmentsByResolver(int id);
    
   //Get Reimbursement by Status
    List<Reimbursement> findAllReimbursmentsByStatus(Status status);
    
    //Get All Reimbursements
    List<Reimbursement> findAllReimbursments();
    
    //Create new Reimbursement
    int save(Reimbursement submittedReimbursment);
    
  //Update existing Reimbursement
    boolean update(Reimbursement updateReimbursment);
    
}
