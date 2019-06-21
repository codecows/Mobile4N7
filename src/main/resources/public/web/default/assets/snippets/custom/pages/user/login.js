//== Class Definition
var SnippetLogin = function () {

    var login = $('#m_login');

    var showErrorMsg = function (form, type, msg) {
        var alert = $('<div class="m-alert m-alert--outline alert alert-' + type + ' alert-dismissible" role="alert">\
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>\
			<span></span>\
		</div>');

        form.find('.alert').remove();
        alert.prependTo(form);
        //alert.animateClass('fadeIn animated');
        mUtil.animateClass(alert[0], 'fadeIn animated');
        alert.find('span').html(msg);
    }


    var handleSignInFormSubmit = function () {
        $('#m_login_signin_submit').click(function (e) {
            e.preventDefault();
            var btn = $(this);
            var form = $(this).closest('form');

            form.validate({
                rules: {
                    userId: {
                        required: true,
                        //email: true
                    },
                    password: {
                        required: true
                    }
                }
            });
            if (!form.valid()) {
                return;
            }
            //btn.addClass('m-loader m-loader--right m-loader--light').attr('disabled', true);
            //var userName = "snsoft";
            var loginRequest = {};
            loginRequest.userId = $("#userId").val();
            loginRequest.password = $("#password").val();
            RestUtils.ajax(Resource.user.login, Resource.user.loginMethod, loginRequest,
                function (result) {
                    //alert(JSON.stringify(result));
                    localStorage.setItem("visitor", result.user.userId);
                    localStorage.setItem("x-access-token", result.token);
                    window.location.href = "web/default/index.html";
                });

            //
            // form.ajaxSubmit({
            //     url: '',
            //     success: function (response, status, xhr, $form) {
            //         // similate 2s delay
            //         setTimeout(function () {
            //             btn.removeClass('m-loader m-loader--right m-loader--light').attr('disabled', false);
            //             showErrorMsg(form, 'danger', 'Incorrect username or password. Please try again.');
            //         }, 2000);
            //     }
            // });
        });
    }

    var localize = function () {
        $.extend($.validator.messages, {
            required: "必选字段",
            remote: "请修正该字段",
            email: "请输入正确格式的电子邮件",
            url: "请输入合法的网址",
            date: "请输入合法的日期",
            dateISO: "请输入合法的日期 (ISO).",
            number: "请输入合法的数字",
            digits: "只能输入整数",
            creditcard: "请输入合法的信用卡号",
            equalTo: "请再次输入相同的值",
            accept: "请输入拥有合法后缀名的字符串",
            maxlength: $.validator.format("请输入一个长度最多是 {0} 的字符串"),
            minlength: $.validator.format("请输入一个长度最少是 {0} 的字符串"),
            rangelength: $.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
            range: $.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
            max: $.validator.format("请输入一个最大为 {0} 的值"),
            min: $.validator.format("请输入一个最小为 {0} 的值")
        });
    };

    //== Public Functions
    return {
        // public functions
        init: function () {
            localize();
            handleSignInFormSubmit();
        }
    };
}();

//== Class Initialization
jQuery(document).ready(function () {
    SnippetLogin.init();
});