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
package org.isf.therapy.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.isf.patient.dto.PatientDTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class TherapyRowDTO {

	@Schema(description="The therapy's ID", example = "1")
	private int therapyID;

	@NotNull(message="the patient is required")
	@Schema(description="The patient")
	private PatientDTO patID;

	@NotNull(message="the start date is required")
	@Schema(description="The start date of therapy", example = "2020-07-16T00:00:00", format = "LocalDateTime")
	private LocalDateTime startDate;

	@NotNull(message="the end date is required")
	@Schema(description="The end date of the therapy", example = "2020-07-30T00:00:00", format = "LocalDateTime")
	private LocalDateTime endDate;

	@NotNull(message="the medical's ID is required")
	@Schema(description="The ID of the medical concerned by the therapy", example = "1")
	private int medicalId;

	@NotNull(message="the quantity is required")
	@Schema(description="The quantity of medicals", example = "48")
	private Double qty;

	@NotNull(message="the unit's ID is required")
	@Schema(description="The unit's ID", example = "1")
	private int unitID;

	@NotNull(message="the frequency in day is required")
	@Schema(description="The frequency in day", example = "2")
	private int freqInDay;

	@NotNull(message="the frequency in period is required")
	@Schema(description="The frequency in period", example = "1")
	private int freqInPeriod;
	
	@Schema(description="A note for the therapy", example = "Sample note")		
	private String note;

	@NotNull(message="the notify flag is required")
	@Schema(description="the notify flag: 1 if the notification need to be activated, 0 otherwise", example = "0")	
	private int notifyInt;

	@NotNull(message="the sms flag is required")
	@Schema(description="the sms flag: 1 if sms need to be sent to patient, 0 otherwise", example = "0")	
	private int smsInt;

	public TherapyRowDTO() {
	}

	public TherapyRowDTO(Integer therapyID, PatientDTO patID, LocalDateTime startDate, LocalDateTime endDate, Integer medicalId,
			Double qty, Integer unitID, Integer freqInDay, Integer freqInPeriod, String note, Integer notifyInt,
			Integer smsInt) {
		this.therapyID = therapyID;
		this.patID = patID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.medicalId = medicalId;
		this.qty = qty;
		this.unitID = unitID;
		this.freqInDay = freqInDay;
		this.freqInPeriod = freqInPeriod;
		this.note = note;
		this.notifyInt = notifyInt;
		this.smsInt = smsInt;
	}

	public int getTherapyID() {
		return this.therapyID;
	}

	public PatientDTO getPatID() {
		return this.patID;
	}

	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	public int getMedicalId() {
		return this.medicalId;
	}

	public Double getQty() {
		return this.qty;
	}

	public int getUnitID() {
		return this.unitID;
	}

	public int getFreqInDay() {
		return this.freqInDay;
	}

	public int getFreqInPeriod() {
		return this.freqInPeriod;
	}

	public String getNote() {
		return this.note;
	}

	public int getNotifyInt() {
		return this.notifyInt;
	}

	public int getSmsInt() {
		return this.smsInt;
	}

	public void setTherapyID(Integer therapyID) {
		this.therapyID = therapyID;
	}

	public void setPatID(PatientDTO patID) {
		this.patID = patID;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setMedicalId(Integer medicalId) {
		this.medicalId = medicalId;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public void setUnitID(Integer unitID) {
		this.unitID = unitID;
	}

	public void setFreqInDay(Integer freqInDay) {
		this.freqInDay = freqInDay;
	}

	public void setFreqInPeriod(Integer freqInPeriod) {
		this.freqInPeriod = freqInPeriod;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setNotifyInt(Integer notifyInt) {
		this.notifyInt = notifyInt;
	}

	public void setSmsInt(Integer smsInt) {
		this.smsInt = smsInt;
	}
}
