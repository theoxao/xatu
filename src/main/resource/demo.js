import appService from "com.theoxao.app.service.AppService";
function add() {
    console.log("thou art entering add method");
    return appService.list();
}

var result = add();
