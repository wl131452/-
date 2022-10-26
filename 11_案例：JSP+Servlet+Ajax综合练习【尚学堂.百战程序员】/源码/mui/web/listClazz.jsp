<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>

    <script>

        $(function(){

            //设置分页的几个全局变量
            var index = 1; //当前页
            var size = 5;//每页条数
            var totalPageCount; //总页数
            var totalCount; //总条数

            //发送请求，获取分页信息的
            function getData(){
                //发送ajax获取所有的班级信息
                $.get('ClazzServlet',{methodName:'getClazzByPage',index:index},function(data){// pageBean
                    eval('var obj = ' + data);

                    //删除掉table中除了标题行和分页行的其它行
                    $('tr:not(#firstRow):not(#lastRow)').remove();

                    var arr = obj.list;

                    //给上面分页的全局变量赋值
                    index = obj.index;
                    totalPageCount = obj.totalPageCount;
                    totalCount = obj.totalCount;

                    for(var i = 0; i < arr.length; i++){
                        $('#lastRow').before('<tr>\n' +
                            '     <td style="text-align:left; padding-left:20px;">'+arr[i].cid+'</td>\n' +
                            '     <td>'+arr[i].cname+'</td>\n' +
                            '     <td>'+arr[i].cteacher+'</td>\n' +
                            '     <td>'+arr[i].remark+'</td>\n' +
                            '     <td><div class="button-group"> <a class="button border-main" href="updateClazz.jsp?cid='+arr[i].cid+'&cname='+arr[i].cname+'&cteacher='+arr[i].cteacher+'&remark='+arr[i].remark+'"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>\n' +
                            ' </tr>')
                    }

                    //显示页码
                    //去掉之前的页码
                    $('.pagelist>a:not(#prePage):not(#nextPage),.pagelist>span').remove();

                    var numbers = obj.numbers; //获取到本次要展示的页码数集合
                    for(var i = 0; i < numbers.length; i++){// [1,2,3,4,5]
                        if(numbers[i] != index){
                            $('#nextPage').before('<a href="javascript:;" class="pageA">'+numbers[i]+'</a>');
                        }else{
                            $('#nextPage').before('<span class="current">'+index+'</span>');
                        }

                    }

                });
            }

            //初始化查询第一页
            getData();

            //下一页
            $('#nextPage').click(function(){
                if(index + 1 > totalPageCount){
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
                    alert('已经是上一页了！');
                    return;
                }else{
                    index = index - 1;
                    getData();
                }
            });


            //给页码绑定点击事件
            $(document).on('click','.pageA',function(){
                index = $(this).text();
                getData();
            });

        })

    </script>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 班级列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <table class="table table-hover text-center">
            <tr id="firstRow">
                <th width="100" style="text-align:left; padding-left:20px;">ID</th>
                <th width="10%">班级名称</th>
                <th>班主任</th>
                <th>备注</th>
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