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
package org.isf.medstockmovtype.dto;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public class MovementTypeDTO {

	@NotNull
	@Schema(description="Code of the movement type", example = "D")
	private String code;
	
	@NotNull
	@Schema(description="Description of the movement type", example = "Damage")
	private String description;
	
	@NotNull
	@Schema(description="Type of the movement type", example = "-")
	private String type;
	
	public MovementTypeDTO(){}
    
    /**
     * @param code
     * @param description
     * @param type
     */
    public MovementTypeDTO(String code, String description, String type) {
        this.code = code;
        this.description = description;
        this.type = type;
    }

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public String getType() {
		return this.type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}
}
