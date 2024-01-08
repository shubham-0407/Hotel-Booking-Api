package org.ncu.bookingService.service;

import org.ncu.bookingService.entity.BookingInfoEntity;

public interface BookingService {
	
	public BookingInfoEntity addBooking(BookingInfoEntity booking);
	public BookingInfoEntity updateBookingStatus(int bookingId, int transactionId);
	public boolean fetchBookingById(int id);

}
