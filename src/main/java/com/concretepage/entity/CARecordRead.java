package com.concretepage.entity;

import com.univocity.parsers.annotations.FixedWidth;
import com.univocity.parsers.annotations.Format;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.fixed.FieldAlignment;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Srikanth on 5/31/2017.
 */
@Entity
@Table(name = "TBL_CASP_FILE_DETAILS")
public class CARecordRead {
    @Transient
    @FixedWidth(value = 2, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 0)
    private String recordType;

    @Transient
    @FixedWidth(value = 4, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 1)
    private String origSysId;

    @Id
    @Column(name = "ORIG_SYSKEY", unique = true, nullable = false, length = 20)
    @FixedWidth(value = 20, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 2)
    private String origSysKey;

    @Column(name = "TARGET_SYSTEM", length = 4)
    @FixedWidth(value = 4, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 3)
    private String targetSystem;

    @Column(name = "ACCOUNT", length = 14)
    @FixedWidth(value = 14, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 4)
    private String account;

    @Column(name = "TRANS_CODE", length = 6)
    @FixedWidth(value = 6, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 5)
    private String transCode;

    @Column(name = "CR_DR_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 6)
    private String crDrInd;

    @Column(name = "TRANS_AMT", length = 11)
    @Format(formats = "#0.00", options = "decimalSeparator=.")
    @FixedWidth(value = 11, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 7)
    private double transAmt;

    @Column(name = "BOT", length = 4)
    @FixedWidth(value = 4, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 8)
    private int bot;

    @Column(name = "TRANS_REF", length = 7)
    @FixedWidth(value = 7, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 9)
    private String transRef;

    @Column(name = "CLIENT_REF", length = 34)
    @FixedWidth(value = 34, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 10)
    private String clientRef;

    @Column(name = "SUCCESS_CODE", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 11)
    private String successCode;

    @Column(name = "REASON_CODE", length = 4)
    @FixedWidth(value = 4, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 12)
    private String reasonCode;

    @Column(name = "CR_DR_AMT", length = 11)
    @Format(formats = "#0.00", options = "decimalSeparator=.")
    @FixedWidth(value = 11, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 13)
    private double crDrAmt;

    @Column(name = "STATUS_CODE", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 14)
    private String statusCode;

    @Column(name = "SIGNAL_CODE", length = 8)
    @FixedWidth(value = 8, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 15)
    private String signalCode;

    @Column(name = "ADDITIONAL_REF", length = 34)
    @FixedWidth(value = 34, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 16)
    private String additionalRef;

    @Column(name = "BRAND_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 17)
    private String brandInd;

    @Column(name = "BOA", length = 4)
    @FixedWidth(value =4, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 18)
    private int boa;

    @Column(name = "GTR_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 19)
    private int gtrInd;

    @Column(name = "UPDATE_DATE")
    private Date processDate;

    @Column(name = "RESPONSE_RECEIVED" , length = 1)
    private Date fileGeneratorIndicator;



}
