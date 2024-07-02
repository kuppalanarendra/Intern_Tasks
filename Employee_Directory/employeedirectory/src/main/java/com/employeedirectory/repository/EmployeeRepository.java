	package com.employeedirectory.repository;
	
	import java.time.LocalDate;
	import java.util.List;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;
	
	import com.employeedirectory.entity.Employee;
	
	@Repository
	public interface EmployeeRepository extends JpaRepository<Employee, Long> {
		
		//based on given id findById() method return Employee from Database
		Employee findById(long id);
		
		//findByDepartment() returns List of Employee based on department
	    List<Employee> findByDepartment(String department);
	    
	    //between two given joining date it will find list of employees
	    List<Employee> findByJoiningDateBetween(LocalDate startDate, LocalDate endDate);
	    
	    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.position=:position")
	    Double findAverageSalaryGroupedByPosition(String position);
	    
	    @Query(value = "SELECT e FROM Employee e ORDER BY e.salary DESC")
	    List<Employee> findTopNhighestEmployess(int n);
	    
	    @Query("SELECT email FROM Employee GROUP BY email HAVING COUNT(email) > 1")
	    List<String>  findDuplicates();
	    
	    List<Employee> findByEmail(String email);
	    
	    @Query("SELECT avg(e.performanceScore) from  Employee e")
	    int averagePerformance();
	}
