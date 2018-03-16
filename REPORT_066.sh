#!/bin/sh

#############################################################################################################################################################################
#   Global Name:        REPORT_066.sh
#   Job Description:    Script to check for the Report066 file, and send an alert mail if unavailable, if file is available rename the file and move to /ssiput/cur folder #
#   SCRIPT LOCATION:    /u01/apps/RunWorkflow/bin                                           
#   Language: 	   sh        
#   Author:            XYZ
#   Date Created:       Mar 02, 2017
#############################################################################################################################################################################

DESTFILE="/ssinput/cur/Report066.csv" 
EmailSubject="PLAN 00 Report066 file unavailable"
EmailTo="xyz@xyz.com

#Chekcing last seven days folder
for number in {1..7}
do
	current_date=$(date +%Y%m%d)
	PASTDATEFOLDER=$(date -d "$current_date - $number days" +%Y%m%d)
	echo "$PASTDATEFOLDER"
	SOURCEFILE="/winf_shared/IFRS9/BBVA_Conf/0.External files/"$PASTDATEFOLDER"/Report066_*.csv"
	EmailBody="Report066 file not found in "$SOURCEFILE
	echo "$SOURCEFILE"

	if [ -f "$SOURCEFILE" ];
	then 
		mv $SOURCEFILE $DESTFILE
	else
		echo ${EmailBody} | mailx -s "${EmailSubject}" ${EmailTo}
	fi
done