Feature: Testing different stores on the BestBuy application

  Scenario: Check if the BestBuy application can be accessed stores by users
    When User sends a Get request for all stores to endpoint and status code 200

    Scenario: Check if user can create a new stores in BestBuy application
      When User sends a Post request with stores "name", "type","address","address2","city","state","zip","lat","lng" and "hours"

      Scenario: Verify if the stores was added to the application
        When User sends a Get request for a newly created stores name and get valid status code

        Scenario: Update the stores information and verify the updated information
          When User sends a Put request to update a record by stores Id
          Then User can verify the updated stores information

          Scenario: Delete the stores and verify if the stores is deleted
            When User sends a Delete request to delete by stores Id and get a status code 200
            Then User get back a valid status code after delete stores
