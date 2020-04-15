set _test=%~dp0
SET projectLocation=%_test:\batFiles\=%
cd %projectLocation%
mvn clean test -DsuiteXmlFile=%projectLocation%\testng.xml
pause