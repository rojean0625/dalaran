<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teleport</title>
<link rel="stylesheet" type="text/css" href="${path}/webuploader-0.1.5/webuploader.css">
<script type="text/javascript" src="${path}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${path}/webuploader-0.1.5/webuploader.js"></script>
<script type="text/javascript">
function doTeleport(){
	alert('doTeleport js');
	$("#form").attr("action","doTeleport.htm");
	$("#form").submit();
}

$(function(){
	   var $list=$("#thelist");   //这几个初始化全局的百度文档上没说明，好蛋疼。
	   var $btn =$("#ctlBtn");   //开始上传
	   var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档
	   var thumbnailHeight = 100;

	   var uploader = WebUploader.create({
	       // 选完文件后，是否自动上传。
	       auto: false,

	       // swf文件路径
	       swf: '${path}/webuploader-0.1.5/Uploader.swf',

	       // 文件接收服务端。
	       server: 'doUpdatePDF.htm',

	       // 选择文件的按钮。可选。
	       // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	       pick: '#filePicker1',

	       // 只允许选择图片文件。
	       accept: {
	           title: 'PDF-FILE',
	           extensions: 'pdf',
	           mimeTypes: 'application/pdf'
	       },
	       method:'POST',
	   });
	   // 当有文件添加进来的时候
	   uploader.on( 'fileQueued', function( file ) {
	       var $li = $('<div id="' + file.id + '" class="file-item thumbnail">' + '<img>' +'<div class="info">' + file.name + '</div>' +'</div>'),
	       $img = $li.find('img');
	       $list.append( $li );

	       // 创建缩略图
	       // 如果为非图片文件，可以不用调用此方法。
	       // thumbnailWidth x thumbnailHeight 为 100 x 100
	       //uploader.makeThumb( file, function( error, src ) {
	        //   if ( error ) {
	          //     $img.replaceWith('<span>不能预览</span>');
	            //   return;
	           //}
	          //$img.attr( 'src', src );
	       //}, thumbnailWidth, thumbnailHeight );
	   });


	   // 文件上传过程中创建进度条实时显示。
	   uploader.on( 'uploadProgress', function( file, percentage ) {
	       var $li = $( '#'+file.id ),$percent = $li.find('.progress span');
	       // 避免重复创建
	       if ( !$percent.length ) {
	           $percent = $('<p class="progress"><span></span></p>').appendTo( $li ).find('span');
	       }
	       $percent.css( 'width', percentage * 100 + '%' );
	   });

	   // 文件上传成功，给item添加成功class, 用样式标记上传成功。
	   uploader.on( 'uploadSuccess', function( file ) {
	       $( '#'+file.id ).addClass('upload-state-done');
	   });

	   // 文件上传失败，显示上传出错。
	   uploader.on( 'uploadError', function( file ) {
	       var $li = $( '#'+file.id ),
	           $error = $li.find('div.error');

	       // 避免重复创建
	       if ( !$error.length ) {
	           $error = $('<div class="error"></div>').appendTo( $li );
	       }

	       $error.text('上传失败');
	   });

	   // 完成上传完了，成功或者失败，先删除进度条。
	   uploader.on( 'uploadComplete', function( file ) {
	       $( '#'+file.id ).find('.progress').remove();
	   });
	      $btn.on( 'click', function() {
	        console.log("上传...");
	        uploader.upload();
	        console.log("上传成功");
	      });
	  });
</script>
</head>
<body>
<form id="form" method="post">
<input type="button" value="Stormwind" onclick="doTeleport()" />
</form>



<span style="font-size:14px;">
    <!--用来存放item-->
    <div id="thelist" class="uploader-list"></div>
    <div>
     <a id="filePicker1">选择图片</a>
     <button id="ctlBtn" class="btn btn-default">开始上传</button>
    </div>
</span>






</body>
</html>