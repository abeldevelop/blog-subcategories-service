Feature: Find all subcategories
    I want to find all subcategories

    Scenario Outline: Find all subcategories <TC>
        Given The endpoint "/v1/subcategories"
        When Make "GET" call
        Then I verify the <responseStatusCode> response code
        And If response code is 200 i verify the contract

        Examples: 
            | TC    | responseStatusCode    | resultSize    |
            | TC01  | 200                   | 2             |
