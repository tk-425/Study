<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Setting up a variable called 'theLocale' -->
<c:set 
	var="theLocale" 
	value="${not empty param.theLocale ? param.theLocale : pageContenxt.request.locale}" 
	scope="session"
/>

<!-- Set actual locale with the variable 'theLocale' -->
<fmt:setLocale value="${theLocale}" />

<!-- Set a reference to the bundles 
	(which bundle base name to use which is the package name where the default file is located) 
	JSP will append locale accordingly -->
<fmt:setBundle basename="com.n2_TagDemo.tag.i18n.resources.locale" />

<html>
<body>
	<h3>I18N Demo</h3>
	
	<!-- "jsp?theLocale" is the variable from above that we just set -->
	<a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a> | 
	<a href="i18n-messages-test.jsp?theLocale=es_ES">Spanish (ES)</a> | 
	<a href="i18n-messages-test.jsp?theLocale=de_DE">German (DE)</a>
	
	<hr />
			
	<fmt:message key="label.greeting" />
	
	<br /><br />
	
	<fmt:message key="label.firstName" />: <i>John</i>
	
	<br />
	
	<fmt:message key="label.lastName" />: <i>Doe</i>
	
	<br /><br />	
	
	<fmt:message key="label.welcome"></fmt:message>
	
	<hr />
	
	Selected locale: ${theLocale}
</body>
</html>