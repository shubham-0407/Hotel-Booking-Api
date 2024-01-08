# Hotel-Booking-Api

Technology used: Spring Boot | Api gateway | Eureka Server

Screenshots of the project: -

Booking Service

Endpoint 1: User saves the booking
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/84a92d9c-315c-454b-9dbc-9983a6e1cc12)


Exception handling for endpoint 1:

Exception 1:	When user enters a past date while making the booking: As the room cannot be booked for past dates.
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/583c5cec-61d5-427d-ab96-957a0b4ecd11)

Exception 2:	If the user roomCheckIn date exceeds roomCheckOut date, then the exception is thrown.
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/6164409d-99e2-4ab4-891c-4a425f9388d5)

Exception 3:	If the user enters number of rooms to be less than or equal to zero: Numbers of rooms should be greater than zero.
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/f058f994-8f39-47dd-8052-76dfce65d5eb)

Endpoint 2: Make transaction for booking the room by communicating with payment-service
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/f2111625-0585-465e-8b4a-c0fdd7f9ce4f)

Exception handling for endpoint 2:

Exception 1: An exception is thrown if the payment mode is other than CARD or UPI. It says “Invalid Payment Mode”. This is done using global exception handler.
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/857f53f4-4483-44ae-ba7a-6c018fffb567)

Exception 2: An exception is thrown if the user makes transaction for a booking id which does not even exists. The exception says “Invalid booking id”. This is done using global exception handler.
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/87f3d6cd-c18e-4f28-9961-962f1d29dea3)


Payment Service

Endpoint 1: Transaction is made. This is the API call which is hit by Booking-Service endpoint-2.
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/4302e14a-84a5-4b5d-9c1b-4f7c39931237)

Endpoint 2: Fetch the transaction details. TransactionId is passed in the url and @PathVariable is used to extract the id and it returns the transaction details of the booking.
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/2bdd1fc1-ba18-4a25-b306-724ccb8e4f58)

Exception for endpoint 2

Exception 1: If the transactionId does not exists then an exception is thrown “Invalid transaction Id” by Global Exception Handler.
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/acac6f71-92a1-4a7c-86a2-32b0756ee7e4)

Screenshot of the Eureka Server
![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/70bfdf52-98da-4ee5-a727-cb8845419618)

![image](https://github.com/shubham-0407/Hotel-Booking-Api/assets/84238355/5bd63f3e-b234-4d5f-b86f-af62d0be7a35)




