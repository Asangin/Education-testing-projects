# Using server mock solution to mock 3 party REST API calls

> Mock API response from AUT server

[WireMock](https://wiremock.org/)
[MockServer](https://mock-server.com/)

## Mock real server by proxying request

The class [WireMockRealServerMockTest.java](src/test/java/com/skryl/edu/WireMockRealServerMockTest.java) illustrates how
to replace actual server responses by routing requests through WireMock. While processing requests, it is also possible
to modify them, such as by adding a header.