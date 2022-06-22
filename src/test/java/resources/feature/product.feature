@REGRESSION
Feature: Testing different API method request on Bestbuy application

  Scenario: Check if the Product aplication can accessed by users
    When user sends Get request for all produts to endpiont
    Then user must get back valid status code produt

    Scenario: Check if user can create a new products in BestBuy application
      When user sends Post request with products"name","type", "price","upc","shipping","description","manufacturer","model","url"and"image"
      Then user get back a valid status code

      Scenario: Verify if the product was added to the application
        When User sends a Get request for a newly created product name
        Then User get back with valid status code

        Scenario: Update the product information and verify the updated information
          When User sends a Put request to update a record by product id
          Then User can verify the updated product information

          Scenario: Delete the product and verify if the product is deleted
            When User sends a Delete request to delete by product Id and get a status code 200
            Then User get back a valid status code after delte
