package EBIEntity;

import java.sql.Timestamp;
import java.util.Calendar;

/*
 * 民航机场类扩展信息
 */
public class EBI_ExtendInfo2 {
	private String Airport;
	private String Airportcode;
	private String Inbound_flights;
	private String Outbound_flights;
	private String Inbound_numberofpeople;
	private String Outbound_numberofpeople;
	private String Inbound_Delayedflights;
	private String Outbound_Delayedflights;
	private String AirportStatus;
	private String Inbound_flights_number;
	private String Outbound_flightsnumber;
	private String Time;

	public String getAirport() {
		return Airport;
	}

	public void setAirport(String airport) {
		Airport = airport;
	}

	public String getAirportcode() {
		return Airportcode;
	}

	public void setAirportcode(String airportcode) {
		Airportcode = airportcode;
	}

	public String getInbound_flights() {
		return Inbound_flights;
	}

	public void setInbound_flights(String inbound_flights) {
		Inbound_flights = inbound_flights;
	}

	public String getOutbound_flights() {
		return Outbound_flights;
	}

	public void setOutbound_flights(String outbound_flights) {
		Outbound_flights = outbound_flights;
	}

	public String getInbound_numberofpeople() {
		return Inbound_numberofpeople;
	}

	public void setInbound_numberofpeople(String inbound_numberofpeople) {
		Inbound_numberofpeople = inbound_numberofpeople;
	}

	public String getOutbound_numberofpeople() {
		return Outbound_numberofpeople;
	}

	public void setOutbound_numberofpeople(String outbound_numberofpeople) {
		Outbound_numberofpeople = outbound_numberofpeople;
	}

	public String getInbound_Delayedflights() {
		return Inbound_Delayedflights;
	}

	public void setInbound_Delayedflights(String inbound_Delayedflights) {
		Inbound_Delayedflights = inbound_Delayedflights;
	}

	public String getOutbound_Delayedflights() {
		return Outbound_Delayedflights;
	}

	public void setOutbound_Delayedflights(String outbound_Delayedflights) {
		Outbound_Delayedflights = outbound_Delayedflights;
	}

	public String getAirportStatus() {
		return AirportStatus;
	}

	public void setAirportStatus(String airportStatus) {
		AirportStatus = airportStatus;
	}

	public String getInbound_flights_number() {
		return Inbound_flights_number;
	}

	public void setInbound_flights_number(String inbound_flights_number) {
		Inbound_flights_number = inbound_flights_number;
	}

	public String getOutbound_flightsnumber() {
		return Outbound_flightsnumber;
	}

	public void setOutbound_flightsnumber(String outbound_flightsnumber) {
		Outbound_flightsnumber = outbound_flightsnumber;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	@Override
	public String toString() {
		return "EBI_ExtendInfo2 [Airport=" + Airport + ", Airportcode=" + Airportcode + ", Inbound_flights="
				+ Inbound_flights + ", Outbound_flights=" + Outbound_flights + ", Inbound_numberofpeople="
				+ Inbound_numberofpeople + ", Outbound_numberofpeople=" + Outbound_numberofpeople
				+ ", Inbound_Delayedflights=" + Inbound_Delayedflights + ", Outbound_Delayedflights="
				+ Outbound_Delayedflights + ", AirportStatus=" + AirportStatus + ", Inbound_flights_number="
				+ Inbound_flights_number + ", Outbound_flightsnumber=" + Outbound_flightsnumber + ", Time=" + Time
				+ "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
