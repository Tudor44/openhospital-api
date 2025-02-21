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
package org.isf.examination.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.drew.lang.annotations.Nullable;

import io.swagger.v3.oas.annotations.media.Schema;

public class PatientExaminationDTO {

    @Schema(description = "Patient Examination Id", example = "1")
    private int pex_ID;

    @NotNull
    @Schema(description = "Date of Patient Examination", example = "2020-03-19T14:58:00.000Z", type ="string")
    private LocalDateTime pex_date;

    @NotNull
    @Schema(description = "Patient Examination Code")
    private Integer patientCode;

    @Schema(description = "Patient Height in cm")
    private Integer pex_height;

    @Schema(description = "Patient Weight in Kg")
    private Double pex_weight;

    @Schema(description = "Blood Pressure MIN in mmHg")
    private Integer pex_ap_min;

    @Schema(description = "Blood Pressure MAX in mmHg")
    private Integer pex_ap_max;

    @Schema(description = "Respiratory Rate in bpm")
    private Integer pex_rr;

    @Schema(description = "Patient Temperature in °C")
    private Double pex_temp;

    @Schema(description = "Patient Saturation in %")
    private Double pex_sat;
    
    @Schema(description = "Heart Rate in Apm")
    private Integer pex_hr;
    
    @Nullable
    @Schema(description = "patient ausculation", example="normal")
    private Ausculation pex_auscultation;
    
    @Schema(description = "Hemo Glucose Test")
    private Integer pex_hgt;
    
    @Schema(description = "Daily urine Volume in ml")
    private Integer pex_diuresis;
    
    @Nullable
    @Schema(description = "Diuresis description", example="physiological")
    private Diurese pex_diuresis_desc;
    
    @Schema(description = "Examination Note")
    private String pex_note;
    
    @Nullable
    @Schema(description = "Bowel Function",example="regular")
    private Bowel pex_bowel_desc;

	public int getPex_ID() {
		return this.pex_ID;
	}

	public LocalDateTime getPex_date() {
		return this.pex_date;
	}

	public Integer getPex_ap_min() {
		return pex_ap_min;
	}

	public void setPex_ap_min(Integer pex_ap_min) {
		this.pex_ap_min = pex_ap_min;
	}

	public Integer getPex_ap_max() {
		return pex_ap_max;
	}

	public void setPex_ap_max(Integer pex_ap_max) {
		this.pex_ap_max = pex_ap_max;
	}

	public Integer getPex_rr() {
		return pex_rr;
	}

	public void setPex_rr(Integer pex_rr) {
		this.pex_rr = pex_rr;
	}

	public Integer getPex_hr() {
		return pex_hr;
	}

	public void setPex_hr(Integer pex_hr) {
		this.pex_hr = pex_hr;
	}

	public Integer getPex_hgt() {
		return pex_hgt;
	}

	public void setPex_hgt(Integer pex_hgt) {
		this.pex_hgt = pex_hgt;
	}

	public Integer getPex_diuresis() {
		return pex_diuresis;
	}

	public void setPex_diuresis(Integer pex_diuresis) {
		this.pex_diuresis = pex_diuresis;
	}

	public Ausculation getPex_auscultation() {
		return pex_auscultation;
	}

	public void setPex_auscultation(Ausculation pex_auscultation) {
		this.pex_auscultation = pex_auscultation;
	}

	public Diurese getPex_diuresis_desc() {
		return pex_diuresis_desc;
	}

	public void setPex_diuresis_desc(Diurese pex_diuresis_desc) {
		this.pex_diuresis_desc = pex_diuresis_desc;
	}

	public Bowel getPex_bowel_desc() {
		return pex_bowel_desc;
	}

	public void setPex_bowel_desc(Bowel pex_bowel_desc) {
		this.pex_bowel_desc = pex_bowel_desc;
	}

	public Integer getPatientCode() {
		return this.patientCode;
	}

	public Integer getPex_height() {
		return this.pex_height;
	}

	public Double getPex_weight() {
		return this.pex_weight;
	}

	public Double getPex_temp() {
		return this.pex_temp;
	}

	public Double getPex_sat() {
		return this.pex_sat;
	}

	public String getPex_note() {
		return this.pex_note;
	}

	public void setPex_ID(int pex_ID) {
		this.pex_ID = pex_ID;
	}

	public void setPex_date(LocalDateTime pex_date) {
		this.pex_date = pex_date;
	}

	public void setPatientCode(Integer patientCode) {
		this.patientCode = patientCode;
	}

	public void setPex_height(Integer pex_height) {
		this.pex_height = pex_height;
	}

	public void setPex_weight(Double pex_weight) {
		this.pex_weight = pex_weight;
	}

	public void setPex_temp(Double pex_temp) {
		this.pex_temp = pex_temp;
	}

	public void setPex_sat(Double pex_sat) {
		this.pex_sat = pex_sat;
	}

	public void setPex_note(String pex_note) {
		this.pex_note = pex_note;
	}
}
