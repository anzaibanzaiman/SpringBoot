'use strict';

let i = 1
function addForm() {
    if (i > 11){
        return true
    } else {
    const element = document.getElementById("addTask");
    const newElement = element.cloneNode(true);

    const newElement_summary = newElement.children[0];
    newElement_summary.name = 'summary'+i;

    const newElement_description = newElement.children[1];
    newElement_description.name = 'description'+i;

    const newElement_status = newElement.children[2];
    newElement_status.name = 'description'+i;

    const newElement_dayLimit = newElement.children[3];
    newElement_dayLimit.name = 'description'+i;

    const parentNode = document.getElementById("addTask");
    parentNode.appendChild(newElement);

    i++;
    }
}