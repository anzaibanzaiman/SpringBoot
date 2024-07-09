
window.addEventListener('DOMContentLoaded', addForm);

let i = 0;
function addForm() {

    if (i > 10){
        return;
    } else{
        const template = document.getElementById("template");
        const newForm = template.content.cloneNode(true);
        const parent = document.getElementById("container");
        parent.appendChild(newForm);

        i++;
    }
}