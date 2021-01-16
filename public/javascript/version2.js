
const csrfToken = $("#csrfToken").val()
const loginRoute = $("#loginRoute").val()
const validateRoute = $("#validateRoute").val()

$("#contents").load(loginRoute)

function login() {
    const name = $("#loginName").val()
    const pass = $("#loginPass").val()
    $.post(validateRoute, {name, pass, csrfToken}, data => {
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