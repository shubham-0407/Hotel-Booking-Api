# Hotel-Booking-Api

Technology used: Spring Boot | Api gateway | Eureka Server

Screenshots of the project: -

Booking Service

Endpoint 1: User saves the booking
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/3a881fcd-cb9e-4ded-8c34-f0bc41465b4b)

Exception handling for endpoint 1:

Exception 1:	When user enters a past date while making the booking: As the room cannot be booked for past dates.
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/85f5e5ec-fe4e-403e-9715-05f6df02c7ac)

Exception 2:	If the user roomCheckIn date exceeds roomCheckOut date, then the exception is thrown.
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/d10b7af0-e609-4136-96fc-95da55cadbce)

Exception 3:	If the user enters number of rooms to be less than or equal to zero: Numbers of rooms should be greater than zero.
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/cf8de54d-f1d9-49c6-b7c1-c89ad106625d)

Endpoint 2: Make transaction for booking the room by communicating with payment-service
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/065f0b7a-8722-4788-9f80-dde05e4f55f7)

Exception handling for endpoint 2:

Exception 1: An exception is thrown if the payment mode is other than CARD or UPI. It says “Invalid Payment Mode”. This is done using global exception handler.
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/ab445b24-fb30-429e-a6b1-7ca662d94cc5)

Exception 2: An exception is thrown if the user makes transaction for a booking id which does not even exists. The exception says “Invalid booking id”. This is done using global exception handler.
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/5cce7144-0dd9-46e8-8f39-39d9edb03c1f)


Payment Service

Endpoint 1: Transaction is made. This is the API call which is hit by Booking-Service endpoint-2.
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/f1b9d57c-e5a6-4603-bc95-df5f00d64901)

Endpoint 2: Fetch the transaction details. TransactionId is passed in the url and @PathVariable is used to extract the id and it returns the transaction details of the booking.
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/a8eebb45-fd74-48a6-9002-7c93555aaa5e)

Exception for endpoint 2

Exception 1: If the transactionId does not exists then an exception is thrown “Invalid transaction Id” by Global Exception Handler.
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/5d7e237b-6d9d-4e45-890b-fb90a618475b)

Screenshot of the Eureka Server
![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/45a88c4c-0e2c-4808-90d0-e214af9e42eb)

![image](https://github.com/aayushi16dex/HotelBookingAPI/assets/47508108/09d1b4d1-5f34-4477-a117-3facbc642b84)



