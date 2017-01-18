@echo off
echo Building javadoc...
title Building javadoc...
javadoc -locale zh_CN -charset utf-8 -encoding utf-8 -docencoding utf-8 -sourcepath "BukkitApi;javadoc" -d target -stylesheetfile javadoc/stylesheet.css -overview javadoc/overview.html -docfilessubdirs -use -doctitle "Bukkit 1.11.2-R0.1-SNAPSHOT API 中文文档" -windowtitle "Bukkit 1.11.2-R0.1-SNAPSHOT API 中文文档" -subpackages org.bukkit
copy javadoc\script.js target\
title Build Completed
echo.
echo BUILD COMPLETED
echo.
pause
