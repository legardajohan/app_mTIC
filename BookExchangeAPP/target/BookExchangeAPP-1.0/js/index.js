$(document).ready(function() {
    $("#form-login").submit(function(event) {
        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function(event) {
        event.preventDefault();
        registrarUsuario();
    });
});

function autenticarUsuario() {
    let username = $("#UserName").val();
    let contrasena = $("#Contrasena").val(); 

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUserLogin",
        data: $.param({
            username: username,
            contrasena: contrasena
        }),
        success: function(result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}

function registrarUsuario() {
    let username = $("#InputUserName").val();
    let contrasena = $("#InputContrasena").val();
    let contrasenaRepeat = $("#InputContrasenaRepeat").val();
    let nombre = $("#InputName").val();
    let apellidos = $("#InputLastNames").val();
    let email = $("#InputEmail").val(); 
    let saldo = $("#InputSaldo").val();
    let premium = $("#InputPremium").prop("checked");

    if (contrasena == contrasenaRepeat) {
        console.log('Entre a contraseñas iguales');
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUserRegister",
            data: $.param({
                username: username,
                contrasena: contrasena,
                nombre: nombre,
                apellidos: apellidos,
                email: email,
                saldo: saldo,
                premium: premium
            }),
            success: function(result) {
                let parsedResult = JSON.parse(result);
                console.log(parsedResult);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las constraseñas no coinciden");
    }

}