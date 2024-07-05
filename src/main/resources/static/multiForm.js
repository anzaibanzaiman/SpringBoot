

let i = 0;
function addForm() {
    if (i > 3){
        return;
    } else{
        const template = document.getElementById("template");
        const newForm = template.content.cloneNode(true);

        const newForm_summary = newForm.children[0].children[1];
        newForm_summary.name = 'summary'+i;

        const newForm_description = newForm.children[1].children[1];
        newForm_description.name = 'description'+i;

        const newForm_status = newForm.children[2].children[1];
        newForm_status.name = 'status'+i;

        const newForm_dayLimit = newForm.children[3].children[1];
        newForm_dayLimit.name = 'dayLimit'+i;

        const parent = document.getElementById("container");
        parent.appendChild(newForm);

        i++;
    }
}

window.addEventListener('DOMContentLoaded', addForm);

/*
function submitForm() {
    var formData = {};

    for(let s=0; s=<i; s++){
        formData["summary"+s] = document.getElementById("summary"+s).value
        formData["description"+s] = document.getElementById("description"+s).value
        formData["status"+s] = document.getElementById("status"+s).value
        formData["dayLimit"+s] = document.getElementById("dayLimit"+s).value
    }

    var dataList = [];
    dataList.push(formData);

    $.ajax({
            type: "POST",
            url: "http://localhost:8080/tasks/multiCreationForm",
            contentType: "application/json",
            data: JSON.stringify(dataList),
            success: function(response) {
                // 成功時の処理
                console.log("データが送信されました。");
            },
            error: function() {
                // エラー時の処理
                console.error("データの送信中にエラーが発生しました。");
            }
    });
}
*/