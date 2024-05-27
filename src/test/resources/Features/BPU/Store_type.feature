Feature: Store Type Test for BPU


  Scenario: Search For Store_type
    Given login to Search for Store_type
    When Search for the Store_type
    Then verify if the Store_type is visible accordingly

  Scenario: Create a Store_type with status active and visibility inactive
    Given Navigate to AIR for BPU
    When Create a Store_type with active status
    Then verify if the Store_type is created
    And check if this store type is active or not
    And check if this store type visibility in stores is inactive or not

  Scenario: Create a Store_type with status active and visibility active
    Given Navigate to AIR for BPU
    When Create a Store_type with active status and visiblity active
    Then verify if the Store_type is created
    And check if this store type is active or not
    And check if this store type visibility in stores is active or not


  Scenario: Create a Store_type with status inactive and visibility inactive
    Given Navigate to AIR for BPU
    When Create a Store_type with inactive status
    Then verify if the Store_type is created
    And check if this store type is inactive or not
    And check if this store type visibility in stores is inactive or not

  Scenario: Create a Store_type with status inactive and visibility active
    Given Navigate to AIR for BPU
    When Create a Store_type with inactive status and visiblity active
    Then verify if the Store_type is created
    And check if this store type is inactive or not
    And check if this store type visibility in stores is active or not

