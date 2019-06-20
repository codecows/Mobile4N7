var Application = function () {
    var initMenu = function () {

        $("#m_ver_menu").find(".m-menu__subnav li a").click(function () {
            $("#content").load($(this).attr("url"));
            $("#m_aside_left_close_btn").click();

        });
        //TODO 加载欢迎页
        $("#content").load("../pages/welcome.html");
    };
    //TODO 有登录此处不需要
    // var userName = "snsoft";
    // var saveToken = function () {
    //     RestUtils.ajax(Resource.auth.getToken + userName, Resource.auth.getTokenMethod, "",
    //         function (result) {
    //             localStorage.setItem("visitor", userName);
    //             localStorage.setItem("x-access-token", result);
    //         });
    // };
    return {
        init: function () {
            //saveToken();
            initMenu();
        }
    };
}();

//== Class initialization on page load
jQuery(document).ready(function () {
    Application.init();
});