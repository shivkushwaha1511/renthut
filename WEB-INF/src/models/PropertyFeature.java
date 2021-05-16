package models;

public class PropertyFeature {
	private int featureId;
	private Property propertyId;
	private int roomCount;
	private int bedroom;
	private int bathroom;
	private boolean electricityBill;
	private int area;
	private boolean waterTank;
	private boolean parking;
	private int distFromSchool;
	private int distFromHospital;
	private boolean terrace;
	private boolean ventilation;
	private boolean petsAllowed;
	private int floorType;
	private boolean garden;
	
	public int getFeatureId() {
		return featureId;
	}
	
	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}
	
	public Property getPropertyId() {
		return propertyId;
	}
	
	public void setPropertyId(Property propertyId) {
		this.propertyId = propertyId;
	}
	
	public int getRoomCount() {
		return roomCount;
	}
	
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	
	public int getBedroom() {
		return bedroom;
	}
	
	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}
	
	public int getBathroom() {
		return bathroom;
	}
	
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}
	
	public boolean isElectricityBill() {
		return electricityBill;
	}
	
	public void setElectricityBill(boolean electricityBill) {
		this.electricityBill = electricityBill;
	}
	
	public int getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}
	
	public boolean isWaterTank() {
		return waterTank;
	}
	
	public void setWaterTank(boolean waterTank) {
		this.waterTank = waterTank;
	}
	
	public boolean isParking() {
		return parking;
	}
	
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	
	public int getDistFromSchool() {
		return distFromSchool;
	}
	
	public void setDistFromSchool(int distFromSchool) {
		this.distFromSchool = distFromSchool;
	}
	
	public int getDistFromHospital() {
		return distFromHospital;
	}
	
	public void setDistFromHospital(int distFromHospital) {
		this.distFromHospital = distFromHospital;
	}
	
	public boolean isTerrace() {
		return terrace;
	}
	
	public void setTerrace(boolean terrace) {
		this.terrace = terrace;
	}
	
	public boolean isVentilation() {
		return ventilation;
	}
	
	public void setVentilation(boolean ventilation) {
		this.ventilation = ventilation;
	}
	
	public boolean isPetsAllowed() {
		return petsAllowed;
	}
	
	public void setPetsAllowed(boolean petsAllowed) {
		this.petsAllowed = petsAllowed;
	}
	
	public int getFloorType() {
		return floorType;
	}
	
	public void setFloorType(int floorType) {
		this.floorType = floorType;
	}
	
	public boolean isGarden() {
		return garden;
	}
	
	public void setGarden(boolean garden) {
		this.garden = garden;
	}

}