<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" type="text/css" href="/resources/css/styles.css">
   <script src="https://cdn.tailwindcss.com" type="text/javascript"></script>
   <title><tiles:insertAttribute name = "title"/></title>
  </head>
  <body>
    <div id="container">
      <div id="header">
        <tiles:insertAttribute name="header" />
      </div>
      <div id="content">
        <tiles:insertAttribute name="body" />
      </div>
      <div id="footer">
        <tiles:insertAttribute name="footer" />
      </div>
    </div>
  </body>
</html>
