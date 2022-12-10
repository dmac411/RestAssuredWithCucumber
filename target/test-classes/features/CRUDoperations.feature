  Feature: To Perform all the CRUD operations
  
  Scenario: To Perform the GET Operation on Employe DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200
    
    
    Scenario: POST operation - name and salary to create employee
     Given The base URI is "http://localhost:3000/employees"
     When I create a new employee with name "Joe" and salary "8999" 
     And I perform a Post operation
   	 Then Response code should be 201 
   	 
   	 
   	