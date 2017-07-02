$(function () {
    $.ajax({
        type: 'POST',
        url: "/user/getUserInfo",
        dataType: "json",
        contentType:"application/json",
        data:{},
        success: function (data) {
            $("#user_head_img").attr("src", "/static/dist/img/" + data.headImage);
            $("#user_head_img_min").attr("src", "/static/dist/img/" + data.headImage);
            $("#user_head_img_max").attr("src", "/static/dist/img/" + data.headImage);
            $("#user_realname").html(data.realName);
            $("#user_name").html(data.username);
            $("#job").html(data.realName);
            $("#mobile").html(data.mobile);
         }
        });
});



