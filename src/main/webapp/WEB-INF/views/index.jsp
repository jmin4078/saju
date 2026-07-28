<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>당신의 사주를 봐드립니다</title>
</head>
<body>
<h1>AI가 봐주는 사주</h1>
<section>
  <form method="post">
    <input name="question" placeholder="질문하고자 하는 키워드를 입력해주세요">
    <button>질문하기</button>
  </form>
</section>
<c:if test="${not empty saju}">
  <section>
    <p>답변 :</p>
    <div id="answer-raw" hidden><c:out value="${saju}"/></div>
    <div id="answer-rendered"></div>
  </section>
  <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
  <script>
    document.addEventListener('DOMContentLoaded', function () {
      const raw = document.getElementById('answer-raw');
      const rendered = document.getElementById('answer-rendered');
      if (raw && rendered) {
        rendered.innerHTML = marked.parse(raw.textContent);
      }
    });
  </script>
</c:if>
</body>
</html>