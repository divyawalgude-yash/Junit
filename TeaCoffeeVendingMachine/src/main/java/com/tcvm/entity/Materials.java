package com.tcvm.entity;

public class Materials {

	private Integer consumptionMaterial;
	private Integer wasteMaterial;
	
	
	public Materials(Integer consumptionMaterial, Integer wasteMaterial) {
		super();
		this.consumptionMaterial = consumptionMaterial;
		this.wasteMaterial = wasteMaterial;
	}
	
	public Integer getConsumptionMaterial() {
		return consumptionMaterial;
	}
	
	public Integer getWasteMaterial() {
		return wasteMaterial;
	}
	
	
	
}
