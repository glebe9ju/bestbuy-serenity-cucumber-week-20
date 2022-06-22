Feature: Testing different services on the BestBuy application

  Scenario: Check if the Services application can be accessed by users
   When User sends a Get request for all services to list endpoint
    Then User must get back a valid status code 200
    
    Scenario: Check if user can create a new service in BesBuy application
      When User sends a Post request with service name
      Then User must get back a valid status code 201
      
      Scenario: Verify if the service was added to the application
        When User sends a Get request for a newly created service name
        Then User must get back a valid status code 200
        
        Scenario: Update athe service information and verify the updated information
          When User sends a Put request to update a record by service ID
          Then User can verify the updated information
          
          Scenario: Delete the service and verify if the service is deleted
            When User sends Delete request to delet by services id and get a status code 200
            Then User must get back a valid status code 404
            

