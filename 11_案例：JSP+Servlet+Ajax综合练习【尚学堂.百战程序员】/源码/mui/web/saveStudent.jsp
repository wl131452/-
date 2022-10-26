<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>添加学生</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>

    <script>

        $(function(){
            //发请求查询所有的班级
            $.get('ClazzServlet',{methodName:'getAll'},function(data){
                eval('var arr = ' + data);
                for(var i = 0; i < arr.length; i++){
                    $('select').append('<option value="'+arr[i].cid+'">'+arr[i].cname+'</option>');
                }
            })


            //给提交按钮绑定事件
            $('#btn').click(function(){

                var param = $('form').serialize() + "&methodName=addStudent";
                $.post('StudentServlet',param,function(data){
                    if(data == 1){
                        alert('添加成功！');
                        $('form')[0].reset();
                    }else{
                        alert('添加失败！')
                    }
                });

                return false;
            });
        })
    </script>


</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>添加学生</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="">
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="sname" value=""  style="width:30%"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field" style="padding-top:8px;">
                    男:<input type="radio"  name="sex" value="男" />
                    女: <input type="radio"  name="sex" value="女" />
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>爱好：</label>
                </div>
                <div class="field" style="padding-top:8px;">
                    抽烟 <input   type="checkbox" name="hobby" value="抽烟"/>
                    喝酒 <input   type="checkbox" name="hobby" value="喝酒"/>
                    烫头 <input   type="checkbox" name="hobby" value="烫头"/>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>出生年月：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="birthdate" value=""  style="width:30%"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>手机号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="phone" style="width:30%"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>所在班级：</label>
                </div>
                <div class="field">
                    <select class="input" name="cid" style="width:30%">
                        <option>--请选择--</option>
                    </select>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>描述：</label>
                </div>
                <div class="field">
                    <textarea type="text" class="input" name="reamrk" style="height:80px;"></textarea>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" id="btn" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body></html>