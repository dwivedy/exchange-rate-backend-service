Build the application

##requirements -

Apache Maven 3.5.3

Java version: 1.8

##To start the application(Spring boot application)
Run as spring boot application. Server runs on port 9005


##Get Token Jwt


`http://localhost:9005/api/v1/authenticate`

`Method: POST`
`Content application/json`
Request Payload
`{
"username":"admin",
"password":"admin",
}`

Response 
`{
  "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYwNjA4NjM1NSwiaWF0IjoxNjA2MDUwMzU1fQ.ngU8Hlghjgv24Bsa_1lcN3mLwhFtVRTivLi-GBG2f6E",
}`


##Get getExchangeRateLatest(String latest)


`http://localhost:9005/api/v1/data`
`Query param
data=latest
`
`Method: GET`

Response 
`{"base":"EUR","rates":{"HKD":9.1972,"GBP":0.89393,"USD":1.1863},"date":"2020-11-20"}`


##Get getExchangeRateSixMonthAndLatest(String latest)


`http://localhost:9005/api/v1/data`
`Query param
data=latest
`
`Method: GET`
`Headers: Authorization Bearer JWT Token `

Response 
`{"base":"EUR","rates":{"HKD":9.1972,"GBP":0.89393,"USD":1.1863},"date":"2020-11-20"}`


##Get getExchangeRateSixMonthAndLatest(String sixMonth)


`http://localhost:9005/api/v1/data`
`Query param
data=sixMonth
`
`Method: GET`
`Headers: Authorization Bearer JWT Token `

Response 
`{"base":"EUR","ratesMap":{"HKD":[{"Month0":9.1972},{"Month1":9.1614},{"Month2":9.0986},{"Month3":9.1212},{"Month4":8.9741},{"Month5":8.6902}],"GBP":[{"Month0":0.89393},{"Month1":0.90273},{"Month2":0.91743},{"Month3":0.89755},{"Month4":0.91123},{"Month5":0.90328}],"USD":[{"Month0":1.1863},{"Month1":1.1821},{"Month2":1.174},{"Month3":1.1769},{"Month4":1.1578},{"Month5":1.1213}]},"date":"2020-06-22"}`





