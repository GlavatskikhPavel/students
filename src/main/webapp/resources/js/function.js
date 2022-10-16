function deleteStudents() {

    var checkedCheckboxes = document.querySelectorAll('input[name=idStudent]:checked');

    if (checkedCheckboxes.length == 0) {
        alert("Пожалуйста выберете хотя бы одного студента!")
        return;
    }

    var ids = "";

    // "1 2 5 "
    for (var i = 0; i < checkedCheckboxes.length; i++) {
        ids = ids + checkedCheckboxes[i].value + " ";
    }
    // указываем id="deleteHidden"
    document.getElementById("deleteHidden").value = ids;
    // запускаем форму чтобы данные улетели на контроллер (обращаемся по id="deleteForm")
    document.getElementById("deleteForm").submit();
}

function modifyStudent() {

    var checkedCheckboxes = document.querySelectorAll('input[name=idStudent]:checked');

    if (checkedCheckboxes.length == 0) {
        alert("Пожалуйста выберете одного студента!")
        return;
    }

    if (checkedCheckboxes.length > 1){
        alert("Пожалуйста выберете только одного студента!")
        return;
    }

    var id = checkedCheckboxes[0].value

    // указываем id="modifyHidden"
    document.getElementById("modifyHidden").value = id;
    // запускаем форму чтобы данные улетели на контроллер (обращаемся по id="modifyForm")
    document.getElementById("modifyForm").submit();
}

function deleteDisciplines(){

    var checkedCheckboxes = document.querySelectorAll('input[name=idDiscipline]:checked');

    if (checkedCheckboxes.length == 0) {
        alert("Пожалуйста выберете хотя бы одну дисциплину!")
        return;
    }

    var ids = "";

    // "1 2 5 "
    for (var i = 0; i < checkedCheckboxes.length; i++) {
        ids = ids + checkedCheckboxes[i].value + " ";
    }
    // указываем id="deleteHidden"
    document.getElementById("deleteHidden").value = ids;
    // запускаем форму чтобы данные улетели на контроллер (обращаемся по id="deleteForm")
    document.getElementById("deleteForm").submit();
}

function modifyDisciplines(){

    var checkedCheckboxes = document.querySelectorAll('input[name=idDiscipline]:checked');

    if (checkedCheckboxes.length == 0) {
        alert("Пожалуйста выберете одну дисциплину!")
        return;
    }

    if (checkedCheckboxes.length > 1){
        alert("Пожалуйста выберете только одну дисциплину!")
        return;
    }

    var id = checkedCheckboxes[0].value

    // указываем id="modifyHidden"
    document.getElementById("modifyHidden").value = id;
    // запускаем форму чтобы данные улетели на контроллер (обращаемся по id="modifyForm")
    document.getElementById("modifyForm").submit();
}
