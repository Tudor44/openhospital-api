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
package org.isf.medicalstockward.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class MedicalWardDTO {

	@Schema(description="The medical ward's id", example="1")
	private MedicalWardIdDTO id;
	
	@Schema(description="The in-quantity", example="150")
	private float in_quantity;
	
	@Schema(description="The out-quantity", example="89")
	private float out_quantity;

	public MedicalWardDTO() {
	}

	public MedicalWardDTO(MedicalWardIdDTO id, float in_quantity, float out_quantity) {
		this.id = id;
		this.in_quantity = in_quantity;
		this.out_quantity = out_quantity;
	}

	public MedicalWardIdDTO getId() {
		return this.id;
	}

	public float getIn_quantity() {
		return this.in_quantity;
	}

	public float getOut_quantity() {
		return this.out_quantity;
	}

	public void setId(MedicalWardIdDTO id) {
		this.id = id;
	}

	public void setIn_quantity(float in_quantity) {
		this.in_quantity = in_quantity;
	}

	public void setOut_quantity(float out_quantity) {
		this.out_quantity = out_quantity;
	}
}
