Feature: Delete subcategory by code
    I want to delete subcategory by code

    Scenario Outline: Delete subcategory by code <TC>
        Given The endpoint "/v1/subcategories/<subcategoryCode>"
        When Make "DELETE" call
        Then I verify the <responseStatusCode> response code
        And If response code is 200 i verify the contract
        And If response code not 204 i verify the error response message <errorResponseMessage>

        Examples: 
            | TC    | subcategoryCode      | responseStatusCode    | errorResponseMessage                                |
            | TC01  | updated-subcategory  | 204                   |                                                     |
            | TC02  | updated-subcategory  | 404                   | No exist subcategory with code: updated-subcategory |
