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
        var data = {};
        data["login"] = $("#login").val();
        data["firstname"] = $("#firstname").val();
        data["lastname"] = $("#lastName").val();
        data["password"] = $("#password").val();
        data["matchingPassword"] = $("#matchingPassword").val();
        data["email"] = $("#email").val();
        $(document).ready(function () {
            $.ajax({
                method: "POST",
                contentType: "application/json",
                url: "/api/users/registration",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (data) {
                    display(data);
                },
                error: function (e) {
                    console.log("FAIL", e);
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




