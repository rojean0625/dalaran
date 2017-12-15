<html>
<head></head>
<style type="text/css">
      *{
            margin: 0;
            padding: 0;
            background-color: #EAEAEA;
        }
        div{
            width: 200px;
            height: 200px;
            background-color: #EAEAEA;
        }
        .center-in-center{
            position: absolute;
            top: 70%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
</style>
<script src="jsp/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
function ini(){
	window.setTimeout(redirect,590);
}

function redirect(){
	//location.href = "bankOrder/toTestPage";
	//location.href = "dalaran/bankOrder/toIndexPage";
	//location.href = "stockade/toIniPage";
	location.href="teleport/toTeleportPage";
}

</script>
<body onload="ini()">
<div class="center-in-center">
<h1>Welcome !</h1>
</div>
</body>
</html>
