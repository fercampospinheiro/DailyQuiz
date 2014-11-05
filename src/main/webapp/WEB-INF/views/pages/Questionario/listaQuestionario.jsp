<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:forEach items="questionarios" var = "questionario">

  <tr>Questionários disponiveis</tr>
  <tr>
    <td> Nome do Questionario : ${questionario.descricao}</td>
  </tr>

</c:forEach>:
