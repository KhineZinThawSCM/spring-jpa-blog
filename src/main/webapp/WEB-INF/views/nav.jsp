<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Blog</a>
    <button class="navbar-toggler" type="button"
      data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false"
      aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active"
          aria-current="page" href="<c:url value="/posts" />">Home</a></li>
        <li class="nav-item"><a class="nav-link"
          aria-current="page" href="<c:url value="/users" />">Users</a></li>
      </ul>
      <div class="btn-group">
        <button type="button" class="btn btn-secondary dropdown-toggle"
          data-bs-toggle="dropdown" data-bs-display="static"
          aria-expanded="false">${pageContext.request.userPrincipal.name}</button>
        <ul class="dropdown-menu dropdown-menu-start">
          <c:url var="logoutAction" value="/logout" />
          <li><a href="${logoutAction}" class="dropdown-item">Logout</a></li>
        </ul>
      </div>
    </div>
  </div>
</nav>