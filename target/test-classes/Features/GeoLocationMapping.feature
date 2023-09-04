Feature: Geo Location Mapping Test


  Scenario: Create a new  Geo Location Mapping
    Given login for creating new  Geo Location Mapping
    And create new  Geo Location Mapping
    Then close the Geo Location Mapping window

  Scenario: Search a  Geo Location Mapping for AIR
    Given Login to Search  Geo Location Mapping
    When search for  Geo Location Mapping
    And description of a  Geo Location Mapping
    Then close  Geo Location Mapping for search
