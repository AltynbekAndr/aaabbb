
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Войти</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
</head>
<body>

<div class="container1">
  <div class="container2">
 <input type="text" class="cspot" placeholder="cspot"><br>
 <input type="text" class="cspot2" placeholder="cspot2"><br>
 <input type="text" class="address1" placeholder="address1"><br>
 <input type="text" class="address2" placeholder="address2"><br>
 <input type="text" class="ccounter" placeholder="ccounter"><br>
 <input type="text" class="ccounter2" placeholder="ccounter2"><br>
 <input type="text" class="ccounter20" placeholder="ccounter20"><br>
 <input type="text" class="cstation" placeholder="cstation"><br>
 <input type="text" class="nregion" placeholder="nregion"><br>
 <input type="text" class="namitype" placeholder="namitype">
 <br>
  <button class="off">off</button>
  <button class="on">on</button>
  <button class="search">search</button>
  <button class="getList1">getList1</button>
  <button class="getList2">getList2</button>
  <button class="searchoffabonent">searchoffabonent</button>
  <button class="add">add</button>

  </div>
    <div class="ress">

    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js">
</script>

<script>
    $('.off').click(
   function(){
     var Abonent = {
       'cspot':$('.cspot').val(),
       'cspot2':$('.cspot2').val(),
       'address1':$('.address1').val(),
       'address2':$('.address2').val(),
       'ccounter':$('.ccounter').val(),
       'ccounter2':$('.ccounter2').val(),
       'ccounter20':$('.ccounter20').val(),
       'cstation':$('.cstation').val(),
       'nregion':$('.nregion').val(),
       'namitype':$('.namitype').val()
     }
      $.ajax({
        type: "POST",
        url: "/getuserdata/off",
        data:JSON.stringify(Abonent),
        contentType:"application/json",//отправка на сервер
        dataType:"json",//получение с сервера
        success: function(data) {
          if(data!=null){
            $('.ress').html(JSON.stringify(data));
          }}
      })});
$('.on').click(
        function(){
            var Abonent = {
                'cspot':$('.cspot').val(),
                'cspot2':$('.cspot2').val(),
                'address1':$('.address1').val(),
                'address2':$('.address2').val(),
                'ccounter':$('.ccounter').val(),
                'ccounter2':$('.ccounter2').val(),
                'ccounter20':$('.ccounter20').val(),
                'cstation':$('.cstation').val(),
                'nregion':$('.nregion').val(),
                'namitype':$('.namitype').val()
            }
            $.ajax({
                type: "POST",
                url: "/getuserdata/on",
                data:JSON.stringify(Abonent),
                contentType:"application/json",//отправка на сервер
                dataType:"json",//получение с сервера
                success: function(data) {
                    if(data!=null){
                        $('.ress').html(JSON.stringify(data));
                    }}
            })});
    $('.search').click(
            function(){
                var Abonent = {
                    'cspot':$('.cspot').val(),
                    'cspot2':$('.cspot2').val(),
                    'address1':$('.address1').val(),
                    'address2':$('.address2').val(),
                    'ccounter':$('.ccounter').val(),
                    'ccounter2':$('.ccounter2').val(),
                    'ccounter20':$('.ccounter20').val(),
                    'cstation':$('.cstation').val(),
                    'nregion':$('.nregion').val(),
                    'namitype':$('.namitype').val()
                }
                $.ajax({
                    type: "POST",
                    url: "/getuserdata/search",
                    data:JSON.stringify(Abonent),
                    contentType:"application/json",//отправка на сервер
                    dataType:"json",//получение с сервера
                    success: function(data) {
                        if(data!=null){
                            $('.ress').html(JSON.stringify(data));
                        }}
                })});



    $('.getList1').click(
            function(){
                var ModP = {
                    "f":0,
                    "l":100
                }
                $.ajax({
                    type: "POST",
                    url: "/getuserdata/getList",
                    data:JSON.stringify(ModP),
                    contentType:"application/json",//отправка на сервер
                    dataType:"json",//получение с сервера
                    success: function(data) {
                        if(data!=null){
                            $('.ress').html(JSON.stringify(data));
                        }}
                })});
    $('.getList2').click(
            function(){
                var ModP = {
                    "f":0,
                    "l":100
                }
                $.ajax({
                    type: "POST",
                    url: "/getuserdata/getList2",
                    data:JSON.stringify(ModP),
                    contentType:"application/json",//отправка на сервер
                    dataType:"json",//получение с сервера
                    success: function(data) {
                        if(data!=null){
                            $('.ress').html(JSON.stringify(data));
                        }}
                })});
    $('.searchoffabonent').click(
            function(){
                var Abonent = {
                    'cspot':$('.cspot').val(),
                    'cspot2':$('.cspot2').val(),
                    'address1':$('.address1').val(),
                    'address2':$('.address2').val(),
                    'ccounter':$('.ccounter').val(),
                    'ccounter2':$('.ccounter2').val(),
                    'ccounter20':$('.ccounter20').val(),
                    'cstation':$('.cstation').val(),
                    'nregion':$('.nregion').val(),
                    'namitype':$('.namitype').val()
                }
                $.ajax({
                    type: "POST",
                    url: "/getuserdata/searchoffabonent",
                    data:JSON.stringify(Abonent),
                    contentType:"application/json",//отправка на сервер
                    dataType:"json",//получение с сервера
                    success: function(data) {
                        if(data!=null){
                            $('.ress').html(JSON.stringify(data));
                        }}
                })});
    $('.add').click(
            function(){
                var User = {
                    'name':$('.cspot').val(),
                    'password':$('.cspot2').val()
                }
                $.ajax({
                    type: "POST",
                    url: "/getuserdata/setuser",
                    data:JSON.stringify(User),
                    contentType:"application/json",//отправка на сервер
                    dataType:"json",//получение с сервера
                    success: function(data) {
                        if(data!=null){
                            $('.ress').html(JSON.stringify(data));
                        }}
                })});
</script>
</body>
</html>