Feature: Find subcategory by code
    I want to find subcategory by code

    Scenario Outline: Find subcategory by code <TC>
        Given The endpoint "/v1/subcategories/<subcategoryCode>"
        When Make "GET" call
        Then I verify the <responseStatusCode> response code
        And If response code is 200 i verify the contract
        And If response code not 200 i verify the error response message <errorResponseMessage>

        Examples: 
            | TC    | subcategoryCode      | responseStatusCode    | responseCategoryCode  | errorResponseMessage                             |
            | TC01  | updated-subcategory  | 200                   | updated-subcategory   |                                                  |
            | TC02  | first-subcategory    | 404                   |                       | No exist subcategory with code: first-subcategory   |
