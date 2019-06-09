package EBIEntity;

import java.sql.Timestamp;
import java.util.Calendar;
/*
 * 地震类扩展信息
 */
public class EBI_ExtendInfo1 {
	private String location_code;
	private String place;
	private String earthquake_time;
	private String level;
	private String depth;
	private String longitude;
	private String latitude;
	private String eq_type;
	private String expedited_reporting_type;
	private String nearest_provincial_capital;
	private String Shenghui;
	private String nearest_prefecture;
	private String dijishi;
	private String nearest_county;
	private String xianjishi;
	private String nearest_village;
	private String villages;
	private String nearest_town;
	private String towns;
	private String juli;
	private String range;
	private String Seismic_information;
	private String WEATHER;
	private String altitude;
	private String population;
	private String area;
	private String gdp;
	private String five_earthquake;
	
	public String getLocation_code() {
		return location_code;
	}

	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getEarthquake_time() {
		return earthquake_time;
	}

	public void setEarthquake_time(String earthquake_time) {
		this.earthquake_time = earthquake_time;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getEq_type() {
		return eq_type;
	}

	public void setEq_type(String eq_type) {
		this.eq_type = eq_type;
	}

	public String getExpedited_reporting_type() {
		return expedited_reporting_type;
	}

	public void setExpedited_reporting_type(String expedited_reporting_type) {
		this.expedited_reporting_type = expedited_reporting_type;
	}

	public String getNearest_provincial_capital() {
		return nearest_provincial_capital;
	}

	public void setNearest_provincial_capital(String nearest_provincial_capital) {
		this.nearest_provincial_capital = nearest_provincial_capital;
	}

	public String getShenghui() {
		return Shenghui;
	}

	public void setShenghui(String shenghui) {
		Shenghui = shenghui;
	}

	public String getNearest_prefecture() {
		return nearest_prefecture;
	}

	public void setNearest_prefecture(String nearest_prefecture) {
		this.nearest_prefecture = nearest_prefecture;
	}

	public String getDijishi() {
		return dijishi;
	}

	public void setDijishi(String dijishi) {
		this.dijishi = dijishi;
	}

	public String getNearest_county() {
		return nearest_county;
	}

	public void setNearest_county(String nearest_county) {
		this.nearest_county = nearest_county;
	}

	public String getXianjishi() {
		return xianjishi;
	}

	public void setXianjishi(String xianjishi) {
		this.xianjishi = xianjishi;
	}

	public String getNearest_village() {
		return nearest_village;
	}

	public void setNearest_village(String nearest_village) {
		this.nearest_village = nearest_village;
	}

	public String getVillages() {
		return villages;
	}

	public void setVillages(String villages) {
		this.villages = villages;
	}

	public String getNearest_town() {
		return nearest_town;
	}

	public void setNearest_town(String nearest_town) {
		this.nearest_town = nearest_town;
	}

	public String getTowns() {
		return towns;
	}

	public void setTowns(String towns) {
		this.towns = towns;
	}

	public String getJuli() {
		return juli;
	}

	public void setJuli(String juli) {
		this.juli = juli;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getSeismic_information() {
		return Seismic_information;
	}

	public void setSeismic_information(String seismic_information) {
		Seismic_information = seismic_information;
	}

	public String getWEATHER() {
		return WEATHER;
	}

	public void setWEATHER(String wEATHER) {
		WEATHER = wEATHER;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getGdp() {
		return gdp;
	}

	public void setGdp(String gdp) {
		this.gdp = gdp;
	}

	public String getFive_earthquake() {
		return five_earthquake;
	}

	public void setFive_earthquake(String five_earthquake) {
		this.five_earthquake = five_earthquake;
	}

	@Override
	public String toString() {
		return "EBI_ExtendInfo1 [location_code=" + location_code + ", place=" + place + ", earthquake_time="
				+ earthquake_time + ", level=" + level + ", depth=" + depth + ", longitude=" + longitude + ", latitude="
				+ latitude + ", eq_type=" + eq_type + ", expedited_reporting_type=" + expedited_reporting_type
				+ ", nearest_provincial_capital=" + nearest_provincial_capital + ", Shenghui=" + Shenghui
				+ ", nearest_prefecture=" + nearest_prefecture + ", dijishi=" + dijishi + ", nearest_county="
				+ nearest_county + ", xianjishi=" + xianjishi + ", nearest_village=" + nearest_village + ", villages="
				+ villages + ", nearest_town=" + nearest_town + ", towns=" + towns + ", juli=" + juli + ", range="
				+ range + ", Seismic_information=" + Seismic_information + ", WEATHER=" + WEATHER + ", altitude="
				+ altitude + ", population=" + population + ", area=" + area + ", gdp=" + gdp + ", five_earthquake="
				+ five_earthquake + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
