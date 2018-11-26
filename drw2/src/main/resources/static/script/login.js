(function($, undefined) {
    $(document).ready(function() {
        var flag4 = 1;
        var _t = 60; // 倒计时时间
        var subFlag = "1";
        var flag = 0;
        var wait = 300;
        var verify1 = "";
        var verify2 = "";
        var flag1 = false;
        var flaghave = 0;
        var flag3 = 1;
        var $invist = $("._invist");
        var $invist_msg = $("._invist_msg");
        var $getKey = $("._getkey");
        var $phoneyanzhengma = $("._yanzhengma");
        var $yanzhengma = $("#jpgVerify");
        var $yanzhengmatishi = $('#jpgVerifys');
        var invist_flag = true;
        var $changeCapcherButton = $("._changeCapcherButton");
        var $phoneMsg = $('#phoneJy');
        var login = {
            init: function() {
                login._bind();
            },
            _bind: function() {
                $invist.on('blur', function(event) {
                    event.preventDefault();
                    login.validateInvist();
                    return false;
                });
                $getKey.on('click', function(event) {
                    event.preventDefault();
                    if (flag3 != 0) {
                        $("#phoneJy").text("");
                        $("#phoneJy").append("<span style=color:#ff7800>请先输入正确的验证码</span>");
                        return false;
                    }
                    if (flag4 == 1) {
                        flag4 = 0;
                        login._ya($(this));
                    }
                    return false;
                });
                $("._phoneNum").on('blur keyup', function(event) {
                    event.preventDefault();
                    login.phoneYz();
                    return false;
                });
                $("._phonVerify").on('blur', function(event) {
                    event.preventDefault();
                    login.checkSecurity($(this));
                    return false;
                });
                $("._userName").on('blur', function(event) {


                    event.preventDefault();
                    login.strVerify($(this));
                    return false;
                });
                $("._password").on('blur', function(event) {
                    event.preventDefault();
                    login.strVerify($(this));
                    return false;
                });
                $("._repeatPassword").on('blur', function(event) {
                    event.preventDefault();
                    login.strVerify($(this));
                    return false;
                });
                $("#jpgVerify").on('blur', function(event) {
                    event.preventDefault();
                    login.verify($(this));
                    return false;
                });
                $("._ajaxSubmit").on('click', function(event) {
                    event.preventDefault();
                    login.ajaxSubmit();
                    return false;
                });
            },
            _ya: function(o) {
                if (login.phoneSend(o)) {
                    if (flaghave != "1") {
                        login._daojishi();
                    }
                } else {
                    flag4 = 1;
                }
            },
            phoneYz: function() { // 手机号验证
                var utel = $("#phone");
                var str = utel.val();
                var regPartton = /^1[3-9]\d{9}$/;
                if (str.length > 11) {
                    $("#phoneJy").text("");
                    $("#phoneJy").append("<span style=color:#ff7800>手机号格式不正确</span>");
                    flag = 1;
                    return false;
                }
                if (!str || str == null) {
                    $("#phoneJy").text("");
                    $("#phoneJy").append("<span style=color:#ff7800>手机号不可为空</span>");
                    flag = 1;
                    return false;
                } else if (!regPartton.test(str)) {
                    $("#phoneJy").text("");
                    $("#phoneJy").append("<span style=color:#ff7800>手机号格式不正确</span>");
                    flag = 1;
                    return false;
                } else {
                    $("#phoneJy").text("");
                    $("#phoneJy").append("<span style=color:green>手机号格式正确</span>");
                    flag = 0;
                    return true;
                }
            },
            phoneSend: function(o) {
                if (!login.phoneYz()) {
                    return false;
                }
                if (flag == "1") {
                    return false;
                }
                var isSuccess = false;
                $.ajax({
                    type: "post", //请求方式
                    dataType: "json",
                    url: path.base + "/user!phoneVerify.action", //发送请求地址
                    async: false,
                    data: { //发送给数据库的数据
                        phone: $("#phone").val(),
                        userName: $("#userName").val(),
                        ud: sendUD
                    },
                    //请求成功后的回调函数有两个参数
                    success: function(data) {
                        flag4 = 1;
                        if (data['msg'] == "1") { //新号码
                            wait = 300;
                            flaghave = 1;
                            $phoneMsg.text("");
                            $phoneMsg.html("<span style=color:#ff7800>该手机号码已经注册</span>");
                        } else if (data['msg'] == "3") {
                            wait = 300;
                            flaghave = 1;
                            $phoneMsg.text("");
                            $phoneMsg.html("<span style=color:#ff7800>发送手机号发生错误,请刷新重试</span>");
                        } else if (data['msg'] == "4") {
                            wait = 300;
                            flaghave = 1;
                            $phoneMsg.text("");
                            $phoneMsg.html("<span style=color:#ff7800>一分钟之内只能发送一次验证码</span>");
                        } else {
                            flag4 = 0;
                            isSuccess = true;
                        }
                    },
                    error: function(data, textStatus) {
                        flag4 = 1;
                    }
                });
                if (isSuccess) {
                    login._changetCapther();
                    o.val("重新发送(" + wait + ")");
                    wait--;
                    return true;
                } else {
                    return false;
                }
            },
            checkSecurity: function(vr) {
                var byName = vr.data('_id');
                var ids = '#' + byName;
                $.ajax({
                    type: "post", //请求方式
                    dataType: "json",
                    url: path.base + "/user!verify.action", //发送请求地址
                    data: { //发送给数据库的数据
                        verifyCode: vr.val(),
                        byName: byName
                    },
                    //请求成功后的回调函数有两个参数
                    success: function(data) {
                        $(ids + "s").text("");
                        if (data.msg == "1") {
                            $(ids + "s").html("<span style=color:green>验证成功</span>");
                            flag1 = true;
                            if (byName == "phonVerify") {
                                verify1 = "1";
                            } else {
                                verify2 = "1";
                            }
                        } else {
                            $(ids + "s").html("<span style=color:#ff7800>验证失败</span>");
                            flag1 = false;
                            if (byName == "phonVerify") {
                                verify1 = "2";
                            } else {
                                verify2 = "2";
                            }
                        }
                    },
                    error: function(data, textStatus) {}
                });
            },
            strVerify: function(event) {

                var strName = event.attr('id');
                var strVal = event.val();

                var ids = '#' + strName + 'Alt';
                //验证用户名
                if ("userName"==strName) {
                    if (strVal == "" || strVal==null) {
                        $(ids).text("");
                        $(ids).append("<span style=color:#ff7800>用户名不能为空</span>");
                        return false;
                    }else if(strVal.indexOf(" ")!=-1){
                        $(ids).text("");
                        $(ids).append("<span style=color:#ff7800>用户名存在空格</span>");
                    }else if(/^[\u4e00-\u9fa5]+$/i.test(strVal)){
                        $(ids).text("");
                        $(ids).append("<span style=color:#ff7800>用户名不能存在汉字</span>");
                    }else if (strVal.length < 6 || strVal.length > 24) {
                        $(ids).text("");
                        $(ids).append("<span style=color:#ff7800>用户名小于6位或者大于24位</span>");
                        return false;
                    } else {
                        $.ajax({
                            type: "post",
                            dataType: "json",
                            url:"/customer/getByName", //发送请求地址
                            data: {
                                verifyStr: strName,
                                verifyVal: strVal
                            },
                            //请求成功后的回调函数有两个参数
                            success: function(data) {
                                var msg1 = "用户名已被注册";
                                if ("2" == data.retCode) {
                                    $(ids).text("");
                                    $(ids).append("<span style=color:green>填入信息可用</span>")
                                } else {
                                    $(ids).text("");
                                    $(ids).append("<span style=color:#ff7800>" + msg1 + "</span>")
                                }
                            }
                        });
                    }
                } else
                //验证密码
                if ('password' == strName) {
                    if (strVal == "" || strVal==null) {
                        $(ids).text("");
                        $(ids).append("<span style=color:#ff7800>密码不能为空</span>");
                    }
                    else if (strVal.length < 6 || strVal.length > 15) {
                        $(ids).text("");
                        $(ids).append("<span style=color:#ff7800>密码小于6位或者大于24位</span>");
                    }
                     else {
                        $(ids).text("");
                        $(ids).append("<span style=color:green>填入信息可用</span>");
                    }
                }
                //重复密码
                if (strName == 'repeatPassword') {
                    if($("#password").val()==null||$("#password").val()==''){
                        $(ids).text("");
                        $(ids).append("<span style=color:#ff7800>请先输入密码</span>");
                    }else
                    if ($("#repeatPassword").val() != $("#password").val()) {
                        $(ids).text("");
                        $(ids).append("<span style=color:#ff7800>两次输入密码不一样</span>");
                    } else {
                        $(ids).text("");
                        $(ids).append("<span style=color:green>密码输入一致</span>");
                    }
                }
                //结束
            },
            verify: function(vr) {
                var byName = vr.attr("id");
                var val = vr.val();
                $.ajax({
                    type: "post", //请求方式
                    dataType: "json",
                    url: "customer/login", //发送请求地址
                    data: { //发送给数据库的数据
                        verifyCode: val,
                        byName: byName
                    },
                    //请求成功后的回调函数有两个参数
                    success: function(data) {

                        if (data.msg == "1") {
                            $("#msg66").text("");
                            $("#msg66").append("<span id='loginMes'  style=color:green;font-size: 50px>验证成功</span>");

                        } else {
                            $("#msg66").text("");
                            $("#msg66").append("<span id='loginMes' style=color:#ff7800;font-size: 50px>验证失败</span>");
                        }
                    },
                    error: function(data, textStatus) {
                        alert(textStatus);
                    }
                });
            },
            ajaxSubmit: function() {
              var selectedItems = new Array();
                  $("input[name='protocol']:checked").each(function() {
                    selectedItems.push($(this).val());
                })
                var pattern = /^(?=.*\d.*)(?=.*[a-zA-Z].*).{6,24}$/;
                if ($('#userName').val() == null || $('#userName').val() == '') {
                    console.log(1)
                    $('#userNameAlt').text("");
                    $('#userNameAlt').append("<span style=color:#ff7800>用户名不能为空</span>");
                    return false;
                } /*else if (!Vtdb.VuserName($('#userName').val())) {
                    console.log(2)
                    $('#userNameAlt').text("");
                    $('#userNameAlt').append("<span style=color:#ff7800>用户名只能为数字和字母</span>");
                    return false;
                } */else if ($('#password').val() == null || $('#password').val() == '') {
                    console.log(3)
                    $('#passwordAlt').text("");
                    $('#passwordAlt').append("<span style=color:#ff7800>密码不能为空</span>");
                    return false;
                } else if ($('#password').val().length < 6 || $('#password').val().length > 15) {
                    console.log(4)
                    $('#passwordAlt').text("");
                    $('#passwordAlt').append("<span style=color:#ff7800>密码小于6位或者大于24位</span>");
                    return false;
                } /*else if (!Vtdb.VuserPasswd($('#password').val())) {
                    console.log(5)
                    $('#passwordAlt').text("");
                    $('#passwordAlt').append("<span style=color:#ff7800>密码必须是数字和字符组合</span>");
                    return false;
                }*/ else if ($("#repeatPassword").val() != $("#password").val()) {
                    console.log(6)
                    $('#repeatPasswordAlt').text("");
                    $('#repeatPasswordAlt').append("<span style=color:#ff7800>两次密码输入不一致</span>");
                    return false;
                } else if (selectedItems.length == 0) {
                    console.log(7)
                    $('#protocolAlt').text("");
                    $('#protocolAlt').append("<span style=color:#ff7800>请点击投贷宝注册协议</span>");
                    return false;
                } /*else if (!flag1) {
                    console.log(8)
                    $("#phonVerifys").html("<span style=color:#ff7800>验证失败</span>");
                    return false;
                } */else if (!invist_flag && $("#customer").val() != "") {
                    console.log(9)
                    $invist_msg.css("color", "#ff7800");
                    $invist_msg.html("推荐人不存在!");
                    return false;
                } else {
                    console.log(10)
                    if (1==1) {
                        $.ajax({
                            type: "post",
                            dataType: "json",
                            url: "/customer/register", //发送请求地址
                            data: {
                                "userName": $('#userName').val(),
                                "passWord": $('#password').val(),
                                "telephone": $("#telephone").val(),
                                "recommend": $("#recommend").val()
                            },
                            //请求成功后的回调函数有两个参数
                            success: function(data) {
                                if (data.msg == '1') {
                                    window.location ="/register1.html?userName="+data.userName;
                                }else {
                                    alert(data.msg);
                                }
                            }
                        });
                        subFlag = "2";
                    }
                }
            },
            _daojishi: function() {
                login._setti(_t);
            },
            _setti: function(i) {
                setTimeout(function() {
                    if (i == 0) {
                        $getKey.html("获取验证码");
                        flag4 = 1;
                    } else {
                        $getKey.html("重新发送(" + i + ")");
                        login._setti(parseInt(i - 1));
                    }
                }, 1000);
            },
            validateInvist: function() {
                if($("._invist").val()!=null&&$("._invist").val()!=""){
                    $.ajax({
                        url: "/customer/getByName",
                        type: 'GET',
                        dataType: 'json',
                        data: {
                            verifyVal: $("._invist").val()
                        },
                        success:function(result) {
                            if (result.retCode==1) {
                                $invist_msg.css("color", "green");
                                $invist_msg.html("推荐人正确");
                                invist_flag = true;
                            } else {
                                $invist_msg.css("color", "#ff7800");
                                $invist_msg.html("推荐人不存在!");
                                invist_flag = false;
                            }
                        },
                        error: function() {
                            alert("fail");
                        }
                    });
                }

            },
            _changetCapther: function() {
                $changeCapcherButton.trigger('click');
                flag3 = 1;
                return false;
            }
        };
        login.init();
    });
})(jQuery)