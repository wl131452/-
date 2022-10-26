<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>

    <script>

        $(function(){
            var index = 1; //当前页
            var size = 3; //每页显示条数
            var totalPageCount; //总页数
            var totalCount; //总条数

            function getData(){
                //查询学生数据
                $.get('StudentServlet',{index:index,methodName:"getStudentByPage",sname:$('#sname').val(),phone:$('#phone').val()},function(data){// pageBean
                    eval('var pageBean = ' + data);

                    var arr = pageBean.list;

                    //每次从后端查询到分页的数据后，重新设置一下前端分页属性
                    index = pageBean.index;
                    totalPageCount = pageBean.totalPageCount;
                    totalCount = pageBean.totalCount;


                    $('tr:not(#firstRow):not(#lastRow)').remove();

                    for(var i = 0; i < arr.length; i++){
                        $('#lastRow').before('<tr>\n' +
                            '      <td style="text-align:left; padding-left:20px;">'+arr[i].sid+'</td>\n' +
                            '      <td>'+arr[i].sname+'</td>\n' +
                            '      <td>'+arr[i].phone+'</td>\n' +
                            '      <td>'+arr[i].sex+'</td>\n' +
                            '      <td>'+arr[i].clazz.cname+'</td>\n' +
                            '      <td>'+arr[i].birthdate+'</td>\n' +
                            '      <td><div class="button-group"> <a class="button border-main" href="add.html"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>\n' +
                            '  </tr>')
                    }

                    //设置页码
                    var numbers = pageBean.numbers;//获取到要展示的页码
                    //加页码之前，将之前的清掉
                    $('.pagelist>a:not(#prePage):not(#nextPage), .pagelist>span').remove();
                    for(var i = 0; i < numbers.length; i++){
                        if(numbers[i] == index){
                            $('#nextPage').before('<span class="current">'+numbers[i]+'</span>')
                        }else{
                            $('#nextPage').before('<a href="javascript:;" class="pageA">'+numbers[i]+'</a>')
                        }
                    }

                });
            }

            //初始调用一次，查询第一页
            getData();

            //下一页
            $('#nextPage').click(function(){
                if(index == totalPageCount){
                    alert('已经是最后一页了！');
                    return;
                }else{
                    index = index + 1;
                    getData();
                }
            });

            //上一页
            $('#prePage').click(function(){
                if(index == 1){
                    alert('已经是第一页了！');
                    return;
                }else{
                    index = index - 1;
                    getData();
                }
            });

            //给页码绑定事件
            $(document).on('click','.pageA',function(){
                index = $(this).text();
                getData();
            })

            //搜索按钮
            $('#search').click(function(){
                index = 1;
                getData();
            });

            //导出按钮
            $('#export').click(function(){
                location.href = 'StudentServlet?methodName=exportStudent&sname='+$('#sname').val()+'&phone='+$('#phone').val();
            });
        })

    </script>

</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 学生列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li>
                    姓名:
                    <input type="text" placeholder="请输入搜索关键字" id="sname" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    手机号:
                    <input type="text" placeholder="请输入搜索关键字" id="phone" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <a href="javascript:void(0)" class="button border-main icon-search" id="search"> 搜索</a>
                    <a href="javascript:void(0)" class="button border-main icon-signal" id="export"> 导出</a>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr id="firstRow">
                <th width="100" style="text-align:left; padding-left:20px;">ID</th>
                <th width="10%">姓名</th>
                <th>手机号</th>
                <th>性别</th>
                <th>所在班级</th>
                <th>出生年月</th>
                <th width="310">操作</th>
            </tr>

            <tr id="lastRow">
                <td colspan="8">
                    <div class="pagelist">
                        <a href="javascript:;" id="prePage">上一页</a>
                        <a href="javascript:;" id="nextPage">下一页</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">

    //搜索
    function changesearch(){

    }

    //单个删除
    function del(id,mid,iscid){
        if(confirm("您确定要删除吗?")){

        }
    }

    //全选
    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    //批量删除
    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
            $("#listform").submit();
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");
            return false;
        }
    }


    //批量首页显示
    function changeishome(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量推荐
    function changeisvouch(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){


            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量置顶
    function changeistop(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }


    //批量移动
    function changecate(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量复制
    function changecopy(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var i = 0;
            $("input[name='id[]']").each(function(){
                if (this.checked==true) {
                    i++;
                }
            });
            if(i>1){
                alert("只能选择一条信息!");
                $(o).find("option:first").prop("selected","selected");
            }else{

                $("#listform").submit();
            }
        }
        else{
            alert("请选择要复制的内容!");
            $(o).find("option:first").prop("selected","selected");
            return false;
        }
    }

</script>
</body>
</html>
