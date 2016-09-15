#!/bin/sh
if [ -d "target" ]; then
	echo "Deleting old javadoc"
	rm -rf target
fi
echo "Building javadoc..."
javadoc -locale zh_CN -charset utf-8 -encoding utf-8 -docencoding utf-8 -sourcepath "BukkitApi:javadoc" -d target -stylesheetfile javadoc/stylesheet.css -overview javadoc/overview.html -docfilessubdirs -use -doctitle "Bukkit 1.10.2-R0.1-SNAPSHOT API 中文文档" -windowtitle "Bukkit 1.10.2-R0.1-SNAPSHOT API 中文文档" -subpackages org.bukkit
echo 
echo "BUILD COMPLETED"
echo 
