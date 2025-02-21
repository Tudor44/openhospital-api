/*
 * Open Hospital (www.open-hospital.org)
 * Copyright © 2006-2023 Informatici Senza Frontiere (info@informaticisenzafrontiere.org)
 *
 * Open Hospital is a free and open source software for healthcare data management.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * https://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package org.isf.medical.dto;

import org.isf.medtype.dto.MedicalTypeDTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class MedicalDTO {

	@Schema(description="The id of the medical", example = "1")
	private Integer code;
	
	@Schema(description="The product code", example = "PARA")
	private String prod_code;
	
	@Schema(description="The medical type")
	private MedicalTypeDTO type;
	
	@Schema(description="The description of the medical", example = "Paracétamol")
	private String description;
	
	@Schema(description="The initial quantity of the medical", example = "21")
	private double initialqty;
	
	@Schema(description="The number of pieces per packet", example = "100")
	private Integer pcsperpck;
	
	@Schema(description="The input quantity of the medical", example = "340")
	private double inqty;
	
	@Schema(description="The out quantity of the medical", example = "8")
	private double outqty;
	
	@Schema(description="The min quantity of the medical", example = "15")
	private double minqty;
	
	@Schema(description = "lock", example = "0")
	private int lock;
	
	public MedicalDTO() { }
	
	/**
	 * Constructor
	 */
	public MedicalDTO(Integer code, MedicalTypeDTO type, String prod_code, String description,
			double initialqty, Integer pcsperpck, double minqty, double inqty, double outqty) {
		this.code = code;
		this.type = type;
		this.prod_code = prod_code;
		this.description = description;
		this.initialqty = initialqty;
		this.pcsperpck = pcsperpck;
		this.minqty=minqty;
		this.inqty = inqty;
		this.outqty = outqty;
	}

	public int getLock() {
		return lock;
	}

	public void setLock(int lock) {
		this.lock = lock;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getProd_code() {
		return this.prod_code;
	}

	public MedicalTypeDTO getType() {
		return this.type;
	}

	public String getDescription() {
		return this.description;
	}

	public double getInitialqty() {
		return this.initialqty;
	}

	public Integer getPcsperpck() {
		return this.pcsperpck;
	}

	public double getInqty() {
		return this.inqty;
	}

	public double getOutqty() {
		return this.outqty;
	}

	public double getMinqty() {
		return this.minqty;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}

	public void setType(MedicalTypeDTO type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInitialqty(double initialqty) {
		this.initialqty = initialqty;
	}

	public void setPcsperpck(Integer pcsperpck) {
		this.pcsperpck = pcsperpck;
	}

	public void setInqty(double inqty) {
		this.inqty = inqty;
	}

	public void setOutqty(double outqty) {
		this.outqty = outqty;
	}

	public void setMinqty(double minqty) {
		this.minqty = minqty;
	}
}
