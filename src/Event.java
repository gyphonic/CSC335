//Todd Mills
//Unit 8 Case Problems
//This class holds event class data for Carly's Catering Event Demo
public class Event {

	public static final String[] eventType = {"Wedding", "Baptism", "Birthday", "Corporate", "Other"};
	public static final int lowPrice = 32;
	public static final int highPrice = 35;
	public static final int cutOffValue = 50;
	private int eventTypeInt;
	private String eventNumber;
	private int numberOfGuests;
	private int eventPrice;
	private int pricePerGuest;
	private String phoneNumber;
	
	//Default and overloaded constructors for the Event class objects
	public Event() {
		setEventNumber("A000");
		setGuests(0);
		setPhoneNumber("0000000000");
		setEventType(0);
	}
public Event(String eventNum, int numGuests, String phoneInput, int eventTypeInput) {
		setGuests(numGuests);
		setEventNumber(eventNum);
		setPhoneNumber(phoneInput);
		setEventType(eventTypeInput);
	}
	//Class methods for getting and setting event number, number of guests, and price
	//This method sets the number of guests, and uses a higher price for small events
	public void setGuests(int numGuests) {
		numberOfGuests = numGuests;
		if (isLargeEvent(numberOfGuests) == true) {
			eventPrice = numberOfGuests * lowPrice;
			pricePerGuest = lowPrice;
		} else {
			eventPrice = numberOfGuests * highPrice;
			pricePerGuest = highPrice;
		}
	}
	//This method checks to see if the event qualifies as a large event (more than 50 guests)
	public boolean isLargeEvent(int numberOfGuests) {
		if (numberOfGuests >=cutOffValue) {
			return true;
		} else {
			return false;
		}
	}
	//This method formats the entered phone number, eg. removes hyphens and dashes before setting
	public void setPhoneNumber(String phoneInput) {
			StringBuilder phoneBuilder = new StringBuilder(phoneInput);
			for (int i = phoneInput.length(); i > 0; i--) {
				if (Character.isDigit(phoneInput.charAt(i-1)) == false) {
					phoneBuilder.deleteCharAt(i-1);
				} 
			} 
			if (phoneBuilder.length() == 10) {
				phoneNumber = phoneBuilder.toString();
			} else {
				phoneNumber = "0000000000";
			}
			
	}
	public void setEventType(int eventTypeInput) {
		if (eventTypeInput > 4 || eventTypeInput < 0) {
			eventTypeInt = 4;
		} else {
			eventTypeInt = eventTypeInput;
		}
	}
	//This method has been updated to check if an entered event number is valid, otherwise sets eventNumber to "A000"
	//Valid numbers are a letter followed by 3 digits
	public void setEventNumber(String eventNum) {
		boolean isValidEventNum = false;
		eventNum = eventNum.toUpperCase();
		if (Character.isLetter(eventNum.charAt(0)) && Character.isDigit(eventNum.charAt(1)) && 
				Character.isDigit(eventNum.charAt(2)) && Character.isDigit(eventNum.charAt(3)) && isValidEventNum == false) {
			isValidEventNum = true;
		} 
		if (isValidEventNum == true) {
			eventNumber = eventNum;
		} else {
			eventNumber = "A000";
		}
	}
	public String getEventNumber() {
		return eventNumber;
	}
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	public int getEventPrice() {
		return eventPrice;
	}
	public int getPricePerGuest() {
		return pricePerGuest;
	}
	//This method converts the int eventType into a string corresponding to the eventType array
	public String getEventType () {
		return eventType[eventTypeInt];
	}
	//This method formats the phone number into a normal format
	public String getPhoneNum() {
		StringBuilder phoneBuilder = new StringBuilder(phoneNumber);
		phoneBuilder.insert(0, "(");
		phoneBuilder.insert(4, ")");
		phoneBuilder.insert(5, " ");
		phoneBuilder.insert(9, "-");
		return phoneBuilder.toString();
	}

}
