<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->

<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><g:layoutTitle default="Grails"/></title>
		<g:layoutHead/>
		<r:layoutResources/>
	</head>
	<body>
		<sec:ifLoggedIn>
			Welcome <sec:username/> - <g:link controller='logout'>Log Out</g:link>
			<g:remoteLink class="logout" controller="logout">${message(code: 'springSecurity.logout.link')}</g:remoteLink>
		</sec:ifLoggedIn>
		<sec:ifNotLoggedIn>
			<g:link controller="login" action="auth">Login</g:link>
		</sec:ifNotLoggedIn>
		<h1>PizzaDemo</h1>
		<g:layoutBody/>
		<r:layoutResources/>
		</body>
</html>




