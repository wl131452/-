<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>修改班级</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>

    <script>

        $(function(){
            $('#btn').click(function(){
                // serialize()方法可以将表单中表单项以键值对的方式给拼接好
                var param = $('#fr').serialize() + '&methodName=updateClazz'; //name=张三&age=20
                $.post('ClazzServlet', param,function(data){
                    eval('var b = ' + data);
                    if(b == true){
                        alert('修改成功！');
                        //清空表单中的内容
                        // $('#fr')[0].reset(); //使用表单的DOM对象的重置方法
                        $('form input').val('');
                        $('form textarea').val('');
                    }else{
                        alert('修改失败！');
                    }
                });
                return false;//阻止表单的提交
            });
        })

    </script>

</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>修改班级</strong></div>
    <div class="body-content">
        <form method="post" id="fr" class="form-x" action="">
            <input type="hidden" name="cid" id="cid" value="${param.cid}">
            <div class="form-group">
                <div class="label">
                    <label>班级名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="cname" id="cname" value="${param.cname}"  style="width:30%"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>班主任：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="cteacher" id="cteacher" value="${param.cteacher}" style="width:30%"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>备注：</label>
                </div>
                <div class="field">
                    <textarea type="text" class="input" name="remark" id="remark" style="height:80px;">${param.remark}</textarea>
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