@echo off
rem 执行安装程序
set classpath .;WebRoot/WEB-INF/bin/spring-context-4.1.6.RELEASE.jar;
java WebRoot/WEB-INF/classes com.deity.oa.install.Installer
rem
pause