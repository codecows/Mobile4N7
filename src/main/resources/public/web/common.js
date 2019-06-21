var RestUtils = function () {
    var headers = {
        "x-access-token": localStorage.getItem("x-access-token"),
        "visitor": localStorage.getItem("visitor")
    };
    return {
        ajax: function (url, type, pars, func) {
            headers.visitor = localStorage.getItem("visitor");
            headers["x-access-token"] = localStorage.getItem("x-access-token");
            console.info("接口:" + url);
            console.info("header:" + JSON.stringify(headers));
            console.info("参数:" + JSON.stringify(pars));
            $.ajax({
                url: url,
                type: type,
                data: JSON.stringify(pars),
                timeout: 15000,
                dataType: 'json',
                headers: headers,
                contentType: 'application/json; charset=UTF-8',
                success: function (result) {
                    console.info("返回:" + JSON.stringify(result));
                    if (result.code == 200) {
                        func(result.data);
                    } else {
                        swal("提示!", result.message, "error");
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log("出错");
                    // 状态码
                    console.log("状态码:" + XMLHttpRequest.status);
                    // 状态
                    console.log("状态:" + XMLHttpRequest.readyState);
                    // 错误信息
                    console.log("错误信息:" + textStatus);
                }
            });
        }
    };
}();

// TODO  URL
 var baseUrl = "http://127.0.0.1:8080/";
//var baseUrl = "http://192.168.5.103:8080/";
var Resource = {
    user: {
        login: baseUrl + "users/login",
        loginMethod: "POST"
    },
    auth: {
        getToken: baseUrl + "auth/getToken/",
        getTokenMethod: "GET"
    },
    approve: {
        getApprovalPending: baseUrl + "approve/getApprovalPending/",
        getApprovalPendingMethod: "GET",
        getApprovalPendingItems: baseUrl + "approve/getApprovalPendingItems/",
        getApprovalPendingItemsMethod: "GET",
        approve: baseUrl + "approve/approve/",
        approveMethod: "GET",
    },
    customer: {
        getCustomer: baseUrl + "ccode/getCustomers",
        getCustomerMethod: "GET",
        deleteCustomer: baseUrl + "ccode/deleteCustomerByCode",
        deleteCustomerMethod: "POST"
    },
    voucher: {
        getVoucher: baseUrl + "voucher/getVouchers/",
        getVoucherMethod: "GET",
        approveVoucher: baseUrl + "voucher/approveVoucher/",
        approveVoucherMethod: "GET",
    }

};
var DataTablesSettings = function () {
    return {
        init: function () {
            return {
                "language": {
                    "decimal": ".",
                    "thousands": ",",
                    "emptyTable": "表格为空",
                    "info": "显示_START_~_END_行/共_TOTAL_行",
                    "infoEmpty": "未找到数据",
                    "infoFiltered": "(filtered from _MAX_ total entries)",
                    "infoPostFix": "",
                    "lengthMenu": "_MENU_行/页",
                    "loadingRecords": "数据载入中...",
                    "processing": "加载中...",
                    "search": "查找:",
                    "zeroRecords": "共找到 0 条数据",
                    "paginate": {
                        "first": "首页",
                        "last": "尾页",
                        "next": "下一页",
                        "previous": "上一页"
                    }
                },
                "pagingType": "full_numbers",
                "processing": true,
                "serverSide": true,
                "pageLength": 10,
                "dom": "" +
                    "<'row'<'col-md-12'tr>>" +
                    "<'row'<'col-md-3'l><'col-md-2'i><'col-md-7'p>>",
                "aria": {
                    "sortAscending": ": 升序",
                    "sortDescending": ": 降序"
                }
            };
        }
    }
}();