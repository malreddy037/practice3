#! /bin/bash 
echo enter your file name :
read file_name
if [-f $file_name ]
then 
	if [ -w $file_name ]
	then
		echo write somedata 
		cat > $file_name
	else
		echo this file desnot have permission
	fi

else
echo this file is not available
fi

