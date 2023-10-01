var main = {

    init: function (){
        var _this = this;

        $("#btn-upload").click(function (){
            _this.save();
        });

        $("#btn-delete").click(function (){
            _this.delete();
        });
    },

    loadTable: function (){
        const displayList = document.getElementById('display-list');
        const totalElement = document.getElementById('total');
        let total = 0;

        displayList.innerHTML = '';
    },

    save: function (){
        var data = {
            costCategory: $("#category").val(),
            costDetails: $("#details").val(),
            costAmount: $("#amount").val()
        };

        $.ajax({
            type: "POST",
            url: '/recordCosts',
            dataType: 'json',
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

        var total = $("#total").val();
        //update total
        total.text(total - 0 + data.amount);
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

        var total = $("#total").val();
        //update total
        total.text(total - amount);
    }
};

main.init();