<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<html>
<head>
<title>Rojean.Capital</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="roejan,capital" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${domain}/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="${domain}/css/style.css" rel='stylesheet' type='text/css' />
<link href='${domain}/fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<link href='${domain}/fonts.googleapis.com/css?family=Cabin:400,700,500,600' rel='stylesheet' type='text/css'>
<link href='${domain}/fonts.googleapis.com/css?family=Pacifico|Prata' rel='stylesheet' type='text/css'>
<link href="${domain}/css/animate.min.css" rel="stylesheet">

<script type="text/javascript" src="${domain}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${domain}/js/bootstrap.js"></script>
<script type="text/javascript" src="${domain}/js/main.js"></script>
<script type="text/javascript" src="${domain}/js/wow.min.js"></script>
<script>
 new WOW().init();
</script>
</head>
<body>
	<!--start-header-->
	<div class="top-bar w3agile-1" id="home">
				<div class="container">
					<div class="row">
						<div class="col-md-8 top-left wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
							<span class="phone">
								<i class="glyphicon glyphicon-phone"></i>
								<em>+13810625541</em>
							</span>
							<span class="email">
								<i class="glyphicon glyphicon-send"></i>
								<em><a href="https://mail.com">email_luo@l63.com</a></em>
							</span>
							<span class="location">
										<i class="glyphicon glyphicon-map-marker"></i>
										   <em>Beijing China</em>
									</span>
						</div>
						<div class="col-md-4 head-right wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".3s">
						   <ul class="top-icons">
									<li><a class="fb" href="#"></a></li>
									<li><a class="twitt" href="#"></a></li>
									<li><a class="goog" href="#"></a></li>
									<li><a class="drib" href="#"></a></li>
							   </ul>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
    </div>

<!-- //header -->
<!-- banner -->
	<div class="banner agileinfo-1">
		<div class="container">
			<div class="header"><!--header-->
				<nav class="navbar navbar-default">
					<div class="navbar-header wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<h1><a href="index.html">Rojean.Capital</a></h1>
					</div>
					<!--navbar-header-->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1 wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="index.html" class="active">主页</a></li>
							<li><a href="index.html">关于我们</a></li>
							<li><a href="index.html">服务</a></li>
							<li><a href="index.html">产品</a></li>
							<li><a href="index.html">渠道</a></li>
							<li><a href="index.html">线上业务</a></li>
						</ul>
						<div class="clearfix"> </div>
					</div>
				</nav>
			<div class="cd-main-header">
				<ul class="cd-header-buttons">
					<li><a class="cd-search-trigger" href="#cd-search"> <span></span></a></li>
				</ul> <!-- cd-header-buttons -->
			</div>
			<div id="cd-search" class="cd-search">
				<form action="#" method="post">
					<input name="Search" type="search" placeholder="Search...">
				</form>
			</div>
		</div>

		<div class="banner-info">
			<h2>为行业内提供专业的大数据支撑</h2>
			<p>
                Public static void main(String[] args) { syncTransData(new Date()); analysisCurrenInfo(); forecastPointCut(); } .
			</p>
		</div>
		</div>
	</div>
<!-- //banner -->
<!-- agile -->
<div class="agile">
		<div class="container">
			<div class="col-md-6 agile-left wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
			<h3>Our Mission</h3>
			<div class="grid_3 grid_5">
				<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#expeditions" id="expeditions-tab" role="tab" data-toggle="tab" aria-controls="expeditions" aria-expanded="true">${pageInfo[0].titleInfo}</a></li>
						<li role="presentation"><a href="#tours" role="tab" id="tours-tab" data-toggle="tab" aria-controls="tours">${pageInfo[1].titleInfo}</a></li>
						<li role="presentation"><a href="#tree" role="tab" id="tree-tab" data-toggle="tab" aria-controls="tree">${pageInfo[2].titleInfo}</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="expeditions" aria-labelledby="expeditions-tab">
						<div class="tab-info">
								<p> ${pageInfo[0].contentInfo}</p>
						</div>
						</div>

						<div role="tabpanel" class="tab-pane fade" id="tours" aria-labelledby="tours-tab">
							<div class="tab-info">
								<p> ${pageInfo[1].contentInfo}</p>


							</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tree" aria-labelledby="tree-tab">
							<div class="tab-info">
							<p> ${pageInfo[2].contentInfo}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
			<div class="col-md-6 agile-right wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
				<ul>
					<li>
						<div class="list-img">
							<img src="${domain}/images/1.jpg" class="img-responsive" alt=" ">
							<div class="textbox"></div>
						</div>
					</li>
					<li>
						<div class="list-img">
							<img src="${domain}/images/2.jpg" class="img-responsive" alt=" ">
							<div class="textbox"></div>
						</div>
					</li>
					<li>
						<div class="list-img">
							<img src="${domain}/images/3.jpg" class="img-responsive" alt=" ">
							<div class="textbox"></div>
						</div>
					</li>
					<li>
						<div class="list-img">
							<img src="images/4.jpg" class="img-responsive" alt=" ">
							<div class="textbox"></div>
						</div>
					</li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
<!-- //agile -->
<!-- count -->
<div class="count w3-1">
		<div class="container">
			<div class="col-md-4 agile_count_grid wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
				<div class="agile_count_grid_left">
					<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
				</div>
				<div class="agile_count_grid_right">
					<p class="counter">324</p>
				</div>
				<div class="clearfix"> </div>
				<h3>我们的设计</h3>
				<ul class="award">
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
				</ul>
			</div>
			<div class="col-md-4 agile_count_grid wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
				<div class="agile_count_grid_left">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
				</div>
				<div class="agile_count_grid_right">
					<p class="counter">543</p>
				</div>
				<div class="clearfix"> </div>
				<h3>目标方向</h3>
				<ul class="award">
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
					<li><a href="#">#.                                    -</a></li>
				</ul>
			</div>
			<div class="col-md-4 agile_count_grid wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
				<div class="agile_count_grid_left">
					<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
				</div>
				<div class="agile_count_grid_right">
					<p class="counter">434</p>
				</div>
				<div class="clearfix"> </div>
				<h3>技术成就</h3>
					<ul class="award">
						<li><a href="#">#.                                    -</a></li>
						<li><a href="#">#.                                    -</a></li>
						<li><a href="#">#.                                    -</a></li>
						<li><a href="#">#.                                    -</a></li>
						<li><a href="#">#.                                    -</a></li>
						<li><a href="#">#.                                    -</a></li>
					</ul>
			</div>

			<div class="clearfix"> </div>
				<!-- Starts-Number-Scroller-Animation-JavaScript -->
					<script src="js/waypoints.min.js"></script>
					<script src="js/counterup.min.js"></script>
					<script>
						jQuery(document).ready(function( $ ) {
							$('.counter').counterUp({
								delay: 20,
								time: 1000
							});
						});
					</script>
				<!-- //Starts-Number-Scroller-Animation-JavaScript -->
		</div>
	</div>
<!-- //count -->
<!-- wthree -->
	<div class="wthree wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
		<div class="container">

			<!-- Slider3 -->
			<div class="slider3">
			<div class="ba-im">
				<ul class="rslides" id="slider3">
					<li>
						<div class="ba-1">
							<p>The important thing in life is to have a great aim, and the determination to attain it. </p>
							<img src="${domain}/images/t1.jpg" class="img-responsive" alt="Hitech Info">

						</div>

					</li>
					<li>
						<div class="ba-1">
						<p>Courage is the ladder on which all the other virtues mount.</p>
							<img src="${domain}/images/t2.jpg" class="img-responsive" alt="Hitech Info">


						</div>

					</li>
					<li>
						<div class="ba-1">
						<p>Character is what you are in the dark.  </p>
							<img src="${domain}/images/t3.jpg" class="img-responsive" alt="Hitech Info">

						</div>

					</li>
					<li>
						<div class="ba-1">
						<p>Meet success like a gentleman and disaster like a man. </p>
							<img src="images/t4.jpg" class="img-responsive" alt="Hitech Info">

						</div>

					</li>

				</ul>
				</div>
			</div>
			<!-- //Slider3 -->

			<!-- Slider-JavaScript -->
			<script src="js/responsiveslides.min.js"></script>
			<script>
				$(function () {
					$("#slider1, #slider2, #slider3").responsiveSlides({
						auto: true,
						nav: true,
						speed: 1500,
						namespace: "callbacks",
						pager: true,
					});
				});
			</script>
		<!-- //Slider-JavaScript -->

		</div>
	</div>
<!-- newsletter -->
	<div class="newsletter wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
		<div class="container">
		<h3>News Letter</h3>
			<form action="#" method="post">
				<input type="text" name="Name" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
				<input type="email" name="Email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
				<input type="submit" value="Submit">
			</form>
		</div>
	</div>
<!-- /newsletter -->
<div class="feature">
	<div class="container">
		<h3 class="tit">Features</h3>
		<div class="feature-grids">
			<div class="col-md-3 feature-grid text-center wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
				<div class="feature-grid-two">
					<a href="#" class="hi-icon hi-icon-archive glyphicon glyphicon-pencil"> </a>
					<h4>Our Expectation.</h4>
					<p> 我们的期望.</p>
				</div>
			</div>
			<div class="col-md-3 feature-grid text-center wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
				<div class="feature-grid-two">
					<a href="#" class="hi-icon hi-icon-archive glyphicon glyphicon-user"> </a>
					<h4>Our advantage</h4>
					<p> 我们的优势.</p>
				</div>
			</div>
			<div class="col-md-3 feature-grid text-center wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
				<div class="feature-grid-two">
					<a href="#" class="hi-icon hi-icon-archive glyphicon glyphicon-star"> </a>
					<h4>Data security</h4>
					<p> 数据安全.</p>
				</div>
			</div>
			<div class="col-md-3 feature-grid text-center wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
				<div class="feature-grid-two">
					<a href="#" class="hi-icon hi-icon-archive glyphicon glyphicon-map-marker"> </a>
					<h4>Auto operation</h4>
					<p> 自动化运算.</p>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- /w3ls -->
	<div class="w3ls">
	<div class="container">
	<div class="col-md-4 w3ls-right wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
			<h3>Contact Us</h3>
				<p class="para"> Non-Business Organizations .</p>
			<ul class="con-icons">
				<li><span class="glyphicon glyphicon-phone" aria-hidden="true"></span>+13810625541</li>
				<li><a href="mailto:info@example.com"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>email_luo@163.com</a></li>
				<li><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>Beijing,Chaoyang Road</li>

			</ul>


		</div>
		<div class="col-md-4 w3ls-left wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
			<h3>Information</h3>

			<p class="para">If this is not enough，what else ?</p>

		</div>
		<div class="col-md-4 w3ls-right wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
			<h3>Follow Us</h3>

			<p class="para">The Modeling and Application in Stock Market Forecast Based on Neural Network with Particle Swarm Optimization.</p>
			<ul class="fb_icons">
				<li class="hvr-rectangle-out"><a class="fb" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="twit" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="goog" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="pin" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="drib" href="#"></a></li>
			</ul>
		</div>

		<div class="clearfix"></div>
		<p class="copy-right wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">© 2017 Rojean. All rights reserved | Design by <a href="#">rojean</a></p>

	</div>
</div>

</body>
</html>