Feature: Getir Case Study

  Scenario: First Case
    When User signs in with "hello@getir.com" username and "hello" password
    Then User is navigated to dashboard
    And  User navigates to the cart
    Then User sees "There is no result" message

    When User navigates back to the dashboard
    And User selects "Atıştırmalık" category
    And  User adds 1 number of the 1 'th product to the cart
    And  User adds 1 number of the 2 'th product to the cart

    When User navigates back to the dashboard
    And User selects "İçecek" category
    And User adds 1 number of the 1 'th product to the cart

    When User navigates to the cart
    When User removes all 3 products from the cart
    Then User sees "There is no result" message


  Scenario: Second Case
    When User signs in with "hello@getir.com" username and "hello" password
    Then User is navigated to dashboard
    And  User navigates to the cart
    Then User sees "There is no result" message

    When User navigates back to the dashboard
    Then User sees the number of categories

    When User selects "Atıştırmalık" category
    And  User adds 2 number of the 1 'th product to the cart

    When User navigates back to the dashboard
    And User selects "Yiyecek" category
    And User adds 3 number of the 1 'th product to the cart

    When User increase all products in the chart by 1
    Then User sees the number of products 3 for 1'th product
    And User sees the number of products 4 for 2'th product

    When User removes all 7 products from the cart
    Then User sees "There is no result" message