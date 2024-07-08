
function addTask() {
    var template = document.getElementById('template');
    var index = template.children.length;

    var div = document.createElement('div');
    div.classList.add('task');

    var divSummary = document.createElement('div');
    divSummary.className = 'form-group mt-3';

    var summaryLabel = document.createElement('label');
    summaryLabel.textContent = '概要';
    summaryLabel.setAttribute('for', 'summaryInput')
    summaryLabel.className = 'form-label';

    var summaryInput = document.createElement('input');
    summaryInput.type = 'text';
    summaryInput.setAttribute('id', 'summaryInput');
    summaryInput.setAttribute('th:field', '*taskList[' + index + '].summary');
    summaryInput.className = 'form-control';

    divSummary.appendChild(summaryLabel);
    divSummary.appendChild(summaryInput);

    var divDescription = document.createElement('div');
    divDescription.className = 'form-group mt-3';

    var descriptionLabel = document.createElement('label');
    descriptionLabel.textContent = '詳細';
    descriptionLabel.setAttribute('for', 'descriptionInput')
    descriptionLabel.className = 'form-label';

    var descriptionTextarea = document.createElement('textarea');
    descriptionTextarea.setAttribute('id', 'descriptionInput');
    descriptionTextarea.setAttribute('th:field', '*taskList[' + index + '].description');
    descriptionTextarea.setAttribute('rows', '10');
    descriptionTextarea.className = 'form-control';

    divDescription.appendChild(descriptionLabel);
    divDescription.appendChild(descriptionTextarea);

    var divStatus = document.createElement('div');
    divStatus.className = 'form-group mt-3';


    var statusLabel = document.createElement('label');
    statusLabel.textContent = 'ステータス';
    statusLabel.setAttribute('for', 'statusInput')
    statusLabel.className = 'form-label';

    var statusSelect = document.createElement('select');
    statusSelect.setAttribute('id', 'statusInput');
    statusSelect.setAttribute('th:field', '*taskList[' + index + '].status');
    statusSelect.className = 'form-control';

    var option1 = document.createElement('option');
    option1.textContent = 'TODO';
    option1.value =  'TODO';

    var option2 = document.createElement('option');
    option2.textContent = 'DOING';
    option2.value =  'DOING';

    var option3 = document.createElement('option');
    option3.textContent = 'DONE';
    option3.value =  'DONE';

    statusSelect.appendChild(option1);
    statusSelect.appendChild(option2);
    statusSelect.appendChild(option3);

    divStatus.appendChild(statusLabel);
    divStatus.appendChild(statusSelect);

    var divDayLimit = document.createElement('div');
    divDayLimit.className = 'form-group mt-3';


    var dayLimitLabel = document.createElement('label');
    dayLimitLabel.textContent = '期限';
    dayLimitLabel.setAttribute('for', 'dayLimitInput')
    dayLimitLabel.className = 'form-label';

    var summaryInput = document.createElement('input');
    dayLimitInput.type = 'text';
    dayLimitInput.setAttribute('id', 'dayLimitInput');
    dayLimitInput.setAttribute('th:field', '*taskList[' + index + '].dayLimit');
    dayLimitInput.className = 'form-control';

    divDayLimit.appendChild(dayLimitLabel);
    divDayLimit.appendChild(summaryInput);

    div.appendChild(divSummary);
    div.appendChild(divDescription);
    div.appendChild(divStatus);
    div.appendChild(divDayLimit);

    template.appendChild(div);

}