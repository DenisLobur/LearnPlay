
const csrfToken = $("#csrfToken").val()
const loginRoute = $("#loginRoute").val()
const validateRoute = $("#validateRoute").val()

$("#contents").load(loginRoute)

function login() {
    const username = $("#loginName").val()
    const password = $("#loginPass").val()
    $.post(validateRoute, {username, password, csrfToken}, data => {
        $("#contents").html(data)
    })
}

function createUser() {
    const name = $("#createName").val()
    const pass = $("#createPass").val()
    $("#contents").load("/create2?username=" + name + "&password=" + pass)
}

function deleteTask(index) {
    $("#contents").load("/delete2?index=" + index)
}

function addTask() {
    const task = $("#newTask").val()
    $("#contents").load("/addTask2?task=" + encodeURIComponent(task))
}