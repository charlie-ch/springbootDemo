<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
        <title><tiles:getAsString name="title" /></title>
    </head>
    <body style="border: 1px solid black">
    basic.jsp
        <!-- Header -->
        <tiles:insertAttribute name="header" />
        <!-- Body -->
        <tiles:insertAttribute name="body" />
        <!-- Footer -->
        <tiles:insertAttribute name="footer" />
    </body>
</html>