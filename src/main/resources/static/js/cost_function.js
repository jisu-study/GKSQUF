function loadTable(){

    //tbody 객체 불러오기
    var tableBody = document.getElementById('table-body');

    //서버에 GET '/records/{recordId}/recordCosts' 요청
    $.get("/records/recordCosts", {recordId : recordId}, function (response){

        //json문자열(response) -> javascript 객체(obj)
        var obj = JSON.parse(response);

        //table에 배치
        obj.forEach(function (item) {

            //row<tr> & cell<td> 생성
            var newRow = tableBody.insertRow();
            var newCostId = newRow.insertCell();
            var newCostCategory = newRow.insertCell();
            var newCostDetails = newRow.insertCell();
            var newCostAmount = newRow.insertCell();
            var newActions = newRow.insertCell();

            //contenteditable로 속성 변경
            newRow.setAttribute('contenteditable', 'true');

            //class 속성 부여
            newCostId.setAttribute('class', 'cost-id');
            newCostCategory.setAttribute('class', 'category');
            newCostDetails.setAttribute('class', 'details');
            newCostAmount.setAttribute('class', 'amount');

            //데이터 집어넣기
            newCostId.innerHTML = item.costId;
            newCostCategory.innerHTML = item.costCategory;
            newCostDetails.innerHTML = item.costDetails;
            newCostAmount.innerHTML = item.costAmount;
            newActions.innerHTML = "<button class='btn-delete'>-</button>"
        })
    });

}


function update(){

}
