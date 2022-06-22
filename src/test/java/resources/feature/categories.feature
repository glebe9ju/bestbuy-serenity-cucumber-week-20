@SMOKE
  Feature: Testing different caegories on the BestBuy application

    Scenario: Check if the BestBuy application can be accessed categories by users
      When User sends a Get request for all categories to endpoint
      Then User get back a valid status code 200

      Scenario: Check if user can create a new category in BestBy application
        When User sends a Post request with category and ID name
        Then User must get back a valid status code 201

        Scenario: Verify if the category was added to the application
          When User sends a Get request for a newly created Ctegory name
          Then User get back with valid status code 200

          Scenario: Update the category information and verify the updated information
            When User sends a Put request to update a record by category Id
            Then User can verify the updated categoty information

            Scenario: Delete the category and verify if the category is deleted
              When User sends a Delete request to delete by category Id and get a status code 200
              Then User get back a valid status code 404

