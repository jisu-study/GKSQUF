var main = {

    init: function (){
        var _this = this;

        $(document).ready(function (){
            _this.loadTable();
        });

        $("#btn-create").click(function (){
            _this.save();
        });

        $("#btn-update").click(function (){
            _this.update();
        })

        $("#btn-delete").click(function (){
            _this.delete();
        });
    },

    loadTable: function (){

        //tbody 객체 불러오기
        var tableBody = document.getElementById('table-body');

        //recordId 추출
        var urlParams = new URLSearchParams(window.location.search);
        var recordId = urlParams.get('recordId');

        recordId = 71;          //test용...


        /*
           서버에서 데이터 불러오기
         */

        //GET '/records/{recordId}/recordCosts' 요청
        $.get("/records/recordCosts", {recordId : recordId}, function (response){

            //json문자열 -> javascript 객체
            var obj = JSON.parse(response);
            console.log(obj);

            //table에 표시
            obj.forEach(function (item) {
                var row = document.createElement("tr");
                row.innerHTML = "<td>" + item.costId + "</td>"
                            + "<td>" + item.costCategory + "</td>"
                            + "<td><input type='text' id='details' value=" + item.costDetails + "></td>"
                            + "<td><input type='number' id='amount' value=" + item.costAmount + "></td>"
                            + "<td><button id=\"btn-update\">+</button><button id=\"btn-delete\">-</button></td>";

                tableBody.append(row);
            })
        });

    },

    save: function (){
        var data = {
            recordId: 71,
            costCategory: $("#category").val(),
            costDetails: $("#details").val(),
            costAmount: $("#amount").val()
        };

        $.ajax({
            type: "POST",
            url: '/recordCosts',
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            success: function (response){
                alert('OK');
            },
            error: function (xhr, status, error){
                console.log(xhr);
                alert('fail');
            }
        });

//        var total = $("#total").val();
        //update total
//        total.text(total + data.amount);
    },

    update: function (){
        var data = {
            recordId: 71,
            details: $("#details").val(),
            amount: $("#amount").val()
        };

        var costId = $('#cost-id').val();

        $.ajax({
            type: "PUT",
            url: '/recordCosts/'+costId,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            success: function (response){
                alert('OK');
            },
            error: function (xhr, status, error){
                alert('fail');
            }
        });

        //var total = $("#total").val();
        //update total
        //total.text(total - 0 + data.amount);
    },

    delete: function (){
        var costId = $('#cost-id').val();
        var amount = $('#amount').val();

        $.ajax({
            type: 'DELETE',
            url: '/recordCosts/'+costId,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: function (response){
                alert('OK');
            },
            error: function (xhr, status, error){
                alert('fail');
            }
        })

        // var total = $("#total").val();
        // //update total
        // total.text(total - amount);
    }
};

main.init();