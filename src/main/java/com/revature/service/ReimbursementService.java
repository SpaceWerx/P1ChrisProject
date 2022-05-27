package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.repository.ReimbursementRepositoryDAO;


@Service("reimbursementService")
public class ReimbursementService 
{
	
	
	ReimbursementRepositoryDAO reimbursementRepository;
	
	public Reimbursement getReimbursementByID(int Id)
   	{
		return reimbursementRepository.findByReimbursmentByID(Id);
    }
	
   
	 public List<Reimbursement> getReimbursments()
	   	{
	    	return reimbursementRepository.findAllReimbursments();
	    }
	 
    public List<Reimbursement> getResolvedReimbursments()
   	{
    	List<Reimbursement> resolvedReimbursments = new ArrayList<>();
    	List<Reimbursement> approvedReimbursments = reimbursementRepository.findAllReimbursmentsByStatus(Status.Approved);
    	List<Reimbursement> deniedReimbursments = reimbursementRepository.findAllReimbursmentsByStatus(Status.Denied);
    	resolvedReimbursments.addAll(approvedReimbursments);
    	resolvedReimbursments.addAll(deniedReimbursments);
		return resolvedReimbursments;
    }
    
    public List<Reimbursement> getPendingReimbursments()
   	{
    	return reimbursementRepository.findAllReimbursmentsByStatus(Status.Pending);
    }
    
    public List<Reimbursement> getApprovedReimbursments()
   	{
    	return reimbursementRepository.findAllReimbursmentsByStatus(Status.Approved);
    }
    
    public List<Reimbursement> getDeniedReimbursments()
   	{
    	return reimbursementRepository.findAllReimbursmentsByStatus(Status.Denied);
    }
	
    public List<Reimbursement> getReimbursmentsByAuthor(int userId)
   	{
		return reimbursementRepository.findAllReimbursmentsByAuthor(userId);
    }
    
    public List<Reimbursement> getReimbursmentsByResolver(int userId)
   	{
		return reimbursementRepository.findAllReimbursmentsByResolver(userId);
    }
	
	
    public Reimbursement submit(Reimbursement submittedReimbursment)
   	{
    	//ID is Auto increment, So no need to set ID.
    	submittedReimbursment.setStatus(Status.Pending);
    	int remId = reimbursementRepository.save(submittedReimbursment);
    	return reimbursementRepository.findByReimbursmentByID(remId);
    	
    }
    
    public Reimbursement update(int reimbursmentId, int resolverID, Status updatedStatus)
   	{
    	    	
		Reimbursement existingReimbursment = reimbursementRepository.findByReimbursmentByID(reimbursmentId);
		
		if(existingReimbursment!=null)
		{
			Status status = existingReimbursment.getStatus();
			
			if(status.name().equalsIgnoreCase(Status.Pending.name()))
			{
				existingReimbursment.setResolver(resolverID);
				existingReimbursment.setStatus(updatedStatus);
				reimbursementRepository.update(existingReimbursment);
			}else
			{
				System.out.println("NO UPDATE: Reimbursment CANNOT BE "+updatedStatus.name()+"... It is already ."+status.name());
			}
			
			
		}else
		{
			System.out.println("Reimbursment Not Found");
			throw new RuntimeException(" ERROR while updating Reimbursment.");
		}
		return existingReimbursment;
    }
	
}
