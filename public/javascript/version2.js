
$("#contents").load("/login2")

function login() {
    const name = $("#loginName").val()
    const pass = $("#loginPass").val()
    $("#contents").load("/validate2?username=" + name + "&password=" + pass)
}

function createUser() {
    console.log("try to create user")
}