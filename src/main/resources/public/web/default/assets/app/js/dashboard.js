var Application = function () {
    var initMenu = function () {

        $("#m_ver_menu").find(".m-menu__subnav li a").click(function () {
            $("#content").load($(this).attr("url"));
        });
        $("#content").load("../pages/welcome.html");
    }
    return {
        init: function () {
            initMenu();
        }
    };
}();

//== Class initialization on page load
jQuery(document).ready(function () {
    Application.init();
});