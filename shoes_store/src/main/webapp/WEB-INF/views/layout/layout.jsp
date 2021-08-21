<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<body>
  <tiles:insertAttribute name="header" />
  <br/>
  <div style="display:inline">
    <tiles:insertAttribute name="menu" />
    <tiles:insertAttribute name="body" />
  </div>
  <br/>
  <br/>
  <tiles:insertAttribute name="footer" />
</body>
</html>