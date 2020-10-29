<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>JavaのAjaxの練習です。</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
    <h2>何も表示しません</h2>
</body>

<script>
    $(function() {

        function getQuizzes() {
            return $.post('/Ajax', {
                action: getQuizzes
            })
        }

        getQuizzes().done(function(result) {
        });

    });
</script>
</html>