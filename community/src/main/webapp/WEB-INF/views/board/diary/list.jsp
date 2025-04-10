<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <link rel="stylesheet" href="/community/res/css/skin/diary/evo-calendar.min.css">
    <link rel="stylesheet" href="/community/res/css/skin/diary/evo-calendar.orange-coral.min.css">
    <script src="/community/res/js/skin/diary/evo-calendar.js"></script>
    <script>
        $(function(){
            myEvent = [
                {
                    id: "required-id-1",
                    name: "홍길동",
                    badge: "03/25 - 03/27",
                    date: ["March/25/2025", "March/27/2025"],
                    description: "나의 생일 시즌",
                    type:"event",
                    everyYear:false
                }
            ];
            $("#mydiary").evoCalendar({
                language: 'ko',
                format:'yyyy/MM/dd',
                titleFormat:'yyyy MM',
                eventHeaderFormat:'yyyy, MM d',
                calendarEvents: myEvent
            });
        });
    </script>
    <c:if test="${badmin.lgrade > 0}">
<div class="container pt-5">
    <h1 class="text-center">다이어리</h1>
    <p class="text-center mb-5 pb-5">jsp + servlet으로 디자인 할 자유 게시판입니다.</p>
    <div class="text-right w-100 mb-4">
        <button type="button" class="btn btn-custom">일정등록</button>
    </div>
    <div id="mydiary"></div>
</div>
<sec:authorize access="!isAuthenticated()">
		<script>
			alert("회원전용 게시판입니다. 로그인 하세요.");
			location.href="/community"
		</script>
	</sec:authorize>
	<c:if test="${badmin.lgrade > user.grade}">
		<script>
			alert("이 게시판을 볼 권한이 없습니다.");
			location.href="/community"
		</script>
	</c:if>
</c:if>