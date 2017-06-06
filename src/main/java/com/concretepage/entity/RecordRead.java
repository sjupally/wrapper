package com.concretepage.entity;

import com.univocity.parsers.annotations.FixedWidth;
import com.univocity.parsers.annotations.Format;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.fixed.FieldAlignment;

import javax.persistence.*;

/**
 * Created by Srikanth on 5/31/2017.
 */
@Entity
@Table(name = "TBL_DQSP_FILE_DETAILS")
public class RecordRead {
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

    @Column(name = "TAR_SYS_ID", length = 4)
    @FixedWidth(value = 4, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 3)
    private String tarSysId;

    @Column(name = "ACCOUNT_NO", length = 14)
    @FixedWidth(value = 14, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 4)
    private String accountNo;

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

    @Column(name = "REF", length = 7)
    @FixedWidth(value = 7, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 9)
    private String ref;

    @Column(name = "BRAND_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 10)
    private String brandInd;

    @Column(name = "PRODUCT_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 11)
    private String productInd;

    @Column(name = "BOA", length = 4)
    @FixedWidth(value = 4, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 12)
    private int boa;

    @Column(name = "RES_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 13)
    private String resInd;

    @Column(name = "SUCCESS_CODE", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 14)
    private String successCode;

    @Column(name = "REASON_CODE", length = 4)
    @FixedWidth(value = 4, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 15)
    private String reasonCode;

    @Column(name = "CR_BR_AMT", length = 11)
    @Format(formats = "#0.00", options = "decimalSeparator=.")
    @FixedWidth(value = 11, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 16)
    private double crBrAmt;

    @Column(name = "STATUS", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 17)
    private String status;

    @Column(name = "SIGNAL", length = 9)
    @FixedWidth(value = 9, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 18)
    private String signal;

    @Column(name = "LAST_LEDGET_BAL", length = 11)
    @Format(formats = "#0.00", options = "decimalSeparator=.")
    @FixedWidth(value = 11, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 19)
    private double lastLedgerBal;

    @Column(name = "REFOR_ACC_NO", length = 12)
    @FixedWidth(value = 12, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 20)
    private String reforAccNo;

    @Column(name = "SCHEME_CODE", length = 4)
    @FixedWidth(value = 4, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 21)
    private String schemeCode;

    @FixedWidth(value = 117, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 22)
    private String filler;


}
