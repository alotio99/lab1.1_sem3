@echo off
setlocal

set SRC_DIR=src
set OUT_DIR=out\production
set JAR_NAME=lab1.jar
set MANIFEST=manifest.mf

echo ==^> 1. Очистка
if exist %OUT_DIR% rmdir /s /q %OUT_DIR%
if exist %JAR_NAME% del %JAR_NAME%
mkdir %OUT_DIR%

echo ==^> 2. Компиляция
dir /s /b %SRC_DIR%\*.java > sources.txt
javac -encoding UTF-8 -d %OUT_DIR% @sources.txt
del sources.txt

echo ==^> 3. Упаковка JAR
jar cfm %JAR_NAME% %MANIFEST% -C %OUT_DIR% .

echo ==^> 4. Собрано. Запуск:
echo     java -jar %JAR_NAME%

endlocal