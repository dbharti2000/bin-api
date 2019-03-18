Feature: testing post request

  Scenario: validate post response
    When I make a post request
    Then I see status code 200


  Scenario: validate get response
    When I make a get request
    Then I see status code 200
    And I see below response in result:
      | Accept          | */*                                      |
      | Accept-Encoding | gzip,deflate                             |
      | Content-Type    | application/json; charset=UTF-8          |
      | Host            | httpbin.org                              |
      | User-Agent      | Apache-HttpClient/4.5.5 (Java/1.8.0_111) |