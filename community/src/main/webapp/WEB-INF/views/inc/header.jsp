<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark py-md-3">
		<!-- 로고 -->
		<a href="/community" class="navbar-brand ml-md-5">Community</a>
		<!-- 모바일용 버튼 -->
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu"><i class="ri-menu-line"></i></button>
		<div class="collapse navbar-collapse justify-content-between ml-md-5" id="menu">
			<ul class="navbar-nav">
				<li class="nav-item ml-md-3">
					<a href="#" class="nav-link">공지사항</a>
				</li>
				<li class="nav-item ml-md-3">
					<a href="#" class="nav-link">인기글</a>
				</li>
				<sec:authorize access="!isAuthenticated()">
				<li class="nav-item ml-md-3">
					<a href="/community/register" class="nav-link">회원가입</a>
				</li>
				</sec:authorize>
			</ul>
			<form class="d-flex mr-4">
				<input class="from-control mr-2 col-8" type="search" placeholder="serach" aria-label="Search" />
				<button class="btn btn-outline-success col-4" type="submit">검색</button>
			</form>
		</div>
	</nav>
</header>