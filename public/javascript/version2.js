
$("#contents").load("/login2")

function login() {
    const name = $("#loginName").val()
    const pass = $("#loginPass").val()
    $("#contents").load("/validate2?username=" + name + "&password=" + pass)
}

function createUser() {
    const name = $("#createName").val()
    const pass = $("#createPass").val()
    $("#contents").load("/create2?username=" + name + "&password=" + pass)
}

function deleteTask(index) {
    $("#contents").load("/delete2?index=" + index)
}