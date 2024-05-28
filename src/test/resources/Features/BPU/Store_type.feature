Feature: Store Type Test for BPU


  Scenario: Search For Store_type
    Given login to Search for Store_type
    When Search for the Store_type
    Then verify if the Store_type is visible accordingly

  Scenario: Create a Store_type with status active and visibility inactive
    Given login to Search for Store_type
    When Create a Store_type with active status and visibility inactive
    And check if this store type is active or not and visibility in stores is inactive or not

  Scenario: Create a Store_type with status active and visibility active
    Given login to Search for Store_type
    When Create a Store_type with active status and visiblity active
    And check if this store type is active or not and visibility in stores is active or not


  Scenario: Create a Store_type with status inactive and visibility inactive
    Given login to Search for Store_type
    When Create a Store_type with inactive status and visibility inactive
    And check if this store type is inactive or not and visibility in stores is inactive or not

  Scenario: Create a Store_type with status inactive and visibility active
    Given login to Search for Store_type
    When Create a Store_type with inactive status and visiblity active
    And check if this store type is inactive or not and visibility in stores is active or not

