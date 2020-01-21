<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <h1 style="color:green;text-align: center">Get Trending Job On ${sysdate}</h1>
     <c:choose>
       <c:when test="${!empty listdto}">
       <table border="1" bgcolor="cyan">
       <tr style="color:red"><th>srno</th><th>id</th><th>company</th><th>domain</th><th>desg</th><th>salrange</th><th>nojo</th><th>exprange</th><th>location</th>
          </tr>
          <c:forEach var="job" items="${listdto}">
          <tr>
          <td>${job.srno}</td>
          <td>${job.id}</td>
          <td>${job.company}</td>
          <td>${job.domain}</td>
          <td>${job.desg}</td>
          <td>${job.salrange}</td>
          <td>${job.nojo}</td>
          <td>${job.exprange}</td>
          <td>${job.location}</td>
          </tr>
          </c:forEach> 
       </table>
       </c:when>
       <c:otherwise>
       <h1 style="color:red;text-align: center">Records Not found</h1>
       </c:otherwise>
     </c:choose>
     <br><br>
     <a href="welcome.htm">home</a>
     <br><br>
     <a href="javaScript:doPrint()">print</a>
     <script language="javaScript">
     function doPrint(){
     frames.focus();
     frames.print();
     }
     <br><br>
     </script>