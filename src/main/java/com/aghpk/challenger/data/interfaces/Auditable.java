package com.aghpk.challenger.data.interfaces;

import java.util.Date;

public interface Auditable {

    Date getAuditCD();

    void setAuditCD(Date auditCD);

    Date getAuditMD();

    void setAuditMD(Date auditMD);

    Date getAuditRD();

    void setAuditRD(Date auditRD);
}
