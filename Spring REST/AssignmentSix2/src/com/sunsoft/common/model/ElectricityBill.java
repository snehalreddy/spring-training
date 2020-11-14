package com.sunsoft.common.model;

public class ElectricityBill {
	private int meterNo;
	private String customerName;
	private float units;
	private float costPerUnit;
	private float amount;
	private String lastDate;

	public ElectricityBill(int meterNo, String customerName, float units, float costPerUnit, float amount,
			String lastDate) {
		this.meterNo = meterNo;
		this.customerName = customerName;
		this.units = units;
		this.costPerUnit = costPerUnit;
		this.amount = amount;
		this.lastDate = lastDate;
	}

	public int getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(int meterNo) {
		this.meterNo = meterNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public float getUnits() {
		return units;
	}

	public void setUnits(float units) {
		this.units = units;
	}

	public float getCostPerUnit() {
		return costPerUnit;
	}

	public void setCostPerUnit(float costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

}
