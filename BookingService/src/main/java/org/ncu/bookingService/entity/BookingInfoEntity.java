package org.ncu.bookingService.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Column(nullable=true)
	private Date toDate;
	
	@Column(nullable=true)
	private Date fromDate;
	
	@Column(nullable=true)
	private String aadharNumber;
	
	@Column(nullable=false)
	private int numOfRooms;
	
	@Column
	private String roomNumbers;
	
	@Column(nullable=false)
	private int roomPrice;
	
	@Column(columnDefinition = "INTEGER DEFAULT 0")
	private int transactionId;
	
	@Column(nullable=true)
	private Date bookedOn;
	
	
	
	

}
