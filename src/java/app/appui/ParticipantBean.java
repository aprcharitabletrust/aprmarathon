/*
 *
 *
 * APR Marathon Registration App Project - MANUAL EDIT
 *
 * Author: Govind Thirumalai
 */
package app.appui;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.*;
import core.ui.*;
import core.appui.*;
import core.util.*;
import app.util.*;
import app.busobj.*;
import app.businterface.*;
import app.busimpl.*;

import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.File;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ParticipantBean implements SpreadSheetInterface {
    public int participantId = 0;
    public int participantGender = 0;
    public int participantTShirtSize = 0;
    public int participantBloodGroup = 0;
	public int participantGroup = 0;
    ParticipantObject selectedParticipantObj = new ParticipantObject();
    ParticipantInterface participantIf = new ParticipantImpl();

    public ParticipantBean() {}

    public void getRequestParameters(HttpServletRequest request) throws AppException {
		HttpSession session = request.getSession();
		if (session == null)
			throw new NullPointerException();
		@SuppressWarnings("unchecked")
		Hashtable<String,String> valuepairs =
			(Hashtable)session.getAttribute(Constants.VALUE_PAIR_STR);
		try {
			participantId = Integer.parseInt(valuepairs.get(AppConstants.PARTICIPANT_ID_STR));
		} catch (NumberFormatException nfe) {
			participantId = 0;
		}
		try {
			participantGender = Integer.parseInt(valuepairs.get(AppConstants.PARTICIPANT_GENDER_STR));
		} catch (NumberFormatException nfe) {
			participantGender = 0;
		}
		try {
			participantTShirtSize = Integer.parseInt(valuepairs.get(AppConstants.PARTICIPANT_T_SHIRT_SIZE_STR));
		} catch (NumberFormatException nfe) {
			participantTShirtSize = 0;
		}
		try {
			participantBloodGroup = Integer.parseInt(valuepairs.get(AppConstants.PARTICIPANT_BLOOD_GROUP_STR));
		} catch (NumberFormatException nfe) {
			participantBloodGroup = 0;
		}
		try {
			participantGroup = Integer.parseInt(valuepairs.get(AppConstants.PARTICIPANT_BLOOD_GROUP_STR));
		} catch (NumberFormatException nfe) {
			participantBloodGroup = 0;
		}
		try {
			participantGroup = Integer.parseInt(valuepairs.get(AppConstants.PARTICIPANT_GROUP_STR));
		} catch (NumberFormatException nfe) {
			participantGroup = 0;
		}
		String saveProfile = valuepairs.get(UtilBean.SAVE_PROFILE_FLAG_STR);
		if ( saveProfile == null ||
			 Boolean.valueOf(saveProfile).booleanValue() == false ) {
			// This is to display the page
			if ( participantId != 0 ) // Display the selected participant
			selectedParticipantObj = participantIf.getParticipant(participantId);
		}
		else {
			String inputFileName = valuepairs.get(Constants.UPLOAD_FILE_NAME_STR);
			if ( inputFileName == null ) {
				if ( participantId != 0 ) {
					String buf = "";
					Date date = null;
					SimpleDateFormat dateFormatter = new SimpleDateFormat(Constants.DATE_FORMAT_STR);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_FIRST_NAME_STR));
					selectedParticipantObj.setParticipantFirstName(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_MIDDLE_NAME_STR));
					selectedParticipantObj.setParticipantMiddleName(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_LAST_NAME_STR));
					selectedParticipantObj.setParticipantLastName(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_GENDER_STR));
					selectedParticipantObj.setParticipantGender(Integer.parseInt(buf));
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_DATE_OF_BIRTH_STR));
					try {
						date = dateFormatter.parse(buf);
					} catch (java.text.ParseException pe) {
						throw new AppException("Parse Exception while parsing " + buf);
					}
					selectedParticipantObj.setParticipantDateOfBirth(date);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_T_SHIRT_SIZE_STR));
					selectedParticipantObj.setParticipantTShirtSize(Integer.parseInt(buf));
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_BLOOD_GROUP_STR));
					selectedParticipantObj.setParticipantBloodGroup(Integer.parseInt(buf));
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_CELL_PHONE_STR));
					selectedParticipantObj.setParticipantCellPhone(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_EMAIL_STR));
					selectedParticipantObj.setParticipantEmail(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_GROUP_STR));
					selectedParticipantObj.setParticipantGroup(Integer.parseInt(buf));
					DebugHandler.debug("Modifying Participant Object " + selectedParticipantObj);
					participantIf.updateParticipant(selectedParticipantObj);
				}
				else {
					String buf = "";
					Date date = null;
					SimpleDateFormat dateFormatter = new SimpleDateFormat(Constants.DATE_FORMAT_STR);
					ParticipantObject participantObj = new ParticipantObject();
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_FIRST_NAME_STR));
					participantObj.setParticipantFirstName(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_MIDDLE_NAME_STR));
					participantObj.setParticipantMiddleName(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_LAST_NAME_STR));
					participantObj.setParticipantLastName(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_GENDER_STR));
					participantObj.setParticipantGender(Integer.parseInt(buf));
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_DATE_OF_BIRTH_STR));
					try {
						date = dateFormatter.parse(buf);
					} catch (java.text.ParseException pe) {
						throw new AppException("Parse Exception while parsing " + buf);
					}
					participantObj.setParticipantDateOfBirth(date);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_T_SHIRT_SIZE_STR));
					participantObj.setParticipantTShirtSize(Integer.parseInt(buf));
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_BLOOD_GROUP_STR));
					participantObj.setParticipantBloodGroup(Integer.parseInt(buf));
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_CELL_PHONE_STR));
					participantObj.setParticipantCellPhone(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_EMAIL_STR));
					participantObj.setParticipantEmail(buf);
					buf = Util.trim(valuepairs.get(AppConstants.PARTICIPANT_GROUP_STR));
					participantObj.setParticipantGroup(Integer.parseInt(buf));
					DebugHandler.debug("Adding Participant Object " + participantObj);
					participantIf.addParticipant(participantObj);
				}
			}
			else {
				String temp = System.getProperty("java.io.tmpdir");
				inputFileName = temp + File.separatorChar + inputFileName;
				readFromFile(inputFileName, null);
			}
		}
    }

    public String getParticipantInfo() throws AppException {
		TableElement te = new TableElement();
		te.setClass(Constants.BODY_TABLE_STYLE);
		TableRowElement tr = null;
		TableDataElement td = null;
		BoldElement be = null;
		SelectElement se = null;
		InputElement ie = null;
		TextareaElement txt = null;
		ParticipantObject participantObj = participantIf.getParticipant(participantId);

		if ( participantObj == null )
			participantObj = new ParticipantObject();
		tr = new TableRowElement();
		be = new BoldElement(AppConstants.CURRENT_PARTICIPANT_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		ArrayList<String> nameArrayList = new ArrayList<String>();
		ArrayList<Integer> valueArrayList = new ArrayList<Integer>();
		ParticipantObject[] participantArr = participantIf.getAllParticipants();
		nameArrayList.add(AppConstants.NEW_PARTICIPANT);
		valueArrayList.add(new Integer(0));
		for (int iterator = 0; iterator < participantArr.length; iterator++) {
			ParticipantObject participantObject = participantArr[iterator];
			if ( participantObject == null )
				break;
			nameArrayList.add(	participantObject.getParticipantId() + "->" +
								participantObject.getParticipantFirstName() + "->" +
								participantObject.getParticipantLastName());
			valueArrayList.add(new Integer(participantObject.getParticipantId()));
		}
		se = new SelectElement(AppConstants.PARTICIPANT_ID_STR, nameArrayList, valueArrayList, String.valueOf(participantId), 0);
		se.setOnChange(UtilBean.JS_SUBMIT_FORM);
		td = new TableDataElement(se);
		tr.add(td);
		te.add(tr);

		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_FIRST_NAME_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		if ( participantId != 0 )
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_FIRST_NAME_STR, selectedParticipantObj.getParticipantFirstName()));
		else
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_FIRST_NAME_STR, Constants.EMPTY));
		tr.add(td);
		te.add(tr);

		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_MIDDLE_NAME_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		if ( participantId != 0 )
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_MIDDLE_NAME_STR, selectedParticipantObj.getParticipantMiddleName()));
		else
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_MIDDLE_NAME_STR, Constants.EMPTY));
		tr.add(td);
		te.add(tr);

		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_LAST_NAME_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		if ( participantId != 0 )
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_LAST_NAME_STR, selectedParticipantObj.getParticipantLastName()));
		else
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_LAST_NAME_STR, Constants.EMPTY));
		tr.add(td);
		te.add(tr);

		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_GENDER_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		nameArrayList = new ArrayList<String>();
		valueArrayList = new ArrayList<Integer>();
		GenderInterface genderIf = new GenderImpl();
		GenderObject[] genderRefArr = genderIf.getAllGenders();
		for (int iterator = 0; iterator < genderRefArr.length; iterator++) {
			GenderObject genderObject = genderRefArr[iterator];
			if (genderObject == null)
				break;
			nameArrayList.add(String.valueOf(genderObject.getGenderName()));
			valueArrayList.add(new Integer(genderObject.getGenderId()));
		}
		if ( participantId != 0 )
			se = new SelectElement(AppConstants.PARTICIPANT_GENDER_STR, nameArrayList, valueArrayList, String.valueOf(selectedParticipantObj.getParticipantGender()), 0);
		else
			se = new SelectElement(AppConstants.PARTICIPANT_GENDER_STR, nameArrayList, valueArrayList, String.valueOf(participantGender), 0);
		td = new TableDataElement(se);
		tr.add(td);
		te.add(tr);

		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_DATE_OF_BIRTH_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		if ( participantId != 0 ) {
			SimpleDateFormat dateFormatter = new SimpleDateFormat(Constants.DATE_FORMAT_STR);
			String formattedDate = dateFormatter.format(selectedParticipantObj.getParticipantDateOfBirth());
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_DATE_OF_BIRTH_STR, formattedDate));
		}	else
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_DATE_OF_BIRTH_STR, Constants.EMPTY));
		tr.add(td);
		te.add(tr);

		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_T_SHIRT_SIZE_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		nameArrayList = new ArrayList<String>();
		valueArrayList = new ArrayList<Integer>();
		TShirtSizeInterface t_shirt_sizeIf = new TShirtSizeImpl();
		TShirtSizeObject[] t_shirt_sizeRefArr = t_shirt_sizeIf.getAllTShirtSizes();
		for (int iterator = 0; iterator < t_shirt_sizeRefArr.length; iterator++) {
			TShirtSizeObject t_shirt_sizeObject = t_shirt_sizeRefArr[iterator];
			if (t_shirt_sizeObject == null)
				break;
			nameArrayList.add(String.valueOf(t_shirt_sizeObject.getTShirtSizeName()));
			valueArrayList.add(new Integer(t_shirt_sizeObject.getTShirtSizeId()));
		}
		if ( participantId != 0 )
			se = new SelectElement(AppConstants.PARTICIPANT_T_SHIRT_SIZE_STR, nameArrayList, valueArrayList, String.valueOf(selectedParticipantObj.getParticipantTShirtSize()), 0);
		else
			se = new SelectElement(AppConstants.PARTICIPANT_T_SHIRT_SIZE_STR, nameArrayList, valueArrayList, String.valueOf(participantTShirtSize), 0);
		td = new TableDataElement(se);
		tr.add(td);
		te.add(tr);

		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_BLOOD_GROUP_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		nameArrayList = new ArrayList<String>();
		valueArrayList = new ArrayList<Integer>();
		BloodGroupInterface blood_groupIf = new BloodGroupImpl();
		BloodGroupObject[] blood_groupRefArr = blood_groupIf.getAllBloodGroups();
		for (int iterator = 0; iterator < blood_groupRefArr.length; iterator++) {
			BloodGroupObject blood_groupObject = blood_groupRefArr[iterator];
			if (blood_groupObject == null)
				break;
			nameArrayList.add(String.valueOf(blood_groupObject.getBloodGroupName()));
			valueArrayList.add(new Integer(blood_groupObject.getBloodGroupId()));
		}
		if ( participantId != 0 )
			se = new SelectElement(AppConstants.PARTICIPANT_BLOOD_GROUP_STR, nameArrayList, valueArrayList, String.valueOf(selectedParticipantObj.getParticipantBloodGroup()), 0);
		else
			se = new SelectElement(AppConstants.PARTICIPANT_BLOOD_GROUP_STR, nameArrayList, valueArrayList, String.valueOf(participantBloodGroup), 0);
		td = new TableDataElement(se);
		tr.add(td);
		te.add(tr);

		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_CELL_PHONE_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		if ( participantId != 0 )
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_CELL_PHONE_STR, selectedParticipantObj.getParticipantCellPhone()));
		else
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_CELL_PHONE_STR, Constants.EMPTY));
		tr.add(td);
		te.add(tr);

		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_EMAIL_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		if ( participantId != 0 )
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_EMAIL_STR, selectedParticipantObj.getParticipantEmail()));
		else
			td = new TableDataElement(new InputElement(InputElement.TEXT, AppConstants.PARTICIPANT_EMAIL_STR, Constants.EMPTY));
		tr.add(td);
		te.add(tr);
	
		tr = new TableRowElement();
		be = new BoldElement(AppConstants.PARTICIPANT_GROUP_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);
		nameArrayList = new ArrayList<String>();
		valueArrayList = new ArrayList<Integer>();
		RegistrantEventInterface registrant_eventIf = new RegistrantEventImpl();
		RegistrantEventObject[] registrant_eventRefArr = registrant_eventIf.getAllRegistrantEvents();
		for (int iterator = 0; iterator < registrant_eventRefArr.length; iterator++) {
			RegistrantEventObject registrant_eventObject = registrant_eventRefArr[iterator];
			if (registrant_eventObject == null)
				break;
			nameArrayList.add(String.valueOf(registrant_eventObject.getRegistrantId()));
			valueArrayList.add(new Integer(registrant_eventObject.getRegistrantEventId()));
		}
		if ( participantId != 0 )
			se = new SelectElement(AppConstants.PARTICIPANT_GROUP_STR, nameArrayList, valueArrayList, String.valueOf(selectedParticipantObj.getParticipantGroup()), 0);
		else
			se = new SelectElement(AppConstants.PARTICIPANT_GROUP_STR, nameArrayList, valueArrayList, String.valueOf(participantGroup), 0);
		td = new TableDataElement(se);
		tr.add(td);
		te.add(tr);


		tr = new TableRowElement();
		be = new BoldElement(Constants.UPLOAD_FILE_LABEL);
		be.setId(Constants.BODY_ROW_STYLE);
		td = new TableDataElement(be);
		tr.add(td);

		ie = new InputElement(InputElement.FILE, Constants.UPLOAD_FILE_NAME_STR,"");
		td = new TableDataElement(ie);
		tr.add(td);
		te.add(tr);

		return te.getHTMLTag() + new BreakElement().getHTMLTag() +  new BreakElement().getHTMLTag() + UtilBean.getSubmitButton() + UtilBean.getDownloadButton();
    }

    public void writeToFile(String outputFileName, Object obj) throws AppException {
		DebugHandler.fine("writeToFile(" + outputFileName + "," + obj + ")");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFFont font01Bold = wb.createFont();
		font01Bold.setFontHeightInPoints((short)12);
		font01Bold.setFontName("Times New Roman");
		font01Bold.setBold(true);

		XSSFFont font01Normal = wb.createFont();
		font01Normal.setFontHeightInPoints((short)12);
		font01Normal.setFontName("Times New Roman");
		font01Normal.setBold(false);

		// Create style
		CellStyle cellstyleTblHdr = wb.createCellStyle();
		cellstyleTblHdr.setFont(font01Bold);
		cellstyleTblHdr.setAlignment(HorizontalAlignment.CENTER);
		cellstyleTblHdr.setWrapText(true);
		cellstyleTblHdr.setBorderBottom(BorderStyle.MEDIUM);
		cellstyleTblHdr.setBorderLeft(BorderStyle.MEDIUM);
		cellstyleTblHdr.setBorderRight(BorderStyle.MEDIUM);
		cellstyleTblHdr.setBorderTop(BorderStyle.MEDIUM);
		cellstyleTblHdr.setVerticalAlignment(VerticalAlignment.CENTER);
		cellstyleTblHdr.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		cellstyleTblHdr.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		CellStyle cellstyleTblLeft = wb.createCellStyle();
		cellstyleTblLeft.setFont(font01Normal);
		cellstyleTblLeft.setAlignment(HorizontalAlignment.LEFT);
		cellstyleTblLeft.setWrapText(true);
		cellstyleTblLeft.setBorderBottom(BorderStyle.THIN);
		cellstyleTblLeft.setBorderLeft(BorderStyle.THIN);
		cellstyleTblLeft.setBorderRight(BorderStyle.THIN);
		cellstyleTblLeft.setVerticalAlignment(VerticalAlignment.TOP);

		XSSFSheet sheet = wb.createSheet();
		FileOutputStream fileOut = null;
		int rowNum = 0;
		int col = 0;
		XSSFRow row = null;
		XSSFCell cell = null;
		try {
			fileOut = new FileOutputStream(outputFileName);
		} catch (FileNotFoundException fnf) {
			throw new AppException("Unable to find file " + outputFileName);
		}
		row = sheet.createRow((short)rowNum);
		sheet.setColumnWidth((short)col, (short) (0));
		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_ID_LABEL);

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue("DB Operation");

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_FIRST_NAME_LABEL);

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_MIDDLE_NAME_LABEL);

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_LAST_NAME_LABEL);

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_GENDER_LABEL);

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_DATE_OF_BIRTH_LABEL);

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_T_SHIRT_SIZE_LABEL);

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_BLOOD_GROUP_LABEL);

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_CELL_PHONE_LABEL);

		cell = row.createCell((short)col++);
		cell.setCellStyle(cellstyleTblHdr);
		cell.setCellValue(AppConstants.PARTICIPANT_EMAIL_LABEL);

		ParticipantInterface participantIf = new ParticipantImpl();
		ParticipantObject[] participantArr = participantIf.getAllParticipants();
		if ( participantArr != null && participantArr.length > 0 ) {
			for (int iterator = 0; iterator < participantArr.length; iterator++) {
				ParticipantObject participantObj = participantArr[iterator];
				if ( participantObj == null )
					break;
				rowNum++;
				col = 0;
				row = sheet.createRow((short)rowNum);

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantId());

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue("INFO");

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantFirstName());

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantMiddleName());

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantLastName());

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantGender());

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantDateOfBirth());

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantTShirtSize());

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantBloodGroup());

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantCellPhone());

				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantEmail());
			
				cell = row.createCell((short)col++);
				cell.setCellStyle(cellstyleTblLeft);
				cell.setCellValue(participantObj.getParticipantGroup());
			}
		}
		try {
			wb.write(fileOut);
			fileOut.close();
		} catch (IOException ioe) {
			throw new AppException("Exception closing file" + outputFileName);
		}
    }

    public void readFromFile(String inputFileName, Object obj) throws AppException {
		DebugHandler.fine("readFromFile(" + inputFileName + obj + ")");
		InputStream fs = null;
		XSSFWorkbook wb = null;
		try {
			fs = new FileInputStream(inputFileName);
		} catch (IOException ioe) {
			throw new AppException("IOException while opening file " + inputFileName);
		}
		try {
			wb = new XSSFWorkbook(fs);
		} catch (IOException ioe) {
			throw new AppException("IOException while getting workbook.");
		}
		XSSFSheet sheet = wb.getSheetAt(0);
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(inputFileName);
		} catch (FileNotFoundException fnf) {
			throw new AppException("Unable to find file " + inputFileName);
		}
		int rowNum = 0;
		int col = 0;
		XSSFRow row = null;
		XSSFCell cell = null;
		String dbOp = null;
		ParticipantInterface participantIf = new ParticipantImpl();
		ParticipantObject participantObject = new ParticipantObject();

		rowNum = 0;
		while ( true ) {
			row = sheet.getRow(++rowNum);
			if ( row == null )
				break;
			participantObject = new ParticipantObject();
			cell = row.getCell((short)1);
			if ( cell != null )
				dbOp = Util.trim(cell.getStringCellValue());
			else
				dbOp = null;
			DebugHandler.fine("DbOp = |" + dbOp + "|");
			if ( dbOp != null &&  dbOp.equalsIgnoreCase("UPDATE") ) {
				cell = row.getCell((short)0); // Get the first column
				try {
					participantObject.setParticipantId((int)cell.getNumericCellValue());
				} catch (NumberFormatException nfe) {
					throw new AppException("Column A has been changed in " + wb.getSheetName((short)0) + " Current value is Row num " + row + " is : " + cell.getStringCellValue());
				}
				participantObject = participantIf.getParticipant(participantObject.getParticipantId());
				col = 2; // Starting from 3rd Column
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantFirstName(Util.trim(cell.getStringCellValue()));
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantMiddleName(Util.trim(cell.getStringCellValue()));
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantLastName(Util.trim(cell.getStringCellValue()));
				cell = row.getCell((short)col++);
				if ( cell != null )
					try {
						participantObject.setParticipantGender((int)cell.getNumericCellValue());
					} catch (NumberFormatException nfe) {
						participantObject.setParticipantGender(0);
					}
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantDateOfBirth(cell.getDateCellValue());
				cell = row.getCell((short)col++);
				if ( cell != null )
					try {
						participantObject.setParticipantTShirtSize((int)cell.getNumericCellValue());
					} catch (NumberFormatException nfe) {
						participantObject.setParticipantTShirtSize(0);
					}
				cell = row.getCell((short)col++);
				if ( cell != null )
					try {
						participantObject.setParticipantBloodGroup((int)cell.getNumericCellValue());
					} catch (NumberFormatException nfe) {
						participantObject.setParticipantBloodGroup(0);
					}
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantCellPhone(Util.trim(cell.getStringCellValue()));
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantEmail(Util.trim(cell.getStringCellValue()));
				if ( cell != null )
					try {
						participantObject.setParticipantGroup((int)cell.getNumericCellValue());
					} catch (NumberFormatException nfe) {
						participantObject.setParticipantGroup(0);
					}
				DebugHandler.fine("Updating Participant " + participantObject);
				participantIf.updateParticipant(participantObject);
			} else if ( dbOp != null && dbOp.equalsIgnoreCase("INSERT") ) {
				col = 2; // Starting from 3rd Column
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantFirstName(Util.trim(cell.getStringCellValue()));
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantMiddleName(Util.trim(cell.getStringCellValue()));
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantLastName(Util.trim(cell.getStringCellValue()));
				cell = row.getCell((short)col++);
				if ( cell != null )
				try {
					participantObject.setParticipantGender((int)cell.getNumericCellValue());
				} catch (NumberFormatException nfe) {
					participantObject.setParticipantGender(0);
				}
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantDateOfBirth(cell.getDateCellValue());
				cell = row.getCell((short)col++);
				if ( cell != null )
					try {
						participantObject.setParticipantTShirtSize((int)cell.getNumericCellValue());
					} catch (NumberFormatException nfe) {
						participantObject.setParticipantTShirtSize(0);
					}
				cell = row.getCell((short)col++);
				if ( cell != null )
					try {
						participantObject.setParticipantBloodGroup((int)cell.getNumericCellValue());
					} catch (NumberFormatException nfe) {
						participantObject.setParticipantBloodGroup(0);
					}
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantCellPhone(Util.trim(cell.getStringCellValue()));
				cell = row.getCell((short)col++);
				if ( cell != null )
					participantObject.setParticipantEmail(Util.trim(cell.getStringCellValue()));
				if ( cell != null )
					try {
						participantObject.setParticipantGroup((int)cell.getNumericCellValue());
					} catch (NumberFormatException nfe) {
						participantObject.setParticipantGroup(0);
					}
				DebugHandler.fine("Adding Participant " + participantObject);
				participantIf.addParticipant(participantObject);
			} else if ( dbOp != null && dbOp.equalsIgnoreCase("DELETE") ) {
				cell = row.getCell((short)0); // Get the first column
				try {
					participantObject.setParticipantId((int)cell.getNumericCellValue());
				} catch (NumberFormatException nfe) {
					throw new AppException("Column A has been changed in " + wb.getSheetName((short)0) + " Current value is Row num " + row + " is : " + cell.getStringCellValue());
				}
				participantObject = participantIf.getParticipant(participantObject.getParticipantId());
				participantIf.deleteParticipant(participantObject);
			} else if ( dbOp != null && ! dbOp.equalsIgnoreCase("INFO") ) {
				throw new AppException("Invalid operation " + dbOp + " in Row num: " + rowNum);
			}
		}
    }
}
