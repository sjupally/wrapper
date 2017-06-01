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
@Table(name = "TBL_DQSP_FILE_DETAILS")
public class Record {
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

    @Column(name = "INSUFF_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 11)
    private String insuffInd;

    @Column(name = "CA_VAL_DATE")
    @FixedWidth(value = 8, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 12)
    private Date caValDate;

    @Column(name = "34REF1", length = 34)
    @FixedWidth(value = 34, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 13)
    private String ref1;

    @Column(name = "34REF2", length = 34)
    @FixedWidth(value = 34, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 14)
    private String ref2;

    @Column(name = "34REF3", length = 34)
    @FixedWidth(value = 34, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 15)
    private String ref3;

    @Column(name = "HOLD_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 16)
    private String holdInd;

    @Column(name = "NO_SUSPENSE_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 17)
    private String noSuspenseInd;

    @Column(name = "ACCNT_NO_IND", length = 1)
    @FixedWidth(value = 1, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 18)
    private String accntNoInd;

    @Column(name = "PROCESS_DATE")
    private Date processDate;

    @Column(name = "FILE_GENERATOR_INDICATOR" , length = 1)
    private Date fileGeneratorIndicator;

    @Transient
    @FixedWidth(value = 62, alignment = FieldAlignment.LEFT, padding = ' ')
    @Parsed(index = 19)
    private String filler;

    public String getRecordType() {
        return "01";
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getOrigSysId() {
        return "IRCP";
    }

    public void setOrigSysId(String origSysId) {
        this.origSysId = origSysId;
    }

    public String getOrigSysKey() {
        return origSysKey;
    }

    public void setOrigSysKey(String origSysKey) {
        this.origSysKey = origSysKey;
    }

    public String getTarSysId() {
        return tarSysId;
    }

    public void setTarSysId(String tarSysId) {
        this.tarSysId = tarSysId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(String crDrInd) {
        this.crDrInd = crDrInd;
    }

    public double getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(double transAmt) {
        this.transAmt = transAmt;
    }

    public int getBot() {
        return bot;
    }

    public void setBot(int bot) {
        this.bot = bot;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getBrandInd() {
        return brandInd;
    }

    public void setBrandInd(String brandInd) {
        this.brandInd = brandInd;
    }

    public String getInsuffInd() {
        return insuffInd;
    }

    public void setInsuffInd(String insuffInd) {
        this.insuffInd = insuffInd;
    }

    public Date getCaValDate() {
        return caValDate;
    }

    public void setCaValDate(Date caValDate) {
        this.caValDate = caValDate;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public String getRef3() {
        return ref3;
    }

    public void setRef3(String ref3) {
        this.ref3 = ref3;
    }

    public String getHoldInd() {
        return holdInd;
    }

    public void setHoldInd(String holdInd) {
        this.holdInd = holdInd;
    }

    public String getNoSuspenseInd() {
        return noSuspenseInd;
    }

    public void setNoSuspenseInd(String noSuspenseInd) {
        this.noSuspenseInd = noSuspenseInd;
    }

    public String getAccntNoInd() {
        return accntNoInd;
    }

    public void setAccntNoInd(String accntNoInd) {
        this.accntNoInd = accntNoInd;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public Date getFileGeneratorIndicator() {
        return fileGeneratorIndicator;
    }

    public void setFileGeneratorIndicator(Date fileGeneratorIndicator) {
        this.fileGeneratorIndicator = fileGeneratorIndicator;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }
}
