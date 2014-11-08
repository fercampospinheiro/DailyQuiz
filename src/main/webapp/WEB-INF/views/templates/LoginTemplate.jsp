<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">

    <title><decorator:title/></title>

    <link rel="stylesheet" href="<c:url value="/resources/libs/bootstrap/3_3/css/bootstrap.min.css"/>">

    <script src="<c:url value="/resources/libs/jquery/2_1_1/jquery-2.1.1.min.js" />"></script>
    <script src="<c:url value="/resources/libs/bootstrap/3_3/js/bootstrap.min.js" />"></script>

    <decorator:head/>
</head>

<body>

<decorator:body/>

</body>
</html>