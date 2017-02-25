import {Component} from "@angular/core";

@Component({
    moduleId: module.id,
    selector: 'registration-panel',
    templateUrl: './registration-panel.component.html',
    styleUrls: ['registration-panel.component.css']
})
export class RegistrationPanelComponent {
    private isAuthenticated:boolean=false;
    constructor() {

    }

    submitForm() {
        var data = {}
        data["login"] = $("#login").val();
        data["firstname"] = $("#firstname").val();
        data["lastname"] = $("#lastname").val();
        data["password"] = $("#password").val();
        data["matchingPassword"] = $("#matchingPassword").val();
        data["email"] = $("#email").val();
        $(document).ready(function () {
            $.ajax({
                method: "POST",
                contentType: "application/json",
                url: "/registration",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (data) {
                    console.log("SUCCESS");
                    display(data);
                },
                error: function (e) {
                    console.log("FAIL");
                    console.log(e);
                }
            })

        });
    }

}
function display(data) {
    //TODO change component and show data user and info about email confirmation

    var json = "<h4>Ajax Response</h4><pre>"
        + JSON.stringify(data, null, 4) + "</pre>";
    $('#feedback').html(json);
}



