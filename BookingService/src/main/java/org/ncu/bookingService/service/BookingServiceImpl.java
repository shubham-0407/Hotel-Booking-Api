package org.ncu.bookingService.service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.ncu.bookingService.entity.BookingInfoEntity;
import org.ncu.bookingService.exception.InvalidBookingId;
import org.ncu.bookingService.exception.InvalidEndDate;
import org.ncu.bookingService.exception.NumberLessThanZero;
import org.ncu.bookingService.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepo;

	@Override
	/* Method to save booking*/
	public BookingInfoEntity addBooking(BookingInfoEntity booking) {
		
		if (booking.getFromDate().after(booking.getToDate())) {
			throw new InvalidEndDate("FromDate cannot be less than toDate"); 
		}
		else {
			// call method to calculate number of days
			int numOfDays = (int) calculateNumberOfDays(booking.getFromDate(), booking.getToDate());
			System.out.println("Days: "+numOfDays);
			
			// call method to calculate room price
			int roomPrice = calculatePrice(booking.getNumOfRooms() ,numOfDays);
			
			// call method to generate random room numbers
			String roomNumbers = generateRandomRoomNumbers(booking.getNumOfRooms());
			
			booking.setRoomNumbers(roomNumbers);
			booking.setRoomPrice(roomPrice);
			booking.setBookedOn(new Date());
			
			return bookingRepo.save(booking);	
		}
	}
	
	// Method to calculate the number of days
    public long calculateNumberOfDays(Date fromDate, Date toDate) {
        if (fromDate != null && toDate != null) {
        	long diffInMillies = Math.abs(toDate.getTime() - fromDate.getTime());
            return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        }
        return 0;
    }
    
    //Method to calculate the room price
    public int calculatePrice(int numOfRooms, int numOfDays) {
    	if(numOfRooms != 0 && numOfDays != 0) {
    		int price = 1000*numOfRooms*numOfDays;
    		return price;
    	}
    	return 0;
    }
    
    // Method to generate random integers
    public static String generateRandomRoomNumbers(int numberOfRooms) {
        if (numberOfRooms <= 0) {
            throw new NumberLessThanZero("Number of rooms should be greater than zero");
        }
        Random random = new Random();
        
     // Generate k random integers with max length 3 digits
        IntStream randomIntegers = random.ints(numberOfRooms, 1, 100); // Range from 1 to 999 (5 digits)

        // Convert the random integers to a comma-separated string
        String result = randomIntegers
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        return result;
    }


	@Override
	/* Method to update booking table after performing transaction*/
	public BookingInfoEntity updateBookingStatus(int bookingId, int transactionId) {
		Optional<BookingInfoEntity> optionalEntity = bookingRepo.findById(bookingId);
		if(optionalEntity.isPresent()) {
			BookingInfoEntity bookingInfo = optionalEntity.get();
			bookingInfo.setTransactionId(transactionId);
			return bookingRepo.save(bookingInfo);
		}
		return null;
	}
	
	@Override
	public boolean fetchBookingById(int id) {
		Optional<BookingInfoEntity> optionalTransaction = bookingRepo.findById(id);
		if(optionalTransaction.isPresent()){
			return true;
        }else {
        	throw new InvalidBookingId("Invalid booking id");
        }
		 
	}

}