Feature: Update subcategory
    I want to update subcategory
			
    Scenario Outline: Update subcategory <TC>
        Given The endpoint "/v1/subcategories/<subcategoryCode>"
        And The resource com.abeldevelop.blog.subcategory.dto.UpdateSubcategoryRequestResource
        And The input data
            | categoryCode   | name      |
            | <categoryCode> | <name>    |
        When Make "PUT" call
        Then I verify the <responseStatusCode> response code
        And If response code is 200 i verify the contract
        And If response code not 200 i verify the error response message <errorResponseMessage>

        Examples: 
            | TC    | categoryCode   | subcategoryCode     | name                          | responseStatusCode    | responseCategoryCode  | errorResponseMessage                                          |
            | TC01  |                | first-subcategory   | First Subcategory             | 400                   |                       | The category code is mandatory                                |
            | TC02  | first-category | first-subcategory   |                               | 400                   |                       | The subcategory name must be between 3 and 25 characters      |
            | TC03  | first-category | first-subcategory   | a                             | 400                   |                       | The subcategory name must be between 3 and 25 characters      |
            | TC04  | first-category | first-subcategory   | aaaaa aaaaa aaaaa aaaaa aaaaa | 400                   |                       | The subcategory name must be between 3 and 25 characters      |
            | TC05  | first-category | first-subcategory   | Updated Subcategory           | 200                   | updated-category      |                                                               |
            | TC06  | first-category | first-subcategory   | Updated Subcategory           | 404                   |                       | No exist subcategory with code: first-subcategory             |
            | TC07  | first-category | updated-subcategory | Updated Subcategory           | 404                   |                       | The subcategory with name Updated Subcategory already exists  |
