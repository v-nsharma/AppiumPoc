package com.teknikos.WestgateMobileApp.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportBackupUtil {

    public static void backupOldReport() {

        File report = new File("reports/ExtentReport.html");

        if (report.exists()) {

            String timeStamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            File backup = new File(
                    "reports/ExtentReport_" + timeStamp + ".html"
            );

            report.renameTo(backup);
        }
    }
}

