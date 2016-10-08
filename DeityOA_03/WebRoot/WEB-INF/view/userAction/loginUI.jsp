<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Deity OA</title>
    <%@ include file="/WEB-INF/view/public/common.jspf" %>
    <LINK HREF="style/blue/login.css" type=text/css rel=stylesheet />
    <script type="text/javascript">
    	$(function(){
    		document.forms[0].loginName.focus();
    	});
    	if(window.parent != window){
    		window.parent.location.reload(true);
    	}
    </script>
</head>
<body>
  
<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<s:form action="userAction_login" namespace="/sys">
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
            <DIV ID="LogoImg"><IMG BORDER="0" SRC="style/blue/images/logo.png" /></DIV>
            <DIV ID="LoginInfo">
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <TR>
                        <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="style/blue/images/login/userId.gif" /></TD>
                        <TD><s:textfield name="loginName" size="20" cssClass="TextField"/></TD>
                        <TD ROWSPAN="2" STYLE="padding-left:10px;">
                        <INPUT TYPE="image" SRC="style/blue/images/login/userLogin_button.gif"/></TD>
                    </TR>
                    <TR>
                        <TD CLASS="Subject"><IMG BORDER="0" SRC="style/blue/images/login/password.gif" /></TD>
                        <TD><s:password name="password" size="20" cssClass="TextField" showPassword="false"/></TD>
                    </TR>
                </TABLE>
            </DIV>
            <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2015 版权所有 Deity</A></DIV>
        </DIV>
    </DIV>
</s:form>
</BODY>

</html>
