Feature: Create new subcategory
    I want to create new subcategory

    Scenario Outline: Create subcategory <TC>
        Given The endpoint "/v1/subcategories"
        And The resource com.abeldevelop.blog.subcategory.dto.CreateSubcategoryRequestResource
        And The input data
            | categoryCode   | name      |
            | <categoryCode> | <name>    |
        When Make "POST" call
        Then I verify the <responseStatusCode> response code
        And If response code is 201 i verify the contract
        And If response code not 201 i verify the error response message <errorResponseMessage>

        Examples: 
            | TC    | categoryCode   | name                          | responseStatusCode    | responseCategoryCode  | errorResponseMessage                                        |
            | TC01  |                | First Subcategory             | 400                   |                       | The category code is mandatory                              |
            | TC02  | first-category |                               | 400                   |                       | The subcategory name must be between 3 and 25 characters    |
            | TC03  | first-category | a                             | 400                   |                       | The subcategory name must be between 3 and 25 characters    |
            | TC04  | first-category | aaaaa aaaaa aaaaa aaaaa aaaaa | 400                   |                       | The subcategory name must be between 3 and 25 characters    |
            | TC05  | first-category | First Subcategory             | 201                   | first-category        |                                                          |
            | TC06  | first-category | Second Subcategory            | 201                   | second-category       |                                                          |
            | TC07  | first-category | First Subcategory             | 400                   |                       | The subcategory with name First Subcategory already exists  |
            
            
            
