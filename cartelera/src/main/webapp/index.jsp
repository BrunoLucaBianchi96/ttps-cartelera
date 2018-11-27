<jsp:include page="layout.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h5 class="card-title text-center">Iniciar Sesión</h5>
                        <form class="form-signin">
                            <div class="form-label-group mb-3">
                                <label for="inputEmail">Email</label>
                                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                            </div>
                            <div class="form-label-group mb-3">
                                <label for="inputPassword">Contraseña</label>
                                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                            </div>
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Entrar</button>
                            <hr class="my-4">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>